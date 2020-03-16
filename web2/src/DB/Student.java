package DB;

public class Student {

    private String Name;
    private int age;
    private int num;

    public Student(String name, int age, int num) {
        Name = name;
        this.age = age;
        this.num = num;
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
}
