<% include '/WEB-INF/includes/header.gtpl'%>

<% include '/WEB-INF/includes/navbar.gtpl'%>

<div class="container">

      <div class="row">

      
        <div class="col-lg-12">
          <h1 class="page-header">Dispositivos <small>listar</small></h1>
		      <%
		        request.devices.each { d->
  		          //println "$d.name -> $d.regId <a href=\"/gcm/send?regId=$d.regId\">send 'a new message'</a><br>"
		        %>
              <div class="row">
                <div class="col-sm-3 col-md-3">
                  <div class="thumbnail">
                  <img src="/images/device.jpg" alt="...">
                    <div class="caption">
                    <center>
                      <h3>$d.name</h3>
                      <p><a href="#" class="btn btn-primary">Testar Conexão</a></p>
                    </center>
                    </div>
                  </div>
                </div>
              </div>
		        <%  
		        }
		      %>
        </div>

      </div><!-- /.row -->

</div><!-- /.container -->

<% include '/WEB-INF/includes/footer.gtpl' %>

