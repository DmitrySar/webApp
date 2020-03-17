package DB;

import java.io.Serializable;

public class Student implements Serializable {

    private String Name;
    private int age;
    private int num;
    private int id;

    public Student(String name, int age, int num) {
        Name = name;
        this.age = age;
        this.num = num;
    }

    public Student(int id, String name, int age, int num) {
        Name = name;
        this.age = age;
        this.num = num;
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public int getNum() {
        return num;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
