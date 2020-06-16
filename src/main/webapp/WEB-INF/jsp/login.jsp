<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="resouces/css/style.css">
</head>
<script type="text/javascript">
    function validateform(){
        var name=document.myform.UserName.value;
        var password=document.myform.Password.value;
        if (name==null || name==""){
            alert("Name can't be blank");
            return false;
        }else if(password.length<4){
            alert("Password must be at least 4 characters long.");
            return false;
        }
    }

</script>

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