- Data Updater - bring and update the data from www.thesportsdb.com/api.php to local database from the docker container:
    - src/main/java/com/football/football_stats/data_updater
- API - expose the data from backend to frontend:
    - src/main/java/com/football/football_stats/api
- Common - the common files used between services (eg. Entities, Repositories, etc.)
    - src/main/java/com/football/football_stats/common

---

More infos about the project are found in the README.md from the root folder.