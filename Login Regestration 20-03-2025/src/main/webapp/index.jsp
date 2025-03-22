<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <style>
        body {
            background: linear-gradient(135deg, #FF6F61, #6A0572);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .card {
            width: 400px;
            padding: 30px;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.3);
            text-align: center;
        }

        .card h1 {
            color: #6A0572;
            font-weight: bold;
            margin-bottom: 20px;
        }

        input {
            padding: 12px;
            width: 100%;
            border-radius: 8px;
            border: 2px solid #6A0572;
            margin-bottom: 15px;
            outline: none;
            transition: 0.3s;
        }

        input:focus {
            border-color: #FF6F61;
            box-shadow: 0px 0px 8px rgba(255, 111, 97, 0.5);
        }

        .btn-custom {
            width: 100%;
            padding: 10px;
            border-radius: 8px;
            background: #FF6F61;
            border: none;
            color: white;
            font-size: 16px;
            font-weight: bold;
            transition: 0.3s;
        }

        .btn-custom:hover {
            background: #d9504e;
            transform: scale(1.05);
        }

        .btn-reset {
            width: 100%;
            padding: 10px;
            border-radius: 8px;
            background: #6A0572;
            border: none;
            color: white;
            font-size: 16px;
            font-weight: bold;
            transition: 0.3s;
        }

        .btn-reset:hover {
            background: #53045a;
            transform: scale(1.05);
        }

        .register-link {
            margin-top: 15px;
            font-size: 15px;
            color: #6A0572;
            font-weight: bold;
            display: block;
            text-decoration: none;
            transition: 0.3s;
        }

        .register-link:hover {
            color: #FF6F61;
        }
    </style>
</head>

<body>
    <div class="card">
        <h1>Login</h1>
        <form action="login.jsp" method="post">
            <input type="email" name="userMail" placeholder="Enter your Email" required><br>
            <input type="password" name="userpass" placeholder="Enter your Password" required><br>
            <button type="submit" class="btn-custom">Login</button>
            <button type="reset" class="btn-reset mt-2">Reset</button>
        </form>
        <a href="register.jsp" class="register-link">Don't have an account? Register here</a>
    </div>
</body>

</html>
