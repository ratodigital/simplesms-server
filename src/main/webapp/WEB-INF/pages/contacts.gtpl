<% include '/WEB-INF/includes/header.gtpl' %>
 
<% include '/WEB-INF/includes/navbar.gtpl' %>

<div class="container">

  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Contato <small>listar</small></h1>
    </div>
  </div>    

  <div class="row">
    <div class="col-xs-6 col-md-3">


      <a href="/contact/add"><i class="fa fa-plus-circle"></i> Novo Contato</a>

      <hr>

      <ul id="navGroups" class="nav nav-pills nav-stacked">
        <li class="nav-header"></li>
          <%
          request.groups.each { group  ->
          %>
          <li class="droppable"><a class="list-group-item ${request.group == group.name ? 'active':''}" href="/contatos?group=${group.name}" <%if (request.group == group.name){%>active<%}%>><span class="badge pull-right">${group.value}</span>${group.name}</a></li>
          <%
          }
          %>
      </ul>
    </div>

    <div class="col-xs-12 col-sm-6 col-md-9">
          <div id="tableContatos" class="table-responsive">
            <table class="table table-striped">
              <thead>
                 <tr>
                    <th></th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Grupo(s)</th>          
                    <th>&nbsp;</th>
                 </tr>
              </thead>
              <tbody>
                 <% request.contacts.each { contact -> %>
                    <tr>
                       <td><a href="/contact/edit/${contact.key.id}"><i class="fa fa-pencil-square-o"></i></a>&nbsp;&nbsp;&nbsp;<a href="/contact/delete/${contact.key.id}" style="color:red"><i class="fa fa-trash-o"></i></a</td>
                       <td><div class="draggable">${contact.name}</div></td>
                       <td>${contact.phone}</td>
                       <td><% contact.groups.each { group -> %> <a href="#"><span class="badge">$group</span></a><%}%></td>
                       <td><a href="/contact/delete/${contact.key.id}" style="color:red"><i class="fa fa-trash-o fa-2x"></i> excluir</a>&nbsp;&nbsp;&nbsp;<a href="/contact/edit/${contact.key.id}"><i class="fa fa-pencil-square-o fa-2x"></i> alterar</a></td>
                    </tr>
                 <% } %>
              </tbody>
            </table>
            
          </div>
        </div>      
      </div><!-- /.row -->
  
    </div>
  </div>    

</div><!-- /.container -->


<script>
/*
(jQuery)(document).ready(function(){

    //this will hold reference to the tr we have dragged and its helper
    var c = {};

    (jQuery)("#navGroups li").draggable({
            helper: "clone",
            start: function(event, ui) {
                c.tr = this;
                c.helper = ui.helper;
            }
    });


    (jQuery)("#tableContatos tr").droppable({
        drop: function(event, ui) {
            var text = ui.draggable.text();
            alert(text);
            //(jQuery)(this).find("input").val(inventor);

            //(jQuery)(c.tr).remove();
            //(jQuery)(c.helper).remove();
        }
    });

});
*/

(jQuery)(function() {
    (jQuery)( ".draggable" ).draggable({ helper: "clone" });
    (jQuery)( ".droppable" ).droppable({
        drop: function( event, ui ) {
            var text = ui.draggable.text();
            console.log(text);

         /*(jQuery)( this )
       .addClass( "ui-state-highlight" )
       .find( "p" )
         .html( "Dropped!" );
         */
            }
 });
});

</script>

<% include '/WEB-INF/includes/footer.gtpl' %>


