<div ng-controller="albumController">
<div class="container-fluid col-padding">
<div class="jumbotronx jumbotronx-sm col-padding">
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-lg-4 col-padding">
                <h1 class="h1">
                 <i class="fa fa-users fa-2x"></i>
                   {{userAlbum.albumName}}</h1>
             
                 
            </div>
            
            <div class="col-sm-4 col-lg-4 col-padding">
           
                <h4 class="h4"><i class="fa fa-camera fa-2x"></i>    
                  {{userAlbum.imageCount}} Photos</h4>
                    <a ng-href="/xlickr/album/addImages/{{userAlbum.albumId}}">
      <button class="btn btn-default">
      <i class="glyphicon glyphicon-upload"></i> upload
      </button>
      </a>
      <a ng-href="/xlickr/delete/album/{{userAlbum.albumId}}">
      <button class="btn btn-default">
      <i class="fa fa-trash-o"></i> delete
      </button>
      </a>
       <a href="#">
      <button class="btn btn-default"><i class="glyphicon glyphicon-share"></i> share </button>
                    </a>
            </div>
          
          <div class="col-sm-4 col-lg-4 col-padding">
                <h4 class="h4">
                <i class="fa fa-user fa-1x"></i>
                  Created by {{userAlbum.albumCreatedBy}}</h4>
            <h4 class="h4"><i class="fa fa-calendar fa-1x"></i>
             Created on {{userAlbum.createdDataString}}</h4>
             <h4 class="h4"><span class="label label-success">
             {{userAlbum.albumPrivateString}}
                  </span>
             </h4>
             
            </div>
                        
        </div>
    </div>
</div>
<br/>
</div>

<div class="container" style="margin-top:20px;" >
	<div class="row">
	 
	 
		<div class="col-md-3 col-sm-4 col-xs-6 " ng-repeat="image in albumImages">
		<div class="panel panel-default img-imgx">
                <div class="panel-body">
		<a ng-href="/xlickr/image/{{image.imageId}}">
		<img class="img-responsive imgx" ng-src="/xlickr/file/stream/image/{{image.imageId}}" />
		</a>
	</div>
	 <div class="panel-footer imgx-footer">
                    <h4><a ng-href="/xlickr/image/{{image.imageId}}" title="Image">{{image.imageName}}</a></h4>
                    <span class="pull-right" >
                    <a ng-href="/xlickr/delete/image/{{image.albumId}}/{{image.imageId}}"><span class="fa fa-trash-o" style="padding-right:10px;"></span></a>
                    <a href="#share"><span class="glyphicon glyphicon-share" style="padding-right:10px;"></span></a>
                    <a ng-href="/xlickr/file/download/image/{{image.imageId}}"><span class="fa fa-download fa-1x" style="padding-right:10px;"></span></a>
                    </span>
                </div>
	</div>
	
	
		</div>
		
		
		
		
    </div>
    
    
</div>

</div>
<script>
var albumId = ${albumId};
</script>