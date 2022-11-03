import java.util.Random;
import java.util.Scanner;

class Game {
    public int number;
    void isCorrectNumber(int attempts) {
        int guess;
        int exit;
        boolean end = false;
        while (!end) {
            Random r = new Random();
            number = r.nextInt(100);
            System.out.format("You have %d attempts to Guess the Number\n",attempts);
            System.out.println("Choose a Number between 1 to 100");
            System.out.println("Guess the Number");
            for (int i = 1; i <= attempts; i++) {
                System.out.println("Attempts left: " + (attempts - i + 1));
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the Number:");
                guess = sc.nextInt();
                if (number == guess) {
                    System.out.println("Your Guess is Right");
                    System.out.println("You won and guessed it in " + i + " attempts");
                    System.out.println("Your Score is: "+(20-i)*10+" Points");
                    break;
                }
                else if (number < guess)
                    System.out.println("Too High...");
                else
                    System.out.println("Too Low...");

                if (i == attempts){
                    System.out.println("You Lose");
                    System.out.println("The Number is: "+number);
                }
            }
            System.out.println("\n\nWant to continue ");
            System.out.println("Type 1 to continue\nType 2 to exit");
            Scanner sc = new Scanner(System.in);
            exit = sc.nextInt();
            if (exit == 1) {
                System.out.println("Welcome");
            } else {
                System.out.println("Thank you and Have a nice day");
                end = true;
            }
        }
    }
}

public class task2game {
    public static void main(String[] args) {
        int level;
        int attempts;
        System.out.println("Welcome to Number Guessing Game");
        System.out.println("Choose Difficulty Level");
        System.out.println("Enter \nEasy: 1 \nHard: 2");
        Scanner sc = new Scanner(System.in);
        level = sc.nextInt();
        if (level == 1) {
            attempts = 10;
        } else {
            attempts = 5;
        }
        Game g = new Game();
        g.isCorrectNumber(attempts);
    }
}