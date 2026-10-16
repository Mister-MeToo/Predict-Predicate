<%-- 
    Document   : performance
    Created on : 15 Oct 2026, 13:23:27
    Author     : IC MOTS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Academic Performance Page</title>
    </head>
    <%
        int countTotal = 0;
        int countFail = 0;
        int countSupplement = 0;
        int countPass = 0;

        request.getSession().setAttribute("countTotal", countTotal);
        request.getSession().setAttribute("countFail", countFail);
        request.getSession().setAttribute("countPass", countPass);
        request.getSession().setAttribute("countSupplement", countSupplement);
    %>
    <body>
        <h1>Enter student details below </h1>
        <form action="verifyDetailsServlet.do" method="post" >
            <table border="1">
                <tr>
                    <td>Student Number:</td>
                    <td><input type="text" name="studentNumber" required=""/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" required=""/></td>
                </tr>
                <tr>
                    <td>Predicate Mark:</td>
                    <td><input type="text" name="predMark" required=""/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="ENTER"/></td>
                </tr>
            </table>
        </form>
    </body>
    
</html>
