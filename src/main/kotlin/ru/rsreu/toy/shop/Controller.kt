package ru.rsreu.toy.shop

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping(value=["/products"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun products(): List<Product> {
        val product1=Product("Мишка", "img/Мишка.jpg","Милый плюшевый мишка станет лучшим другом вашему ребенку.","023498", 1700)
        val product2=Product("Пикачу","img/Пикачу.jpg","Детектив Пикачу поможет найти сладости и конечно же кофе.","190384",987)
        val product3=Product("Пингвинёнок","img/Пингвинёнок.jpg","Мягкий пингвинёнок скрасит холодные и грустные вечера.","193278",1500)
        return listOf(product1,product2,product3)
    }
}