CREATE TABLE IF NOT EXISTS performer
(

      performer_name varchar(40) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS composition
(
    composition_name varchar(40) PRIMARY KEY
    );

CREATE TABLE IF NOT EXISTS performedcomposition
(
    pc_id BIGSERIAL PRIMARY KEY,
    performer_name varchar(40) REFERENCES performer(performer_name),
    composition_name varchar (40) REFERENCES composition(composition_name)
    );