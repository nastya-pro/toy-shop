package ru.rsreu.toy.shop.controller

import org.springframework.http.MediaType
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.service.ProductService

@RestController
class ProductRestController(
    private val productService: ProductService
) {

    @GetMapping(value = ["/getProducts"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProducts(search: String?): List<ProductDto> {
        return productService.getProducts()
    }

    @DeleteMapping(value = ["/deleteProduct"])
    @PreAuthorize("hasAuthority('ADMIN')")
    fun deleteProduct(id: String) {
        productService.deleteProduct(id)
    }

}