CREATE DATABASE product;

CREATE SCHEMA product_storage;

CREATE TABLE product_storage.item (
  id BIGSERIAL PRIMARY KEY,
  code INTEGER UNIQUE NOT NULL,
  default_name CHARACTER VARYING (256) NOT NULL
);

CREATE TABLE product_storage.attribute (
  id BIGSERIAL PRIMARY KEY,
  default_name CHARACTER VARYING (256) NOT NULL
);

CREATE TABLE product_storage.item_attribute (
  item_id BIGINT NOT NULL REFERENCES product_storage.item (id),
  attribute_id BIGINT NOT NULL REFERENCES product_storage.attribute (id),
  PRIMARY KEY (item_id, attribute_id)
);

CREATE TABLE product_storage.locale (
id SMALLSERIAL PRIMARY KEY,
name CHARACTER VARYING (32) NOT NULL
);

DROP TABLE product_storage.item_translation;

CREATE TABLE product_storage.item_translation (
  id BIGSERIAL PRIMARY KEY,
  item_id BIGINT NOT NULL REFERENCES product_storage.item (id),
  locale_id BIGINT NOT NULL REFERENCES product_storage.locale (id),
  name CHARACTER VARYING (256) NOT NULL
);

CREATE TABLE product_storage.attribute_translation (
  id BIGSERIAL PRIMARY KEY,
  attribute_id BIGINT NOT NULL REFERENCES product_storage.attribute (id),
  locale_id BIGINT NOT NULL REFERENCES product_storage.locale (id),
  name CHARACTER VARYING (256) NOT NULL
);

INSERT INTO product_storage.item (code, default_name)
VALUES
  (1, 'Telephone');

INSERT INTO product_storage.locale (name)
VALUES
  ('EN'),
  ('RU');

INSERT INTO product_storage.attribute (default_name)
VALUES
  ('Model'),
  ('Manufacture'),
  ('Screen Size');

INSERT INTO product_storage.item_attribute (item_id, attribute_id)
VALUES
  ((SELECT id FROM product_storage.item WHERE default_name = 'Telephone'), (SELECT id FROM product_storage.attribute WHERE default_name = 'Model')),
  ((SELECT id FROM product_storage.item WHERE default_name = 'Telephone'), (SELECT id FROM product_storage.attribute WHERE default_name = 'Manufacture')),
  ((SELECT id FROM product_storage.item WHERE default_name = 'Telephone'), (SELECT id FROM product_storage.attribute WHERE default_name = 'Screen Size'));

INSERT INTO product_storage.attribute_translation (attribute_id, locale_id, name)
VALUES
  ((SELECT id FROM product_storage.attribute WHERE default_name = 'Model'), (SELECT id FROM product_storage.locale WHERE name = 'EN'), 'Model'),
  ((SELECT id FROM product_storage.attribute WHERE default_name = 'Model'), (SELECT id FROM product_storage.locale WHERE name = 'RU'), 'Модель'),
  ((SELECT id FROM product_storage.attribute WHERE default_name = 'Manufacture'), (SELECT id FROM product_storage.locale WHERE name = 'EN'), 'Manufacture'),
  ((SELECT id FROM product_storage.attribute WHERE default_name = 'Manufacture'), (SELECT id FROM product_storage.locale WHERE name = 'RU'), 'Производитель'),
  ((SELECT id FROM product_storage.attribute WHERE default_name = 'Screen Size'), (SELECT id FROM product_storage.locale WHERE name = 'EN'), 'Screen Size'),
  ((SELECT id FROM product_storage.attribute WHERE default_name = 'Screen Size'), (SELECT id FROM product_storage.locale WHERE name = 'RU'), 'Размер экрана');

INSERT INTO product_storage.item_translation (item_id, locale_id, name)
VALUES
  ((SELECT id FROM product_storage.item WHERE default_name = 'Telephone'), (SELECT id FROM product_storage.locale WHERE name = 'EN'), 'Telephone'),
  ((SELECT id FROM product_storage.item WHERE default_name = 'Telephone'), (SELECT id FROM product_storage.locale WHERE name = 'RU'), 'Телефон');