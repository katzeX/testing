package com.internship.it.config;

import org.junit.jupiter.api.Disabled;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Disabled
@TestConfiguration
@EnableAutoConfiguration
@EnableJpaRepositories("com.internship.bookstore.repository")
@EntityScan("com.internship.bookstore.model")
//@ComponentScan
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
}
