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

    private static final String DB_URL = getEnvironment("DB_URL", "jdbc:mysql://localhost:3306/login_db");
    private static final String DB_USER = getEnvironment("DB_USER", "root");
    private static final String DB_PASSWORD = getEnvironment("DB_PASSWORD", "your_mysql_password");
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

    private static String getEnvironment(String key, String defaultValue) {
        String value = System.getenv(key);
        return value == null || value.trim().isEmpty() ? defaultValue : value;
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
