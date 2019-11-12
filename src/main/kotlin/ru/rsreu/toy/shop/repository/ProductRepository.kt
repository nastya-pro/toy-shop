package ru.rsreu.toy.shop.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import ru.rsreu.toy.shop.entity.Product

interface ProductRepository : MongoRepository<Product, ObjectId>