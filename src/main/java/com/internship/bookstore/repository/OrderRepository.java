package com.internship.bookstore.repository;

import com.internship.bookstore.model.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<BookOrder, Long> {
}
