DROP DATABASE pharmacy;
create database pharmacy;
USE pharmacy;
CREATE TABLE Users
(
    userId int NOT NULL
    AUTO_INCREMENT,
    firstname varchar
    (10),
    surname varchar
    (10),
    initials varchar
    (4),
    status int NOT NULL DEFAULT 1,
    cpr varchar
    (10),
    PRIMARY KEY
    (userId)
);

    CREATE TABLE Roles
    (
        roleName VARCHAR(36) NOT NULL,
        PRIMARY KEY ( roleName )
    );

    CREATE TABLE UserRole
    (
        userId INT NOT NULL,
        roleName VARCHAR(36) NOT NULL,
        FOREIGN KEY (userId) REFERENCES Users(userId) ON DELETE CASCADE,
        FOREIGN KEY (roleName) REFERENCES Roles(roleName),
        PRIMARY KEY (roleName, userId)
    );


    CREATE TABLE Commodity
    (
        commodityId int NOT NULL,
        commodityName varchar(20),
        PRIMARY KEY (commodityId)
    );

    CREATE TABLE CommodityBatch (
    commodityBatchId int NOT NULL,
    commodityId int,
    weight double,
    supplier varchar
    (20),
    PRIMARY KEY
    (commodityBatchId),
    FOREIGN KEY
    (commodityId) REFERENCES Commodity
    (commodityId)
);


    CREATE TABLE Prescription
    (
        prescriptionId int NOT NULL,
        prescriptionName varchar(20),
        PRIMARY KEY (prescriptionId)
    );

    CREATE TABLE ProductBatch
    (
        productBatchId int NOT NULL,
        prescriptionId int,
        startDate date,
        endDate date,
        status int,
        PRIMARY KEY (productBatchId)
    );

    CREATE TABLE ProductBatchComp (
    productBatchId int NOT NULL,
    commodityBatchId int,
    userId int,
    tara double,
    netto double,
    PRIMARY KEY
    (productBatchId, commodityBatchId),
    FOREIGN KEY
    (commodityBatchId) REFERENCES CommodityBatch
    (commodityBatchId),
    FOREIGN KEY
    (userId) REFERENCES Users
    (userId)
);

    CREATE TABLE PrescriptionComp (
    prescriptionId int NOT NULL,
    commodityId int,
    nomNetto double,
    tolerance double,
    PRIMARY KEY
    (prescriptionId, commodityId),
    FOREIGN KEY
    (prescriptionId) REFERENCES Prescription
    (prescriptionId),
    FOREIGN KEY
    (commodityId) REFERENCES Commodity
    (commodityId)
);
    INSERT INTO Roles
        (roleName)
    VALUES
        ('Admin'),
        ('Pharmaceut'),
        ('Produktionsleder'),
        ('Laborant');
    INSERT INTO Users
        (firstname, surname, initials, cpr)
    values
        ('Peter', 'Olsen', 'PO', '1102911234'),
        ('Ole', 'Petersen', 'OP', '1102921234');
    INSERT INTO UserRole
        (userId, roleName)
    values
        (1, 'Admin'),
        (1, 'Pharmaceut'),
        (1, 'Produktionsleder');
    INSERT INTO UserRole
        (userId, roleName)
    values
        (2, 'Laborant'),
        (2, 'Produktionsleder');
    INSERT INTO Commodity
        (commodityId, commodityName)
    values
        (1, "A");
    INSERT INTO Commodity
        (commodityId, commodityName)
    values
        (2, "B");
    INSERT INTO CommodityBatch
        (commodityBatchId, commodityId, weight, supplier )
    values(1, 1, 2.3, "MD Exports");
    INSERT INTO CommodityBatch
        (commodityBatchId, commodityId, weight, supplier )
    values(2, 2, 3.3, "MD Exports2");
    INSERT INTO ProductBatch
        (productBatchId, prescriptionId, status)
    values
        (1, 1, 2);
    INSERT INTO ProductBatch
        (productBatchId, prescriptionId, status)
    values
        (2, 2, 1);
    INSERT INTO  ProductBatchComp
        (productBatchId, commodityBatchId, userId, tara, netto)
    values
        (1, 1, 1, 2.4, 5.5);
    INSERT INTO  ProductBatchComp
        (productBatchId, commodityBatchId, userId, tara, netto)
    values
        (2, 1, 2, 3.4, 3.5);
    INSERT INTO  Prescription
        (prescriptionId, prescriptionName)
    values(1, "LemonWithWater");
    INSERT INTO  Prescription
        (prescriptionId, prescriptionName)
    values(2, "MelonWithWater");
    INSERT INTO PrescriptionComp
        (prescriptionId, commodityId, nomNetto, tolerance)
    values
        (1, 1, 2.3, 4.5);
