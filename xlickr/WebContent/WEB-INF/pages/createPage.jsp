<div class="container-fluid create-albums col-padding">
<div class="jumbotronx jumbotronx-sm col-padding">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12 col-padding">
                <h1 class="h1">
                    Create Album</h1>
            </div>
        </div>
    </div>
</div>
<br/>
<br/>

<div class="container ">
    <div class="row">
        <div class="col-md-4">
            <div class="well well-sm ">
                <form action="/xlickr/create" method="post" >
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="name">
                             Album Name</label>
                            <input type="text" class="form-control" placeholder="Album Name"  name="albumName"  required autofocus>
                        </div>
                         <div class="form-group">
                            <label for="name">
                                Description</label>
                            <textarea id="message" class="form-control"  name="albumDesc" rows="9" cols="25" 
                               placeholder="Album Description" ></textarea>
                        </div>
                        
                        <div class="form-group">
                            <label for="subject">
                                Is Private</label>
                             <input type="checkbox" aria-label="..." name="isPrivate">
                        </div>
                        <button type="submit" class="btn btn-primary pull-right" id="btnContactUs">
                            Create Album</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <div class="col-md-4 col-padding">
          <!-- <img alt="" src="/xlickr/resources/images/index.jpg" class="subpageimages img-responsive"> -->
        </div>
    </div>
</div>

</div>