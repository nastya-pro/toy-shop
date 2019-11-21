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
    fun getProducts(): List<ProductDto> {
        return productRepository.findAll().map { convertToProductDto(it) }
    }

    private fun convertToProductDto(entity: Product): ProductDto {
        return ProductDto(
            id = entity.id?.toHexString(),
            title = entity.title,
            description = entity.description,
            imgUrl = entity.imgUrl,
            price = entity.price,
            vendorCode = entity.vendorCode
        )
    }

    fun deleteProduct(id: String) {
        val objectId = ObjectId(id)
        productRepository.deleteById(objectId)
    }

    fun createProduct(product: ProductDto) {
        val entity = Product(
            title = product.title,
            description = product.description,
            imgUrl = product.imgUrl,
            price = product.price,
            vendorCode = product.vendorCode
        )

        productRepository.save(entity)
    }

    fun findProduct(id: String):ProductDto? {
        if (ObjectId.isValid(id)) {
            val objectId = ObjectId(id)
            val product = productRepository.findByIdOrNull(objectId)
            if (product != null) {
                val productDto = convertToProductDto(product)
                return productDto
            } else {
                return null
            }
        } else {
            return null
        }
    }

}