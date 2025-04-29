# WildFly Jakarta EE Application with PostgreSQL

Denna applikation är byggd med Jakarta EE och körs i en WildFly-server med PostgreSQL som databas.

## Funktioner
- RESTful API för att hantera bilinformation.
- WildFly som applikationsserver.
- PostgreSQL som databas.

## Teknologier
- Jakarta EE (JAX-RS för REST API)
- WildFly (applikationsserver)
- PostgreSQL (databas)
- Docker och Docker Compose för containerisering

## Instruktioner för att bygga och köra applikationen

### Förutsättningar
1. Docker och Docker Compose måste vara installerade på din maskin.
2. Maven ska vara installerat för att bygga applikationen.

### Steg 1: Bygg applikationen
För att bygga applikationen och skapa WAR-filen, kör:

```bash
mvn clean package
