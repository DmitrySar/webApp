<%@ page import="java.util.ArrayList" %>
<%@ page import="DB.Student" %>
<%@ page import="DB.DBStudent" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список учащихся</title>

</head>
<body>
<%!
    private String getRow(String ... args) {
        String result = "";
        for (String s:args) {
            result += "<td>" + s + "</td>";
        }
        return "<tr>" + result + "</tr>";
    }

%>

<h2>Удалить из БД:</h2>

    <form method="POST">
        <p>
            Введите номер: <input type="text" name="del_id">
            <input type="submit">
        </p>

    </form>
    <%
        String id = request.getParameter("del_id");
        if(null != id && "" != id) {
            new DBStudent().deleteStudent(Integer.parseInt(id));
            out.println("Удалён учащийся №" + id);
        }
    %>
<h1>Список учащихся</h1>

<table>
    <tr><td>ID</td><td>NAME</td><td>AGE</td><td>GROUP</td></tr>
    <%
        ArrayList<Student> students = new DBStudent().getStudents();

        for (Student s: students) {
            out.println(getRow(String.valueOf(s.getId()), s.getName(), String.valueOf(s.getAge()), String.valueOf(s.getNum())));
        }

    %>
</table>


</body>
</html>
