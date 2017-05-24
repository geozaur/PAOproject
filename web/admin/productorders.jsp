<%@page import="Models.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Orders list</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container centered">
            <div class="centered pad">


                <table>
                    <caption><h2><%= request.getAttribute("productName")%> report</h2></caption>
                    <tr>
                        <th>Id</th>
                        <th>Client</th>
                        <th>Service</th>
                        <th>Date</th>
                        <th>State</th>
                        <th>Photo</th>
                        <th>Price</th>
                    </tr>

                    <%
                        for (Order order : (List<Order>) request.getAttribute("productOrders")) {
                    %>
                    <tr>
                        <td><%= order.getId()%></td>
                        <td><%= order.getClient().getFirstName() + " " + order.getClient().getLastName()%></td>
                        <td><%= order.getService().getName()%></td>
                        <td><%= order.getDate()%></td>
                        <td><%= order.isState()%></td>
                        <td><%= order.getPhoto()%></td>
                        <td><%= order.getPrice()%></td>
                    </tr>
                    <%
                        }
                    %>
                </table>

                <br>

                <a href="ProductList">Back to products page</a>
            </div>
        </div>
    </body>
</html>
