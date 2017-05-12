<%@page import="java.util.List"%>
<%@page import="Models.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clients list</title>
    </head>
    <body>
        <table>
            <caption><h2>List of Clients</h2></caption>
            <tr>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Country</th>
                <th>City</th>
                <th>Address</th>
                <th>Blocked</th>
            </tr>

            <%
                for (Client client : (List<Client>) request.getAttribute("clientList")) {
            %>
            <tr>
                <td> <%= client.getUsername()%></td>
                <td> <%= client.getFirstName()%></td>
                <td> <%= client.getLastName()%></td>
                <td> <%= client.getCountry()%></td>
                <td> <%= client.getCity()%></td>
                <td> <%= client.getAddress()%></td>
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
    </body>
</html>
