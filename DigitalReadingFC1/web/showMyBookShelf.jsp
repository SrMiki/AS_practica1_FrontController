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
<c:if test="${biblioteca.isEmpty()==false}">

    <div class="d-flex">
        <table class="table table-hover">

            <tr>

                <th scope="col">Title</th>
                <th scope="col">Author</th>
                <th scope="col">Genre</th>
                <th scope="col">SellingDate</th>
                <th scope="col">Price</th> 
                <th > <th>

            </tr>

            <c:forEach var="bookshelfItem" items="${biblioteca}">

                <!-- removeLink for remove a Book from BookShelf -->
                <c:url var="removeLink" value="FrontController">

                    <c:param name="command" value="removeBookFromBookshelf"></c:param>
                    <c:param name="bookID" value="${bookshelfItem.id}"></c:param>

                </c:url>

                <tr>

                    <td> ${bookshelfItem.title}</td>
                    <td> ${bookshelfItem.author}</td>
                    <td> ${bookshelfItem.genre}</td>
                    <td> ${bookshelfItem.sellingDate}</td>
                    <td> ${bookshelfItem.price}</td>
                    <td> 
                        <a href="#" class="btn btn-warning">download</a>
                        <a href="${removeLink}" onclick="return confirm('Do you want to remove this book from your bookshelf?');" class="btn btn-danger">remove</a>
                    <td> 
                </tr>
                
            </c:forEach>

        </table>

    </div>
</c:if>

<c:if test="${biblioteca.isEmpty()}">
    <h1 class="py-3 px-3"> Your bookshelf is empty </h1>
</c:if>



<jsp:include page="/WebComponent/footer.jsp"/>
