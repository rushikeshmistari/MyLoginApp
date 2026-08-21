<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Error</title>
    <style>
        body { margin: 0; min-height: 100vh; display: grid; place-items: center; font-family: Arial, sans-serif; background: #fff7ed; color: #431407; }
        .card { width: min(92%, 450px); padding: 38px; text-align: center; background: white; border-radius: 14px; box-shadow: 0 12px 35px rgba(154, 52, 18, .15); }
        h1 { color: #dc2626; } p { color: #57534e; line-height: 1.6; }
        a { display: inline-block; margin-top: 18px; padding: 12px 25px; border-radius: 7px; color: white; background: #ea580c; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>
    <main class="card">
        <h1>Login Failed</h1>
        <p>Invalid username or password. Please try again.</p>
        <a href="login.jsp">Back to Login</a>
    </main>
</body>
</html>
