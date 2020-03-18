<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.03.2020
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="example.css">
  </head>
  <body>
  <h1><a href="studentslist.jsp">Список учащихся</a></h1>
  <h1><a href="adduser.jsp">Добавить учащегося</a> </h1>
  <h1>
    <!-- servlet -->
    <%= request.getAttribute("date") %>
    <br>
    <!-- insert expression -->
    <%= new Date() %>
    <br>
     2 + 3 =
    <%= 2 + 3 %>
  </h1>


  <form>
    <input name="name" type="text" value="">
    <input type="submit">
  </form>
  <!-- java bean -->
  <jsp:useBean id="testBean" class="beans.BeanTester" />
  <% String req = request.getParameter("name"); %>
  <jsp:setProperty name="testBean" property="name" value="<%= req %>" />
  <h2>
    <jsp:getProperty name="testBean" property="name"/>
  </h2>
  <p>
    <a href="questinary.jsp">Вопросник</a>
  </p>

  $END$
  </body>
</html>
