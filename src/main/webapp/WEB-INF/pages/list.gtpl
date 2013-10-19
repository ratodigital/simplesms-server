<% include '/WEB-INF/includes/header.gtpl'%>

<% include '/WEB-INF/includes/navbar.gtpl'%>

<div class="container">

      <div class="row">

      
        <div class="col-lg-12">
          <h1 class="page-header">Dispositivos <small>Clique no dispositivo para enviar SMS</small></h1>
		      <%
		        request.devices.each { d->
		          println "$d.name -> $d.regId <a href=\"/gcm/send?regId=$d.regId\">send 'a new message'</a><br>"
		        }
		      %>
        </div>

      </div><!-- /.row -->

</div><!-- /.container -->

<% include '/WEB-INF/includes/footer.gtpl' %>

