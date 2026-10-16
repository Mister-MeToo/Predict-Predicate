<%-- 
    Document   : verifyDetails_output
    Created on : 15 Oct 2026, 15:10:05
    Author     : IC MOTS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Details Outcome Page</title>
    </head>
    <%
      String result = (String) request.getAttribute("result");
    %>
    <body>
        <h1>Verify Details Outcome</h1>
        <p>
            Congrats. The data has been processed. The result:
            <br>
            <b><%=result%></b>
        </p>
        <ul>
            <li>Click <a href="performance2.jsp">here</a> to enter more details</li>
            <li>Click <a href="final_output.jsp">here</a> to end process</li>
        </ul>
        
    </body>
</html>
