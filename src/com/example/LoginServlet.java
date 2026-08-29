package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = getDatabaseUrl();
    private static final String DB_USER = getFirstEnvironment("DB_USER", "MYSQLUSER", "MYSQL_USER", "root");
    private static final String DB_PASSWORD = getFirstEnvironment("DB_PASSWORD", "MYSQLPASSWORD", "MYSQL_PASSWORD", "");
    private static final String LOGIN_QUERY = "SELECT username FROM users WHERE username = ? AND password = ?";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (isValidUser(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private static String getDatabaseUrl() {
        String url = getFirstEnvironment("DB_URL", "MYSQL_URL", "DATABASE_URL", "");
        if (!url.isEmpty()) {
            return url.startsWith("mysql://") ? "jdbc:" + url : url;
        }

        String host = getFirstEnvironment("MYSQLHOST", "MYSQL_HOST", "localhost");
        String port = getFirstEnvironment("MYSQLPORT", "MYSQL_PORT", "3306");
        String database = getFirstEnvironment("MYSQLDATABASE", "MYSQL_DATABASE", "login_db");
        return "jdbc:mysql://" + host + ":" + port + "/" + database
                + "?useSSL=true&requireSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }

    private static String getFirstEnvironment(String firstKey, String secondKey, String thirdKey, String defaultValue) {
        String value = getEnvironment(firstKey);
        if (value.isEmpty()) {
            value = getEnvironment(secondKey);
        }
        if (value.isEmpty()) {
            value = getEnvironment(thirdKey);
        }
        return value.isEmpty() ? defaultValue : value;
    }

    private static String getEnvironment(String key) {
        String value = System.getenv(key);
        return value == null ? "" : value.trim();
    }

    private boolean isValidUser(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement statement = connection.prepareStatement(LOGIN_QUERY)) {
                createUsersTable(connection);
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet result = statement.executeQuery()) {
                    return result.next();
                }
            }
        } catch (ClassNotFoundException | SQLException exception) {
            log("Database login error", exception);
            return false;
        }
    }

    private void createUsersTable(Connection connection) throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "username VARCHAR(50) NOT NULL UNIQUE, "
                + "password VARCHAR(255) NOT NULL)";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTable);
            statement.executeUpdate("INSERT IGNORE INTO users (username, password) VALUES ('student', 'java123')");
        }
    }
}
