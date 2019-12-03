package ru.rsreu.toy.shop.service

import org.bson.types.ObjectId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.rsreu.toy.shop.dto.ProductDto
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
        //ToDo удалять изображения
        val objectId = id.toObjectId()
        productRepository.deleteById(objectId)
    }

    fun createProduct(
        title: String,
        imgId: ObjectId,
        description: String,
        vendorCode: String,
        price: Long
    ) {
        val entity = Product(
            title = title,
            description = description,
            imgId = imgId,
            price = price,
            vendorCode = vendorCode
        )

        productRepository.save(entity)
    }

    fun findProduct(id: String): ProductDto? {
        val objectId = id.toObjectId()
        val product = productRepository.findByIdOrNull(objectId)
        if (product != null) {
            val productDto = convertToProductDto(product)
            return productDto
        } else {
            return null
        }
    }

    fun getImageId(productId: String): ObjectId? {
        val id = productId.toObjectId()
        val product = productRepository.findByIdOrNull(id)
        return product?.imgId
    }
}

fun String.toObjectId(): ObjectId? {
    if (ObjectId.isValid(this)) {
        return ObjectId(this)
    } else {
        return null
    }
}
