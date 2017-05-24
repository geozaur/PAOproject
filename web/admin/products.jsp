<%@page import="Models.Service"%>
<%@page import="java.util.List"%>
<%@page import="Models.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Products list</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container centered">
            <div class="centered pad">
                <table>
                    <caption><h2 class="title">List of Products</h2></caption>
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
                        <td style="text-align: center"> <form action="ProductOrder" method="POST">
                                <input type="hidden" name="id" value=<%= product.getId()%>>
                                <input type="hidden" name="productName" value=<%= product.getName()%>>
                                <button type="submit">Show</button>
                            </form></td>
                        <td style="text-align: center"> <form action="RemoveProduct" method="Post">
                                <input type="hidden" name="id" value="<%= product.getId()%>">
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
                        Add a new product
                    </legend>
                    <form action="AddProduct" method="Post">
                        Name <input type="text" name="name"> <br>
                        Color <input type="text" name="color"> <br>
                        Size <input type="text" name="size"> <br>
                        Price <input type="number" name="price"> <br>

                        <br>

                        List of compatible services

                        <br>

                        <%
                            List<Service> serviceList = (List<Service>) request.getAttribute("serviceList");
                            for (int i = 0; i < serviceList.size(); i++) {
                                String serviceName = serviceList.get(i).getName() + " " + serviceList.get(i).getType();
                                if (serviceList.get(i).isColored()) {
                                    serviceName = serviceName + " Colorat";
                                } else {
                                    serviceName = serviceName + " Necolorat";
                                }
                        %>
                        <input type="checkbox" name="service<%=i%>" value="<%= serviceList.get(i).getId()%>"> <%=serviceName%>
                        <br>
                        <%
                            }
                        %>

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
