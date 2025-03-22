<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mysql.jdbc.Driver"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    
    <style>
        /* Reset default styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background: linear-gradient(135deg, #FF6F61, #6A0572);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: Arial, sans-serif;
        }

        .centre {
            background: rgba(255, 255, 255, 0.9);
            backdrop-filter: blur(10px);
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.2);
            text-align: center;
            font-size: 20px;
            color: #333;
            width: 350px;
            border: 1px solid rgba(255, 255, 255, 0.3);
        }

        h3 {
            font-size: 22px;
            font-weight: bold;
            color: #6A0572;
            margin-bottom: 15px;
        }

        .btn {
            text-decoration: none;
            font-size: 16px;
            color: white;
            background: linear-gradient(90deg, #ff758c, #ff7eb3);
            padding: 12px 20px;
            border-radius: 8px;
            transition: all 0.3s ease-in-out;
            display: inline-block;
            margin-top: 10px;
            border: none;
            cursor: pointer;
        }

        .btn:hover {
            background: linear-gradient(90deg, #ff5e78, #ff3d68);
            transform: scale(1.05);
        }
    </style>
</head>
<body>

    <div class="centre">
        <%
        try {
            String url = "jdbc:mysql://localhost:3306/logindb";
            String name = "root";
            String pass = "root";

            String driver = "com.mysql.jdbc.Driver";

            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, name, pass);

            // Get user input
            String Username = request.getParameter("Username");
            String userMail = request.getParameter("userMail");
            String userpass = request.getParameter("userpass");

            String query1 = "SELECT * FROM USERS WHERE gmail = ?;";
            PreparedStatement ps = con.prepareStatement(query1);
            ps.setString(1, userMail);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
        %>
                <h3>User already present</h3>
                <a class="btn" href='index.jsp'>Login</a>
        <%
            } else {
                String query2 = "INSERT INTO USERS (Username, gmail, pass) VALUES (?, ?, ?);";
                ps = con.prepareStatement(query2);
                ps.setString(1, Username);
                ps.setString(2, userMail);
                ps.setString(3, userpass);

                int rows = ps.executeUpdate();
                if (rows > 0) {
        %>
                    <h3>New Account Created Successfully</h3>
                    <a class="btn" href='index.jsp'>Login</a>
        <%
                } else {
                    out.println("<h3 style='color: red;'>Failed to create new account</h3>");
                }
            }
        } catch (Exception e) {
            out.println("<h3 style='color: red;'>Error: " + e.getMessage() + "</h3>");
        }
        %>  
    </div>

</body>
</html>
