<%-- 
    Document   : catalogo
    Created on : 24-sep-2020, 9:25:34
    Author     : Miki
--%>


<%@ page import="Book.*" %> 
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- si no se incluye no funciona, aunque la incluya el header no lo hereda -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- si no se incluye no funciona : |  -->


<div class=" py-3 px-3">
    <div class="row">
        <c:forEach var="libro" items="${catalogo}">

            <c:url var="addBookToCart" value="FrontController">

                <c:param name="command" value="addBookToCart"></c:param>
                <c:param name="bookID" value="${libro.id}"></c:param>

            </c:url>

            <c:url var="showBook" value="FrontController">

                <c:param name="command" value="showBookDetails"></c:param>
                <c:param name="bookID" value="${libro.id}"></c:param>

            </c:url>


            <div class="col-md-4 bg-dark py-3 text-center">
                <div class="card bg-blue">
                    <div class="card-header py-3" style="height: 90px">${libro.title} </div>
                    <div class="card-body py-3">
                        <img class="card-img-top img-responsive" src="${libro.getPortada()}" alt="Card image cap" width="50px" height="25   0px">

                            <div class="d-flex justify-content-between align-items-center py-3 px-2">
                                <div class="btn-group">
                                    <c:choose>

                                        <c:when test = "${carrito.contains(libro)}">
                                            <button type="button" data-toggle="modal" data-target="#cartContainTheBook" class="btn btn-warning">buy</button>
                                        </c:when>

                                        <c:when test = "${libro.isAlreadyContains(biblioteca)}">
                                            <button type="button" data-toggle="modal" data-target="#bookIsAlreadyInTheBookshelf" class="btn btn-warning">buy</button>
                                        </c:when>

                                        <c:otherwise>
                                            <a href="${addBookToCart}" class="btn btn-warning">buy</a>
                                        </c:otherwise>
                                    </c:choose>
                                    <a href="${showBook}" class="btn btn-info">details</a>
                                </div>
                                <small class="text-muted">${libro.getLikes()} &nbsp 
                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M8 2.748l-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                                    </svg>
                                </small>

                            </div>
                    </div>
                </div>
            </div>


        </c:forEach>
    </div>
</div>

