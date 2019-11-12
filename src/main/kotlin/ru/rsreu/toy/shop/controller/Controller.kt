package ru.rsreu.toy.shop.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.entity.Product
import ru.rsreu.toy.shop.repository.ProductRepository
import ru.rsreu.toy.shop.service.ProductService
import java.util.*
import javax.swing.text.html.parser.Entity

@RestController
class Controller(
    private val productService: ProductService
) {

    @GetMapping(value = ["/products"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun products(): List<ProductDto> {
        return productService.getProducts()
    }

    @DeleteMapping(value = ["/deleteProduct"])
    fun deleteProduct(id: String) {
        productService.deleteProduct(id)
    }
}