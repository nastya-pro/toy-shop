package ru.rsreu.toy.shop.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.dto.UpdateProductDto
import ru.rsreu.toy.shop.service.ImageService
import ru.rsreu.toy.shop.service.ProductService

@Controller
open class Controller(
    private val productService: ProductService,
    private val imageService: ImageService
) {
    @PostMapping(value = ["/createProduct"])
    @PreAuthorize("hasAuthority('ADMIN')")
    open fun createProduct(
        @RequestParam title: String,
        @RequestParam("img") img: MultipartFile,
        @RequestParam description: String,
        @RequestParam vendorCode: String,
        @RequestParam price: Long
    ): String {
        val imageId = imageService.saveImg(img)
        val product = UpdateProductDto(title.trim(), imageId, description.trim(), vendorCode, price)
        productService.createProduct(product)
        return "redirect:/"
    }

    @PostMapping(value = ["/updateProduct"])
    @PreAuthorize("hasAuthority('ADMIN')")
    open fun updateProduct(
        @RequestParam id: String,
        @RequestParam title: String,
        @RequestParam("img") img: MultipartFile,
        @RequestParam description: String,
        @RequestParam vendorCode: String,
        @RequestParam price: Long
    ): String {
        val imgId = if (!img.isEmpty){
            val oldImgId = productService.getImageId(id)
            imageService.deleteImg(oldImgId)
            imageService.saveImg(img)
        } else {
            productService.getImageId(id)
        }
        val product = UpdateProductDto(title.trim(), imgId, description.trim(), vendorCode, price)
        productService.updateProduct(id, product)
        return "redirect:/"
    }

    @GetMapping(value = ["/"])
    open fun products(): String {
        return "products"
    }

    @GetMapping(value = ["/create"])
    @PreAuthorize("hasAuthority('ADMIN')")
    open fun create(model: ModelMap): String {
        val product = ProductDto(null, "", "", "", "", -1)
        model.addAttribute("product", product)
        return "createProduct"
    }

    @GetMapping(value = ["/edit"])
    @PreAuthorize("hasAuthority('ADMIN')")
    open fun edit(id: String?, model: ModelMap): String {
        if (id != null) {
            val product = productService.findProduct(id)
            model.addAttribute("product", product)
            return "createProduct"
        } else {
            throw ResourceNotFoundException()
        }
    }

    @GetMapping(value = ["/login"])
    open fun getLogin(): String {
        return "login"
    }
}