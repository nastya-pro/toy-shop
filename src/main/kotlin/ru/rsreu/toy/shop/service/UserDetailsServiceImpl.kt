package ru.rsreu.toy.shop.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.rsreu.toy.shop.repository.UserRepository
import ru.rsreu.toy.shop.security.UserWithDetails

@Service
class UserDetailsServiceImpl(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByIdOrNull(username)
            ?: throw UsernameNotFoundException("User not found")
        val roles = setOf(SimpleGrantedAuthority(user.role.name))
        return UserWithDetails(user.login, user.password, roles, user.firstName)
    }
}