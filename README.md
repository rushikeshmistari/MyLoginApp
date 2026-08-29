# MyLoginApp

A JSP, Servlet, and JDBC login web application for Experiment 5.

## Requirements

- JDK 8 or later
- Apache Tomcat 9 (uses `javax.servlet`)
- MySQL Server
- MySQL Connector/J JAR copied to `WebContent/WEB-INF/lib/`

## Run the application

1. Run `database.sql` in MySQL.
2. For local use, in `src/com/example/LoginServlet.java`, replace `your_mysql_password` with the MySQL password for the `root` user. For deployment, configure `DB_URL`, `DB_USER`, and `DB_PASSWORD` as environment variables.
3. Add `mysql-connector-j-<version>.jar` to `WebContent/WEB-INF/lib/`.
4. Import the project into Eclipse as a Dynamic Web Project and run it using Tomcat 9.
5. Open `http://localhost:8080/MyLoginApp/`.

Test login: `student` / `java123`.

## Railway deployment

The repository includes a `Dockerfile`, `pom.xml`, and `railway.json`. Create a MySQL service in Railway, then configure the web service with `DB_URL`, `DB_USER`, and `DB_PASSWORD` using the values from that database service.
