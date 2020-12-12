<%-- 
    Document   : MyComments
    Created on : 01-oct-2020, 8:56:37
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

<c:forEach var="libro" items="${catalogo}">
    <c:if test="${libro.getComentarios().isEmpty() == false}">

        <div class="container py-3">
            <div class="row">
                <div class="col-md-3 bg-dark text-center py-3">
                    <div class="card mb-2 shadow-sm ">
                        <div class="card-header">${libro.title} </div>
                        <div class="card-body">
                            <img class="card-img-top img-responsive" src="${libro.getPortada()}" alt="Card image cap" width="72px" height="250px">
                        </div>
                    </div>
                </div>
                <div class="col-md-8 bg-light py-3">
                    <form action="FrontController" id="updateCommentForm">
                        <input type="hidden" name="command" value="updateComment"/>

                        <c:forEach var="comentario" items="${libro.getComentarios()}">
                            <input type="hidden" name="commentID" value="${comentario.id}">
                            <c:url var="removeCommentLink" value="FrontController">

                                <c:param name="command" value="deleteComment"></c:param>
                                <c:param name="commentID" value="${comentario.id}"></c:param>

                            </c:url>
                            <div class="row py-3">
                                <div class="col-md-8 md-form">
                                    <textarea class="md-textarea form-control" rows="3" name="comment"  form="updateCommentForm"> ${comentario}</textarea>
                                </div>
                                <div class="col-md-4 md-form">
                                    <button type="submit" onclick="return confirm('Do you want to update this comment?');" class="btn btn-warning px-3">edit</button>                 
                                    <a href="${removeCommentLink}" onclick="return confirm('Do you want to delete this comment?');" class="btn btn-danger px-3">remove</a>                                        
                                </div>
                            </div>
                        </c:forEach>
                    </form>
                </div>
            </div>
        </div>
    </div>
</c:if>
</c:forEach>


<jsp:include page="./WebComponent/footer.jsp"/>
