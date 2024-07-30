Introduction
This project is a simple REST micro-service built with Spring Boot. It fetches foreign exchange rates for USD from the European Central Bank and stores this data in a PostgreSQL database. The service provides endpoints to access the stored FX rates. The external API is only called when there is no data available in the database.

Prerequisites
Java 17 or higher
Maven 3.6.3 or higher
Git

Installation and Setup

Clone the repository
bash
git clone https://github.com/Namishjain253/forex-microservice.git
cd forex-microservice


Build the project
bash
mvn clean install
Set up the database

Database Migrations
Database migrations are managed using Flyway. The migration scripts are located in the src/main/resources/db/migration directory. 
Flyway will automatically run these scripts on application startup to set up the database schema.

Running the Application
You can run the application using Maven or directly from your IDE.

Using Maven
bash
mvn spring-boot:run

Using IDE
Import the project as a Maven project.
Run the Application class from your IDE.

API Endpoints
GET localhost:8080/fx
Description: Returns FX rates from USD to EUR, GBP, JPY, and CZK. Query parameter to can be used to specify the target currency.
Request:
http
GET localhost:8080/fx?to=EUR
Response:
json
{
  "date": "2024-03-18",
  "sourceCurrency": "USD",
  "targetCurrency": "EUR",
  "exchangeRate": 0.85
}
GET localhost:8080/fx/{targetCurrency}

Description: Returns the 3 latest FX rates from USD to the specified target currency with a step of 1 day.

Request:
http
GET localhost:8080/fx/EUR

Response:
json
[
  {
    "date": "2024-03-18",
    "sourceCurrency": "USD",
    "targetCurrency": "EUR",
    "exchangeRate": 0.85
  },
  {
    "date": "2024-03-17",
    "sourceCurrency": "USD",
    "targetCurrency": "EUR",
    "exchangeRate": 0.84
  },
  {
    "date": "2024-03-16",
    "sourceCurrency": "USD",
    "targetCurrency": "EUR",
    "exchangeRate": 0.83
  }
]
Testing
Extensive and advanced tests are included in the src/test directory. Tests cover:

Unit tests for service and controller layers.
Integration tests for database interactions.
End-to-end tests for API endpoints.
Run tests using Maven:

bash
mvn test
Project Structure

css
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── fxrates/
│   │               ├── controller/
│   │               ├── model/
│   │               ├── repository/
│   │               ├── service/
│   │               └── Application.java
│   └── resources/
│       ├── db/
│       │   └── migration/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── example/
                └── fxrates/
                    ├── controller/
                    ├── service/
                    └── FxRatesApplicationTests.java
