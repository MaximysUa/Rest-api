CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS user_table
(   id BIGINT generated by default as identity PRIMARY KEY,
    user_name VARCHAR (100),
    family_name VARCHAR (100)
);

CREATE TABLE IF NOT EXISTS book_table
(   id BIGINT generated by default as identity PRIMARY KEY,
    title VARCHAR (100),
    user_entity_id BIGINT default 1,
    FOREIGN KEY (user_entity_id) REFERENCES user_table (id)
);