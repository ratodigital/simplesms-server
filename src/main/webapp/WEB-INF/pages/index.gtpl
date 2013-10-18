<% include '/WEB-INF/includes/header.gtpl'%>

<% include '/WEB-INF/includes/navbar.gtpl' %>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
    
	  <div class="container">
	    <h1>SimpleSMS <small>Beta</small></h1>
	    <p>Utilize o seu Android como gateway para enviar mensagens SMS pela internet, aproveitando o plano da sua operadora.</p>
	    
      <a data-toggle="modal" href="#myModal" class="btn btn-success btn-lg">Login</a> 

    </div>
  </div>

	<div class="container">
		<div class="row">
			<div class="col-lg-4">
  			<img src="/images/androidapp.png" width="128px" height="128px" alt="Baixar SimpleSMS App">
			  <h2>1. Baixe o App</h2>
			  <p>Faça o download e instale aplicativo SimpleSMS para Android. Ele será utilizado para comunicar-se com nosso servidor para encaminhar suas mensagens SMS diretamente da internet. Na primeira utilização do aplicativo você deverá informar um endereço válido de e-mail, uma senha e um nome para o dispositivo.</p>
			  <p><a href="#divPdf" id="btnPdf" type="button" data-toggle="button" class="btn btn-primary" onclick="showDivPdf();"><span class="glyphicon glyphicon-info-sign"></span> Saiba mais</a></p>
			</div>
			<div class="col-lg-4">
  			<img src="/images/phone.png" width="128px" height="128px" alt="CSV">
			  <h2>2. Números de Telefones</h2>
			  <p>Você poderá criar seu cadastro de números telefônicos, importar as listas de contato dos dispositivos cadastrados ou importar de arquivos externos (CSV, Excel). Utilize email e senha informados no App para efetuar logon no SimpleSMS Web.</p>
			  <p><a href="#divCsv" id="btnCsv" type="button" data-toggle="button" class="btn btn-primary" onclick="showDivCsv();"><span class="glyphicon glyphicon-info-sign"></span> Saiba mais</a></p>
			</div>
			<div class="col-lg-4">
        <img src="/images/sms.png" width="128px" height="128px" alt="Email">
			  <h2>3. Envie os SMS</h2>
			  <p>Configure o nome do remetente, o assunto e o texto da mensagem a ser encaminhada a cada participante. Você também poderá ver uma prévia de como ficará o certificado pronto.</p>
			  <p><a href="#divEmail" id="btnEmail" type="button" data-toggle="button" class="btn btn-primary" onclick="showDivEmail();"><span class="glyphicon glyphicon-info-sign"></span> Saiba mais</a></p>
			</div>
	</div>

<% include '/WEB-INF/includes/footer.gtpl' %>

