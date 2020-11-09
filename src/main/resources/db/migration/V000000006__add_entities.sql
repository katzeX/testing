CREATE SEQUENCE seq_discount
  INCREMENT BY 1
  MINVALUE 1
  NO CYCLE;

CREATE TABLE discounts
(
  id            BIGINT DEFAULT nextval('seq_discount') PRIMARY KEY,
  book_id       BIGINT NOT NULL,
  discount_price    DOUBLE PRECISION,
  start_date     TIMESTAMP,
  end_date       TIMESTAMP,
  CONSTRAINT fk_book_discount FOREIGN KEY (book_id) REFERENCES books (id)
);

CREATE SEQUENCE seq_review
  INCREMENT BY 1
  MINVALUE 1
  NO CYCLE;

CREATE TABLE reviews
(
  id            BIGINT DEFAULT nextval('seq_review') PRIMARY KEY,
  book_id       BIGINT NOT NULL,
  text_review   VARCHAR,
  user_id       BIGINT NOT NULL,
  CONSTRAINT fk_book_review FOREIGN KEY (book_id) REFERENCES books (id),
  CONSTRAINT fk_user_review FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE SEQUENCE seq_wish_list
  INCREMENT BY 1
  MINVALUE 1
  NO CYCLE;

CREATE TABLE wishlist
(
  id            BIGINT DEFAULT nextval('seq_wish_list') PRIMARY KEY,
  book_id       BIGINT NOT NULL,
  user_id       BIGINT NOT NULL,
  CONSTRAINT fk_book_wish FOREIGN KEY (book_id) REFERENCES books (id),
  CONSTRAINT fk_user_wish FOREIGN KEY (user_id) REFERENCES users (id)
);



