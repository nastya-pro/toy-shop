package ru.rsreu.toy.shop.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ru.rsreu.toy.shop.entity.User

interface UserRepository: MongoRepository<User, String>