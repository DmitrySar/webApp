package DB;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class DBStudent {

    private String query = "SELECT ID, NAME, AGE, GROUP_NUMBER FROM STUDENTS ORDER BY ID";
    private String driver = "org.h2.Driver";
    private String connectionString = "jdbc:h2:~/technetium";
    private String login = "sa";
    private String password = "";

    public ArrayList<Student> getStudents() {
        query = "SELECT ID, NAME, AGE, GROUP_NUMBER FROM STUDENTS ORDER BY ID";
        ArrayList<Student> table = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, login, password);
             Statement statement = connection.createStatement()) {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                table.add(new Student(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4)));
            }
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return table;
    }

    public boolean insertStudent(Student student) {
        query = String.format("INSERT INTO STUDENTS(NAME, AGE, GROUP_NUMBER) VALUES('%s', %d, %d)",
                student.getName(), student.getAge(), student.getNum());
        try (Connection connection = DriverManager.getConnection(connectionString, login, password);
        Statement statement = connection.createStatement()) {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            return statement.execute(query);
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteStudent(int id) {
        query = String.format("DELETE FROM STUDENTS WHERE ID=%d", id);
        try (Connection connection = DriverManager.getConnection(connectionString, login, password);
        Statement statement = connection.createStatement()) {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            return statement.execute(query);
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStudent(Student student, int id) {
        query = String.format("UPDATE STUDENTS SET NAME='%s', AGE=%d, GROUP_NUMBER=%d WHERE ID=%d;", student.getName(),
                student.getAge(), student.getNum(), id);
        try (Connection connection = DriverManager.getConnection(connectionString, login, password);
        Statement statement = connection.createStatement()) {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            return statement.execute(query);
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }

}
