# Progrramming_Patterns_Final-Project

# Project Description

## 1. Basic Description

This is a ***group project for up to two students***, though it can also be completed individually. If done in a team, both members must actively contribute to the project, and the same project files must be submitted by both students. A demonstration may be required at the end of the semester.

## 2.  Learning Objectives

* Develop a software product that meets user requirements.
* Design a database for storing data.
* Build a database client in Java using Java Database Connectivity (JDBC).
* Implement CRUD operations within a Java application using JDBC
* Manage and manipulate data entered by the user, keeping track of changes.
* Create an internationalized application using I18N and L10N concepts along with relevant Java classes.
* Apply design patterns learned in class and implement an MVC architecture.
* Utilize data structures, collections, and Stream processing (with Lambda expressions).
* Collaborate through a Git repository for version control, issue tracking, and team collaboration.
* Follow a Test-Driven Development (TDD) approach.

## 3. Tools to be used

1. Any preferred IDE for development.
2. SQLite for the database.
   
## 4. Design Requirements

* A clear and well-designed GUI for input and output is essential.
* Utilize relevant class libraries.
* Implement at least two design patterns introduced in the class, such as Factory, Abstract Factory, Singleton, Bridge, Memento.
* Ensure the application follows MVC architecture.
* The application must support at least two languages (e.g., French and English), using I18N Java classes like ResourceBundle and Locale.
* Choose appropriate data structures that best fit the data model.
* At least two hierarchies of classes, each one has two layers (such as User, Teacher, Student) is required for the project. 

## 5. Steps to follow

~~1. Create UML diagrams (ER, class, and activity diagrams).~~
2. Create and populate the database.
3. Design the user interface (GUI or Console).
~~4. Implement the MVC architecture.~~
5. Develop the core classes.
6. Write test class(es) using JUnit to test the controller methods. 
8. Verify if CRUD operations implemented by the methods correctly update the database.
9. Add internationalization features using at least two Locale objects.
10. Refactor the code to incorporate design patterns.

## 6. Project Deliverables

### 6.1 Deliverable 1 - Project Description:

Submit a project idea, addressing the following points:
~~* Scenario: Explain the scenario under which your project will operate.~~
~~* Design Paradigm: List the functionalities you plan to demonstrate.~~
~~* Expected Output: Describe the expected results and the actions the user can perform with your application.~~
~~* Git Repository: Initialize a Maven project with valid `.gitignore`, and a `README.md` file for a project description. Create a `doc` folder which contains diagrams and the the Deliverable 1 PDF.~~

### 6.2 Deliverable 2 - 50% Checkpoint:

Submit the source code as a `.zip` file. The application structure must be in place, with:
* Implementation of all core classes and data structures.
* Database connectivity.
* Updated Git repository.

The Git repo must be updated too.

### 6.3 Deliverable 3 - Final Submission:

Submit the complete application, including:
* Project source code (as a `.zip` file).
* Executable JAR file that includes all necessary resources to run the project without recompilation.

The Git repo must be updated too.

### 6.4 Project Report:

Submit a project report consisting of:
* Cover page with your name, project title, and course name.
* Outline/Table of Contents.
* Project Description (same as Deliverable 1).
* Program Features and Screenshots (showing how the project meets the requirements, with output and execution examples).
* Challenges (any unimplemented features or issues faced during development).
* Learning Outcomes (what you gained from the project).

## 7. Submission Requirements

1. Deliverable 1 and the Project Report should be submitted as PDF files via the Lea system.
2.	Deliverables 2 and 3 should be uploaded to the Git repository.
3.	Deliverables 2 and 3 must also be zipped and submitted via Lea.

## 8. Grading Criteria

The following criteria will be used to evaluate the project:

The project will be evaluated based on the following:

* Functionality (accuracy of output, performance, etc.)
* Robustness (handling edge cases, exceptions, and invalid inputs)
* Adherence to project specifications
* Appropriate use of data structures and the Collections API
* Correct application of design patterns, I18N, MVC, Lambda expressions, and OOP principles (e.g., information hiding, polymorphism)
* Code documentation
* Thorough testing
* Quality of presentation and completeness of output
* Appropriate use of Git for commits and collaboration
* A recentable code testing coverage
* Git repository is appropriated used.

Project Idea: Travel Agency

# Travel Agency Management System

## Project Scenario

### Overview
This project involves creating a travel agency management system that allows users and customers to interact with various functionalities related to travel bookings.

### Functionalities

- **For Users/Customers**:
  - Search for available travel packages (flights, hotels, tours).
  - Book travel packages.
  - Manage bookings (registration, updating details).
  - Manage customer accounts (registration, updating details).

- **For Admins**:
  - Add, update, and remove travel packages.
  - View all customer bookings and manage inventory.

## Design Paradigm

### Model-View-Controller (MVC) Pattern
- **Model**: Represents the data structure and interacts with the database.
  - Examples: `TravelPackage`, `User`, `Booking`.
- **View**: Graphical User Interface (GUI) for users and admins, supporting internationalization.
- **Controller**: Manages user requests, performs CRUD operations using JDBC, and updates the view.




   
