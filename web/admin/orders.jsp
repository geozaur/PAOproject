<%@page import="Models.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders list</title>
    </head>
    <body>
        <table>
            <caption><h2>List of Orders</h2></caption>
            <tr>
                <th>Id</th>
                <th>Client</th>
                <th>Service</th>
                <th>Product</th>
                <th>Date</th>
                <th>State</th>
                <th>Photo</th>
                <th>Price</th>
            </tr>

            <%
                for (Order order : (List<Order>) request.getAttribute("orderList")) {
            %>
            <tr>
                <td><%= order.getId() %></td>
                <td><%= order.getClient().getFirstName() + " " +  order.getClient().getLastName() %></td>
                <td><%= order.getService().getName() %></td>
                <td><%= order.getProduct().getName() %></td>
                <td><%= order.getDate() %></td>
                <td><%= order.isState() %></td>
                <td><%= order.getPhoto() %></td>
                <td><%= order.getPrice() %></td>
            </tr>
            <%
                }
            %>
        </table>
        
        <form action="AddProduct" method="Post">
            
        </form>
        
        <a href="index.jsp">Back to admin page</a>
    </body>
</html>
