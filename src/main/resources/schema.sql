CREATE TABLE student
(
    SId INTEGER NOT NULL,
    Navn VARCHAR(50) NOT NULL,
    PRIMARY KEY (SId)
);
CREATE TABLE fag
(
    FId VARCHAR(11) NOT NULL,
    Navn VARCHAR(50) NOT NULL,
    PRIMARY KEY (FId)
);
CREATE TABLE studentFag
(
    FId VARCHAR(11) NOT NULL,
    SId INTEGER NOT NULL,
    Aar INTEGER(4),
    Karakter CHAR(1),
    Prosent INTEGER(2),
    PRIMARY KEY (SId,Fid,Aar),
    FOREIGN KEY (SId) REFERENCES student(SId),
    FOREIGN KEY (FId) REFERENCES fag(FId)
);