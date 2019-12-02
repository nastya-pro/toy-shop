package ru.rsreu.toy.shop.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import ru.rsreu.toy.shop.dto.ChangeProductDto
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.service.ProductService

@Controller
class Controller(
    private val productService: ProductService
) {
    @PostMapping(value = ["/createProduct"])
    @PreAuthorize("hasAuthority('ADMIN')")
    fun createProduct(
        @RequestParam id: String?,
        @RequestParam title: String,
        @RequestParam("img") img: MultipartFile,
        @RequestParam description: String,
        @RequestParam vendorCode: String,
        @RequestParam price: Long
    ): String {
        //ToDo UpdateProduct
        val urlImg = productService.saveImg(img)
        val product = ProductDto(id, title, urlImg, description, vendorCode, price)
        productService.createProduct(trimSpaces(product))
        return "redirect:/"
    }

    private fun trimSpaces(product: ProductDto): ProductDto {
        return product.copy(
            title = product.title.trim(),
            description = product.description.trim(),
            vendorCode = product.vendorCode.trim()
        )
    }

    @GetMapping(value = ["/"])
    fun products(): String {
        return "products"
    }

    @GetMapping(value = ["/create"])
    @PreAuthorize("hasAuthority('ADMIN')")
    fun create(model: ModelMap): String {
        val product = ProductDto(null, "", "", "", "", -1)
        model.addAttribute("product", product)
        return "createProduct"
    }

    @GetMapping(value = ["/edit"])
    @PreAuthorize("hasAuthority('ADMIN')")
    fun edit(id: String?, model: ModelMap): String {
        if (id != null) {
            val product = productService.findProduct(id)
            if (product != null) {
                model.addAttribute("product", product)
                return "createProduct"
            } else {
                throw ResourceNotFoundException()
            }
        } else {
            throw ResourceNotFoundException()
        }
    }

    @GetMapping(value = ["/login"])
    fun getLogin(): String {
        return "login"
    }

    @GetMapping(value = ["/stocks"])
    fun getStocks(): String {
        return "createProduct"
    }
}