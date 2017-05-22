<%@page import="Models.Service"%>
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
                <th>Reports</th>
                <th>Remove</th>
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
                <td> <form action="ProductOrder" method="POST">
                        <input type="hidden" name="id" value=<%= product.getId()%>>
                        <input type="hidden" name="productName" value=<%= product.getName()%>>
                        <button type="submit">Show</button>
                    </form></td>
                <td>
                <td> <form action="RemoveProduct" method="Post">
                        <input type="hidden" name="id" value="<%= product.getId()%>">
                        <button type="submit">X</button>
                    </form></td>
            </tr>
            <%
                }
            %>
        </table>
        
        <form action="AddProduct" method="Post">
            Name <input type="text" name="name"> <br>
            Color <input type="text" name="color"> <br>
            Size <input type="text" name="size"> <br>
            Price <input type="number" name="price"> <br>
            List of compatible services<br>
            <%
                List<Service> serviceList = (List<Service>) request.getAttribute("serviceList");
                for (int i = 0; i < serviceList.size(); i++) {
            %>
                <input type="checkbox" name="service<%=i%>" value="<%= serviceList.get(i).getId()%>"> <%=serviceList.get(i).getName()%><br>
            <%
                }
            %>
            <button type="submit">Submit</button>
        </form>
        
        <a href="index.jsp">Back to admin page</a>
    </body>
</html>
