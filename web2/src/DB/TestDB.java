package DB;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestDB {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

//        students.add(new Student("Иванов Иван Иванович", 18, 303));
//        students.add(new Student("Петров Петр Петрович", 19, 304));
//        students.add(new Student("Сидоров Сидор Сидорович", 20, 202));
        Stream<Student> students = Stream.of(
                new Student("Иванов Иван Иванович", 18, 303),
                new Student("Петров Петр Петрович", 19, 304),
                new Student("Сидоров Сидор Сидорович", 20, 202)
        );

        String createTable = "DROP TABLE IF EXISTS STUDENTS;\n" +
                "CREATE TABLE STUDENTS(ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255), AGE INT, GROUP_NUMBER INT);\n";
        String insertValueToTable = "INSERT INTO STUDENTS(NAME, AGE, GROUP_NUMBER) VALUES(?, ?, ?);\n";
        String selectQuery = "SELECT * FROM STUDENTS ORDER BY ID LIMIT 10;";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/technetium", "sa", "");
             Statement statement = connection.createStatement()) {
            Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();

            statement.executeUpdate(createTable);

            PreparedStatement preparedStatement = connection.prepareStatement(insertValueToTable);
            students.forEach((student) -> {
                try {
                    preparedStatement.setString(1, student.getName());
                    preparedStatement.setInt(2, student.getAge());
                    preparedStatement.setInt(3, student.getNum());
                    preparedStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
//            preparedStatement.setString(1, "Иванов Иван Иванович");
//            preparedStatement.setInt(2, 23);
//            preparedStatement.setInt(3, 404);
//            preparedStatement.execute();

//            statement.execute(insertValueToTable);

            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                System.out.printf("%s %s %s %s\n", resultSet.getString("ID")
                ,resultSet.getString("NAME")
                ,resultSet.getString("AGE")
                ,resultSet.getString("GROUP_NUMBER"));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
