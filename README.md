# CDIO_Final
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

## Use case arbejde

- Martin og Oliver
  - Bruger admin og Afvejning
- Thomas og Daniel
  - Råvare og Råvarebatch
- Andrey og Mohamad
  - Pruduktionsbatch og Recept

## TODO inden milestone 1
- Klasse diagram skal være "færdigt"
- Plan over forløbet (Gantt)
    - Deadline (hvornår skal al kode være færdigt?)

## Anden TODO
- Implementering begynder med datalag Onsdag
    - Skal vi dele elementerne op mellem os.? (Users/Commodities/Prescriptions osv.)
- Skriv ned i slutningen af dagen hvad man har lavet og hvor mange timer man har brugt (evt)

## Ændringer til Klasse diagram

- Ret ProductBatchComp diagrammet til at kunne tage endnu et parameter ind i IProduktBatchKompDAO 
- Tilføj supplier til commodityBatch i klasse diagram
