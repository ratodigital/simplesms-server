<% include '/WEB-INF/includes/header.gtpl' %>
 
<% include '/WEB-INF/includes/navbar.gtpl' %>

<div class="container">
  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Contato <small>listar</small></h1>
      
      <a href="/contact/add">Incluir Contato</a>
      <br><br>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
             <tr>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Grupo(s)</th>          
                <th>&nbsp;</th>
             </tr>
          </thead>
          <tbody>
             <% request.contacts.each { contact -> %>
                <tr>
                   <td>${contact.name}</td>
                   <td>${contact.phone}</td>
                   <td><% contact.groups.each { group -> %> <a href="#"><span class="badge">$group</span></a><%}%></td>
                   <td><a href="/contact/delete/${contact.key.id}">Delete</a> | <a href="/contact/edit/${contact.key.id}">Edit</a></td>
                </tr>
             <% } %>
          </tbody>
        </table>
        
      </div>
    </div>      
  </div><!-- /.row -->
</div><!-- /.container -->
 
<% include '/WEB-INF/includes/footer.gtpl' %>


