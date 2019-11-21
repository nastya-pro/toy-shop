package ru.rsreu.toy.shop.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.service.ProductService

@Controller
class Controller(
    private val productService: ProductService
) {
    @PostMapping(value = ["/createProduct"])
    fun createProduct(product: ProductDto): String {
        productService.createProduct(product)
        return "redirect:/"
    }

    @GetMapping(value = ["/"])
    fun products(): String {
        return "products"
    }

    @GetMapping(value = ["/create"])
    fun create(model: ModelMap): String {
        val product = ProductDto(null, "", "", "", "", "")
        model.addAttribute("product", product)
        return "createProduct"
    }

    @GetMapping(value = ["/edit"])
    fun edit(model: ModelMap): String {
        val product = ProductDto(
            title = "Cat",
            vendorCode = "578980",
            price = "457",
            imgUrl = "hkhkjn",
            description = "WGrdtgcgvj",
            id = null
        )
        model.addAttribute("product", product)
        return "createProduct"
    }
}