ALTER TABLE volunteer ADD CONSTRAINT uk_volunteer_name UNIQUE (name);

ALTER TABLE visitor ADD CONSTRAINT uk_visitor_name UNIQUE (name);