# REST Assured API Test Automation

API test automation framework built with **Java, REST Assured, TestNG and Maven**, testing the public [Restful-Booker](https://restful-booker.herokuapp.com) practice API.

![Java](https://img.shields.io/badge/Java-17-blue) ![Maven](https://img.shields.io/badge/Maven-build-orange)

<!-- After you add GitHub Actions, add the CI badge here:
![CI](https://github.com/<your-username>/restassured-api-tests/actions/workflows/tests.yml/badge.svg) -->

## What this project covers

- CRUD operations: GET, POST, PUT, PATCH, DELETE
- Authentication (token generation and use)
- Request chaining (create -> read -> update -> delete)
- Positive and negative test cases (400, 403, 404)
- Response validation with Hamcrest matchers
- JSON schema validation
- Reusable request/response specifications
- Data-driven tests with TestNG `@DataProvider`
- HTML test reports

## Tech stack

| Tool | Purpose |
|---|---|
| Java 17 | Programming language |
| REST Assured | API testing library |
| TestNG | Test runner and assertions |
| Maven | Build and dependency management |
| Hamcrest | Response matchers |
| Extent Reports | Test reporting |

## Project structure

```
restassured-api-tests/
├── pom.xml
├── testng.xml
├── README.md
└── src/
    └── test/
        ├── java/
        │   └── com/shivam/api/
        │       ├── tests/         # Test classes
        │       ├── models/        # POJOs (request/response bodies)
        │       └── utils/         # Specs, config, helpers
        └── resources/
            ├── config.properties  # Base URL, credentials
            └── schemas/           # JSON schema files
```

(Update this to match your actual folders.)

## Prerequisites

- JDK 19 or higher
- Maven 3.9 or higher
- Git

Check your setup:

```bash
java -version
mvn -version
```

## How to run the tests

```bash
# Clone the repository
git clone https://github.com/shivamj1007/restassured-api-tests.git
cd restassured-api-tests

# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=BookingTests
```

## Test reports

After a run, open the report here:

```
target/surefire-reports/index.html
```

(Change this path if you use Extent Reports.)

## Sample test scenarios

| # | Scenario | Type | Expected result |
|---|---|---|---|
| 1 | Get all bookings | Positive | 200 and a non-empty list |
| 2 | Create a booking with valid data | Positive | 200 and a booking ID is returned |
| 3 | Get a booking by ID | Positive | 200 and the correct details |
| 4 | Update a booking without a token | Negative | 403 Forbidden |
| 5 | Get a booking with an invalid ID | Negative | 404 Not Found |

(Replace with your real test cases.)

## Notes

- Tests run against a public practice API, so data resets periodically and the service can occasionally be slow or down. Re-run before assuming a test is broken.
- The credentials used (`admin` / `password123`) are the public practice credentials published by Restful-Booker. No private data is stored in this repo.

## Roadmap

- [ ] Add GitHub Actions CI pipeline
- [ ] Add JSON schema validation tests
- [ ] Add Docker support
- [ ] Add a Python (Pytest + Requests) version of the same tests

## Author

**Shivam**
QA Automation Engineer
[LinkedIn](https://linkedin.com/in/shivam-jangid-b19716a8) | [GitHub](https://github.com/<your-username>)
