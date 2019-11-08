package ru.rsreu.toy.shop.dto

data class ProductDto(
    val title: String,
    val imgUrl: String,
    val description: String,
    val vendorCode: String,
    val price: Number
)