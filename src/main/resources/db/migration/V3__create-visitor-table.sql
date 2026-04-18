CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE visitor (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    age INTEGER NOT NULL,
    first_feedback TEXT,
    responsible_volunteer_id UUID,
    creation_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    first_visit_date DATE NOT NULL,
    visitor_status VARCHAR(20) NOT NULL,

    CONSTRAINT fk_visitor_volunteer FOREIGN KEY (responsible_volunteer_id) REFERENCES volunteer(id)
)