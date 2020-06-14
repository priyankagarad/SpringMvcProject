<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<head>
    <title>Login Form</title>
</head>

<body>
${message}
        <form action="Login" >
            <input type="text" name="UserName" placeholder="UserName"></br></br>
            <input type="password" name="Password" placeholder="Password"></br></br>
            <input type="submit" name="submit" value="Login"></br></br>
            <a href="register">Registration</a></br></br>
        </form>
</body>
</html>