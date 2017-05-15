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
        <h1>Hello <%= request.getSession().getAttribute("username")%></h1>
        
        <form action="" method="Post">
            <p>Alegeti serviciul dorit:</p>
            <%
                for (Service service : (List<Service>) request.getAttribute("serviceList")) {
            %>
            <input type="radio" name="service" value="<%= service.getId() %>"> 
                <%= service.getName() + " " + 
                    service.getType() + " " +
                    (service.isColored() ? "colorat" : "necolorat") + " " +
                    service.getPrice() + "RON" %> <br>
            <% } %>
            
            <p>Alegeti produsul dorit:</p>
            <%
                for (Product product : (List<Product>) request.getAttribute("productList")) {
            %>
            <input type="radio" name="product" value="<%= product.getId() %>"> 
                <%= product.getName() + " " + 
                    product.getColor() + " " +
                    product.getSize() + " " +
                    product.getPrice() + "RON" %> <br>
            <% } %>
            
            <p>Alegeti poza dorita:</p>
            <input type="file" name="image"> <br>
            
            <button type="submit">Trimiteti comanda</button>
        </form>
        
        <form action="SignoutController">
            <button>Log out</button>
        </form>
    </body>
</html>