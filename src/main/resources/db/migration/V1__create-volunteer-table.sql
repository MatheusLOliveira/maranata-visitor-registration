CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE volunteer (
    id  UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(150) NOT NULL,
    role VARCHAR(50) NOT NULL
);