package ru.rsreu.toy.shop

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
open class ToyShop

fun main(args: Array<String>) {
    SpringApplication.run(ToyShop::class.java, *args)
}