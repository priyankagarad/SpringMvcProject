<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
        <form action="Login" name="myform" onsubmit="return validateform()" >
            <div class="loginBox">
                <h1>Login </h1>

                <form action="loginServlet" method="get">
                    <input type="text" name="UserName" placeholder="UserName">
                    <input type="password" name="Password" placeholder="Password">
                    <input type="submit" name="submit" value="Login">
                </form>
        </form>
            <form action="register" method="get">
                <input type="submit" name="submit" value="Register">
            </div>
        </form>
</body>
</html>