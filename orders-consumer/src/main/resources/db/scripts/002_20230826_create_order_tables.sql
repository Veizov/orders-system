--liquibase formatted sql

--changeset denislav.veizov:002
CREATE TABLE orders.store
(
    id          integer      not null
        constraint store_pk
            primary key,
    name        varchar(255) not null,
    description text,
    website     varchar(255),
    review_url  varchar(255)
);

CREATE TABLE orders.order
(
    id                 bigserial
        constraint order_pk
            primary key,
    store_id           integer                  not null
        constraint store_order_fk
            references orders.store,
    external_id        bigint                   not null,
    shopper_first_name varchar(255)             not null,
    shopper_last_name  varchar(255)             not null,
    shopper_email      varchar(255)             not null,
    date_ordered       timestamp with time zone not null,
    date_created       timestamp with time zone not null default now()
);
create unique index store_order_unique_index on orders.order (store_id, external_id);

CREATE TABLE orders.product
(
    id           bigserial
        constraint product_pk
            primary key,
    order_id     integer                  not null
        constraint product_order_fk
            references orders.order,
    external_id  bigint                   not null,
    name         varchar(255)             not null,
    description  text,
    price        numeric(10, 2)           not null,
    quantity     integer                  not null,
    date_created timestamp with time zone not null default now()
);