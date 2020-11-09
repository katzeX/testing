package com.internship.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "vouchers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Voucher {
    @Id
    @SequenceGenerator(name = "voucher_id_generator", sequenceName = "seq_vouchers", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voucher_id_generator")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "price")
    private Double price;
}
