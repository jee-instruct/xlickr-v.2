var myapp = angular.module('xlickr',[]);

myapp.controller('userDetailsController',function($scope,$http){
	$http.get("/xlickr/service/user/details").success(function(data){
		$scope.userDetails = data;	
	});
});

myapp.controller('albumsController',function($scope,$http){
	$http.get("/xlickr/service/user/albums").success(function(data){
		$scope.userAlbums = data;	
	});
});

myapp.controller('albumController',function($scope,$http,$window){
	$scope.albumId = $window.albumId;
	$http.get("/xlickr/service/album/images/"+$scope.albumId).success(function(data){
		$scope.albumImages = data;	
	});
	$http.get("/xlickr/service/user/album/"+$scope.albumId).success(function(data){
		$scope.userAlbum = data;	
	});
});

myapp.controller('imagePageController',function($scope,$http,$window){
	$scope.imageId = $window.imageId;
	$http.get("/xlickr/service/image/"+$scope.imageId).success(function(data){
		$scope.image = data;	
	});
	$http.get("/xlickr/service/comments/image/"+$scope.imageId).success(function(data){
		$scope.comments = data;	
	});
	$http.get("/xlickr/service/image/metadata/"+$scope.imageId).success(function(data){
		$scope.metadata = data;	
	});
	
	$scope.comment="enter comments";
	
	 $scope.sendCommentsPost = function() {
	        $http({
	            method: 'POST',
	            url: "/xlickr/service/image/comment/"+$scope.imageId,
	            data: $.param({comment: $scope.comment,imageId:$scope.imageId}),
	            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	        }).success(function(data){
	        	$scope.comments = "";
	        });
	        
	        
	    } ;
	
	
	
});



