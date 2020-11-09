package com.internship.bookstore.service;

import com.internship.bookstore.model.Voucher;
import com.internship.bookstore.repository.VoucherRepository;
import com.internship.bookstore.utils.exceptions.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoucherService {

    private final VoucherRepository voucherRepository;
    @Value("${message.voucher.not-found}")
    private String messageVoucherNotFound;

    public Double apply(String title) {
        log.info("Validating voucher with title: [{}]", title);

        Voucher voucher = voucherRepository.findVoucherByTitle(title).orElseThrow(() -> {
            log.warn("Voucher with title [{}] was not found in the database", title);
            return new RecordNotFoundException(format(messageVoucherNotFound, title));
        });

        if (LocalDate.now().compareTo(voucher.getEndDate()) < 0) {
            return voucher.getPrice();
        }

        return null;
    }
}

