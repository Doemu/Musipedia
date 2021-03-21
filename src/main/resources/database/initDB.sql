CREATE TABLE IF NOT EXISTS performer
(
    id BIGSERIAL PRIMARY KEY,
    performer_name varchar(40) UNIQUE
);

CREATE TABLE IF NOT EXISTS composition
(
    id BIGSERIAL PRIMARY KEY,
    composition_name varchar(40) UNIQUE
    );

CREATE TABLE IF NOT EXISTS performedcomposition
(
    pc_id BIGSERIAL PRIMARY KEY,
    performer_id BIGSERIAL REFERENCES performer(id),
    composition_id BIGSERIAL REFERENCES composition(id),
    UNIQUE (performer_id, composition_id)
    );

create sequence IF NOT EXISTS composition_id_seq START WITH 4;
create sequence IF NOT EXISTS performer_id_seq START WITH 4;
create sequence IF NOT EXISTS pc_id_seq START WITH 5;