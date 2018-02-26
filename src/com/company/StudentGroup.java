package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class StudentGroup {
    private int size;
    private Student[] students = new Student[10];
   public Student[] getCopyOfStudent() {
        Student[] copy = new Student[size];
        System.arraycopy(students, 0, copy, 0, size);
        return copy;
    }
    public void printgroup() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + students[i]);
        }
    }


    public void add(Student student) {
        if(size >= students.length) {
            copyArray();
        }
        students[size++] = student;
    }

    private void copyArray() {
        Student[] tmp = new Student[students.length * 2];
        System.arraycopy(students, 0, tmp, 0, students.length);
        students = tmp;
    }


    public int getNumberOfStudent(String name) {
        for(int i=0;i<size;i++)
        {if(name.equals(students[i].getName()))
            return i;
    }
    return -1;
    }
    public void sortByStudentsName(){
        Student[] copy = new Student[size];
        System.arraycopy(students, 0, copy, 0, size);
        Arrays.sort(copy, Comparator.comparing(Student::getName));
        students = copy;
    }
    public  void sortByStudentsAverageMark(){
        Student[] tmp = new Student[size];
        System.arraycopy(students, 0, tmp, 0, size);
        for (int i = 0; i <tmp.length-1; i++)
        {
            int index = i;
            for (int j = i + 1; j < tmp.length; j++){
                if (tmp[j].getAverageMark() < tmp[index].getAverageMark()){
                    index = j;//searching for lowest index
                }}
                Student smallerNumber = tmp[index];
                tmp[index] = tmp[i];
                tmp[i] = smallerNumber;
                }students= tmp;
   }
    public void removeByNumber(int n) {
        Student[] tmp = new Student[students.length - 1];
        if (n < size && n >= 0) {
            System.arraycopy(students, 0, tmp, 0, n);
            System.arraycopy(students, n + 1, tmp, n, tmp.length - n);
            students = tmp;
        }
    }
    public void removeByName(String name) {
            Student[] tmp = new Student[students.length - 1];
            int n=getNumberOfStudent(name);
            if(n!=-1)
            {   System.arraycopy(students, 0, tmp, 0, n);
                System.arraycopy(students, n + 1, tmp, n, tmp.length -n );
                students = tmp;
            }
   }
}
