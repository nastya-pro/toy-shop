package ru.rsreu.toy.shop.dto

import org.bson.types.ObjectId

data class UpdateProductDto(
    val title: String,
    val imageId: ObjectId,
    val description: String,
    val vendorCode: String,
    val price: Long
)