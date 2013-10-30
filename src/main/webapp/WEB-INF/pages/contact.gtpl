<% include '/WEB-INF/includes/header.gtpl' %>

<% include '/WEB-INF/includes/navbar.gtpl' %>
 
<%
  def contact = request.getAttribute("contact")
  boolean existingKey = contact?.key
  String action = !existingKey ? 'Incluir' : 'Atualizar'
%>
 
<div class="container">
  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Contato <small>${action.toLowerCase()}</small></h1>
      <form role="form" class="form-horizontal" action="/contact/${!existingKey ? 'insert' : 'update'}" method="POST">
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Nome</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="name" name="name" value="${contact?.name ? contact.name : ''}" size="60">
          </div>      
        </div>
        <div class="form-group">
          <label for="phone" class="col-lg-2 control-label">Telefone</label>
          <div class="col-lg-6">
            <input type="text" class="form-control" id="phone" name="phone" value="${contact?.phone ? contact.phone : ''}">
          </div>      
        </div>
        <div class="form-group">
          <label for="grupos" class="col-lg-2 control-label">Grupos</label>
          <div class="col-lg-6">
            <select id="groups" name="groups" data-placeholder="Grupos..." class="form-control chosen-select" multiple tabindex="-1">
              <option value=""></option>
                <% request.groups.each { group -> %>
                  <option value="${group.name}" ${contact && group.name in contact.groups ? 'selected' : ''}>${group.name}</option>
                <% } %>  
            </select>
          </div>
      </div>     
      <div class="form-actions">
        <div class="col-lg-offset-2 col-lg-10">
          <!-- Indicates caution should be taken with this action -->
          <button type="submit" class="btn btn-primary btn-lg">${action}</button>
          <!-- Indicates a dangerous or potentially negative action -->
          <button type="button" class="btn btn-danger" onclick="javascript:document.location.href = '/contatos';">Cancelar</button>
        </div>
      </div>             
      <% if(existingKey) { %>
         <input type="hidden" name="id" value="${contact.key.id}">
      <% } %>
    </form>
  </div><!-- /.row -->
</div><!-- /.container -->
 
<% include '/WEB-INF/includes/footer.gtpl' %>
