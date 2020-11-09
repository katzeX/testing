CREATE SEQUENCE seq_vouchers
  INCREMENT BY 1
  MINVALUE 1
  NO CYCLE;

CREATE TABLE vouchers
(
  id            BIGINT DEFAULT nextval('seq_vouchers') PRIMARY KEY,
  title         VARCHAR UNIQUE,
  start_date    TIMESTAMP,
  end_date      TIMESTAMP,
  price         DOUBLE PRECISION
);
