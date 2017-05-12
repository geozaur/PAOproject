<%@page import="java.util.List"%>
<%@page import="Models.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products list</title>
    </head>
    <body>
        <table>
            <caption><h2>List of Products</h2></caption>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Color</th>
                <th>Size</th>
                <th>Price</th>
            </tr>

            <%
                for (Product product : (List<Product>) request.getAttribute("productList")) {
            %>
            <tr>
                <td> <%= product.getId()%></td>
                <td> <%= product.getName()%></td>
                <td> <%= product.getColor()%></td>
                <td> <%= product.getSize()%></td>
                <td> <%= product.getPrice()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
