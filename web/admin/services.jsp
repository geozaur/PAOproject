<%@page import="java.util.List"%>
<%@page import="Models.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Services list</title>
    </head>
    <body>
        <table>
            <caption><h2>List of Products</h2></caption>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Type</th>
                <th>Colored</th>
                <th>Price</th>
            </tr>

            <%
                for (Service service : (List<Service>) request.getAttribute("serviceList")) {
            %>
            <tr>
                <td> <%= service.getId()%></td>
                <td> <%= service.getName()%></td>
                <td> <%= service.getType()%></td>
                <td> <%= service.isColored()%></td>
                <td> <%= service.getPrice()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
