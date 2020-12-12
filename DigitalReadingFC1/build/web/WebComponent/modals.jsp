<%-- 
    Document   : modals
    Created on : 04-oct-2020, 11:48:32
    Author     : Miki
--%>

<!-- Modal Warning cartContainTheBook -->
<div class="modal fade" id="cartContainTheBook" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color: indianred">
                <h5 class="modal-title" style="color: white">Warning!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" style="background-color: GhostWhite">
                <div class="form-group">
                    <label >This book is already in the cart</label>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">got it</button>
            </div>
        </div>  
    </div>
</div>

<!-- Modal Waring the bookIsAreladyInTheBookshelf -->
<div class="modal fade" id="bookIsAlreadyInTheBookshelf" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color: indianred">
                <h5 class="modal-title" style="color: white">Warning!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" style="background-color: GhostWhite">
                <div class="form-group">
                    <label >This book is already in your bookshelf</label>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">got it</button>
            </div>
        </div>  
    </div>
</div>



<!-- Modal warning the user HaveNotEnoughtMoney -->
<div class="modal fade" id="HaveNotEnoughtMoney" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color: indianred">
                <h5 class="modal-title text-center" style="color: white">Warning!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" style="background-color: GhostWhite">
                <p>You don't have enough money!</p>
                <p>Current account: ${user.getAccount()} </p>
                <p>cart whole cost: ${carrito.getTotalPrice()} </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">got it</button>
            </div>
        </div>  
    </div>
</div>
            
            
<!-- Modal insertCommentForm -->
<div class="modal fade" id="insertComment" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header" style="background-color: indianred">
                <h5 class="modal-title">New comment!</h5>
                <!-- cruz para cerrar -->
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form action="FrontController" id="insertCommentForm">
                <div class="modal-body" style="background-color: GhostWhite">

                    <input type="hidden" name="command" value="insertComment"></input>
                    <div class="form-group">
                        <label for="fTitle">Write your comment </label>
                        <div class="row py-3">
                            <div class="col-md-12 md-form">
                                <textarea class="md-textarea form-control" rows="3" name="comment"  form="insertCommentForm"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">done</button>
                </div>
            </form>
        </div>  
    </div>
</div>
