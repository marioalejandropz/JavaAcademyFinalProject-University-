package data;

public class Student {
    private String name;
    private int age;
    private int studentId;
    private static int id = 1;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
        this.studentId = id++;
    }

    public String getName(){
        return name;
    }

    public int getStudentId(){
        return studentId;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return "\nStudent name: " + getName() + "\n" +
                "Age: " + getAge() + "\n" +
                "Student Id: " + getStudentId();

    }
}
