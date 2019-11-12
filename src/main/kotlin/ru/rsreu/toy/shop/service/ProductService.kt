package ru.rsreu.toy.shop.service

import org.springframework.stereotype.Service
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.entity.Product
import ru.rsreu.toy.shop.repository.ProductRepository

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    fun getProducts(): List<ProductDto>{
        return productRepository.findAll().map { createResult(it) }
    }

    private fun createResult(entity: Product): ProductDto {
        return ProductDto(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            imgUrl = entity.imgUrl,
            price = entity.price,
            vendorCode = entity.vendorCode
        )
    }
}