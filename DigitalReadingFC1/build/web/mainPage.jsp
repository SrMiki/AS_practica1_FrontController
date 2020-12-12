<%-- 
    Document   : index
    Created on : 05-sep-2020, 19:42:18
    Author     : Miki
--%>
<%@ page import="java.util.*" %>
<%@ page import="Book.*" %> 
<jsp:include page="./WebComponent/header.jsp"/>
<jsp:include page="./WebComponent/navbar.jsp"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="px-3">
    <div class="py-3 text-center">
        <p class="lead">DigitalReading!</p>
    </div>
    <div class="row">
        <div class="col-md-4 order-md-2 ">
            <jsp:include page="./WebComponent/cart.jsp"/>
        </div>
        <div class="col-md-8 order-md-1">
            <jsp:include page="./WebComponent/catalogo.jsp"/>
        </div>
    </div>
</div>
<jsp:include page="./WebComponent/modals.jsp"/>
<jsp:include page="./WebComponent/footer.jsp"/>
