import java.util.Scanner;

public class moduleTwo {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Does player one choose rock, paper, or scissors? ");
        String playerOne = input.next();
        System.out.print("Does player two choose rock, paper, or scissors? ");
        String playerTwo = input.next();

        if (playerOne.equals("rock")){
            if (playerTwo.equals("scissors")) {
                System.out.println("Player one wins");
            } else if (playerTwo.equals("paper")) {
                System.out.println("Player two wins");
            } else {
                System.out.println("Draw try again");
            }
        } else if (playerOne.equals("paper")){
            if (playerTwo.equals("rock")) {
                System.out.println("Player one wins");
            } else if (playerTwo.equals("scissors")) {
                System.out.println("Player two wins");
            } else {
                System.out.println("Draw try again");
            }
        } else { //if playerOne chooses scissors
            if (playerTwo.equals("rock")) {
                System.out.println("Player two wins");
            } else if (playerTwo.equals("paper")) {
                System.out.println("Player one wins");
            } else {
                System.out.println("Draw try again");
            }
        }
    }
}
