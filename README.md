# REST & SOAP API Automation Framework

![Java](https://img.shields.io/badge/Java-21-blue)
![Maven](https://img.shields.io/badge/Maven-3.8%2B-green)
![REST Assured](https://img.shields.io/badge/REST_Assured-5.5.6-orange)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red)
![SOAP](https://img.shields.io/badge/SOAP-XML-red)
![Validation](https://img.shields.io/badge/JSON%20%2F%20XSD-Validation-success)
![GitHub stars](https://img.shields.io/github/stars/Fatma-shehata123/RESTAssuredAutomation?style=social)

> **A full-featured API automation framework using REST Assured (Java 21) for testing REST and SOAP services with JSON Schema & XSD validation.**

---

## Features

| Feature | Description |
|--------|-------------|
| **REST API Testing** | Public (`reqres.in`) + Local (`localhost:3000`) APIs |
| **SOAP API Testing** | XML-based requests with XSD validation |
| **Schema Validation** | JSON Schema + XSD Schema validation |
| **HTTP Methods** | GET, POST, PUT, PATCH, DELETE |
| **Reporting** | HTML reports via TestNG (`test-output/index.html`) |
| **Logging** | Full request/response logging with `log().all()` |
| **Modern Stack** | Java 21, REST Assured 5.5.6, TestNG 7.11.0 |

---

## Project Structure
```
RESTAssuredAutomation/
├── src/
│   └── test/
│       └── java/
│           ├── TestOnReqres.java           # Public API tests
│           ├── TestOnLocalAPI.java         # Local API CRUD + PATCH
│           ├── JsonSchemaValidationTest.java # JSON Schema validation
│           └── SoapXMLRequestAndValidator.java  # SOAP + XSD validation
├── src/test/resources/
│   ├── Schema.json                         # JSON Schema for reqres.in
│   └── calculator.xsd                      # XSD for SOAP response
├── SoapRequest/
│   └── Add.xml                             # SOAP request payload
├── test-output/                            # HTML reports
├── pom.xml
├── .gitignore
└── README.md
```

---

## Prerequisites

- **Java 21** (or higher)
- **Maven 3.8+**
- **IDE**: IntelliJ IDEA (recommended)
- **Local API (optional)**: Run `json-server` on `http://localhost:3000`

---

## Setup & Run

Clone the repository
```
git clone https://github.com/Fatma-shehata123/RESTAssuredAutomation.git
cd RESTAssuredAutomation
```

Install dependencies
```
mvn clean install
```

 Run all tests
```
mvn test
```
