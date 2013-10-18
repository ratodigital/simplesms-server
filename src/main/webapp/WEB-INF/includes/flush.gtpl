    <% if (request.status == "OK" && request.flush) { %>
    <div class="alert alert-success">
      <button data-dismiss="alert" class="close" type="button">×</button>
      <h2>OK</h2>
      <p>$request.flush</p>
    </div>
    <%} else if (request.status == "ERROR" && request.flush) {%>
    <div class="alert alert-danger">
      <button data-dismiss="alert" class="close" type="button">×</button>
      <h2>Erro</h2>
      <p>$request.flush</p>
    </div>
    <% } %>

