CREATE TABLE IF NOT EXISTS ORDERS
(
    id          SERIAL PRIMARY KEY,
    customer_id VARCHAR(255)   NOT NULL,
    order_date  TIMESTAMP      NOT NULL,
    status      VARCHAR(50)    NOT NULL,
    total       DECIMAL(10, 2) NOT NULL
);
INSERT INTO orders (customer_id, order_date, status, total)
VALUES ('C001', '2024-08-05 09:00:00', 'COMPLETED', 1200.00),
       ('C002', '2024-08-05 09:15:00', 'PENDING', 800.00),
       ('C003', '2024-08-05 09:30:00', 'COMPLETED', 150.00),
       ('C004', '2024-08-05 09:45:00', 'CANCELLED', 250.00);

CREATE TABLE IF NOT EXISTS ORDER_ITEMS
(
    id         SERIAL PRIMARY KEY,
    order_id   INT            NOT NULL REFERENCES ORDERS (id),
    product_id VARCHAR(255)   NOT NULL,
    quantity   INT            NOT NULL,
    price      DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO order_items (order_id, product_id, quantity, price)
VALUES (1, 'P001', 1, 1200.00), -- Order 1 contains 1 Laptop
       (2, 'P002', 1, 800.00),  -- Order 2 contains 1 Smartphone
       (3, 'P003', 2, 150.00),  -- Order 3 contains 2 Headphones
       (4, 'P004', 1, 250.00); -- Order 4 contains 1 Office Chair


CREATE TABLE IF NOT EXISTS OUTBOX_EVENTS
(
    id             SERIAL PRIMARY KEY,
    aggregate_type VARCHAR(255) NOT NULL,
    aggregate_id   VARCHAR(255) NOT NULL,
    type           VARCHAR(255) NOT NULL,
    payload        TEXT         NOT NULL,
    timestamp      TIMESTAMP    NOT NULL
);

