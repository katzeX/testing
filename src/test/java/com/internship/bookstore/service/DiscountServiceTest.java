package com.internship.bookstore.service;

import com.internship.bookstore.api.dto.DiscountResponseDto;
import com.internship.bookstore.model.Discount;
import com.internship.bookstore.repository.BookRepository;
import com.internship.bookstore.repository.DiscountRepository;
import com.internship.bookstore.utils.exceptions.RecordNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static com.internship.TestConstants.ID_ONE;
import static com.internship.bookstore.utils.BookTestUtils.BOOK_ONE;
import static com.internship.bookstore.utils.DiscountTestUtils.DISCOUNT_ONE;
import static com.internship.bookstore.utils.DiscountTestUtils.DISCOUNT_REQUEST_DTO;
import static com.internship.bookstore.utils.DiscountTestUtils.DISCOUNT_RESPONSE_DTO;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DiscountServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private DiscountRepository discountRepository;

    @InjectMocks
    private DiscountService discountService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(discountService, "messageBookNotFound",
                "Book with id %s was not found");
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(bookRepository, discountRepository);
    }

    @Test
    public void shouldCalculateDiscountAndSaveIt() {
        final DiscountResponseDto expectedDiscountResponseDto = DISCOUNT_RESPONSE_DTO;

        when(bookRepository.findBookById(ID_ONE)).thenReturn(Optional.of(BOOK_ONE));
        when(discountRepository.save(any(Discount.class))).thenReturn(DISCOUNT_ONE);

        final DiscountResponseDto actualDiscountResponseDto = discountService.save(DISCOUNT_REQUEST_DTO);

        //assertEquals(expectedDiscountResponseDto.getDiscountPrice(), actualDiscountResponseDto.getDiscountPrice());
        //assertEquals(expectedDiscountResponseDto.getBookId(), actualDiscountResponseDto.getBookId());

        assertAll(
                () -> assertEquals(expectedDiscountResponseDto.getDiscountPrice(),
                        actualDiscountResponseDto.getDiscountPrice()),
                () -> assertEquals(expectedDiscountResponseDto.getBookId(), actualDiscountResponseDto.getBookId())
        );

        verify(discountRepository, times(1)).save(any(Discount.class));
    }

    @Test
    public void shouldThrowRecordNotFoundException() {
        when(bookRepository.findBookById(ID_ONE)).thenReturn(Optional.empty());
        assertThrows(RecordNotFoundException.class, () -> discountService.save(DISCOUNT_REQUEST_DTO));
    }
}
