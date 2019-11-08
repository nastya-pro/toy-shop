package ru.rsreu.toy.shop.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.rsreu.toy.shop.dto.ProductDto

@RestController
class Controller {

    @GetMapping(value = ["/products"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun products(): List<ProductDto> {
        val product1 = ProductDto("Мишка", "img/Мишка.jpg", "Милый плюшевый мишка станет лучшим другом вашему ребенку.", "023498", 1700)
        val product2 = ProductDto("Пикачу", "img/Пикачу.jpg", "Детектив Пикачу поможет найти сладости и конечно же кофе.", "190384", 987)
        val product3 = ProductDto("Пингвинёнок", "img/Пингвинёнок.jpg", "Мягкий пингвинёнок скрасит холодные и грустные вечера.", "193278", 1500)
        return listOf(product1, product2, product3)
    }
}