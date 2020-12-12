<%-- 
    Document   : cards
    Created on : 23-sep-2020, 17:28:05
    Author     : Miki
--%>
<!-- si no se incluye no funciona, aunque la incluya el header no lo hereda -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- si no se incluye no funciona : |  -->
<%@page import="cart.Cart"%>
<%@ page import="java.util.*" %>
<%@ page import="Book.*" %> 

<c:if test="${carrito.isEmpty()==false}">
    <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">Your cart</span>
    </h4>

    <ul class="list-group mb-3">

        <c:forEach var="cartItem" items="${carrito.getCart()}">

            <c:url var="removeLink" value="FrontController">

                <c:param name="command" value="removeBookFromCart"></c:param>
                <c:param name="bookID" value="${cartItem.id}"></c:param>

            </c:url>

            <li class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                    <h6 class="my-0">${cartItem}</h6>
                    <small class="text-muted"></small>
                    <a href="${removeLink}" style="color:red">remove</a>
                </div>
                <span class="text-muted">${cartItem.price}</span>
            </li>


        </c:forEach>
        <li class="list-group-item d-flex justify-content-between lh-condensed">
            <div>
                <h6 class="my-0">TOTAL PRICE</h6>
            </div>
            <span class="text-muted">${carrito.getTotalPrice()}</span>
            <c:if test="${carrito.getTotalPrice() > user.getAccount()}">
                <span class="text-muted">overcost</span>
            </c:if>

        </li>
        <li class="list-group-item d-flex justify-content-between lh-condensed">
            <a href="FrontController?command=removeAllBooksFromCart" class="btn btn-secondary">clear</a>
            <c:choose>
                <c:when test="${carrito.getTotalPrice() > user.getAccount()}">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#HaveNotEnoughtMoney">
                        buy
                    </button>
                </c:when>    
                <c:otherwise>
                    <a href="FrontController?command=addBookToBookshelf" class="btn btn-success" >buy</a>
                </c:otherwise>
            </c:choose>



        </li>

    </ul>

</c:if>



