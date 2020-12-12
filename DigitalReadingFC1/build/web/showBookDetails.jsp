<%-- 
    Document   : book
    Created on : 28-sep-2020, 10:56:09
    Author     : Miki
--%>
<%@ page import="Book.*" %> 
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- si no se incluye no funciona, aunque la incluya el header no lo hereda -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- si no se incluye no funciona : |  -->

<!--- Detalles de un libro seleccionado -->

<jsp:include page="./WebComponent/header.jsp"/>
<jsp:include page="./WebComponent/navbar.jsp"/>

<div class="container py-3">
    <div class="row">

        <div class="col-md-3 bg-dark text-center py-3">
            <div class="card mb-2 shadow-sm ">


                <div class="card-header">${libro.title} </div>

                <div class="card-body">
                    <img class="card-img-top img-responsive" src="${libro.getPortada()}" alt="Card image cap" width="72px" height="250px">
                        <p class="card-text">${libro.toString()}</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <small class="text-muted">${libro.getLikes()} &nbsp 
                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M8 2.748l-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                                </svg>
                            </small>
                        </div>
                </div>

            </div>
        </div>

        <div class="col-md-8 bg-light py-3">

            <table class="table-hover">
                <c:forEach var="comentario" items="${libro.comentarios}">
                    <tr>
                        <td class="py-3 px-3"> ${comentario} </td> 
                        <td class="py-3 px-3"> ${comentario.getUsername()}</td>
                    </tr>
                </c:forEach>
            </table>

            <div>
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#insertComment">comment</button> 
            </div>


        </div>

    </div>
</div>
                                
                                

<jsp:include page="./WebComponent/modals.jsp"/>
<jsp:include page="./WebComponent/footer.jsp"/>