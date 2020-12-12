<%-- 
    Document   : register
    Created on : 06-sep-2020, 18:15:18
    Author     : Miki
--%>



<jsp:include page="/WebComponent/header.jsp"/>

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">

<div class="cuerpoSignin text-center">

    <form class="form-signin" action="FrontController">
        <input type="hidden" name="command" value="insertUser">
        <a href="index.jsp">
            <img class="mb-4" src="img/main.png" alt="" width="72" height="72">
        </a>
        <h1 class="h3 mb-3 font-weight-normal">New user</h1>
        <div class="form-group">
            <label for="inputUser" ></label>
            <input type="user" name="username" class="form-control" placeholder="Your name..." required autofocus>
        </div>
        <div class="form-group">
            <label for="inputUser" ></label>
            <input type="user" name="lastname" class="form-control" placeholder="Your lastname..." required autofocus>
        </div>
         <div class="form-group">
            <label for="inputEmail" ></label>
            <input type="email" name="email" class="form-control" placeholder="You email..." required autofocus>
        </div>
        <div class="form-group">
            <label for="inputPassword"></label>
            <input type="password" name="password" class="form-control" placeholder="Password" required>
        </div>
        
        <button class="btn btn-lg btn-info btn-block" type="submit">Sing up</button>

    </form>
</div>

<jsp:include page="/WebComponent/footer.jsp"/>