# Gemini CLI Java 25 Project

This project is a Java 25 application managed with Maven.

## Project Structure

- `pom.xml`: Maven project object model file.
- `src/main/java`: Contains the main Java source code.
- `src/main/resources`: Contains project resources.
- `src/test/java`: Contains test Java source code.

## Building the Project

To build the project using Maven, navigate to the project's root directory and run:

```bash
mvn clean install
```

## Running the Project

After building, you can run the main application from the target directory, or directly using Maven:

```bash
mvn exec:java -Dexec.mainClass="org.example.Main"
```

## Technologies Used

- Java 25
- Apache Maven
