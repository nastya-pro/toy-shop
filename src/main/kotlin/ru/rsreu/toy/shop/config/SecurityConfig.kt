package ru.rsreu.toy.shop.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import ru.rsreu.toy.shop.security.SimplePasswordEncoder

@Configuration
open class SecurityConfig(
    @Qualifier("userDetailsServiceImpl")
    private val userDetailsService : UserDetailsService
) : WebSecurityConfigurerAdapter() {

    @Bean
    open fun passwordEncoder():PasswordEncoder = SimplePasswordEncoder()/*BCryptPasswordEncoder()*/

    @Autowired
    fun registerGlobalAuthentication(auth : AuthenticationManagerBuilder){
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder())
    }

    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/login**").permitAll()
            .antMatchers("/img/**","/style/**","/script/**","/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
//            .successHandler()
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
    }
}