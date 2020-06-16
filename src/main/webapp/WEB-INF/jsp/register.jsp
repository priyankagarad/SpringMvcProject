<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
    <link rel="stylesheet" type="text/css" href="resouces/css/style.css">
</head>
<script type="text/javascript">
    function validation()
    {
        var a = document.form.username.value;
        if(a=="")
        {
            alert("Please Enter Your Name");
            document.form.username.focus();
            return false;
        }
        if(!isNaN(a))
        {
            alert("Please Enter Only Characters in username");
            document.form.username.select();
            return false;
        }
        if ((a.length < 5) || (a.length > 15))
        {
            alert("Your Name Character must be 5 to 15 Character");
            document.form.username.select();
            return false;
        }

    }
    function validation1()
    {

        alert("Password");

        var a = document.getElementById("name");
        if(a=="")
        {
            alert("Please Enter Your Password");
            document.getElementById("name").focus();
            return false;
        }
        if ((a.length < 4) || (a.length > 8))
        {
            alert("Your Password must be 4 to 8 Character");
            document.getElementById("demo").select();
            return false;
        }
    }
</script>
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