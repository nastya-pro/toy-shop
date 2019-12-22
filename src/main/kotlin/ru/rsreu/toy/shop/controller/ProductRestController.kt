package ru.rsreu.toy.shop.controller

import org.springframework.core.io.InputStreamResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.service.ImageService
import ru.rsreu.toy.shop.service.ProductService

@RestController
class ProductRestController(
    private val productService: ProductService,
    private val imageService: ImageService
) {

    @GetMapping(value = ["/getProducts"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProducts(sort: String?): List<ProductDto> {
        return productService.getProducts(sort ?: "default")
    }

    @DeleteMapping(value = ["/deleteProduct"])
    @PreAuthorize("hasAuthority('ADMIN')")
    fun deleteProduct(id: String) {
        val imgId = productService.getImageId(id)
        imageService.deleteImg(imgId)
        productService.deleteProduct(id)
    }

    @GetMapping(value = ["/img/{id}"])
    @ResponseBody
    fun getImg(@PathVariable id:String): ResponseEntity<InputStreamResource> {
        return imageService.getImg(id)
    }
}