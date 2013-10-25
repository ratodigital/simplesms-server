<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">SimpleSMS</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
      <ul class="nav navbar-nav navbar-right">
				<!--
        <li><a href="services.html">Services</a></li>
        <li><a href="contact.php">Contact</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="portfolio-1-col.html">1 Column Portfolio</a></li>
            <li><a href="portfolio-2-col.html">2 Column Portfolio</a></li>
            <li><a href="portfolio-3-col.html">3 Column Portfolio</a></li>
            <li><a href="portfolio-4-col.html">4 Column Portfolio</a></li>
            <li><a href="portfolio-item.html">Single Portfolio Item</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="blog-home-1.html">Blog Home 1</a></li>
            <li><a href="blog-home-2.html">Blog Home 2</a></li>
            <li><a href="blog-post.html">Blog Post</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="full-width.html">Full Width Page</a></li>
            <li><a href="sidebar.html">Sidebar Page</a></li>
            <li><a href="faq.html">FAQ</a></li>
            <li><a href="404.html">404</a></li>
            <li class="active"><a href="pricing.html">Pricing Table</a></li>
          </ul>
        </li>
				-->
				<%if (!memcache['userEmail']){%>
				<li class="dropdown">
          <a class="dropdown-toggle" href="#" data-toggle="dropdown">Login</a>
          <div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px; width: 240px;">
            <!-- Login form here -->
						<form role="form">
							<div class="form-group">
								<input id="email" class="form-control" type="email" name="email" size="30" placeholder="E-mail"/>
							</div>
							<input id="password" class="form-control" type="password" name="password" size="30" placeholder="Senha" />
							<input id="user_remember_me" style="float: left; margin-right: 10px;" type="checkbox" name="rememberMe" value="1" />
							<label class="string optional" for="user_remember_me"> Remember me</label>
						 
							<input class="btn btn-primary" style="clear: left; width: 100%; height: 32px; font-size: 13px;" type="button" id="btnLogin" value="Login" onclick="submitLogin();" />
						</form>
          </div>
        </li>
				<%} else {%>
        <li><a href="/sms">Enviar SMS</a></li>				
        <li><a href="/dispositivos">Dispositivos</a></li>
				<li><a href="/telefones">Telefones</a></li>
				<li><a href="/logout">Logout</a></li>
				<%}%>
    	</ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container -->
</nav>


