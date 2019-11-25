package ru.rsreu.toy.shop.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.rsreu.toy.shop.enums.UserRolEnum
import ru.rsreu.toy.shop.repository.UserRepository

@Service
class UserDetailsServiceImpl(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user =  userRepository.findByIdOrNull(username)
            ?: throw UsernameNotFoundException("User not found")
        val roles = UserRolEnum.values()
            .map { SimpleGrantedAuthority(it.name) }.toSet()
        return User(user.login, user.password, roles)
    }
}