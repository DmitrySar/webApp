package servlets;

import DB.DBStudent;
import DB.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/view")
public class UserCreator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int number = Integer.parseInt(request.getParameter("number"));
        Student student = new Student(name, age, number);
        DBStudent dbStudent = new DBStudent();
        dbStudent.insertStudent(student);
        ArrayList<Student> students = dbStudent.getStudents();
        try (PrintWriter writer = response.getWriter()) {
            writer.println(String.format("<h1>Учащийся %s добавлен в список</h1>", student.getName()));
            writer.println("<h1>Полный список:</h1>");
            writer.println("<table>");
            writer.println("<tr><td>ID</td><td>NAME</td><td>AGE</td><td>GROUP</td></tr>");
            for (Student s: students) {
                writer.println("<tr>");
                writer.println(String.format("<td>%d</td><td>%s</td><td>%d</td><td>%d</td>", s.getId(), s.getName(), s.getAge(), s.getNum()));
                writer.println("</tr>");
            }
            writer.println("</table>");
        }

    }
}
