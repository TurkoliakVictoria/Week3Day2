package com.company;
import java.util.Scanner;

    public class School {

        private final static int ADD_NEW_STUDENT = 1;
        private final static int REMOVE_STUDENT = 2;
        private final static int DISPLAY_ALL_STUDENTS = 3;
        private static final int SEARCH_STUDENT=4;
        private static final int SORT_STUDENTS=5;
        private final static int EXIT = 6;

        private StudentManager manager = new StudentManager();
        private Scanner scanner = new Scanner(System.in);

        public void run() {
            System.out.println("Hello director");
            while (true) {
                showMenu();
                int act = scanner.nextInt();
                switch (act) {
                    case ADD_NEW_STUDENT: {
                        manager.addNewStudent();
                        break;
                    }
                    case REMOVE_STUDENT: {
                        System.out.println("1-Remove student by number");
                        System.out.println("2-Remove student by name");
                        int t=scanner.nextInt();
                        if(t==1){
                        manager.removeStudentbyNumber();
                        break;}
                        else if(t==2){
                            manager.removeStudentbyName();
                        break;}
                    }
                    case DISPLAY_ALL_STUDENTS: {
                        manager.displayAllStudents();
                        break;
                    }
                    case SEARCH_STUDENT:{
                        System.out.println("1-search by name");
                        System.out.println("2-search the worst student by grade");
                        System.out.println("3-search the best student by grade");
                        int cost=scanner.nextInt();
                        if(cost==1){
                            manager.searchForStudentName();
                            break;}
                            if(cost==2){
                                manager.searchForWorstStudent();
                                break;}
                            if(cost==3){
                                manager.searchForBestStudent();
                                break;}

                    }
                    case SORT_STUDENTS:{
                    System.out.println("1-Sort by name");
                    System.out.println("2-Sort by average mark");
                    int q=scanner.nextInt();
                    if(q==1){
                    manager.sortByName();
                    break;
                    }
                    if(q==2){
                        manager.sortByGrade();
                        break;
                    }
                    }
                    case EXIT: {
                        System.out.println("Good bye");
                        return;
                    }
                    default: {
                        System.out.println("Unknown command !!!");
                    }
                }
            }

        }

        private void showMenu() {
            System.out.println("Choose your act");
            System.out.println("1) Add student");
            System.out.println("2) Remove student");
            System.out.println("3) Display all students");
            System.out.println("4) Search for student");
            System.out.println("5) Sort  students");
            System.out.println("6) Exit");
        }
    }

