<!DOCTYPE html>
<html>
    <head>
        <title>User's page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <h1>Hello <%= request.getParameter("username") %></h1>
    </body>
</html>