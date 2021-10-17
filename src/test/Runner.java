package test;

import data.Student;
import data.University;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        University eafit = new University();
        eafit.setFullTimeTeacher("Jorge Montoya", 350, 5, "Full time");
        eafit.setFullTimeTeacher("Juan David Morales", 320, 4, "Full time");
        eafit.setPartTimeTeacher("Carlos Giraldo", 180, 25, "Part time");
        eafit.setPartTimeTeacher("Juan Manuel Gómez", 120, 30, "Part time");
        eafit.setPartTimeTeacher("Cristian Carmona", 100, 18, "Part time");

        eafit.setStudentsList("John Marston", 19);
        eafit.setStudentsList("Leon S. Kennedy", 21);
        eafit.setStudentsList("Lara Croft", 22);
        eafit.setStudentsList("Sarah Kerrigan", 24);
        eafit.setStudentsList("Nathan Drake", 17);
        eafit.setStudentsList("Jill Valentine", 23);
        eafit.setStudentsList("Joel Miller", 28);
        eafit.setStudentsList("Geralt of Rivia", 30);

        List<Student> musicCourseList = new ArrayList<>();
        musicCourseList.add(eafit.getStudentsList().get(0));
        musicCourseList.add(eafit.getStudentsList().get(5));
        musicCourseList.add(eafit.getStudentsList().get(4));
        musicCourseList.add(eafit.getStudentsList().get(6));

        List<Student> globalWarmingCourseList = new ArrayList<>();
        globalWarmingCourseList.add(eafit.getStudentsList().get(1));
        globalWarmingCourseList.add(eafit.getStudentsList().get(4));
        globalWarmingCourseList.add(eafit.getStudentsList().get(2));
        globalWarmingCourseList.add(eafit.getStudentsList().get(7));

        List<Student> psychologyCourseList = new ArrayList<>();
        psychologyCourseList.add(eafit.getStudentsList().get(2));
        psychologyCourseList.add(eafit.getStudentsList().get(3));
        psychologyCourseList.add(eafit.getStudentsList().get(0));
        psychologyCourseList.add(eafit.getStudentsList().get(6));

        List<Student> ecommerceCourseList = new ArrayList<>();
        ecommerceCourseList.add(eafit.getStudentsList().get(1));
        ecommerceCourseList.add(eafit.getStudentsList().get(3));
        ecommerceCourseList.add(eafit.getStudentsList().get(5));
        ecommerceCourseList.add(eafit.getStudentsList().get(7));

        List<Student> socialSkillsCourseList = new ArrayList<>();
        socialSkillsCourseList.add(eafit.getStudentsList().get(7));
        socialSkillsCourseList.add(eafit.getStudentsList().get(3));
        socialSkillsCourseList.add(eafit.getStudentsList().get(1));


        eafit.setCoursesList("Music", eafit.getTeachersList().get(0).getName(), musicCourseList, 10);
        eafit.setCoursesList("Global Warming", eafit.getTeachersList().get(1).getName(), globalWarmingCourseList, 20);
        eafit.setCoursesList("Psychology", eafit.getTeachersList().get(2).getName(), psychologyCourseList, 30);
        eafit.setCoursesList("E-Commerce", eafit.getTeachersList().get(3).getName(), ecommerceCourseList, 40);
        eafit.setCoursesList("Social Skills", eafit.getTeachersList().get(4).getName(), socialSkillsCourseList, 50);

        List<Student>newCourseStudentsList = new ArrayList<>();
        boolean isRunning = true;

        while (isRunning) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n=============== Welcome to EAFIT's search tool =============== \n" +
                    "------------ Please select an option to continue: ------------ \n" +
                    "Type 1 to see the university teachers and their information\n" +
                    "Type 2 to see the university courses and details \n" +
                    "Type 3 to create a new student and add him/her to a course \n" +
                    "Type 4 to create a new course \n" +
                    "Type 5 to see the courses that a specific student is included\n" +
                    "Type 6 to exit \n" +
                    "==============================================================\n");
            int optionSelected = scan.nextInt();

            switch (optionSelected) {
                case 1:
                    System.out.println("\nThese are the university teachers:");
                    eafit.showTeachersInfo();
                    break;
                case 2:
                    System.out.println("\nThese are the ongoing courses, please select a course to get details:");
                    scan = new Scanner(System.in);
                    eafit.showCourseToSelect();
                    int courseSelected = scan.nextInt();
                    eafit.showCourseSelected(courseSelected);
                        break;
                case 3:
                    scan = new Scanner(System.in);
                    System.out.println("\nPlease insert the student name:");
                    String name = scan.nextLine();
                    System.out.println("Please insert the student age:");
                    int age = scan.nextInt();
                    eafit.setStudentsList(name, age);
                    System.out.println("\nPlease select a course to include the new student:");
                    eafit.showCourseToSelect();
                    int selection = scan.nextInt();
                    eafit.addStudentToCourse(selection);
                    break;
                case 4:
                    scan = new Scanner(System.in);
                    System.out.println("\nPlease insert the course name:");
                    name = scan.nextLine();
                    System.out.println("Please insert the classroom number :");
                    int classroom = scan.nextInt();
                    System.out.println("\nThese are the available teachers:");
                    eafit.showTeachersInfo();
                    System.out.println("\nPlease assign a teacher, type the teacher's Id you would like to add for this course:");
                    Scanner read = new Scanner(System.in);
                    int teacherId = read.nextInt();
                    String teacherSelected = "";
                    if(teacherId <= eafit.getTeachersList().size()) {
                        for (int i = 0; i < eafit.getTeachersList().size(); i++) {
                            if (teacherId == eafit.getTeachersList().get(i).getTeacherId()) {
                                teacherSelected = eafit.getTeachersList().get(i).getName() + " - " + eafit.getTeachersList().get(i).getStatus();
                            }
                        }
                    }else {
                        System.out.println("Please select a valid Id");
                        break;
                    }
                    System.out.println("\nHow many students would you like to include for this course:");
                    int numberOfStudentsToAdd = scan.nextInt();
                    System.out.println("\nThese are the available students to add for this course:");
                    eafit.showStudentsInfo();
                    eafit.selectStudentsToNewList(numberOfStudentsToAdd, newCourseStudentsList, name, teacherSelected, classroom, scan);
                    System.out.println("\nProcess successfully done! These are the details of the new course:");
                    System.out.println(eafit.getLastCourseAdded());
                    break;
                case 5:
                    System.out.println("\nThese are the students to check:");
                    eafit.showStudentsInfo();
                    System.out.println("\nPlease insert the student Id in order to check the information:");
                    int studentId = scan.nextInt();
                    eafit.showStudentCourses(studentId);
                    break;
                case 6:
                    System.out.println("Session ended, come back soon!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Please select a valid option");
            }
        }
    }
}

