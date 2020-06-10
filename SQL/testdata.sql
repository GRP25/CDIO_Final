--Testdatj
--Users
INSERT INTO Users (firstname, surname, initials, cpr) values ('Peter','Olsen', 'PO','1102911234');
INSERT INTO Users (firstname, surname, initials, cpr) values ('Ole','Petersen', 'OP','1102921234');

--Userroles
INSERT INTO UserRole (userId, roleName) values (1, 'Admin');
INSERT INTO UserRole (userId, roleName) values (1, 'Pharmaceut');
INSERT INTO UserRole (userId, roleName) values (1, 'Produktionsleder');
INSERT INTO UserRole (userId, roleName) values (2, 'Produktionsleder');
INSERT INTO UserRole (userId, roleName) values (2, 'Laborant');

INSERT INTO Commodity (commodityName, supplier) values ("A", "ABC Exports");
INSERT INTO Commodity (commodityName, supplier) values ("B", "MD Exports");

INSERT INTO CommodityBatch (commodityId, weight ) values(1,2.3);

INSERT INTO ProduktBatch (status, prescriptionId) values (1, 1);
INSERT INTO ProduktBatch (status, prescriptionId) values (1, 2);

INSERT INTO  ProduktBatchComp (commodityId, userId, tara, netto) values (1, 1, 2.4, 5.5);
INSERT INTO  ProduktBatchComp (commodityId, userId, tara, netto) values (1, 1, 3.4, 3.5);

INSERT INTO  Prescription (prescriptionName) values("LemonWithWater");
INSERT INTO  Prescription (prescriptionName) values("MelonWithWater");

INSERT INTO PrescriptionComp (commodityId, nomNetto, tollerance) values (1, 2.3, 4.5);
