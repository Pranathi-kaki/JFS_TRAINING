<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>User List</title>
    <style>
        body {
            background: linear-gradient(135deg, #FF6F61, #6A0572);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.3);
            text-align: center;
            max-width: 700px;
        }

        h3 {
            color: #6A0572;
            font-weight: bold;
            margin-bottom: 20px;
        }

        table {
            border-radius: 8px;
            overflow: hidden;
        }

        th {
            background: #6A0572 !important;
            color: white !important;
        }

        tr:nth-child(even) {
            background: #f3e6f5;
        }

        tr:nth-child(odd) {
            background: #fde7e6;
        }

        td {
            color: #333;
        }
    </style>
</head>

<body>
    <div class="container">
        <h3>All Users</h3>
        <%@page import="java.sql.ResultSet"%>
        <%@page import="java.sql.Statement"%>
        <%@page import="java.sql.SQLException" %>
        <%@page import="java.sql.Connection" %>
        <%@page import="java.sql.DriverManager" %>
        <%@page import="com.mysql.jdbc.Driver" %>

        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from USERS");
        %>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>User Name</th>
                    <th>User Email</th>
                    <th>User Password</th>
                </tr>
            </thead>
            <tbody>
                <%
                while(rs.next()){
                    String Username = rs.getString("Username");
                    String userMail = rs.getString("gmail");
                    String userpass = rs.getString("pass");
                %>
                <tr>
                    <td><%=Username %></td>
                    <td><%=userMail %></td>
                    <td><%=userpass %></td>
                </tr>
                <% } 
                }
            catch (Exception e) {
                e.printStackTrace();
            }
            %>
            </tbody>
        </table>
    </div>
</body>

</html>
