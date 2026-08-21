<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Application</title>
    <style>
        * { box-sizing: border-box; }
        body { margin: 0; min-height: 100vh; display: grid; place-items: center; font-family: Arial, sans-serif; background: #eef4ff; color: #172554; }
        .card { width: min(92%, 400px); padding: 34px; background: white; border-radius: 14px; box-shadow: 0 12px 35px rgba(30, 64, 175, .17); }
        h1 { margin: 0 0 8px; color: #1d4ed8; font-size: 28px; }
        p { margin: 0 0 26px; color: #64748b; }
        label { display: block; margin: 16px 0 7px; font-weight: bold; font-size: 14px; }
        input { width: 100%; padding: 12px; border: 1px solid #cbd5e1; border-radius: 7px; font-size: 15px; }
        input:focus { outline: 2px solid #93c5fd; border-color: #2563eb; }
        button { width: 100%; margin-top: 24px; padding: 12px; border: 0; border-radius: 7px; color: white; background: #2563eb; font-size: 16px; font-weight: bold; cursor: pointer; }
        button:hover { background: #1d4ed8; }
    </style>
</head>
<body>
    <main class="card">
        <h1>Welcome Back</h1>
        <p>Please enter your username and password to sign in.</p>
        <form action="login" method="post">
            <label for="username">Username</label>
            <input id="username" name="username" type="text" required autofocus>

            <label for="password">Password</label>
            <input id="password" name="password" type="password" required>

            <button type="submit">Login</button>
        </form>
    </main>
</body>
</html>
