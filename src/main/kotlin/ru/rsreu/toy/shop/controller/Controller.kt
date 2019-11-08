package ru.rsreu.toy.shop.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.entity.Product
import ru.rsreu.toy.shop.repository.ProductRepository
import javax.swing.text.html.parser.Entity

@RestController
class Controller(
    private val productRepository: ProductRepository
) {

    @GetMapping(value = ["/products"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun products(): List<ProductDto> {
        return productRepository.findAll().map { createResult(it) }
    }

    private fun createResult(entity: Product): ProductDto {
        return ProductDto(
            title = entity.title,
            description = entity.description,
            imgUrl = entity.imgUrl,
            price = entity.price,
            vendorCode = entity.vendorCode
        )
    }
}