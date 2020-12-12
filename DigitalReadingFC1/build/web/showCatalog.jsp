<%-- 
    Document   : listaLibros
    Created on : 07-sep-2020, 17:28:06
    Author     : Miki
--%>

<jsp:include page="./WebComponent/header.jsp"/>
<jsp:include page="./WebComponent/navbar.jsp"/>
<!-- si no se incluye no funciona, aunque la incluya el header no lo hereda -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- si no se incluye no funciona : |  -->

<div class="d-flex">

    <div class="card col-sm-4">
        <div class="card-body">
            <form action="FrontController">
                <input type="hidden" name="command" value="insertBook">

                <div class="form-group">
                    <label for="fTitle">Title</label>
                    <input type="text" id="fTitle" name="title" placeholder="Book title" class="form-control"> 
                </div>

                <div class="form-group">
                    <label for="fAuthor">Author</label>
                    <input type="text" id="fAuthor" name="author" placeholder="Book author" class="form-control">
                </div>

                <div class="form-group">
                    <label for="fGenre">Genre</label>
                    <input type="text" id="fGenre" name="genre" placeholder="Book genre" class="form-control">
                </div>

                <div class="form-group">
                    <label for="fSellingDate">SellingDate</label>
                    <input type="text" id="fSellingDate" name="sellingDate" placeholder="Book selling date" class="form-control">
                </div>

                <div class="form-group">
                    <label for="fPrice">Price</label>
                    <input type="text" id="fPrice" name="price" placeholder="Book price" class="form-control">
                </div>


                <input type="submit" value="Insert" class="btn btn-info">

            </form>
        </div>
    </div>
    <div class="col-sm-8">


        <table class="table table-hover">

            <tr>

                <th scope="col">ID</th>
                <th scope="col">Title</th>
                <th scope="col">Author</th>
                <th scope="col">Genre</th>
                <th scope="col">SellingDate</th>
                <th scope="col">Price</th> 
                <th></th>

            </tr>

            <c:forEach var="libro" items="${catalogo}">


                <!-- enlace para UPDATE de cada libro con su campo clave -->

                <c:url var="updateLink" value="FrontController">

                    <c:param name="command" value="getBook"></c:param>
                    <c:param name="bookID" value="${libro.id}"></c:param>

                </c:url>

                <!-- enlace para DELETE de cada libro con su campo clave -->
                <c:url var="deleteLink" value="FrontController">

                    <c:param name="command" value="deleteBook"></c:param>
                    <c:param name="bookID" value="${libro.id}"></c:param>

                </c:url>

                <tr>

                    <th scope="row"> ${libro.id} </td>
                    <td> ${libro.title}</td>
                    <td> ${libro.author}</td>
                    <td> ${libro.genre}</td>
                    <td> ${libro.sellingDate}</td>
                    <td> ${libro.price}</td>
                    <td> 
                        <a href="${updateLink}" class="btn btn-warning">actualizar</a>
                    </td> <td>

                        <a href="${deleteLink}" onclick="return confirm('Do you want to remove this book?');" class="btn btn-danger">eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="/WebComponent/footer.jsp"/>