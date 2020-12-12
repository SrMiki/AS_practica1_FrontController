<%-- 
    Document   : uploadBook
    Created on : 23-sep-2020, 10:48:40
    Author     : Miki
--%>

<jsp:include page="/WebComponent/header.jsp"/>
<jsp:include page="/WebComponent/navbar.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="card col-lg-8">
        <div class="card-body">
            <form action="FrontController">
                <input type="hidden" name="command" value="updateBook">
                <input type="hidden" name="bookID" value="${bookToUpload.getId()}">

                <div class="form-group">
                    <label for="fTitle">Title</label>
                    <input type="text" id="fTitle" name="title" value="${bookToUpload.getTitle()}" class="form-control"> 
                </div>

                <div class="form-group">
                    <label for="fAuthor">Author</label>
                    <input type="text" id="fAuthor" name="author" value="${bookToUpload.getAuthor()}" class="form-control">
                </div>

                <div class="form-group">
                    <label for="fGenre">Genre</label>
                    <input type="text" id="fGenre" name="genre" value="${bookToUpload.getGenre()}" class="form-control">
                </div>

                <div class="form-group">
                    <label for="fSellingDate">SellingDate</label>
                    <input type="text" id="fSellingDate" name="sellingDate" value="${bookToUpload.getSellingDate()}" class="form-control">
                </div>

                <div class="form-group">
                    <label for="fPrice">Price</label>
                    <input type="text" id="fPrice" name="price" value="${bookToUpload.getPrice()}" class="form-control">
                </div>


                <input type="submit" value="update" class="btn btn-info">

            </form>
        </div>
    </div>




<jsp:include page="/WebComponent/footer.jsp"/>