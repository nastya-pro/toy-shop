package ru.rsreu.toy.shop

data class Product(
        val title: String,
        val imgUrl: String,
        val description: String,
        val vendorCode: String,
        val price: Number
)