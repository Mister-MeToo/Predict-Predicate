<%-- 
    Document   : errorPage
    Created on : 15 Oct 2026, 13:45:57
    Author     : IC MOTS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        %>
        <h1>Hello user, here is the error below</h1>
        <p>
            <%=errorMessage%>
        </p>
    </body>
</html>
