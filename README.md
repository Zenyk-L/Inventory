# Todo List Application

This is a Spring Boot application to manage a simple inventory system for a store. The system should allow users to view a list of available products,
 add new products, and update existing ones. Each product should have a name, description, price, and quantity. Use Hibernate to persist the product
 information in a MySQL database.

## Features

- CRUD operations with Products

## Prerequisites

Before running the application, make sure you have the following prerequisites installed on your system:

- Java 17 or higher
- MySQL database server

## Setup

1. Clone the repository: 
    https://github.com/Zenyk-L/Inventory.git

2. Update the database configuration in `src/main/resources/application.properties` with your PostgreSQL database settings:

spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=your_username
spring.datasource.password=your_password

## Running the Application

1. Start the MySQL database server.

2. Run the application:

   The application should now be accessible at `http://localhost:8080`.

## API Endpoints

- Get all: GET http://localhost:8080/products
- Create: POST http://localhost:8080/products
- Updatel: PUT http://localhost:8080/products/{id}

## Usage

You can use a tool like Postman to interact with the API endpoints and manage product items. 

###  Feedback

- Was it easy to complete the task using AI? 

Yes it was easy to complete the task using AI, because it generate for you almost ready code.
It was needed only add some simple things like getter and setter. 

- How long did task take you to complete? (Please be honest, we need it to gather anonymized statistics) 

About 2-2.5 hours.

- Was the code ready to run after generation? What did you have to change to make it usable?

It was straight  ready to run. Only fixed controller response type.

- Which challenges did you face during completion of the task?

It was a little hard to build proper prompt to get ready code after one request.
 Some times if I try to build clarifying prompts in answer was not matched types

- Which specific prompts you learned as a good practice to complete the task?

Tried to build prompts as much detailed with more terminology.




