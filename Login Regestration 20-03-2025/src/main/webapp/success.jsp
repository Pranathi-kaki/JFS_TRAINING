<style>
    body {
        background: linear-gradient(135deg, #FF6F61, #6A0572);
        color: #ffffff; /* White text */
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

     .centre {
            background: #ffffff; /* White background for the box */
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.2);
            text-align: center;
            font-size: 20px;
            color: #333; /* Dark text for readability */
            width: 350px;
            border: 1px solid rgba(0, 0, 0, 0.1);
        }

    h3 {
        font-size: 25px;
        font-weight: bold;
        color: #6A0572;
        margin-bottom: 15px;
    }

    .links {
        display: flex;
        flex-direction: column;
        gap: 15px;
        margin-top: 15px;
    }

    .links a {
        text-decoration: none;
        font-size: 18px;
        padding: 12px 20px;
        border-radius: 8px;
        background: linear-gradient(90deg, #ff4b5c, #ff6b7a);
        color: white;
        transition: all 0.3s ease-in-out;
        display: inline-block;
    }

    .links a:hover {
        background: linear-gradient(90deg, #ff2e42, #ff5a6b);
        transform: scale(1.05);
    }
</style>


<div class="centre">
    <%
    if (session.getAttribute("ID") != null) {
        String role = (String) session.getAttribute("role");
    %>
        <h3>WELCOME BACK..!!! <%= session.getAttribute("Username") %></h3>
        <div class="links">
            <a href='logout.jsp'>Logout</a>
            <% if (role != null && role.trim().equalsIgnoreCase("admin")) { %>
                <a href='list.jsp'>Users List</a>
            <% } %>
        </div>
    <%
    } else {
    %>
        <h3>Session Expired!!</h3>
        <a href="login.jsp">Login Again</a>
    <%
    }
    %>
</div>
