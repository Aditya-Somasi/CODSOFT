import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        String[] questions = {
            "What is the capital of France?",
            "What is the square root of 64?",
            "Who wrote 'Romeo and Juliet'?"
        };

        String[][] options = {
            {"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"},
            {"1. 6", "2. 7", "3. 8", "4. 9"},
            {"1. William Shakespeare", "2. Mark Twain", "3. Charles Dickens", "4. Jane Austen"}
        };

        int[] correctAnswers = {3, 3, 1};
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();

            if (answer == correctAnswers[i]) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The correct answer was option " + correctAnswers[i]);
            }

            System.out.println();
        }

        System.out.println("Quiz finished! Your score is: " + score + "/" + questions.length);
        scanner.close();
    }
}
