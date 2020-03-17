package DB;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StudentTest {

    public static void main(String[] args) {
        DBStudent dbStudent = new DBStudent();
//        INSERT
        Student s = new Student("Петренко Василий Петрович", 20, 666);
//        dbStudent.insertStudent(s);

//        DELETE
//        dbStudent.deleteStudent(4);

//        UPDATE
//        dbStudent.updateStudent(s, 5);

        //SELECT
         ArrayList<Student> students = new DBStudent().getSelect();
        for (Student student: students) {
            System.out.println(String.format("%d %s %d %d", student.getId(), student.getName(), student.getAge(), student.getNum()));
        }

    }

}
