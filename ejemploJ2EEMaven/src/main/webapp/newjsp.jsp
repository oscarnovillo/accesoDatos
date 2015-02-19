<%-- 
    Document   : newjsp
    Created on : 04-ene-2015, 19:11:29
    Author     : oscar
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>

    
    <c:set var="t" value="${tests}" />
    <table>
      <c:forEach var="test" items='${t}'>
        <tr>
          <td><c:out value="${test.num}"/> </td>
          <td><c:out value="${test.nombre}"/> </td>
        </tr>
      </c:forEach>
      
    </table>
    <h1>Hello World2!</h1>
  </body>
</html>
