import java.util.*;
public class OddsOrEvens {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Let's play a game called Odds or Evens");
        System.out.print("What is your name? ");
        String name = input.next();
        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String choice = input.next();

        if (choice.equals("O")){
            System.out.println(name + " has picked Odds. The Computer will be evens.");
            System.out.println("--------------------");
        } else if (choice.equals("E")){
            System.out.println(name + " has picked Evens. The computer will be Odds.");
            System.out.println("--------------------");
        } else {
            System.out.println("invalid choice, please try again and enter a capital \"O\" or a capital \"E\"");
        }

        System.out.print("How many \"fingers\" do you play? ");
        Integer playerFingers = input.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " \"fingers\"");
        System.out.println("--------------------");

        Integer gameSum = playerFingers + computer;
        System.out.println(playerFingers + " + " + computer + " = " + gameSum);

        Boolean oddOrEven = (gameSum % 2) == 0;
        if (oddOrEven == true){
            System.out.println(gameSum + " is...even!");
                if (choice.equals("E")){
                    System.out.println("The player wins!");
                }else{
                    System.out.println("The computer wins!");
                }
        } else {
            System.out.println(gameSum + " is...odd!");
                if (choice.equals("O")){
                    System.out.println("The player wins!");
                }else{
                    System.out.println("The computer wins!");
                }
        }
        System.out.println("--------------------");
    }
}
