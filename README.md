# RestAPI_Redis_caching_db

This project demonstrates the integration of Spring Boot with Redis caching to create a RESTful API for managing invoices. The application uses Redis as a caching mechanism to optimize database queries and improve performance when fetching and managing invoice records.

## Features

- Create, retrieve, update, and delete invoice records via RESTful API endpoints.
- Utilize Redis caching to store and retrieve invoice data, reducing database load.
- Implement error handling and exception classes for better control of error responses.
- Follow the Model-View-Controller (MVC) design pattern for clean and modular code structure.
- Leverage Spring Data JPA for seamless interaction with the underlying database.
- Use Spring Boot's built-in caching annotations to simplify caching configurations.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Redis Caching
- RESTful API
- Java
- Maven

## Getting Started

1. Clone this repository to your local machine.
2. Configure your Redis server connection details in the `application.properties` file.
3. Build the project using Maven: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

## API Endpoints

- `POST /redis/v1/invoice/saveInv`: Create a new invoice record.
- `GET /redis/v1/invoice/allInv`: Fetch all invoice records.
- `GET /redis/v1/invoice/getOne/{invId}`: Fetch a specific invoice by ID.
- `PUT /redis/v1/invoice/modify/{invId}`: Update an existing invoice record.
- `DELETE /redis/v1/invoice/delete/{invId}`: Delete an invoice record by ID.

## Contributions

Contributions, issues, and feature requests are welcome! Feel free to check the [Issues]([link-to-issues](https://github.com/faizal108/RestAPI_Redis_caching_db/issues)) page.

## License

This project is licensed under the [MIT License](LICENSE).


