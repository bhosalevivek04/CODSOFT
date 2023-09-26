import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueCalculations = true;

        while (continueCalculations) {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            int totalMarks = 0;

            // Loop to input marks for each subject
            for (int i = 1; i <= numSubjects; i++) {
                System.out.print("Enter marks obtained in subject " + i + ": ");
                int marks = scanner.nextInt();
                totalMarks += marks;
            }

            // Calculate the average percentage
            double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;
            char grade;

            // Determine the grade based on the average percentage
            if (averagePercentage >= 90) {
                grade = 'O';
            } else if (averagePercentage >= 80) {
                grade = 'A';
            } else if (averagePercentage >= 70) {
                grade = 'B';
            } else if (averagePercentage >= 60) {
                grade = 'C';
            } else if (averagePercentage >= 50) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // Display the results
            System.out.println("#########################");
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);

            // Ask the user if they want to continue
            System.out.print("Do you want to continue? (yes/no): ");
            String continueInput = scanner.next();

            continueCalculations = continueInput.equalsIgnoreCase("yes");
        }

        // Close the scanner
        scanner.close();
    }
}
