<%-- 
    Document   : profile
    Created on : 01-oct-2020, 17:01:13
    Author     : Miki
--%>
<%@page import="Comentarios.ModelComment"%>
<jsp:include page="./WebComponent/header.jsp"/>
<jsp:include page="./WebComponent/navbar.jsp"/>


<div class="container bootstrap snippet">

    <div class="row py-3">
        <div class="col-sm-3"><!--left col-->


            <div class="text-center">
                <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
            </div></hr><br>

            <ul class="list-group mb-6">
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    Activity <i class="fa fa-dashboard fa-1x"></i>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <strong>Book</strong></span> ${numBooks}
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <strong>Comments</strong >${numComments}
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <strong>Likes</strong></span>${numLikes}
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <strong>Account</strong >${user.getAccount()}
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#staticBackdrop">deposit money

                    </button> 
                </li>

            </ul> 

        </div><!--/col-3-->

        <div class="col-sm-9">
            <form class="form-signin" action="FrontController">
                <input type="hidden" name="command" value="updateUser"/>
                <div class="tab-content">
                    <div class="tab-pane active">
                        <hr>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label><h4>First name</h4></label>
                                <input type="text" class="form-control" name="username" value="${user.username}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label><h4>Last name</h4></label>
                                <input type="text" class="form-control" name="lastname" value="${user.lastname}">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label><h4>Email</h4></label>
                                <input type="text" class="form-control" name="email" value="${user.email}">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label><h4>Password</h4></label>
                                <input type="password" class="form-control" name="password" value="${user.password}"
                            </div>
                        </div>
                        <!--
                <div class="form-group">

                    <div class="col-xs-6">
                        <label for="password2"><h4>Verify</h4></label>
                        <input type="password" class="form-control" name="password2" id="password2" placeholder="password2" title="enter your password2.">
                    </div>
                </div> -->
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-info" type="submit">save change</button>
                            </div>
                        </div>

                        <hr>

                    </div>
                </div><!--/tab-pane-->
            </form>
        </div><!--/tab-content-->

    </div><!--/col-9-->
</div><!--/row-->

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color: indianred">
                <h5 class="modal-title" style="color: white">Deposit money</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="FrontController">
                <div class="modal-body" style="background-color: GhostWhite">
                    <input type="hidden" name="command" value="addMoney">
                    <div class="form-group">
                        <label for="fTitle">Introduce money count: </label>
                        <input type="text" name="deposit" class="form-control"> 
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">deposit</button>
                </div>
            </form>
        </div>  
    </div>
</div>