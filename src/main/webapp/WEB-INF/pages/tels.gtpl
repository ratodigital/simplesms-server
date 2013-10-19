<% include '/WEB-INF/includes/header.gtpl' %>
 
<% include '/WEB-INF/includes/navbar.gtpl' %>

<h2>Phones</h2>
 
<a href="/tel/add">Add Phone</a>
<br><br>
<table border="1">
  <thead>
     <tr>
        <th>Número</th>
        <th>Nome</th>
        <th>&nbsp;</th>
     </tr>
  </thead>
  <tbody>
     <% request.tels.each { tel -> %>
        <tr>
           <td>${tel.number}</td>
           <td>${tel.name}</td>
           <td><a href="/tel/delete/${tel.key.id}">Delete</a> | <a href="/tel/edit/${tel.key.id}">Edit</a></td>
        </tr>
     <% } %>
  </tbody>
</table>
 
<% include '/WEB-INF/includes/footer.gtpl' %>


