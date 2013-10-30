<% include '/WEB-INF/includes/header.gtpl' %>
 
<% include '/WEB-INF/includes/navbar.gtpl' %>

                    <% /*datastore.execute { from categories sort asc by name }.each { category -> 
                    def count = datastore.execute {
                      select count 
                      from posts
                      where type == 'post'
                      and draft == false                      
                      and categories == category.name
                    }*/
                    %>
<div class="container">

  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Contato <small>listar</small></h1>
      <a href="/contact/add">Incluir Contato</a>
    </div>
  </div>    

  <div class="row">
    <div class="col-md-2">
      <div class="list-group">

        <%
        request.groups.each { group  ->
        %>        
        <a class="list-group-item ${request.group == group.name ? 'active':''}" href="/contatos?group=${group.name}" <%if (request.group == group.name){%>active<%}%>><span class="badge pull-right">${group.value}</span>${group.name}</a>
        <%  
        }
        %>
      </div>
    </div>

    <div class="col-md-10">
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
  
    </div>
  </div>    

</div><!-- /.container -->
 
<% include '/WEB-INF/includes/footer.gtpl' %>


