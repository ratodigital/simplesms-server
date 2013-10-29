<% include '/WEB-INF/includes/header.gtpl'%>

<% include '/WEB-INF/includes/navbar.gtpl'%>

<div class="container">

      <div class="row">

      
        <div class="col-lg-12">
          <h1 class="page-header">Enviar SMS <small>Informe a mensagem e selecione o dispositivo para enviar SMS</small></h1>
          
          <form class="form-horizontal" role="form" method="post" action="/send/sms">
       
            <div class="form-group">
              <label class="sr-only" for="message">Mensagem</label>
              <input type="message" class="form-control" name="message" id="message" placeholder="Mensagem (máx. 160 caracteres)" maxlength="160">
            </div>             
            <div class="form-group">
              <label class="control-label" for="device">Selecione o dispositivo</label>
              <div class="controls">
                <%
                  request.devices.each { d->
       	        %>   
                <label class="radio" for="device">
                  <input type="radio" name="device" id="device" value="$d.regId">
                  $d.name
                </label>
                <%		            
    		          }
    		        %>          
              </div>
            </div>   
            <div class="form-group">
              <label class="control-label" for="phone">Selecione os destinatários</label>
              <div class="controls">
                <%
                  request.phones.each { p->
       	        %>   
                <label class="checkbox" for="phone">
                  <input type="checkbox" name="phone" id="phone" value="$p.number">
                  $p.name <$p.number>
                </label>
                <%		            
    		          }
    		        %>          
              </div>
            </div>                         
            <button type="submit" class="btn btn-primary">Enviar</button>
          </form>          
        </div>

      </div><!-- /.row -->

</div><!-- /.container -->

<% include '/WEB-INF/includes/footer.gtpl' %>

