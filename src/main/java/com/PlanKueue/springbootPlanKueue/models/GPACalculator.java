package com.PlanKueue.springbootPlanKueue.models;
import java.util.Scanner;

public class GPACalculator {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int totalCredits = 0;
      double totalGradePoints = 0.0;

      System.out.print("Enter the number of classes: ");
      int numClasses = input.nextInt();

      for (int i = 1; i <= numClasses; i++) {
         System.out.printf("Enter the credit hours for class %d: ", i);
         int credits = input.nextInt();
         System.out.printf("Enter the grade received for class %d (A, B, C, D, or F): ", i);
         String grade = input.next().toUpperCase();

         double gradePoints = 0.0;
         switch (grade) {
            case "A":
               gradePoints = 4.0;
               break;
            case "B":
               gradePoints = 3.0;
               break;
            case "C":
               gradePoints = 2.0;
               break;
            case "D":
               gradePoints = 1.0;
               break;
            case "F":
               gradePoints = 0.0;
               break;
            default:
               System.out.println("Invalid grade entered. Please try again.");
               i--;
               continue;
         }

         totalCredits += credits;
         totalGradePoints += gradePoints * credits;
      }

      double gpa = totalGradePoints / totalCredits;
      System.out.printf("Your GPA is %.2f\n", gpa);
   }
}
