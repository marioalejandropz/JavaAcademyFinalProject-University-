package data;

import java.util.List;

public class Course {
    private String name, teacherName;
    private int classroom;
    private List<Student>studentsList;
    private int courseId;
    private static int id = 1;

    public Course(String name, String teacherName, List<Student>studentsList, int classroom){
        this.name = name;
        this.teacherName = teacherName;
        this.studentsList = studentsList;
        this.classroom = classroom;
        this.courseId = id++;
    }

    public String getName(){
        return name;
    }

    public String getTeacherName(){
        return teacherName;
    }

    public List<Student> getStudentsList(){ return studentsList; }

    public int getCourseId(){
        return courseId;
    }

    public int getClassroom(){
        return classroom;
    }

    public void addStudentToNewList(Student student){
        this.studentsList.add(student);
    }

    public String toString(){
        return "\nCourse name: " + getName() + "\n" +
                "Teacher: " + getTeacherName() + "\n" +
                "Classroom: " + getClassroom() + "\n" +
                "Course Id: " + getCourseId() + "\n" +
                "Course students: \n" + getStudentsList();
    }
}
