CREATE TABLE exchange_rate (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    base_currency VARCHAR(3) NOT NULL,
    target_currency VARCHAR(3) NOT NULL,
    exchange_rate DOUBLE NOT NULL,
    UNIQUE KEY (date, base_currency, target_currency)
);
