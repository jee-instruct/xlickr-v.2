<div ng-controller="imagePageController">
<div class="container-fluid background-black" >
<div class="container">
<img class="img-responsive main-image" ng-src="/xlickr/file/stream/image/{{image.imageId}}" />

<div class="row" style="margin-top:10px;">

<div class="col-md-8">

 <div class="page-header">
            <h3 class="reviews">Leave your comment</h3>
</div>
 <div class="comment-tabs">
<ul class="nav nav-tabs" role="tablist">
                <li class="active"><a href="#comments-logout" role="tab" data-toggle="tab"><h4 class="reviews text-capitalize">Comments</h4></a></li>
                <li><a href="#add-comment" role="tab" data-toggle="tab"><h4 class="reviews text-capitalize">Add comment</h4></a></li>
            </ul> 
<div class="tab-content">
                <div class="tab-pane active" id="comments-logout">                
                   <ul class="commentList">
            <li ng-repeat="comment in comments | orderBy: 'commentedDate':true">
                <div class="commenterImage">
                  <img ng-src="/xlickr/file/user/profile/image/{{comment.userId}}" />
                </div>
                <div class="commentText">
                    <p class="">{{comment.comments}} </p> <span class="date sub-text">on {{comment.createdDataString}} by {{comment.username}}</span>

                </div>
            </li>
        </ul>
                        
                        </div>
                        <div class="tab-pane" id="add-comment">
                    <form ng-submit="sendCommentsPost()" class="form-horizontal" id="commentForm" role="form"> 
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Comment</label>
                            <div class="col-sm-10">
                              <textarea class="form-control" name="comment" id="addComment" rows="5" ng-model="comment"></textarea>
                              <input type="text" hidden="true" name="imageId" value="${imageId}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">                    
                                <button class="btn btn-success btn-circle text-uppercase" type="submit" id="submitComment"><span class="glyphicon glyphicon-send"></span> Summit comment</button>
                            </div>
                        </div>            
                    </form>
                </div>
                        </div>
</div>
</div>
<div class="col-md-4">
<div class="page-header">
<h3 class="reviews">Photo Information</h3>
</div>

<div class="row">
<div class="col-md-12">
                <div class="db-wrapper">
                    <div class="db-pricing-seven">
                        <ul>
                            <li class="price">
                                <i class="fa fa-camera fa-3x"></i>
                                {{image.imageName}}<br>
                                Album: {{image.albumName}}<br>
                                Size: {{image.imageSize}} Bytes<br>
                                Content Type: {{image.imageContentType}}<br>
                                uploaded by: {{image.imageUploadedBy}}<br>
                                uploaded on: {{image.createdDataString}}<br>
                                <h4 class="h4"><span class="label label-success">
            					 {{image.imagePrivateString}}
                				  </span>
                            </li>
                            <li>
                            
                            <h5 ng-repeat="data in metadata">{{data.key}} : {{data.value}}</h5>
                           
                            
                            </li>
                        </ul>
                        <div class="pricing-footer">
                            <a ng-href="/xlickr/file/download/image/{{image.imageId}}" class="btn btn-primary"><i class="fa fa-download fa-1x"></i> download </a>
                        </div>
                    </div>
                </div>
            </div>
</div>





</div>


</div>
</div>
</div>
</div>
<script>
var imageId = ${imageId};
</script>