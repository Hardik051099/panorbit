PanOrbit Application
Description
PanOrbit is a web application that provides information about countries, cities, and languages using the World database. The application allows users to search for countries, cities, and languages and view their details. Users can also sign up and log in to the application to access additional features.

Technologies Used
Java
Spring Boot
Spring Security
Hibernate
MySQL
React
Prerequisites
Before running the application, make sure you have the following installed:

Java 11 or later
MySQL
Node.js
Getting Started
Clone the repository: git clone https://github.com/example/panorbit.git
Navigate to the project directory: cd panorbit
Install the frontend dependencies: cd frontend && npm install
Create a new MySQL database for the project.
In the src/main/resources/application.properties file, update the database connection information.
Import the world.sql file into the database to populate the data.
Run the Spring Boot application: ./mvnw spring-boot:run
In a separate terminal window, start the frontend: cd frontend && npm start
Open a web browser and navigate to http://localhost:3000 to view the application.
Testing the APIs
Signup API
To test the /pan/signup API, follow these steps:

Open Postman and create a new POST request.
Set the URL to http://localhost:8081/pan/signup.
In the "Body" tab, select "raw" and "JSON" and enter the following JSON object:
perl
Copy code
{
    "firstName": "John",
    "lastName": "Doe",
    "gender": "Male",
    "email": "johndoe@example.com",
    "phoneNumber": "+1-541-754-3010"
}
Click "Send" to submit the request.
If the request is successful, the response will have a status code of 201 (Created). If the user already exists, the response will have a status code of 409 (Conflict).
Login API
To test the /pan/login API, follow these steps:

Open Postman and create a new POST request.
Set the URL to http://localhost:8081/pan/login.
In the "Body" tab, select "raw" and "JSON" and enter the following JSON object:
perl
Copy code
{
    "email": "johndoe@example.com"
}
Click "Send" to submit the request.
If the request is successful, the response will have a status code of 200 (OK), and an OTP will be sent to the user's phone number.
Search API
To test the /world/search API, follow these steps:

Open Postman and create a new GET request.
Set the URL to http://localhost:8081/pan/search?q=<search_term>, where <search_term> is the term you want to search for.
Click "Send" to submit the request.
If the request is successful, the response will have a status code of 200 (OK) and a JSON object containing the search results.

Country Details API
To test the /pan/countries/<country_code> API, follow these steps:

Open Postman and create a new GET request.
Set the URL to `http://localhost:8081/pan/country/<countryCode> , where country_code is the code of country we want to get details
Click "Send" to submit the request.
If the request is successful, the response will have a status code of 200 (OK) and a JSON object containing the country details results.

