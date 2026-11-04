# Modna kolekcija

## Članovi tima

- Amel Kolasević
- Dino Matković

## Opis aplikacije

Modna kolekcija 2026 je Spring MVC web aplikacija za prikaz i upravljanje brandovima, proizvodima i kategorijama satova. Aplikacija omogućava pregled podataka kroz web stranice, dodavanje novih proizvoda i kategorija, izmjenu postojećih kategorija, kao i dohvat kategorija kroz REST endpoint u JSON formatu.

Podaci su povezani sa MariaDB relacionom bazom podataka.

## Tehnologije

- Java 27
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MariaDB
- Maven
- HTML/CSS

## Modeli i relacije

Aplikacija ima tri glavna modela: `Brand`, `Product` i `Category`.

### Brand

Brand predstavlja proizvođača i sadrži:

- `id`
- `name`
- `dateCreated`
- `locationCount`
- listu proizvoda

### Product

Product predstavlja proizvod i sadrži:

- `id`
- `name`
- `price`
- `description`
- `category`
- `brand`

### Category

Category predstavlja kategoriju proizvoda i sadrži:

- `id`
- `name`
- `description`
- listu proizvoda

### Relacije

Jedan brand može imati više proizvoda:

```text
Brand 1 ---- * Product
```

Jedna kategorija može imati više proizvoda:

```text
Category 1 ---- * Product
```

Primjeri:

- Seiko ima proizvode: 5, Prospex, Presage
- Casio ima proizvode: GSHOCK, EDIFICE
- Kategorija Sport može sadržavati proizvode: Prospex, EDIFICE

## Funkcionalnosti

- prikaz svih brandova
- prikaz svih proizvoda
- prikaz svih kategorija
- dodavanje novog proizvoda postojećem brandu
- dodavanje nove kategorije
- izmjena postojeće kategorije
- povezivanje proizvoda sa brandom i kategorijom
- REST endpoint za dohvat kategorija u JSON formatu
- spremanje podataka u MariaDB bazu

## Rute

| Ruta | Opis |
|---|---|
| `/` | Preusmjerava na `/brands` |
| `/brands` | Lista svih brandova |
| `/products` | Lista svih proizvoda |
| `/categories` | Lista svih kategorija |
| `/categories/add` | Forma za dodavanje nove kategorije |
| `/categories/edit/{id}` | Forma za izmjenu kategorije |
| `/categories/update/{id}` | Ažuriranje postojeće kategorije |
| `/brands/{id}/products/add` | Forma za dodavanje proizvoda brandu |
| `/api/categories` | REST endpoint koji vraća kategorije kao JSON |
| `/api/categories/{id}` | REST endpoint koji vraća jednu kategoriju kao JSON |

## Baza podataka

Aplikacija koristi MariaDB bazu podataka pod nazivom `kolekcija`. Konfiguracija konekcije nalazi se u fajlu `src/main/resources/application.properties`.

Hibernate automatski kreira i ažurira tabele na osnovu JPA entiteta.


### Lista brandova

![Lista brandova](src/main/resources/screenshots/slika1.png)

### Lista proizvoda

![Lista proizvoda](src/main/resources/screenshots/slika2.png)

## Korišteni alati

- JetBrains IntelliJ IDEA
- JetBrains AI Assistant
- -GitHub Copilot plugin
- MariaDB
