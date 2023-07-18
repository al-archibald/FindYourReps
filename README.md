# FindYourReps

### FindYourReps is a web application that utilizes Java for the backend, Vue.js for the frontend, and PostgreSQL as the database. 

### The main functionality of FindYourReps is to search through the database to display the search results of United States Senators including their names, phone numbers, email addresses, and political parties.

## README - Installation and Usage

This README provides a concise guide for installing and using the project.

## Prerequisites
Before proceeding, make sure you have the following programs installed on your machine:

- Java IDE (e.g., IntelliJ IDEA)
- PostgreSQL database **_-- exact project setup guidelines can be found in README.md within Java folder._**
- pgAdmin
- Vue.js IDE (e.g, VS Code) **_-- exact project setup guidelines can be found in README.md within Vue folder._**

## Installation
1. Clone the project repository from GitHub to your local machine.
2. Open the Java project portion in your Java IDE.
3. Install any required dependencies specified in the project documentation.
4. Set up the PostgreSQL database and connect it to pgAdmin.
5. Open the Vue.js project portion in VS Code.

## Usage
1. Start the backend server by running the project in your Java IDE.
2. Open a terminal and run the shell script for the database. (e.g., `sh create.sh`).
3. Navigate to the frontend directory of the project in VS Code.
4. Install the frontend dependencies using npm (e.g., `npm install`).
5. Launch the frontend application (e.g., `npm run serve`).
6. Access the application through your web browser.
7. If new user, click _"Need a new account? Sign up"_ to register a new username and password.
8. Once registered, you will be returned to the Home page where you can login.
9. After logging in using new username and password, you can then search representatives using any bit of information from a single letter to a full name. This search is case-insensitive and is searching within the **"name"** column of the PostgreSQL database.
10. The results will be displayed in amounts of 5 per page and sorted in alphabetical ascending order by representatives' first names.
