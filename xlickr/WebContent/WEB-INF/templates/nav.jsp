<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-inverse navbar-fixed-top" ng-controller="userDetailsController">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/xlickr"><b>Xlickr</b></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
           <security:authorize access="isAnonymous()">
           </security:authorize>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Explore <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Recent Photos</a></li>
                <li><a href="#">Top 20</a></li>
                <li><a href="#">Weekly</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Galleries</a></li>
                <li><a href="#">Categories</a></li>
              </ul>
            </li>
            <li><a href="/xlickr/create">Create</a></li>
            <security:authorize access="!isAnonymous()">
            <li><a href="/xlickr/albums">My Albums</a></li>
            </security:authorize>
          </ul>
          
          
     <!--    <form class="navbar-form navbar-right" role="search">
         <div class="input-group">
  		 <input type="text" class="form-control" id="search">
  		 <span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
		</div> 
      </form>
      -->
      
      
      <form id="custom-search-form" class="navbar-form navbar-right pull-right">
                <div class="nput-group">
                    <input type="text" class="search-query mac-style" placeholder="Search">
                    <button type="submit" class="btn"><i class="glyphicon glyphicon-search"></i></button>
                </div>
            </form>
            
      
          <ul class="nav navbar-nav navbar-right">
            <security:authorize access="isAnonymous()">           
            <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
			<ul id="login-dp" class="dropdown-menu">
				<li>
					 <div class="row">
							<div class="col-md-12">
							
								<b>Login </b>
								 <form class="form" role="form" method="post" action="/xlickr/login" accept-charset="UTF-8" id="login-nav">
										<div class="form-group">
											 <label class="sr-only" for="exampleInputEmail2">Username</label>
											 <input type="text" class="form-control" id="exampleInputEmail2" name="username" placeholder="Username" required autofocus>
										</div>
										<div class="form-group">
											 <label class="sr-only" for="exampleInputPassword2">Password</label>
											 <input type="password" class="form-control" id="exampleInputPassword2" name="password" placeholder="Password" required>
                                             <div class="help-block text-right"><a href="#">Forget the password ?</a></div>
										</div>
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block">Sign in</button>
										</div>
										<div class="checkbox">
											 <label>
											 <input type="checkbox"> keep me logged-in
											 </label>
										</div>
								 </form>
							</div>
							<div class="bottom text-center">
								New here ? <a href="/xlickr/signup" class="btn btn-primary"><b>Sign Up</b></a>
							</div>
					 </div>
				</li>
			</ul>
        </li>
            </security:authorize>
            <security:authorize access="!isAnonymous()">
           <li><a href="#">Upload</a></li>
           
            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome <security:authentication property="principal.username"/>
                                        <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <div class="navbar-content">
                                                    <div class="row">
                                                        <div class="col-md-5">
                                                            <img src="/xlickr/file/profile/image" height="120" width="120"
                                                                alt="Alternate Text" class="img-responsive" />
                                                            <p class="text-center small">
                                                                <a href="#">Change Photo</a></p>
                                                        </div>
                                                        <div class="col-md-7">
                                                         <h4>   <span>{{userDetails.firstname}} {{userDetails.lastname}}</span></h4>
                                                            <p class="text-muted small">
                                                                {{userDetails.email}}</p>
                                                            <div class="divider">
                                                            </div>
                                                            <a href="#" class="btn btn-primary btn-sm active pull-right">View Profile</a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="navbar-footer">
                                                    <div class="navbar-footer-content">
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <a href="#" class="btn btn-default btn-sm">Change Password</a>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <a href="/xlickr/logout" class="btn btn-default btn-sm pull-right">Sign Out</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </li>
          </security:authorize>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>