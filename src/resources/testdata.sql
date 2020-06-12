/*INSERT INTO Roles (roleName) VALUES ('Admin'), ('Pharmaceut'), ('Produktionsleder'), ('Laborant');

INSERT INTO Users (firstname, surname, initials, cpr) values ('Peter','Olsen', 'PO','1102911234'), ('Ole','Petersen', 'OP','1102921234');
*/

INSERT INTO UserRole (userId, roleName) values (1, 'Admin'), (1, 'Pharmaceut'), (1, 'Produktionsleder');
INSERT INTO UserRole (userId, roleName) values (2, 'Laborant'), (2, 'Produktionsleder');

INSERT INTO Commodity (commodityId, commodityName) values (1, "A");
INSERT INTO Commodity (commodityId, commodityName) values (2, "B");

INSERT INTO CommodityBatch (commodityBatchId, commodityId, weight, supplier ) values(1,1, 2.3, "MD Exports");
INSERT INTO CommodityBatch (commodityBatchId, commodityId, weight, supplier ) values(2,2, 3.3, "MD Exports2");


INSERT INTO ProduktBatch (productBatchId, prescriptionId, status) values (1, 1, 2);
INSERT INTO ProduktBatch (productBatchId, prescriptionId, status) values (2, 2, 1);


INSERT INTO  ProduktBatchComp (productBatchId, commodityBatchId, userId, tara, netto) values (1, 1, 1, 2.4, 5.5);
INSERT INTO  ProduktBatchComp (productBatchId, commodityBatchId, userId, tara, netto) values (2, 1, 2, 3.4, 3.5);

INSERT INTO  Prescription (prescriptionId, prescriptionName) values(1, "LemonWithWater");
INSERT INTO  Prescription (prescriptionId, prescriptionName) values(2, "MelonWithWater");

INSERT INTO PrescriptionComp (prescriptionId, commodityId, nomNetto, tollerance) values (1, 1, 2.3, 4.5);

