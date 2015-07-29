<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <div class="container-fluid signup">
    <div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm pull-right">
            <legend><a href="#"><i class="glyphicon glyphicon-new-window"></i></a> Sign up!</legend>
            <form:form action="/xlickr/signup" method="post" class="form" role="form" enctype="multipart/form-data" modelAttribute="user">
            <div class="row">
                <div class="col-xs-6 col-md-6">
                    <form:input class="form-control" path="firstname" placeholder="First Name" type="text"
                        required="autofocus" />
                </div>
                <div class="col-xs-6 col-md-6">
                    <form:input class="form-control" path="lastname" placeholder="Last Name" type="text" required="true" />
                </div>
            </div>
             <br />
            <form:input class="form-control" name="youremail" path="email" placeholder="Your Email" type="email" />
              <br />
             
             <div class="form-group">
    <label for="exampleInputFile">Profile Picture</label>
    <br/>
    <span class="btn btn-default btn-file">
        Browse <form:input type="file" placeholder="upload your picture" path="picture" />
    </span>
  </div>
             <br/>
             <form:input type="text" class="form-control" placeholder="Phone Number"  path="phonenumber" />
            <br />
            <form:input type="text" class="form-control" placeholder="Username" path="username" aria-describedby="basic-addon1"/>
              <br />
             <form:input type="password" class="form-control" placeholder="password" path="password" aria-describedby="basic-addon1"/>
            <br />
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Sign up</button>
            </form:form>
        </div>
    </div>
</div>
    </div>