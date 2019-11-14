package ru.rsreu.toy.shop.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductDto(
    @JsonProperty("id")
    val id: String?,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("imgUrl")
    val imgUrl: String,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("vendorCode")
    val vendorCode: String,
    @JsonProperty("price")
    val price: Number
)