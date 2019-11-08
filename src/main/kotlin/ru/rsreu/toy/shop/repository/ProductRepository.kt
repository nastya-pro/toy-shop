package ru.rsreu.toy.shop.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ru.rsreu.toy.shop.entity.Product
import java.util.*

interface ProductRepository : MongoRepository<Product, UUID>