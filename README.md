# FanCode Task Completion Automation

This project automates the process of checking if users from the city "FanCode" have completed more than 50% of their to-do tasks using the JSONPlaceholder API.

## Overview
- **Objective**: Ensure all users in the city "FanCode" have completed more than half of their to-do tasks.
- **City Identification**: Users from "FanCode" are identified by latitude between -40 and 5, and longitude between 5 and 100.
- **APIs Used**: JSONPlaceholder API `/users`, `/todos`.

### Technologies Used
- Java
- Maven
- TestNG
- RestAssured (for API testing)
- SLF4J (for logging)
  
## Running the tests after cloning it 

1. To run the test, use TestNG from your IDE by right-clicking on the test class UserTasks.java and select Run.
2. Use 'mvn clean -e test' to run the tests

## Logging:
Logs are configured using SLF4J 

