package ru.rsreu.toy.shop.service

import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.entity.Product
import ru.rsreu.toy.shop.repository.ProductRepository
import java.util.*

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    fun getProducts(): List<ProductDto> {
        return productRepository.findAll().map { createResult(it) }
    }

    private fun createResult(entity: Product): ProductDto {
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
        val objectId= ObjectId(id)
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

}