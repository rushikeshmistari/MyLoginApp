# MyLoginApp

A JSP, Servlet, and JDBC login web application for Experiment 5.

## Requirements

- JDK 8 or later
- Apache Tomcat 9 (uses `javax.servlet`)
- MySQL Server
- Maven (the MySQL Connector/J dependency is included automatically in the WAR)

## Run the application

1. Run `database.sql` in MySQL.
2. For local use, set `DB_URL`, `DB_USER`, and `DB_PASSWORD` as environment variables if your MySQL settings differ from the defaults. For deployment, Railway's `MYSQLHOST`, `MYSQLPORT`, `MYSQLDATABASE`, `MYSQLUSER`, and `MYSQLPASSWORD` variables are supported automatically; alternatively configure `DB_URL`, `DB_USER`, and `DB_PASSWORD`.
3. Run `mvn package`, then deploy `target/ROOT.war` to Tomcat 9, or import the project into Eclipse as a Dynamic Web Project.
5. Open `http://localhost:8080/MyLoginApp/`.

Test login: `student` / `java123`.

## Railway deployment

The repository includes a `Dockerfile`, `pom.xml`, and `railway.json`. Create a MySQL service in Railway, then configure the web service with `DB_URL`, `DB_USER`, and `DB_PASSWORD` using the values from that database service.
