<%@page import="Models.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Orders list</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container centered">
            <div class="centered pad">
                <table>
                    <caption><h2 class="title"><%= request.getAttribute("clientName")%>'s Orders</h2></caption>
                    <tr>
                        <th>Id</th>
                        <th>Service</th>
                        <th>Product</th>
                        <th>Date</th>
                        <th>State</th>
                        <th>Photo</th>
                        <th>Price</th>
                    </tr>

                    <%
                        for (Order order : (List<Order>) request.getAttribute("clientOrders")) {
                    %>
                    <tr>
                        <td><%= order.getId()%></td>
                        <td><%= order.getService().getName()%></td>
                        <td><%= order.getProduct().getName()%></td>
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

                <a href="ClientList">Back to clients page</a>
            </div>
        </div>
    </body>
</html>
