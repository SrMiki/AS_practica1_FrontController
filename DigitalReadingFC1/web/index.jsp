<%-- 
    Document   : login
    Created on : 06-sep-2020, 18:14:11
    Author     : Miki
--%>

<jsp:include page="/WebComponent/header.jsp"/>

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">

<div class="cuerpoSignin text-center">

    <form class="form-signin" action="FrontController">
        <input type="hidden" name="command" value="login">
        <img class="mb-4" src="img/main.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputUser" class="sr-only">username</label>
        <input type="user" name="username" class="form-control" placeholder="Your username..." required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-info btn-block" type="submit">Sign in</button>
        <div>
            <div class="d-flex justify-content-center links">
                Don't have an account? &nbsp; <a href="register.jsp"> Sign Up </a>
            </div>                
        </div>
    </form>
</div>

<jsp:include page="/WebComponent/footer.jsp"/>