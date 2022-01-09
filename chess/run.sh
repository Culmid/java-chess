#!/bin/sh
mvn clean package
java -cp .:target/chess-1.0-SNAPSHOT.jar cullen.middleton.App