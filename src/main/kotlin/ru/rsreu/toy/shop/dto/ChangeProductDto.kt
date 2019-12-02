package ru.rsreu.toy.shop.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

data class ChangeProductDto (
    @RequestParam
    val id: String?,
    @RequestParam
    val title: String,
    @RequestParam("img")
    val img: MultipartFile?,
    @RequestParam
    val description: String,
    @RequestParam
    val vendorCode: String,
    @RequestParam
    val price: Long
)