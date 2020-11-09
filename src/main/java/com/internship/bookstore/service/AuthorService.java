package com.internship.bookstore.service;

import com.internship.bookstore.api.dto.AuthorResponseDto;
import com.internship.bookstore.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.internship.bookstore.utils.mappers.AuthorMapper.mapAuthorToAuthorResponseDto;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public List<AuthorResponseDto> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(mapAuthorToAuthorResponseDto)
                .collect(toList());
    }
}
