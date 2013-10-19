<% include '/WEB-INF/includes/header.gtpl' %>

<% include '/WEB-INF/includes/navbar.gtpl' %>
 
<%
  def tel = request.getAttribute("tel")
  boolean existingKey = tel?.key
  String action = !existingKey ? 'Incluir' : 'Atualizar'
%>
 
<h2>${action} Telefone(s)</h2>
 
<form action="/tel/${!existingKey ? 'insert' : 'update'}" method="POST">
   <table border="0">
      <tbody>
         <tr>
            <td>Telefone:</td>
            <td><input type="text" name="number" value="${tel?.number ? tel.number : ''}"></td>
         </tr>
         <tr>
            <td>Nome:</td>
            <td><input type="text" name="name" value="${tel?.name ? tel.name : ''}"></td>
         </tr>
      </tbody>
      <% if(existingKey) { %>
         <input type="hidden" name="id" value="${tel.key.id}">
      <% } %>
   </table>
   <br>
   <input type="submit" value="${action}">
   <input type="button" value="Cancel" onclick="javascript:document.location.href = '/tels';">
</form>
 
<% include '/WEB-INF/includes/footer.gtpl' %>
