INSERT INTO users VALUES (1,'test@domain.com', '$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm');

INSERT INTO authors VALUES (1, 'Test', 'Test');

INSERT INTO books(id,title, author_id, available_books, price, book_language)
VALUES (1,'Frankenstein',
        (SELECT authors.id from authors where authors.first_name='Test' AND authors.last_name='Test'),
        10, 150, 'English');

INSERT INTO vouchers
VALUES (1, 'Voucher', '2020-10-05 00:35:14.000000', '2050-11-05 00:35:21.000000', 150);