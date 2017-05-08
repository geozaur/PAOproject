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
        <table border="1" cellpadding="5">
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
                for (Client client : (List<Client>)request.getAttribute("clientList")){
                  %>
                  <tr>
                      <td> <%= client.getUsername() %></td>
                      <td> <%= client.getFirstName() %></td>
                      <td> <%= client.getLastName() %></td>
                      <td> <%= client.getCountry() %></td>
                      <td> <%= client.getCity() %></td>
                      <td> <%= client.getAddress() %></td>
                      <td> <%= client.isBlocked() %></td>
                      
                  </tr>
                  <%
                }
            %>
<!--            
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>-->
        </table>
    </body>
</html>
