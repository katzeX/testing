package com.internship.bookstore.service;


import com.internship.bookstore.model.User;
import com.internship.bookstore.repository.UserRepository;
import com.internship.bookstore.utils.exceptions.BookStoreException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.internship.bookstore.utils.exceptions.ExceptionType.USER_NOT_FOUND;
import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> {
                    log.warn("User with email [{}] was not found in the database", email);
                    return BookStoreException.of(USER_NOT_FOUND, email);
                }
        );

        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("user"));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    public User getUser() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;

        if (user instanceof UserDetails) {
             email = ((UserDetails) user).getUsername();
        } else {
             email = user.toString();
        }

        return userRepository.findByEmail(email).orElseThrow(
                () -> {
                    log.warn("User with email [{}] was not found in the database", email);
                    return BookStoreException.of(USER_NOT_FOUND, email);
                }
        );
    }
}
