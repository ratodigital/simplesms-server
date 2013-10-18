    <hr>
    
    <div id="footer">
      <div class="container">
        <p class="text-muted credit">Desenvolvido por <a href="http://github.com/ratodigital">Rato Digital</a>, 2013.</p>
      </div>
    </div>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/modern-business.js"></script>
		<script>
    (jQuery)(document).ready(function() {

        (jQuery)('#btnLogin').click(function() {
            (jQuery).ajax({
                type: "POST",
                dataType: "json",
                url: '/login',
                data: {
                    email: (jQuery)("#email").val(),
                    password: (jQuery)("#password").val()
                },
                success: function(json)
                {
                    if (json.status === 'ERROR') {
                      alert("Usuário ou senha inválidos");
                    } else {
                      location.reload(true)
                    }
                }
            });

        });
    });		
		</script>
  </body>
</html>
