CREATE TABLE IF NOT EXISTS PRODUCTS
(
    id          SERIAL PRIMARY KEY,
    product_id  VARCHAR(255) UNIQUE NOT NULL,
    name        VARCHAR(255)        NOT NULL,
    description TEXT,
    category    VARCHAR(255),
    price       DECIMAL(10, 2)      NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO products (product_id, name, description, category, price)
VALUES ('P001', 'Laptop', 'High-performance laptop', 'Electronics', 1200.00),
       ('P002', 'Smartphone', 'Latest model smartphone', 'Electronics', 800.00),
       ('P003', 'Headphones', 'Noise-cancelling headphones', 'Electronics', 150.00),
       ('P004', 'Office Chair', 'Ergonomic office chair', 'Furniture', 250.00);


CREATE TABLE IF NOT EXISTS INVENTORY
(
    id         SERIAL PRIMARY KEY,
    product_id VARCHAR(255) NOT NULL REFERENCES PRODUCTS (product_id),
    quantity   INT          NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO inventory (product_id, quantity)
VALUES ('P001', 50),
       ('P002', 200),
       ('P003', 150),
       ('P004', 75);


CREATE TABLE IF NOT EXISTS INVENTORY_TRANSACTIONS
(
    id                   SERIAL PRIMARY KEY,
    product_id           VARCHAR(255) NOT NULL REFERENCES PRODUCTS (product_id),
    transaction_type     VARCHAR(50)  NOT NULL, -- e.g., "INCREASE", "DECREASE"
    quantity             INT          NOT NULL,
    order_id             INT,                    -- Nullable, can link back to an order
    transaction_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
