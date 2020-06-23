# CDIO_Final

## Styling den 23-06-2020
* Alert og succes functioner
* Generelt ploish af tabeller
* Nogle steder står der Opret i stedet for opdater
* Råvare navn ved afvejning
## Raport Struktur
* Der skal laves noget struktur over vores rapport
    * Implementations laget skal måske deles op i 3-lagsmodellen
* Kode eksempler skal ændres fra billed til "lstlisting"
* Hvorfor er der 2 Exceptions
## Endpoints
### Prescription Comp
* GET     https://api.mama.sh/PrescriptionComp
* POST    https://api.mama.sh/PrescriptionComp
* PUT     https://api.mama.sh/PrescriptionComp
* GET     https://api.mama.sh/PrescriptionComp/component
* GET     https://api.mama.sh/PrescriptionComp/{presID}
### Prescriptions
* GET     https://api.mama.sh/Prescriptions
* POST    https://api.mama.sh/Prescriptions
* PUT     https://api.mama.sh/Prescriptions
* GET     https://api.mama.sh/Prescriptions/ID/{PrescriptionID}
### Productbatch
* GET     https://api.mama.sh/ProductBatchs
* POST    https://api.mama.sh/ProductBatchs
### Productbatch Comp
* POST    https://api.mama.sh/ProductBatchs/Comp
* GET     https://api.mama.sh/ProductBatchs/Comp/{ProductID}
* GET     https://api.mama.sh/ProductBatchs/ID/{ProductID}
### Aner ikke hvad det her er??
* GET     https://api.mama.sh/application.wadl
### Commodity
* GET     https://api.mama.sh/commodity
* POST    https://api.mama.sh/commodity
* PUT     https://api.mama.sh/commodity
* GET     https://api.mama.sh/commodity/{commodity_id}
### Commodity Batch
* GET     https://api.mama.sh/commodityBatch
* POST    https://api.mama.sh/commodityBatch
* PUT     https://api.mama.sh/commodityBatch
* GET     https://api.mama.sh/commodityBatch/list/{commodity_id}
* GET     https://api.mama.sh/commodityBatch/{commodityBatch_id}
### ProductBatch Comp igen??
* GET     https://api.mama.sh/productbatchcomp
* POST    https://api.mama.sh/productbatchcomp
* GET     https://api.mama.sh/productbatchcomp/ID/{ProductID}
### User Resource
* GET     https://api.mama.sh/userresource - Show
* POST    https://api.mama.sh/userresource - Create
* PUT     https://api.mama.sh/userresource - Update
* DELETE  https://api.mama.sh/userresource/{userID} - Inactivate
* GET     https://api.mama.sh/userresource/{userID} - Show


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

## Fejl fundet gennem Postman
- StartDate og EndDate i ProductBatch
- Lav et rework af ProductBatch og ProductBatchComp
- Få fikset Response når der oprettet en Prescription
- Fikse det der returneres i PrescriptionComp (Validation) 
- Den tilader os at give et prescrioptionID til ProductBatch selvom den ikke eksistere
- Generelt skal Validations rettes
