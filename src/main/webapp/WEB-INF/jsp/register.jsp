<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
${message}
<form action="save" method="post" name="form"  onsubmit="return validation()" >

    <div class="loginBox">

        <h1>Register </h1>

            <input type="text" name="username" placeholder="Username"  required>

            <input type="password" name="password" placeholder="Password" id="name" required onclick="validation1()">

            <input type="email" name="email" placeholder="Email" required>

            <input type="submit" name="submit" value="Register">
    </div>
</form>
</table>
</form>
</center>
</body>
</html>