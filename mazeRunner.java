import java.util.*;
public class mazeRunner {
    static Maze myMap = new Maze();
    public static void main(String[] args){
        intro();
        while (!myMap.didIWin()) {
                userMove();
            if (myMap.didIWin()){
                System.out.println("Congratulations! You made it out alive.");
            }
        }
    }
    public static void intro(){
        System.out.println("Welcome to MazeRunner! ");
        System.out.println("Here is your current position! ");
        myMap.printMap();
    }

    public static String userDirection(){
        Scanner input = new Scanner(System.in);
        System.out.println("Where would you like to move? (R, L, U, D)");
        String direction = input.next();
        return direction;
    }

    public static String userMove(){
        String direction = userDirection();
        if(direction.equals("R")){
            if (myMap.canIMoveRight()){
                myMap.moveRight();
                myMap.printMap();
            } else if (myMap.isThereAPit("R")){
                watchPits("R");
                myMap.printMap();
            } else {
                System.out.println("Sorry, you've hit a wall.");
            }
        } else if (direction.equals("L")){
            if (myMap.canIMoveLeft()){
                myMap.moveLeft();
                myMap.printMap();
            } else if (myMap.isThereAPit("L")){
                watchPits("L");
                myMap.printMap();
            } else {
                System.out.println("Sorry, you've hit a wall.");
            }
        } else if (direction.equals("U")){
            if (myMap.canIMoveUp()){
                myMap.moveUp();
                myMap.printMap();
            } else if (myMap.isThereAPit("U")){
                watchPits("U");
                myMap.printMap();
            } else {
                System.out.println("Sorry, you've hit a wall.");
            }
        } else if (direction.equals("D")) {
            if (myMap.canIMoveDown()){
                myMap.moveDown();
                myMap.printMap();
            } else if (myMap.isThereAPit("D")){
                watchPits("D");
                myMap.printMap();
            } else {
                System.out.println("Sorry, you've hit a wall.");
            }
        }
        return direction;
    }
    public static void watchPits(String direction){
        Scanner input = new Scanner(System.in);
        System.out.println("Watch out! There's a pit ahead. Jump it? (yes) ");
        String decision = input.next();
        if (decision.charAt(0) == 'y'){
            myMap.jumpOverPit(direction);
        } else {
            watchPits(direction);
        }
    }
}

