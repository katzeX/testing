package com.internship.bookstore.service;

import com.internship.bookstore.api.dto.OrderRequestDto;
import com.internship.bookstore.api.dto.OrderResponseDto;
import com.internship.bookstore.model.Book;
import com.internship.bookstore.model.BookOrder;
import com.internship.bookstore.repository.BookRepository;
import com.internship.bookstore.repository.OrderRepository;
import com.internship.bookstore.utils.exceptions.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.internship.bookstore.utils.mappers.OrderMapper.mapBookOrderToOrderResponseDto;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final UserService userService;
    private final VoucherService voucherService;
    @Value("${message.book.not-found}")
    private String messageBookNotFound;

    @Transactional
    public OrderResponseDto save(OrderRequestDto orderRequestDto) {
        log.warn("Saving order request for book with: id [{}]", orderRequestDto.getBookId());

        Book book = bookRepository.findBookById(orderRequestDto.getBookId()).orElseThrow(() -> {
            log.warn("Book with id [{}] was not found in the database", orderRequestDto.getBookId());
            return new RecordNotFoundException(format(messageBookNotFound, orderRequestDto.getBookId()));
        });

        Double voucherPrice = voucherService.apply(orderRequestDto.getVoucherTitle());
        BookOrder bookOrder = new BookOrder();

        if (voucherPrice != null && book.getPrice() <= voucherPrice) {
            bookOrder.setPrice(voucherPrice - book.getPrice());
        }

        bookOrder.setBook(book);
        bookOrder.setUser(userService.getUser());

        bookOrder = orderRepository.save(bookOrder);

        return mapBookOrderToOrderResponseDto.apply(bookOrder);
    }
}
