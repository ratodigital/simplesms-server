<% include '/WEB-INF/includes/header.gtpl' %>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
	  <div class="container">
	    <h1>Certificados PDF <small>Beta</small></h1>
	    <p class="text-center">A maneira mais fácil e rápida de enviar certificados de participação em cursos e eventos por e-mail. Com apenas 3 passos todos os participantes recebem um email padrão com o certificado anexado em formato PDF.</p>
	  </div>
  </div>
  
	<div class="container">
	  <div class="row">
      <div class="progress">
        <%
        def percent = 33
        def title = "Template PDF (1/3)"
				def info = "Pdf"
        if (request.status == 'GETCSV') {
          percent = 66
          title = "Dados CSV (2/3)"
					info = "Csv"
        } else if (request.status == 'GETMSGDATA') {
          title = "Enviar Email (3/3)"
          percent = 100
					info = "Email"
        }
        %>
        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${percent}" aria-valuemin="0" aria-valuemax="100" style="width: ${percent}%">
        </div>
      </div>
    </div>
		<div class="row">
	    <div class="pull-left"> 
				<h1>$title</h1>
			</div>
			<div class="pull-right">
				<h1><a href="#" data-toggle="tooltip" title="Saiba mais" onclick="showDiv${info}()"><span class="glyphicon glyphicon-info-sign"></span></a> <a href="/" data-toggle="tooltip" title="Página inicial"><span class="glyphicon glyphicon-home"></span></a><h1>
			</div>
		</div>
    <hr>
	  <div class="row">
      <% if (request.flush != null && request.flushError != "") {%>
			<div class="col-md-12">
        <div class="alert alert-danger alert-dismissable">
          <a href="#" class="alert-link">$request.flushError</a>
        </div>
			</div>      
      <% } %>	  
	    <div class="col-md-2">  
        <%
        def image = "pdf"
        if (request.status == 'GETCSV') {
          image = "csv"
        } else if (request.status == 'GETMSGDATA') {
          image = "email"
        }
        %>	    
  	    <p class="text-center"><img src="/images/${image}.png" width="128px" height="128px" alt="PDF"></p>
	    </div>	  
	    
	    <div class="col-md-10">
				<%
				if (request.status == 'GETPDF' || request.status == 'GETCSV') {
				%>  
				<form id="pdfForm" class="form-horizontal" role="form" action="${blobstore.createUploadUrl('/upload.groovy')}" 
				 method="post" enctype="multipart/form-data">
				<%  
				} else {
				%>  
				<form id="pdfForm" class="form-horizontal" role="form" action="/upload" method="post">
				<%  
				}
				%>

          <input name="pdfKey" type="hidden" value="$request.pdfKey"/>
          <input name="pdfName" type="hidden" value="$request.pdfName"/>  
          <input name="pdfFields" type="hidden" value="$request.pdfFields"/>    

          <%
          if (request.status == 'GETPDF') {
          %>       
          <input name="status" type="hidden" value="GETCSV"/>          
  			  <div class="form-group input-lg">
    			  <label for="file" class="col-lg-2 control-label">PDF</label>
					  <span class="input-group-btn">
              <input type="file" class="input-lg" name="pdfFile" required/><br/>
					  </span>
				  </div>   
				  <%  
          } else if (request.status == 'GETCSV') {
          %>
          <input type="hidden" name="status" value="GETMSGDATA">
  			  <div class="form-group input-lg">
    			  <label for="file" class="col-lg-2 control-label">CSV</label>
					  <span class="input-group-btn">
              <input type="file" class="input-lg" name="csvFile" required/><br/>
					  </span>
				  </div>              
          <%
          } else if (request.status == 'GETMSGDATA') {
          %>
          <input type="hidden" id="status" name="status" value="SENDPDF"/>  
          <input name="csvKey" type="hidden" value="$request.csvKey"/>          
          
          <div class="form-group input-lg">
            <label for="fromEmail" class="col-lg-2 control-label">Email do rementente</label>
            <div class="col-lg-10">
              <input type="email" class="form-control input-lg" name="fromEmail" id="fromEmail" placeholder="Email" value="certificadospdf@gmail.com" disabled>
            </div>
          </div>
          
          <div class="form-group input-lg">
            <label for="fromName" class="col-lg-2 control-label">Nome do rementente</label>
            <div class="col-lg-10">
              <input type="text" class="form-control input-lg" name="fromName" id="fromName" value="${params.fromName ?: 'Certificados PDF'}" required>
            </div>
          </div>    
          
          <div class="form-group input-lg">
            <label for="subject" class="col-lg-2 control-label">Assunto *</label>
            <div class="col-lg-10">
              <input type="text" class="form-control input-lg" name="subject" id="subject" value="${params.subject ?: 'Seu certificado está pronto!'}" required>
            </div>
          </div>    
          
          <div class="form-group input-lg">
            <label for="message" class="col-lg-2 control-label">Mensagem *</label>
            <div class="col-lg-10">
                <textarea id="message" name="message" class="form-control input-lg" rows="7" required><%if (!params.message) {%>Olá,

Seu certificado de participação segue em anexo.

Atenciosamente
---
Certificados PDF
certificadospdf.appspot.com
<%} else {%>
$params.message
<%}%>
                </textarea>
            </div>
          </div>              

          <div class="form-group">
            <div class="col-lg-10 col-lg-offset-2">
              <%if (request.pdfFields != "null" && request.pdfFields != null) {%> 
                * Você pode utilizar os campos <b>$request.pdfFields</b>
              <%} else {%>                 
                * O template PDF não possui nenhum campo que possa ser utilizado.
              <%}%>
            </div>
          </div>    

          <br/> 
          <div class="form-actions">
            <%
            }
            def submitButton = "Próximo <span class=\"glyphicon glyphicon-chevron-right\">"
            if (request.status == 'GETMSGDATA') {
            %>
            <div class="pull-left">
					    <button class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="Veja uma prévia de como ficará o PDF" data-original-title="Veja uma prévia de como ficará o PDF" onclick="submitPreview();"><span class="glyphicon glyphicon-eye-open"></span> Preview</button>
            </div>
            <%
              submitButton = "Enviar certificados <span class=\"glyphicon glyphicon-ok\">"            
            }
            %>
            <div class="pull-right">
              <button class="btn btn-primary btn-lg" onclick="submitForm();">$submitButton</span></button>
            </div>
          </div>
        </form>	                             
      </div> <!-- col-md-10 -->
    </div> <!-- row -->

    <div class="container">
      <% include '/WEB-INF/includes/divPdf.gtpl' %>	
      <% include '/WEB-INF/includes/divEmail.gtpl' %>     
      <% include '/WEB-INF/includes/divCsv.gtpl' %>		      
    </div>
    
  </div> <!-- container -->
  
<% include '/WEB-INF/includes/footer.gtpl' %>

