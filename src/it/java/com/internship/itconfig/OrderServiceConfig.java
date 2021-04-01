package com.internship.itconfig;

import com.internship.bookstore.repository.AuthorRepository;
import com.internship.bookstore.repository.BookRepository;
import com.internship.bookstore.repository.OrderRepository;
import com.internship.bookstore.repository.UserRepository;
import com.internship.bookstore.repository.VoucherRepository;
import com.internship.bookstore.service.OrderService;
import com.internship.bookstore.service.UserService;
import com.internship.bookstore.service.VoucherService;

import org.junit.jupiter.api.Disabled;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Disabled
@TestConfiguration
@EnableAutoConfiguration
@EnableJpaRepositories("com.internship.bookstore.repository")
@EntityScan("com.internship.bookstore.model")
//@ComponentScan(basePackages = {
//    "com.internship.bookstore.service",
//    "com.internship.itconfig"
//})
public class OrderServiceConfig {

//    @Bean
//    public OrderService orderService(
//            OrderRepository orderRepository,
//            BookRepository bookRepository,
//            UserService userService,
//            VoucherService voucherService) {
//        return new OrderService(orderRepository, bookRepository, userService, voucherService);
//    }
//
//    @Bean
//    public UserService userService(
//            UserRepository userRepository) {
//        return new UserService(userRepository);
//    }
//
//    @Bean
//    public VoucherService voucherService(
//            VoucherRepository voucherRepository) {
//        return new VoucherService(voucherRepository);
//    }
//
//    @Bean
//    public Prerequisites prerequisites(
//        BookRepository bookRepository,
//        AuthorRepository authorRepository,
//        UserRepository userRepository,
//        VoucherRepository voucherRepository,
//        OrderRepository orderRepository){
//        return new Prerequisites(bookRepository, authorRepository, userRepository, voucherRepository, orderRepository);
//    }
}
