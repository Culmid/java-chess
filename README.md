# java-chess
![maven badge](https://github.com/Culmid/java-chess/actions/workflows/maven.yml/badge.svg)

This project is a basic implementation of command line chess, in Java, using OOP. The project was designed to be a conceptual challenge by constructing the project in a different way to what is usually seen online. The main adaptions were keeping just one array of pieces with no reference to empty squares on the board and using the calculation of all legal moves in order to determine if a move is legal. These adaptations allow for interesting alterations to the normal running of a program like this. Please feel free to borrow and investigate with these adaptations. I hope the different way of doing this project inspires some creativity.

Please Note: This project is by no means optimized at this time, so any optimization tips are welcome. Also, this project is build using Maven, so all relevant commands apply. Furthermore, if you spot any errors in the project or room for more/better testing, please do not hesitate to bring it up.

## Requirements

- Maven
- Java 11 (and JUnit 4)

## Usage

```bash
$ ./run.sh
```

This command cleans and packages the project and then runs the resulting jar package. This triggers a command line game of chess between two people where square references are used to move. There are also two main commands "/h"/"/help" and "/r"/"/resign", "/h" followed by a square reference will give a list of legal moves for that square (if a Piece exists on that square) and "/r" will resign, letting the other player win. As stated above any other Maven commands will be functional as well, as a result of the project structure, this command is just the main way to run the system.