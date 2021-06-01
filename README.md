#  Dungeons Master

## Project Description
Dungeons Master is a decision-based dungeon crawler game modelled heavily, but not fully, off the typical Dungeons and Dragons ruleset. When you click play, you will choose your dungeon, Race (Elf, Dwarf, Human), and Class (Rogue, Fighter, Wizard). Based on your choices, you will have different attributes (Strength, Dexterity, Constitution, Wisdom, Charisma, Intelligence) and based on those attributes, you will be better or worse at different actions. Due to the random nature of dice, no 2 journeys will be exactly the same, even if you make the same choices. So, hop on in, click play, and pray that the dice gods and RNGesus smile upon you.
	
## Technologies Used
- Java 1.8
- JUnit 4.13.1
- SLF4J 1.7.12
- HTML/CSS/Javascript
- NodeJS 6.14.12
- React 17.0.2
- Redux 1.5.
- Axios 0.21.1
- spring-boot-starter-data-mongodb
- spring-boot-starter-web
- Spring Boot 2.4.5

## Features

### Implemented
- Create character/Customize
- Navigate throughtout dungeon
- Create combat system to fight monsters.
- Reach the end of the dungeon
- Query [Dungeons and Dragons api](https://www.dnd5eapi.co) for weapon and spell properties.

## Getting Started
To install the client and server applications, click on the following links to install the pre-requisite software.

1) [Intellij](https://www.jetbrains.com/help/idea/installation-guide.html)
2) [Visual Studio Code](https://code.visualstudio.com/download)
3) [JDK 1.8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
4) [NodeJS](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
5) [MongoDB](https://docs.mongodb.com/manual/installation/)

6) Open a terminal or powershell and clone this repo:

```git clone https://github.com/JavaPowerProgrammers/Project2_Team6.git```

7) Navigate to your home directory and enter the following command to start MongoDB:

```mongod --dbpath mongo-data/```

8) Open the Client application in VS Code, open a terminal in VS Code, and enter the follow commands:

```cd frontend```

```npm install axios```

```npm install @reduxjs/toolkit```

9) Open the Server application in Intellij and wait for gradle to finish building the application. Then, open BackendApplication.java in the package com.ex and click the green play button to the left of the main method.  This should launch the server listening for HTTP requests on port 8080.
10) Back in VS Code, in the terminal, type:

```npm start```

11) This automatically opens a tab in your default web browser at http://localhost:3000.  If not, then copy/paste the link in your browser, and you should see the following:

![Dungeons Master Home Screen](/DungeonsMasterHome.png?raw=true "Dungeons Master Home Screen")

## Usage

The game is fairly self-explanatory.  In the center sub-window, you have several options to choose from, such as "Attack Spider" and "Examine Dead Body in the Corner".  Clicking on any of these options leads to another screen where some interaction occurs.  Throughout the game, you may add items to your inventory.  These can be viewed by clicking on the "Inventory" button on the right hand side below the character stats display.

	
## Contributors
### Team Thundercats
- [David Houman](https://github.com/DHouman) - designed the game, contributed game assets, and contributed to backend design and testing.
- [Benjamin Bales](https://github.com/benjaminbales) - contributed to design and testing of backend Spring boot application, combined DND API data with backend data to maintain and update game state.
- [Rakeon Jerralds](https://github.com/LORDBLACKSMITH-ray) - developed frontend application using React and Redux.

## License

This project uses the following license:[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

	
