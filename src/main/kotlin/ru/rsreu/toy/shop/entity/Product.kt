package ru.rsreu.toy.shop.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document("PRODUCTS")
data class Product(
    @Id
    @Field("_id")
    val id: ObjectId,
    val title: String,
    val imgUrl: String,
    val description: String,
    val vendorCode: String,
    val price: Number
)