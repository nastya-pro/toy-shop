package ru.rsreu.toy.shop.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.service.ProductService

@RestController
class ProductRestController(
    private val productService: ProductService
) {

    @GetMapping(value = ["/getProducts"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProducts(): List<ProductDto> {
        return productService.getProducts()
    }

    @DeleteMapping(value = ["/deleteProduct"])
    fun deleteProduct(id: String) {
        productService.deleteProduct(id)
    }

}