<!-- Header -->
<div id="top-nav" class="navbar navbar-inverse navbar-fixed-top ">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-toggle"></span>
            </button>
            <a class="navbar-brand" href="#">SimpleSMS</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <%if (!memcache['userEmail']){%>
                <li class="dropdown">
                <a class="dropdown-toggle" href="#" data-toggle="dropdown">Login</a>
                <div class="dropdown-menu" style="padding: 15px; padding-bottom: 10px; width: 240px;">
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
                <li><a href="/mensagens">Mensagens</a></li>
                <li><a href="/dispositivos">Dispositivos</a></li>
                <li><a href="/contatos">Contatos</a></li>
                <li><a href="/grupos">Grupos</a></li>
                <li><a href="/logout">Logout</a></li>
                <%}%>
                <li class="dropdown">
                <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a>
                <ul id="g-account-menu" class="dropdown-menu" role="menu">
                <li><a href="#">My Profile</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-lock"></i> Logout</a></li>
            </ul>
        </div>
    </div><!-- /container -->
</div>
<!-- /Header -->