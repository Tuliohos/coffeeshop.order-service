BEGIN TRANSACTION;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

    CREATE TABLE orders (
        id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
        user_id UUID NOT NULL,
        total_amount DECIMAL(10, 2) NOT NULL,
        order_date TIMESTAMP NOT NULL,
        status VARCHAR(20) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

    CREATE TABLE products (
            id UUID PRIMARY KEY,
            name VARCHAR(255) NOT NULL,
            calories INT,
            description TEXT,
            price DECIMAL(10, 2),
            type VARCHAR(20),
            is_vegan BOOLEAN,
            is_gluten_free BOOLEAN,
            image_url VARCHAR(255)
    );

    CREATE TABLE order_products (
        id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
        order_id UUID NOT NULL,
        product_id UUID NOT NULL,
        quantity INT NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

    ALTER TABLE order_products ADD FOREIGN KEY (order_id) REFERENCES orders(id);
    ALTER TABLE order_products ADD FOREIGN KEY (product_id) REFERENCES products(id);

COMMIT;