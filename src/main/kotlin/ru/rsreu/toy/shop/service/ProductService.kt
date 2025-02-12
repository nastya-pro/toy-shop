package ru.rsreu.toy.shop.service

import org.bson.types.ObjectId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.rsreu.toy.shop.controller.ResourceNotFoundException
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.dto.UpdateProductDto
import ru.rsreu.toy.shop.entity.Product
import ru.rsreu.toy.shop.repository.ProductRepository

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    fun getProducts(sort: String): List<ProductDto> {
        val products = productRepository.findAll().map { convertToProductDto(it) }
        return when (sort) {
            "name" -> products.sortedBy { it.title }
            "priceAsc" -> products.sortedBy { it.price }
            "priceDesc" -> products.sortedByDescending { it.price }
            else -> products
        }
    }

    private fun convertToProductDto(entity: Product): ProductDto {
        return ProductDto(
            id = entity.id?.toHexString(),
            title = entity.title,
            description = entity.description,
            imgUrl = "/img/${entity.imgId.toHexString()}",
            price = entity.price,
            vendorCode = entity.vendorCode
        )
    }

    fun deleteProduct(id: String) {
        val objectId = id.toObjectId()
        productRepository.deleteById(objectId)
    }

    fun createProduct(product: UpdateProductDto) = processProduct(null, product)

    fun updateProduct(id: String, product: UpdateProductDto) = processProduct(id.toObjectId(), product)

    private fun processProduct(
        id: ObjectId?,
        product: UpdateProductDto
    ) {
        val entity = Product(
            id = id,
            title = product.title,
            description = product.description,
            imgId = product.imageId,
            price = product.price,
            vendorCode = product.vendorCode
        )

        productRepository.save(entity)
    }

    fun findProduct(id: String): ProductDto {
        val objectId = id.toObjectId()
        val product = productRepository.findByIdOrNull(objectId) ?: throw ResourceNotFoundException()
        return convertToProductDto(product)
    }

    fun getImageId(productId: String): ObjectId {
        val id = productId.toObjectId()
        val product = productRepository.findByIdOrNull(id) ?: throw ResourceNotFoundException()
        return product.imgId
    }

    private fun String.toObjectId(): ObjectId {
        if (ObjectId.isValid(this)) {
            return ObjectId(this)
        } else {
            throw ResourceNotFoundException()
        }
    }
}
