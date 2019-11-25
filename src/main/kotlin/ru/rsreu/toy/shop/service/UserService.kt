package ru.rsreu.toy.shop.service

import org.springframework.stereotype.Service
import ru.rsreu.toy.shop.dto.UserDto
import ru.rsreu.toy.shop.repository.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun login(user: UserDto): Boolean{
        return true
    }
}