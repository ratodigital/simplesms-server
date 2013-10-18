<% include '/WEB-INF/includes/header.gtpl'%>

<% include '/WEB-INF/includes/navbar.gtpl'%>

<div class="container">

      <div class="row">

        <% include '/WEB-INF/includes/flush.gtpl' %>
      
        <div class="col-lg-12">
          <h1 class="page-header">Services <small>What We Do</small></h1>
          <ol class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li class="active">Services</li>
          </ol>
        </div>

      </div><!-- /.row -->

      <div class="row">
      <!--
        <div class="col-lg-12">
          <img class="img-responsive" src="http://placehold.it/1200x300">
        </div>
      -->
        <%
          request.devices.each { d->
            println "$d.name -> $d.regId <a href=\"/gcm/send?regId=$d.regId\">send 'a new message'</a>"
          }
        %>
      </div><!-- /.row -->

</div><!-- /.container -->

<% include '/WEB-INF/includes/footer.gtpl' %>

