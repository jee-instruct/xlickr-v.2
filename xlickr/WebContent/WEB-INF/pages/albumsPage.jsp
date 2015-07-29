<div class="container" style="margin-top:20px;" ng-controller="albumsController">
	<div class="row form-group">
        <div class="col-xs-12 col-md-4" ng-repeat="album in userAlbums | orderBy: 'albumCreatedDate':true">
            <div class="panel panel-default">
                <div class="panel-image">
              <a href="/xlickr/album/{{album.albumId}}" ng-switch="album.randomImageId"> 
              <img ng-switch-when="0"  src="/xlickr/resources/images/aperture-icon.png" class="panel-image-preview" />
                <img ng-switch-default ng-src="/xlickr/file/stream/image/{{album.randomImageId}}" class="img-responsive panel-image-preview" /></a>
                </a>
                </div>
                <div class="panel-body">
                    <h4>Title: {{album.albumName}}</h4>
                    <p>Description: {{album.albumDescription}}</p>
                    <h5>Image Count: {{album.imageCount}}</h5>
                    <h6>Created by {{album.albumCreatedBy}} on {{album.createdDataString}}</h6>
                </div>
                <div class="panel-footer text-center">
                    <a ng-href="/xlickr/album/addImages/{{album.albumId}}"><span class="glyphicon glyphicon-upload"></span></a>
                    <a ng-href="/xlickr/delete/album/{{album.albumId}}"><span class="fa fa-trash-o"></span></a>
                    <a href="#share"><span class="glyphicon glyphicon-share"></span></a>
                    <a href="#download"><span class="fa fa-download"></span></a>
                    <a href="#rating">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </a>
                </div>
            </div>
        </div>
	</div>
</div>