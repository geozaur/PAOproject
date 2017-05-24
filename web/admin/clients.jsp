<%@page import="java.util.List"%>
<%@page import="Models.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Clients list</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container centered">
            <div class="centered pad">
                <table>
                    <caption><h2 class="title">List of Clients</h2></caption>
                    <tr>
                        <th>Username</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Country</th>
                        <th>City</th>
                        <th>Address</th>
                        <th>Orders</th>
                        <th>Blocked</th>
                    </tr>

                    <%
                        for (Client client : (List<Client>) request.getAttribute("clientList")) {
                    %>
                    <tr>
                        <td> <%= client.getUsername()%></td>
                        <td> <%= client.getFirstName()%></td>
                        <td> <%= client.getLastName()%></td>
                        <td> <%= client.getPhone()%></td>
                        <td> <%= client.getEmail()%></td>
                        <td> <%= client.getCountry()%></td>
                        <td> <%= client.getCity()%></td>
                        <td> <%= client.getAddress()%></td>
                        <td> <form action="ClientOrder" method="POST">
                                <input type="hidden" name="username" value=<%= client.getUsername()%>>
                                <button type="submit">Show</button>
                            </form></td>
                        <td>
                            <form action="BlockController" method="POST">
                                <input type="hidden" name="username" value=<%= client.getUsername()%>>
                                <input type="hidden" name="blocked" value=<%= client.isBlocked() ? 1 : 0%>>
                                <button type="submit"><% if (client.isBlocked()) {
                                    %>Unblock<%
                                    } else {
                                    %>Block<%
                                    }%></button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                
                <br>
                <br>

                <a href="index.jsp">Back to admin page</a>
            </div>
        </div>
    </body>
</html>
