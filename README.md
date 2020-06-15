# CDIO_Final
## Endpoints
### Prescription Comp
GET     https://api.mama.sh/api/PrescriptionComp
POST    https://api.mama.sh/api/PrescriptionComp
PUT     https://api.mama.sh/api/PrescriptionComp
GET     https://api.mama.sh/api/PrescriptionComp/component
GET     https://api.mama.sh/api/PrescriptionComp/{presID}
### Prescriptions
GET     https://api.mama.sh/api/Prescriptions
POST    https://api.mama.sh/api/Prescriptions
PUT     https://api.mama.sh/api/Prescriptions
GET     https://api.mama.sh/api/Prescriptions/ID/{PrescriptionID}
### Productbatch
GET     https://api.mama.sh/api/ProductBatchs
POST    https://api.mama.sh/api/ProductBatchs
### Productbatch Comp
POST    https://api.mama.sh/api/ProductBatchs/Comp
GET     https://api.mama.sh/api/ProductBatchs/Comp/{ProductID}
GET     https://api.mama.sh/api/ProductBatchs/ID/{ProductID}
### Aner ikke hvad det her er??
GET     https://api.mama.sh/api/application.wadl
### Commodity
GET     https://api.mama.sh/api/commodity
POST    https://api.mama.sh/api/commodity
PUT     https://api.mama.sh/api/commodity
GET     https://api.mama.sh/api/commodity/{commodity_id}
### Commodity Batch
GET     https://api.mama.sh/api/commodityBatch
POST    https://api.mama.sh/api/commodityBatch
PUT     https://api.mama.sh/api/commodityBatch
GET     https://api.mama.sh/api/commodityBatch/list/{commodity_id}
GET     https://api.mama.sh/api/commodityBatch/{commodityBatch_id}
### ProductBatch Comp igen??
GET     https://api.mama.sh/api/productbatchcomp
POST    https://api.mama.sh/api/productbatchcomp
GET     https://api.mama.sh/api/productbatchcomp/ID/{ProductID}
### User Resource
GET     https://api.mama.sh/api/userresource
POST    https://api.mama.sh/api/userresource
PUT     https://api.mama.sh/api/userresource
DELETE  https://api.mama.sh/api/userresource/{userID}
GET     https://api.mama.sh/api/userresource/{userID}


## Vigtige links
[Opgavebeskrivelsen](https://docs.google.com/document/d/1QrAzcQmpb-4YLtxR1y-2_UD1ep6b3zqIt3s0HpE95iM/edit)

[Gantt diagram](https://docs.google.com/spreadsheets/d/1CNBKCBNwR9ypWmpiL89Cq-r3YfgAK80_uBcye_2FB7k/edit?fbclid=IwAR1zHT7rFR00NNegIhTMGHC9Neyvlbj9UqFP4hxhQvGWHG5SgxCR0BYLT04#gid=0)

## Noter
Hvis vi laver vores egen vægt så skal vi lave brutto kontrol på afvejningen (dvs. efter at man har fjernet tara og netto, så skal vægten vise 0)

## Spørgsmål til hjælpelære
- Skal det være en single page application?
    __ikke et krav__
- Skal exteptions være med i klassediagram?
    __ja__
- Skal vi have en sql fil med?
    __det er nok en god ide men ikke et krav.__
- Login med id eller roller eller hvad fanden?
    __det bestemmer vi selv.__
- Spørg om funktionalitetslag (UserService) skal den være der?.


## TODO

## Ændringer til Klasse diagram

- Ret ProductBatchComp diagrammet til at kunne tage endnu et parameter ind i IProduktBatchKompDAO 
- Tilføj supplier til commodityBatch i klasse diagram

## Things i want to do before i graduate
- Find på noget smart til de roles

- start og slut dato i ProductBatch

## Agenda til kl 16:30
- getCommodityBatchList Mangler der ikke en condition i sql statement?
- Snak omkring mappe struktur
- Bliv enige om at det skal være ArrayList eller bare List
