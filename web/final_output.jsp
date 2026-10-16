<%-- 
    Document   : final_output
    Created on : 15 Oct 2026, 15:35:55
    Author     : IC MOTS
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Final Output Page</title>
    </head>

    <body>
        <h1>Final Output</h1>
        <p>
            Total Students Processed: <%=request.getSession().getAttribute("countTotal")  %>
            <br>
            Total Students Failed: <%= request.getSession().getAttribute("countFail")%>
            <br>
            Total Students Passed: <%=request.getSession().getAttribute("countPass")%>
            <br>
            Total Students Supplement: <%= request.getSession().getAttribute("countSupplement") %>
        </p>
        
        <h2>Processed Students Details</h2>
        <%
        List <User> listOfUsers = (List<User>) request.getSession().getAttribute("listOfUsers");
        if (listOfUsers != null && !listOfUsers.isEmpty()){    
        %>
        <table border="1">
            <tr>
                <th>Student Number</th>
                <th>Name</th>
                <th>Predicate Mark</th>
            </tr>
            <%
                for (User u : listOfUsers){
            %>
            <tr>
                <td><%= u.getStudnNo()  %></td>
                <td><%= u.getName()  %></td>
                <td><%= u.getPredMark()  %></td>
            </tr>
            <%
                }
            %>
        </table>
            <%
                }else {    
            %>
            <p>No records found</p>
            <%
                }
            %>
    </body>
</html>
