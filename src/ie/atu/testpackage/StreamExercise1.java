package ie.atu.testpackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }
}

public class StreamExercise1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22, 3.8));
        students.add(new Student("Bob", 19, 3.5));
        students.add(new Student("Charlie", 21, 3.9));
        students.add(new Student("Diana", 20, 3.7));
        students.add(new Student("Eve", 23, 3.6));
        students.add(new Student("Frank", 24, 3.95));

        
        students.stream()
                .filter(s -> s.getGpa() > 3.7)   // Find students with GPA > 3.7
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .map(s -> String.format("Name: %-10s GPA: %.2f Age: %d", s.getName(), s.getGpa(), s.getAge()))
                .forEach(System.out::println);

        // Optional:
        List<String> studentInfoList = students.stream()
                .filter(s -> s.getGpa() > 3.7)
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .map(s -> String.format("Name: %-10s GPA: %.2f Age: %d", s.getName(), s.getGpa(), s.getAge()))
                .collect(Collectors.toList());

        System.out.println("Filtered and formatted student information:");
        studentInfoList.forEach(System.out::println);
    }
}