<div class="container-fluid col-padding">
<div class="jumbotronx jumbotronx-sm col-padding">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12 col-padding">
                <h1 class="h1">
                   Upload Photos</h1>
            </div>
        </div>
    </div>
</div>
<br/>
</div>
<div class="container">
    <div class="row">
    <div class="col-md-4">
          <div class="thumbnail" style="padding: 0">
            <div style="padding:4px">
              <img alt="300x200" style="width: 100%" src="/xlickr/resources/images/aperture-icon.png">
            </div>
            <div class="caption">
              <h2>${albumname}</h2>
              <p>${albumdesc}</p>
              <p>Owner: ${createdBy}</p>
              <p>Created On: ${createdDate}</p>
              <a href="/xlickr/album/${albumId}">
      <button class="btn btn-default pull-right"><i class="fa fa-eye"></i> View </button>
                    </a>
            </div>
            <div class="modal-footer" style="text-align: left">
              <div class="row-fluid">
                <div class="col-md-4"><b>${totalimages}</b><br/><small>Images</small></div>
                <div class="col-md-4"><b>${rating}</b><br/><small>Rating</small></div>
                <div class="col-md-4"><b>${albumId}</b><br/><small>Comments</small></div>
              </div>
            </div>
          </div>
      </div>
      <div class="col-md-8" style="top: 100px">
      <form action="/xlickr/file/multifileupload"
      class="dropzone"
      id="my-awesome-dropzone">
      <div class="dz-message upload-photos-height">
    Drop Photos here or click to upload.<br />
  </div>
<input type="hidden"  value="${albumId}" name ="albumId">      
      </form>
      
      </div>
    </div>
</div>
