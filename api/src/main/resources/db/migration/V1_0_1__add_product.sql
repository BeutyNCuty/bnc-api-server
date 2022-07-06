create table product
(
    id             bigint auto_increment
        primary key,
    product_brand  varchar(255) null,
    product_info   varchar(255) null,
    product_name   varchar(255) null,
    product_price  int          not null,
    product_status varchar(255) null
);
