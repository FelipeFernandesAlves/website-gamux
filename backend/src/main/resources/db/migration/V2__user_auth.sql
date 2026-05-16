ALTER TABLE users
    ADD COLUMN password varchar,
    ADD COLUMN role varchar DEFAULT 'USER';