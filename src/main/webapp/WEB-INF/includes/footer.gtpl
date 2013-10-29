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
    <script src="/js/chosen.jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
      var config = {
        '.chosen-select'           : {},
        '.chosen-select-deselect'  : {allow_single_deselect:true},
        '.chosen-select-no-single' : {disable_search_threshold:10},
        '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
        '.chosen-select-width'     : {width:"95%"}
      }
      for (var selector in config) {
        (jQuery)(selector).chosen(config[selector]);
      }
    </script>

		<script>

        		
		function submitLogin() {
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
		}		
		</script>
  </body>
</html>
