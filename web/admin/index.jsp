<!DOCTYPE html>
<html>
    <head>
        <title>User's page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container centered">
            <div class="centered">
                <h1 class="title">
                    Admin dashboard
                </h1>
                
                <ul class="list">
                    <li><a href="ClientList">Clients list</a></li>
                    <li><a href="ServiceList">Services list</a></li>
                    <li><a href="ProductList">Products list</a></li>
                    <li><a href="OrderList">Orders list</a></li>
                </ul>
                <form action="SignoutController">
                    <button class="btn-log">Log out</button>
                </form>
            </div>
        </div>
    </body>
</html>