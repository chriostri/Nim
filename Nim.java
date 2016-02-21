import java.util.Random;
import java.util.Scanner;

class Nim {

    public static void main(String[] args) {
        System.out.println("Welcome to Nim!");
        
        Random randy = new Random();
        Scanner sc = new Scanner(System.in);
        
        int turn = randy.nextInt(2);
        if (turn == 0) {
            System.out.println("Computer goes first.");
        } else {
            System.out.println("You go first.");
        }
        
        int size = randy.nextInt(91) + 10;
        System.out.println("Initial number of sticks: " + size + ".");
        
        while (size > 1) {
            int num_removed;
            if (turn == 0) { // computer's turn
                num_removed = randy.nextInt(size / 2) + 1;
                size = size - num_removed;
                System.out.println("Computer removes " + num_removed + ".\nCurrent number of sticks: " + size + ".");
                turn = 1;
            } else { // user's turn
                System.out.print("How many sticks do you wish to pick up? ");
                num_removed = sc.nextInt();
                if (num_removed < 1 || num_removed > (size / 2)) { // user error
                    System.out.println("Error! You must pick up x where 0 < x and x <= half the sticks.");
                    // We do not update size and we do not update turn, hence next time around loop it is
                    // still user's turn and s/he must enter again
                } else { // no user error
                    size = size - num_removed;
                    System.out.println("You remove " + num_removed + ".\nCurrent number of sticks: " + size + ".");
                    turn = 0;
                }
            }
        }
        
        if (turn == 0) {
            System.out.println("Computer picks up the remaining stick, and loses!");
        } else {
            System.out.println("You pick up the remaining stick, and lose!");
        }
    }

}