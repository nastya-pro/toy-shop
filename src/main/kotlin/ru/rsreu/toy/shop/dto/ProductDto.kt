package ru.rsreu.toy.shop.dto

import java.util.*

data class ProductDto(
    val id: UUID,
    val title: String,
    val imgUrl: String,
    val description: String,
    val vendorCode: String,
    val price: Number
)