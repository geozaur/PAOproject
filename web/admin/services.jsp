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
                <th>Remove</th>
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
                <td> <form action="RemoveService" method="Post">
                        <input type="hidden" name="id" value="<%= service.getId()%>">
                        <button type="submit">X</button>
                    </form></td>
            </tr>
            <%
                }
            %>
        </table>

        <form action="AddService" method="Post">
            Name <input type="text" name="name"> <br>
            Type <input type="text" name="type"> <br>
            Colored <input type="checkbox" name="colored" value="true"> <br>
            Price <input type="number" name="price"> <br>
            <button type="submit">Submit</button>
        </form>
        
        <a href="index.jsp">Back to admin page</a>
    </body>
</html>
