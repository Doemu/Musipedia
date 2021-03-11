CREATE TABLE IF NOT EXISTS Performer
(
      performerName varchar(40) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Composition
(
    compositionName varchar(40) PRIMARY KEY
    );

CREATE TABLE IF NOT EXISTS PerformedComposition
(
    performerName varchar(40),
    compositionName varchar (40),
    PRIMARY KEY (performerName, compositionName)
    );