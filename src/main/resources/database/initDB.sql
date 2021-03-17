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
    performer_name varchar(40),
    composition_name varchar (40),
    PRIMARY KEY (performer_name, composition_name)
    );