<% include '/WEB-INF/includes/header.gtpl' %>

<% include '/WEB-INF/includes/navbar.gtpl' %>
 
<%
  def group = request.getAttribute("group")
  boolean existingKey = group?.key
  String action = !existingKey ? 'Incluir' : 'Atualizar'
%>
 
<h2>${action} Grupo(s)</h2>
 
<form action="/group/${!existingKey ? 'insert' : 'update'}" method="POST">
   <table border="0">
      <tbody>
         <tr>
            <td>Nome:</td>
            <td><input type="text" name="name" value="${group?.name ? group.name : ''}"></td>
         </tr>
         <tr>
            <td>Descrição:</td>
            <td><input type="text" name="description" value="${group?.description ? group.description : ''}"></td>
         </tr>
      </tbody>
      <% if(existingKey) { %>
         <input type="hidden" name="id" value="${group.key.id}">
      <% } %>
   </table>
   <br>
   <input type="submit" value="${action}">
   <input type="button" value="Cancel" onclick="javascript:document.location.href = '/grupos';">
</form>
 
<% include '/WEB-INF/includes/footer.gtpl' %>
