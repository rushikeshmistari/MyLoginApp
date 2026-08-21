<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <style>
        body { margin: 0; min-height: 100vh; display: grid; place-items: center; font-family: Arial, sans-serif; background: #eff6ff; color: #172554; }
        .card { width: min(92%, 480px); padding: 38px; text-align: center; background: white; border-radius: 14px; box-shadow: 0 12px 35px rgba(30, 64, 175, .17); }
        h1 { color: #15803d; } p { color: #475569; line-height: 1.6; }
        a { display: inline-block; margin-top: 18px; padding: 12px 25px; border-radius: 7px; color: white; background: #2563eb; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>
    <main class="card">
        <h1>Login Successful</h1>
        <p>Welcome, <strong><%= username %></strong>!<br>You have been authenticated using JSP, Servlet, and JDBC.</p>
        <a href="logout">Logout</a>
    </main>
</body>
</html>
