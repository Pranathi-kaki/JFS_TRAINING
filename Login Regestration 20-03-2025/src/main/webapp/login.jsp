<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.SQLException"%>
<style>
    body {
        background: linear-gradient(135deg, #FF6F61, #6A0572);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        font-family: Arial, sans-serif;
    }

    .centre {
        background: white;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.3);
        text-align: center;
        font-size: 22px;
        color: #6A0572;
    }

    h3 {
        font-size: 26px;
        font-weight: bold;
        color: #FF6F61;
        margin-bottom: 15px;
    }

    .links {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-top: 15px;
    }

    .btn {
        text-decoration: none;
        font-size: 18px;
        color: white;
        background: #6A0572;
        padding: 10px 15px;
        border-radius: 8px;
        transition: 0.3s;
    }

    .btn:hover {
        background: #FF6F61;
    }
</style>

<%
    String url = "jdbc:mysql://localhost:3306/logindb";
    String name = "root";
    String pass = "root";

    try {
        // Load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, name, pass);

        // Get user input
        String userMail = request.getParameter("userMail");
        String userpass = request.getParameter("userpass");

        // SQL query to check user credentials and fetch role
        String query = "SELECT ID, Username, role FROM USERS WHERE gmail = ? AND pass = ?;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, userMail);
        ps.setString(2, userpass);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Set session attributes
            session.setAttribute("ID", rs.getInt("ID"));
            session.setAttribute("Username", rs.getString("Username"));
            session.setAttribute("gmail", userMail);
            session.setAttribute("role", rs.getString("role"));  // Store role in session
            
            response.sendRedirect("success.jsp"); // Redirect to success page
        }
        else {
%>
        <div class="centre">
            <h3>USER NOT FOUND</h3>
            <div class="links">
                <a class="btn" href='register.jsp'>Sign up</a>
            </div>
        </div>
<%
        }

    } catch (Exception e) {
        out.println("<div class='centre'><h3>Error:</h3> " + e.getMessage() + "</div>");
    }
%>
