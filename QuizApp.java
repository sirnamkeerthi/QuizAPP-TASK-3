import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Define quiz questions, options, and correct answers
        String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Which gas do plants absorb from the atmosphere?"
        };

        String[][] options = {
            {"A) London", "B) Paris", "C) Rome", "D) Madrid"},
            {"A) Earth", "B) Mars", "C) Venus", "D) Jupiter"},
            {"A) Oxygen", "B) Carbon dioxide", "C) Nitrogen", "D) Hydrogen"}
        };

        int[] correctAnswers = {1, 2, 1};

        // Set the timer for each question (in seconds)
        int questionTimeLimit = 2;

        // Display and evaluate each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Select your answer (A, B, C, D): ");
            String userAnswer = scanner.next().toUpperCase();

            if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D")) {
                int userChoice = userAnswer.charAt(0) - 'A' + 1;

                if (userChoice == correctAnswers[i]) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer is " + options[i][correctAnswers[i] - 1] + "\n");
                }
            } else {
                System.out.println("Invalid choice. Skipping to the next question.\n");
            }

            // Implement a timer for each question
            try {
                for (int timeRemaining = questionTimeLimit; timeRemaining >= 0; timeRemaining--) {
                    System.out.println("Time left: " + timeRemaining + " seconds");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Display the final score and a summary of correct/incorrect answers
        System.out.println("Quiz completed!");
        System.out.println("Your Score: " + score + "/" + questions.length);
        int incorrect = questions.length - score;
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + incorrect);

        scanner.close();
    }
}
