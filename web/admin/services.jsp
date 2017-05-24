<%@page import="java.util.List"%>
<%@page import="Models.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Services list</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container centered">
            <div class="centered pad">
                <table>
                    <caption><h2 class="title">List of Services</h2></caption>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Colored</th>
                        <th>Price</th>
                        <th>Reports</th>
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
                        <td style="text-align: center"> <form action="ServiceOrder" method="POST">
                                <input type="hidden" name="id" value=<%= service.getId()%>>
                                <input type="hidden" name="serviceName" value=<%= service.getName()%>>
                                <button type="submit">Show</button>
                            </form></td>
                        <td style="text-align: center"> <form action="RemoveService" method="Post">
                                <input type="hidden" name="id" value="<%= service.getId()%>">
                                <button type="submit">X</button>
                            </form></td>
                    </tr>
                    <%
                        }
                    %>
                </table>

                <br>
                <br>
                
                <fieldset>
                    <legend>
                        Add a new service
                    </legend>
                    <form action="AddService" method="Post">
                        Name <input type="text" name="name"> <br>
                        Type <input type="text" name="type"> <br>
                        Colored <input type="checkbox" name="colored" value="true"> <br>
                        Price <input type="number" name="price"> <br>
                        <button class="btn-submit" type="submit">Submit</button>
                    </form>
                </fieldset>

                <br>
                <br>

                <a href="index.jsp">Back to admin page</a>
            </div>
        </div>
    </body>
</html>
