ALTER TABLE orders
    ADD price DOUBLE PRECISION;

ALTER TABLE orders
    ADD book_id BIGINT REFERENCES books(id);

ALTER TABLE orders
    ADD user_id BIGINT REFERENCES users(id);

