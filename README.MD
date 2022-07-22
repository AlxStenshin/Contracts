
## Contracts

<!-- ABOUT -->

## About
Contracts is a client-server Java application, that provides functionality for storing, retrieving and analyzing generalized contract records.

Server-side developed using Spring Boot and uses PostgreSQL for data storage purposes.

Client-side is a simple JavaFX application, that provides user interaction with server side via http requests.

### How To Build:

1. Clone the repo
   ```sh
   git clone https://github.com/AlxStenshin/Contracts.git
   ```
2. Navigate to Server source dir
   ```sh
   cd Contracts/ContractsServer
   ```
3. Build and run tests using
   ```sh
   ./gradlew clean build
   ```
   

### How To Run:
1. Start server using docker-compose:
   ```sh
   docker compose up
   ```
    Or run on a local machine with
   ```sh
   ./gradlew bootJar && java -jar build/libs/ContractsServer-0.0.1-SNAPSHOT.jar
   ```
   Please provide access to Postgres server at tcp port 5433 using `postgres:postgres` for authentication while using server application is stand-alone mode


2. You can start client application using provided fat .jar for mac, windows and linux os:
   ```sh
   cd ../ContractsClient/build/libs/
   java -jar ContractsClient-1.0-SNAPSHOT.jar
   ```
   Alternatively feel free to build client application using your favorite IDE with pre-configured Gradle Tasks (run, build, jar).
