#  Dungeons Master

## Project Description
Dungeons Master is a decision-based dungeon crawler game modelled heavily, but not fully, off the typical Dungeons and Dragons ruleset. When you click play, you will choose your dungeon, Race (Elf, Dwarf, Human), and Class (Rogue, Fighter, Wizard). Based on your choices, you will have different attributes (Strength, Dexterity, Constitution, Wisdom, Charisma, Intelligence) and based on those attributes, you will be better or worse at different actions. Due to the random nature of dice, no 2 journeys will be exactly the same, even if you make the same choices. So, hop on in, click play, and pray that the dice gods and RNGesus smile upon you.

Technologies Used: Java 1.8, JDBC (Java Database Connectivity), MongoDB, HTML/CSS/Javascript, AJAX, Spring Boot, Spring MVC, React, Redux, JUnit, log4j.




Project 2 Requirements - Due Friday of Week 7
Simulate some business 30%
Documentation 5% - (javadocs)
User Interaction 10%
Unit Testing (70% coverage) 40%
Presentation 5%
Data Persistence 5%
Logging 5%

The following are the specifications for Project 2.
Project 2 is an HTML CHYOA game application.

HTML DND Theme Dungeon Crawl Game Web Application:

        -Spring Boot
	
## Technologies Used
- Java 1.8
- JUnit 4.13.1
- SLF4J 1.7.12
- HTML/CSS/Javascript
- NodeJS 6.14.12
- React 17.0.2
- Redux ???
- Axios 0.21.1
- spring-boot-starter-data-mongodb
- spring-boot-starter-web
- Spring Boot 2.4.5
- 

## Features

### Implemented
- Create character/Customize
- Navigate throughtout dungeon
- Create combat system to fight monsters.
- Reach the end of the dungeon
- Query [Dungeons and Dragons api](https://www.dnd5eapi.co) for weapon and spell properties.

## Getting Started
To install the client and server applications, click on the follow links to install the pre-requisite software.

1) [Intellij](https://www.jetbrains.com/help/idea/installation-guide.html)
2) [Visual Studio Code](https://code.visualstudio.com/download)
3) [JDK 1.8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
4) [NodeJS](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
5) [MongoDB](https://docs.mongodb.com/manual/installation/)

6) Open a terminal or powershell and clone this repo:

```git clone https://github.com/benjaminbales/ERS.git```

7) Navigate to your home directory and enter the following command to start MongoDB:

```mongod --dbpath mongo-data/```

8) Open the Client application in VS Code, open a terminal in VS Code, and enter the follow commands:

```cd frontend```

```npm install axios```

```npm install @reduxjs/toolkit``

10) Open the Server application in Intellij and wait for gradle to finish building the application. Then, open BackendApplication.java in the package com.ex and click the green play button to the left of the main method.  This should launch the server listening for HTTP requests on port 8080.
11) Back in VS Code, in the terminal, type:

```npm start```

12) This automatically opens a tab in your default web browser at http://localhost:3000.  If not, then copy/past the link in your browser, and you should see the following:

![ERS Home Screen](/ERSHome.png?raw=true "ERS Home Screen") //replace with new home screen

## Usage

1) Click on the login tab and enter the default manager username and password.  
2) This will re-direct you to the manager home page where can see an empty table with options to view a list of employees, and pending and resolved reimbursement requests.  
3) Create an employee using the "register employee" button.  
4) Then, log out and log back in as an employee.  
5) You'll see a similar empty table, but now you have a button to create a new reimbursment request.  Click it, submit a request with some arbitrary amount, and log out.  
6) Log back in as the manager, and verify that you can view both the employee and the pending request by clicking the "Get" buttons in their respective table columns.  
7) Then, click on the pending request and click the button to approve the request.  
8) Finally, log out and log back in as the employee and verify that the pending request now appears in the resolved column and not in the pending column. 

	
## Contributors
### Team Thundercats
- [David Houman](https://github.com/DHouman) - designed the game, contributed game assets, and contributed to backend design and testing.
- [Benjamin Bales](https://github.com/benjaminbales) - contributed to design and testing of backend Spring boot application, combined DND API data with backend data to maintain and update game state.
- [Rakeon Jerralds](https://github.com/LORDBLACKSMITH-ray) - developed frontend application using React and Redux.

## License

This project uses the following license:[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

	
