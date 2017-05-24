<%@page import="Models.Product"%>
<%@page import="java.util.List"%>
<%@page import="Models.Service"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User's page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container centered">

            <div class="centered">

                <h1 class="title">Hello <%= request.getSession().getAttribute("username")%></h1>

                <%
                    if (request.getAttribute("valid") != null) {
                        if (request.getAttribute("valid").equals("false")) { %>

                <div class="invalid-order">
                    <p>Asociere produs-serviciu invalida. Va rugam refaceti comanda.</p>
                </div>

                <%} else {%>

                <div class="valid-order">
                    <p>Comanda plasata cu succes!</p>    
                </div>

                <%}
                    }
                %>

                <form action="AddOrder" method="Post" enctype="multipart/form-data">
                    <input type="hidden" name="username" value="<%= request.getSession().getAttribute("username")%>">
                    <p>Alegeti serviciul dorit:</p>
                    <div class="radio">
                        <%
                            for (Service service : (List<Service>) request.getAttribute("serviceList")) {
                        %>
                        <input type="radio" name="service" value="<%= service.getId()%>"> 
                        <%= service.getName() + " "
                                + service.getType() + " "
                                + (service.isColored() ? "colorat" : "necolorat") + " "
                                + service.getPrice() + "RON"%>
                        <br>
                        <% } %>
                    </div>

                    <p>Alegeti produsul dorit:</p>
                    <div class="radio">
                        <%
                            for (Product product : (List<Product>) request.getAttribute("productList")) {
                        %>
                        <input type="radio" name="product" value="<%= product.getId()%>"> 
                        <%= product.getName() + " "
                                + product.getColor() + " "
                                + product.getSize() + " "
                                + product.getPrice() + "RON"%>
                        <br>
                        <% }%>
                    </div>

                    <p>Alegeti poza dorita:</p>
                    <input type="file" name="photo" size="50">
                    
                    <br>
                    <br>

                    <button class="btn-submit" type="submit">Trimiteti comanda</button>
                </form>

                <form action="SignoutController">
                    <button class="btn-log">Log out</button>
                </form>
            </div>
        </div>
    </body>
</html>