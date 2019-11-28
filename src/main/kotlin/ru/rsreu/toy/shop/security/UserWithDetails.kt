package ru.rsreu.toy.shop.security

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User

class UserWithDetails(
    login: String,
    password: String,
    roles: Set<SimpleGrantedAuthority>,
    val firstName: String
) : User(login, password, roles)