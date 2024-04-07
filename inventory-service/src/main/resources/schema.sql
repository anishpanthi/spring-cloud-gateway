create table if not exists inventory
(
    id serial primary key,
    item_name varchar(100) not null,
    item_price decimal(6,2) not null,
    total_available int not null,
    total_sold decimal(6,2) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);


