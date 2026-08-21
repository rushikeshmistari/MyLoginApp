# MyLoginApp

A JSP, Servlet, and JDBC login web application for Experiment 5.

## Requirements

- JDK 8 or later
- Apache Tomcat 9 (uses `javax.servlet`)
- MySQL Server
- MySQL Connector/J JAR copied to `WebContent/WEB-INF/lib/`

## Run the application

1. Run `database.sql` in MySQL.
2. In `src/com/example/LoginServlet.java`, replace `your_mysql_password` with the MySQL password for the `root` user (or update both database constants to your own MySQL account).
3. Add `mysql-connector-j-<version>.jar` to `WebContent/WEB-INF/lib/`.
4. Import the project into Eclipse as a Dynamic Web Project and run it using Tomcat 9.
5. Open `http://localhost:8080/MyLoginApp/`.

Test login: `student` / `java123`.
