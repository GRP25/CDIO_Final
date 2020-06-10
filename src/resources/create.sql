CREATE TABLE Users (
    userId int NOT NULL AUTO_INCREMENT,
    firstname varchar(10),
    surname varchar(10),
    initials varchar(4),
    status int NOT NULL DEFAULT 1,
    cpr varchar(10),
    PRIMARY KEY (userId)
);
// hooo
CREATE TABLE Roles (
    roleName VARCHAR(36) NOT NULL,
    PRIMARY KEY ( roleName )
);

CREATE TABLE UserRole (
    userId INT NOT NULL,
    roleName VARCHAR(36) NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId) ON DELETE CASCADE,
    FOREIGN KEY (roleName) REFERENCES Roles(roleName),
    PRIMARY KEY (roleName, userId)
);


CREATE TABLE Commodity (
    commodityId int NOT NULL,
    commodityName varchar(20),
    PRIMARY KEY (commodityId)
);

CREATE TABLE CommodityBatch (
    commodityBatchId int NOT NULL,
    commodityId int,
    weight double,
    supplier varchar(20),
    PRIMARY KEY (commodityBatchId),
    FOREIGN KEY (commodityId) REFERENCES Commodity(commodityId)
);

CREATE TABLE Prescription (
    prescriptionId int NOT NULL,
    prescriptionName varchar(20),
    PRIMARY KEY (prescriptionId)
);

CREATE TABLE ProduktBatch (
    productBatchId int NOT NULL,
    prescriptionId int,
    startDate date,
    endDate date,
    status int,
    PRIMARY KEY (productBatchId),
    FOREIGN KEY (prescriptionId) REFERENCES Prescription(prescriptionId)
);

CREATE TABLE ProduktBatchComp (
    productBatchId int NOT NULL,
    commodityBatchId int,
    userId int,
    tara double,
    netto double,
    PRIMARY KEY (productBatchId, commodityBatchId),
    FOREIGN KEY (productBatchId) REFERENCES ProduktBatch(productBatchId),
    FOREIGN KEY (commodityBatchId) REFERENCES CommodityBatch(commodityBatchId),
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

CREATE TABLE PrescriptionComp (
    prescriptionId int NOT NULL,
    commodityId int,
    nomNetto double,
    tollerance double,
    PRIMARY KEY (prescriptionId, commodityId),
    FOREIGN KEY (prescriptionId) REFERENCES Prescription(prescriptionId),
    FOREIGN KEY (commodityId) REFERENCES Commodity(commodityId)
);

INSERT INTO Roles (roleName) VALUES ('Admin'), ('Pharmaceut'), ('Produktionsleder'), ('Laborant')
