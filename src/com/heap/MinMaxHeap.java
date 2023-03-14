package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;


//  does not allow NULL
//  The queue items must be Comparable, to determine their priorities.
//  By deafult, the items in the priority queue are ordered in natural order.
//  PriorityQueue is not thread safe. Use PriorityBlockingQueue in concurrent environment.
//  It provides O(log(n)) time performance for add and poll methods.
class Student implements Comparable<Student>
{
    String name;
    int roll;
    int marks;

    public Student(String name, int roll, int marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }
    @Override
    public int compareTo(Student student) {
        return this.marks-student.marks;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                ", marks=" + marks +
                '}';
    }


}
public class MinMaxHeap {
    public static void main(String[] args) {


        // Default :  Min Heap
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        pq1.add(10);
        pq1.add(20);
        pq1.add(30);
        System.out.println("Min Heap : "+pq1.peek());




        // Max Heap
        PriorityQueue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder());
        pq2.add(10);
        pq2.add(20);
        pq2.add(30);
        System.out.println("Max Element : "+pq2.peek());


        // Comparable
        // Arrange Student according to marks (higher top)
        PriorityQueue<Student> students=new PriorityQueue<>(Collections.reverseOrder());
        students.add(new Student("A",1,100));
        students.add(new Student("B",3,50));
        students.add(new Student("C",2,900));
        students.add(new Student("D",4,10));
        while (!students.isEmpty())
        {
            System.out.println(students.peek().toString());
            students.remove();
        }





    }
}
