<% include '/WEB-INF/includes/header.gtpl' %>
 
<% include '/WEB-INF/includes/navbar.gtpl' %>

<h2>Phones</h2>
 
<a href="/tel/add">Mensagens</a>
<br><br>
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
       <tr>
          <th>Status</th>        
          <th>Mensagem</th>
          <th>Telefones</th>
          <th>Criação</th>
          <th>Gateway</th>
          <th>SMS</th>                        
       </tr>
    </thead>
    <tbody>
       <% request.messages.each { msg -> %>
         <%
         def trClass = ""
         switch (msg.status) {
          case "WAIT": 
            trClass = "danger"
            break
          case "GATEWAY": 
            trClass = "warning"
            break
          case "SENT":
            trClass = "success"
         }
         %>
          <tr class="$trClass">
             <td>${msg.status}</td>        
             <td>${msg.message}</td>
             <td>${msg.phones}</td>
             <td>${msg.dateCreated ?: ""}</td>
             <td>${msg.dateGateway ?: ""}</td>
             <td>${msg.dateSent ?: ""}</td>                      
          </tr>
       <% } %>
    </tbody>
  </table>
</div>
 
<% include '/WEB-INF/includes/footer.gtpl' %>


