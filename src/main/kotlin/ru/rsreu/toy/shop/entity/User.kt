package ru.rsreu.toy.shop.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("USERS")
data class User(
    @Id
    val login: String,
    val password:String
)