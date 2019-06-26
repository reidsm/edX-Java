import java.util.*;
public class mazeRunner {
    static Maze myMap = new Maze();
    public static void main(String[] args){
        intro();
        while (!myMap.didIWin()) {
            userMove();
        }
    }
    public static void intro(){
        System.out.println("Welcome to MazeRunner! ");
        System.out.println("Here is your current position! ");
        myMap.printMap();
    }
    public static String userMove(){
        Scanner input = new Scanner(System.in);
        System.out.println("Where would you like to move? (R, L, U, D)");
        String direction = input.next();
        if(direction.equals("R")){
            if (myMap.canIMoveRight()){
                myMap.moveRight();
                myMap.printMap();
            } else {
                System.out.println("Sorry, you've hit a wall.");
            }
        } else if (direction.equals("L")){
            if (myMap.canIMoveLeft()){
                myMap.moveLeft();
                myMap.printMap();
            } else {
                System.out.println("Sorry, you've hit a wall.");
            }
        } else if (direction.equals("U")){
            if (myMap.canIMoveUp()){
                myMap.moveUp();
                myMap.printMap();
            } else {
                System.out.println("Sorry, you've hit a wall.");
            }
        } else if (direction.equals("D")) {
            if (myMap.canIMoveDown()){
                myMap.moveDown();
                myMap.printMap();
            } else {
                System.out.println("Sorry, you've hit a wall.");
            }
        }
        return direction;
    }
}

