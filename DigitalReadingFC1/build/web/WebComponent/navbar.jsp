<%-- 
    Document   : navbar
    Created on : 06-sep-2020, 23:08:41
    Author     : Miki
--%>

<!-- si no se incluye no funciona, aunque la incluya el header no lo hereda -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- si no se incluye no funciona : |  -->


<nav class="navbar navbar-expand-lg navbar-light" style="background-color: indianred; color: white">
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <c:if test="${user != null}">

                <li class="nav-item active">
                    <a class="nav-link" style="color: white" href="mainPage.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="FrontController?command=showBookShelf">MyBookShelf</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="FrontController?command=showComments">MyComments</a>
                </li>
                <c:if test="${user.isAdmin()==1}">
                    <li class="nav-item" style="color: white">
                        <a class="nav-link" style="color: white" href="FrontController?command=showCatalog">Books</a>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </div>

    <div>
        <ul class="navbar-nav">

            <li class="nav-item">
                <a href="FrontController?command=showProfile" class="nav-link" style="color: white">${user.getUsername()} ${user.getLastname()} </a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" style="color: white"href="FrontController?command=logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>