# [WIP] Football Stats

 Work in progress project

Technologies:
  - Java
  - Spring Boot
  - Angular
  - PostgreSQL
  - Docker
  - Swagger (using SpringDoc)

Contains:
- dockerfiles/docker-compose.yml file to generate a postgres db container
- src/main/java/com/football/football_stats/data_updater package to bring the data from www.thesportsdb.com/api.php in the local database
- src/main/java/com/football/football_stats/api to expose the data from the local db
- src/main/java/com/football/football_stats/common for the common files used between services (eg. Entities, Repositories, etc.)
