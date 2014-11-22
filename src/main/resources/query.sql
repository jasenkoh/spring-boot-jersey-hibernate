CREATE TABLE member
(
  id serial NOT NULL,
  first_name character varying NOT NULL,
  last_name character varying NOT NULL,
  email character varying NOT NULL,
  CONSTRAINT pk_user_id PRIMARY KEY (id)
)

CREATE TABLE product
(
  id serial NOT NULL,
  name character varying NOT NULL,
  currency character varying NOT NULL,
  regular_price numeric NOT NULL,
  discount_price numeric NOT NULL,
  member_id bigint NOT NULL,
  CONSTRAINT pk_product_id PRIMARY KEY (id),
  CONSTRAINT fk_product__member FOREIGN KEY (member_id)
      REFERENCES member (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)