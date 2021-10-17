package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {

    private List<Course>coursesList;
    private List<Teacher>teachersList;
    private List<Student>studentsList;

    public University() {
        this.coursesList = new ArrayList<>();
        this.teachersList = new ArrayList<>();
        this.studentsList  = new ArrayList<>();
    }

    public List<Course> getCoursesList(){
        return coursesList;
    }

    public List<Teacher> getTeachersList(){
        return teachersList;
    }

    public List<Student> getStudentsList(){
        return studentsList;
    }

    public void setCoursesList(String name, String teacher, List<Student>studentList, int classroom){
        this.coursesList.add(new Course(name, teacher, studentList, classroom));
    }

    public void setStudentsList(String name, int age){
        this.studentsList.add(new Student(name, age));
    }

    public void setFullTimeTeacher(String name, int baseSalary, float experienceYears, String status){
        this.teachersList.add(new FullTimeTeacher(name, baseSalary, experienceYears, status));
    }

    public void setPartTimeTeacher(String name, int baseSalary, float hoursPerWeek, String status){
        this.teachersList.add(new PartTimeTeacher(name, baseSalary, hoursPerWeek, status));
    }

    public void showTeachersInfo(){
        for(Teacher teacher: getTeachersList()){
            System.out.println(teacher);
        }
    }

    public void showStudentsInfo(){
        for(Student student: getStudentsList()){
            System.out.println(student);
        }
    }

    public void showCourseToSelect(){
        for(int i = 0; i < getCoursesList().size(); i++) {
            System.out.println("Type " + (i + 1) + " to select " + getCoursesList().get(i).getName());
        }
    }

    public void showCourseSelected(int courseSelected){
        if(courseSelected <= getCoursesList().size()){
            for(int i = 0; i <= getCoursesList().size(); i++) {
                if (courseSelected == i + 1) {
                    System.out.println(getCoursesList().get(i));
                }
            }
        }else{
            System.out.println("Please select a valid option");
        }
    }

    public void addStudentToCourse(int selection){
        if(selection <= getCoursesList().size()) {
            for(int i = 0; i < getCoursesList().size(); i++) {
                if (selection == i + 1) {
                    getStudent(i, getStudentsList().get(getStudentsList().size() - 1));
                    System.out.println("\nProcess successfully done! This is the new list of students for this course:");
                    System.out.println(getCoursesList().get(i).getStudentsList());
                }
            }
        }else{
            System.out.println("Please select a valid option");
        }
    }

    public Course getLastCourseAdded(){
        return getCoursesList().get(getCoursesList().size() - 1);
    }

    public void selectStudentById(int studentId, List<Student>newList){
        if(studentId <= getStudentsList().size()) {
            for (int i = 0; i < getStudentsList().size(); i++) {
                if (studentId == getStudentsList().get(i).getStudentId()) {
                    newList.add(getStudentsList().get(i));
                }
            }
        }else {
            System.out.println("Please select a valid Id");
        }
    }

    public void selectStudentsToNewList(int numberOfStudentsToAdd, List<Student>newList, String name, String teacherSelected, int classroom, Scanner scan ){
        for(int i = 0; i < numberOfStudentsToAdd; i++){
            System.out.println("\nStudent: " + (i + 1) + "\n" +
                    "Please type the student's Id that you would like to add:");
            int studentId = scan.nextInt();
            selectStudentById(studentId, newList);
            setCoursesList(name, teacherSelected, newList, classroom);
        }
    }

    public void showStudentCourses(int studentId){
        if(studentId <= getStudentsList().size()){
            for(int i = 0; i < getStudentsList().size(); i++){
                if(studentId == getStudentsList().get(i).getStudentId()) {
                    System.out.println("\n" + getStudentsList().get(i).getName() + " is currently doing these courses:");
                    for (Course course : getCoursesList()) {
                        for (Student student : course.getStudentsList()) {
                            if (studentId == student.getStudentId()) {
                                System.out.println(" - " + course.getName());
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("Please select a valid option");
        }
    }

    public void getStudent(int i, Student student){
        this.coursesList.get(i).addStudentToNewList(student);
    }
}
