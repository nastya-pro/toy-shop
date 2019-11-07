package ru.rsreu.toy.shop

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ToyShop

fun main(args: Array<String>) {
    SpringApplication.run(ToyShop::class.java, *args)
}