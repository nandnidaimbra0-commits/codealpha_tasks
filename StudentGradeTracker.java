import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Student Grade Tracker =====");

        System.out.print("Enter number of subjects: ");
        int totalSubjects = sc.nextInt();

        ArrayList<Integer> grades = new ArrayList<>();

        System.out.println("Enter grades:");

        for (int i = 0; i < totalSubjects; i++) {
            int grade = sc.nextInt();
            grades.add(grade);
        }

        System.out.println("\n===== Grades Entered =====");

        for (int i = 0; i < grades.size(); i++) {
            System.out.println(grades.get(i));
        }

        int sum = 0;

        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }

        double average = (double) sum / totalSubjects;

        int highest = grades.get(0);
        int lowest = grades.get(0);

        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) > highest) {
                highest = grades.get(i);
            }
            if (grades.get(i) < lowest) {
                lowest = grades.get(i);
            }
        }

        System.out.println("\n===== Final Summary =====");
        System.out.println("Total Subjects: " + totalSubjects);
        System.out.println("Total Marks: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        System.out.println("=========================");
        System.out.println("Status: Completed");
        sc.close();
    }
}
