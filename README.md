# Football Stats

---
Purposes:

- A football stats platform inspired by Flashscore, Livescore, etc., which shows the current competition tables,
  results, team info, etc. In the future, there will be added results predictions based on different algorithms.
- The personal aim for this long-term project is to improve my Spring and Angular skills by developing an increasingly
  complex platform.

---
Technologies:

- Java
- Spring/Spring Boot
- Angular (with Angular Material and RxJS)
- PostgreSQL (with Adminer)
- Swagger (using SpringDoc)
- Maven
- Docker

---
Contains:

Infrastructure:

- Docker container for PostgreSQL database with Adminer:
    - dockerfiles/docker-compose.yml

Backend:

- Data Updater - bring and update the data from www.thesportsdb.com/api.php to local database from the docker container:
    - src/main/java/com/football/football_stats/data_updater
- API - expose the data from backend to frontend:
    - src/main/java/com/football/football_stats/api
- Common - the common files used between services (eg. Entities, Repositories, etc.)
    - src/main/java/com/football/football_stats/common

Frontend:

- The frontend written in Angular and using Angular Material:
    - src/main/frontend/

---

Backend routes:
http://localhost:8080/swagger-ui.html
