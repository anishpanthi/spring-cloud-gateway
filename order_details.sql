create table if not exists order_details
(
    order_id int not null primary key ,
    item_name varchar(100) not null,
    item_price int not null,
    total_quantity int not null,
    total_amount double precision not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
    )
