CREATE SEQUENCE seq_authors
  INCREMENT BY 1
  MINVALUE 1
  NO CYCLE;

CREATE TABLE authors
(
    id BIGINT DEFAULT nextval('seq_authors') PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL
);

CREATE SEQUENCE seq_books
  INCREMENT BY 1
  MINVALUE 1
  NO CYCLE;

CREATE TABLE books
(
    id BIGINT DEFAULT nextval('seq_books') PRIMARY KEY,
    title VARCHAR NOT NULL,
    author_id BIGINT REFERENCES authors(id),
    available_books BIGINT,
    price DOUBLE PRECISION,
    book_language VARCHAR
);

CREATE SEQUENCE seq_orders
  INCREMENT BY 1
  MINVALUE 1
  NO CYCLE;


CREATE TABLE orders
(
    id BIGINT DEFAULT nextval('seq_orders') PRIMARY KEY,
    number_of_items BIGINT
);

CREATE SEQUENCE seq_users
  INCREMENT BY 1
  MINVALUE 1
  NO CYCLE;

CREATE TABLE users
(
  id               BIGINT DEFAULT nextval('seq_users') PRIMARY KEY,
  email            VARCHAR
);

CREATE SEQUENCE seq_user_roles
  INCREMENT BY 1
  MINVALUE 1
  NO CYCLE;

CREATE TABLE user_roles
(
  id            BIGINT DEFAULT nextval('seq_user_roles') PRIMARY KEY,
  user_id       BIGINT NOT NULL,
  role          varchar,
  CONSTRAINT fk_user_roles_users FOREIGN KEY (user_id) REFERENCES users (id)
);



