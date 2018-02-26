package com.company;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {
    private Scanner scanner = new Scanner(System.in);
    private StudentGroup studentGroup = new StudentGroup();

    public void addNewStudent() {
        System.out.println();
        String name = getInputString("Enter students name - ");
        System.out.print("Enter students age - ");
        int age = scanner.nextInt();
        System.out.print("Enter students average mark - ");
        double averageMark = scanner.nextDouble();
        String city = getInputString("Enter students city - ");
        String street =getInputString("Enter students street - ");
       String phone= getInputString("Enter students phone - ");
        Address address = new Address(city, street, phone);
        Student student = new Student(name, age, averageMark,address);
        studentGroup.add(student);
        System.out.println("Student was successfully added\n");
    }

    public void removeStudentbyName() {
        String name = getInputString("Enter students name - ");
        System.out.println("Was entered next students name - " + name);
        studentGroup.removeByName(name);
        System.out.println("Student was successfully removed");
    }
    public void removeStudentbyNumber() {
        int n=scanner.nextInt();
        System.out.println("Was entered next students number - " + n);
        studentGroup.removeByNumber(n);
        System.out.println("Student was successfully removed");
    }
    public void searchForStudentName()
    {
       System.out.println("Please enter student name that you want to find ");
        String name = scanner.nextLine();
        System.out.println("Searching student"+name);
        if(studentGroup.getNumberOfStudent(name)!=-1)
            System.out.println("The student is in base with number" +studentGroup.getNumberOfStudent(name));
        else System.out.println("This student does not exist");
    }
    public void searchForBestStudent(){
        Student[] st=studentGroup.getCopyOfStudent();
        Arrays.sort(st, Comparator.comparing(Student::getAverageMark));
        System.out.println("Best student is "+studentGroup.getNumberOfStudent(st[st.length-1].getName()));
    }
    public void searchForWorstStudent(){
        Student[] st=studentGroup.getCopyOfStudent();
        Arrays.sort(st, Comparator.comparing(Student::getAverageMark));
        System.out.println("Worst student is "+studentGroup.getNumberOfStudent(st[0].getName()));
    }
    public void displayAllStudents() {
        studentGroup.printgroup();
    }
    public void sortByName(){
        studentGroup.sortByStudentsName();
    }
    public void sortByGrade(){
        studentGroup.sortByStudentsAverageMark();
    }

    private String getInputString(String message){
        System.out.print(message);
        String input = "";
        while (input.isEmpty()) {
            input = scanner.nextLine();
        }
        return input;
    }
}
