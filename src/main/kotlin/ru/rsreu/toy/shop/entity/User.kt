package ru.rsreu.toy.shop.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import ru.rsreu.toy.shop.enums.UserRoleEnum


@Document("USERS")
data class User(
    @Id
    @Field("_id")
    val login: String,
    val password: String,
    val role: UserRoleEnum
)