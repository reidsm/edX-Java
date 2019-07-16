import java.util.*;
public class Battleship {

    /*There are three necessary global variables I need to make the logic of my system work:
    The game board, the number of player ships, and the number of computer ships
    I wanted to try to keep all of the data on the same board since that works best in my own head
    but that may have caused some logical problems down the line that I didn't consider. let me know
    if I missed something*/

    public static int [][] board = new int[10][10];
    public static int numPlayerShips = 5;
    public static int numComputerShips = 5;

    /*The main class calls other methods. First it creates the board. Then it promts the player to deploy their ships.
    Then it prints the board again with the player ships showing. Then it deploys the computer ships, and finally
    starts the battle.
    The battle logic works like this:
    Continue while both players have ships
    Player takes a turn
    Computer takes a turn
    [...]
    If one of them runs out of ships end the game and display the winner*/

    public static void main(String[] args) {
    createBoard();
    playerShips();
    createBoard();
    computerShips();
    createBoard();
    battle();
    }

    /*This function creates the board. It is talking to the first of the global variables up there ^^
    I had a lot of trouble with this part until I watched the help video that the microsoft intern made for us */

    public static void createBoard(){
        System.out.println("  123456789"); //print the column numbers
        for(int r = 0; r < board.length; r++){
            System.out.print(r + "|"); //this prints the row number and pipe symbol before each row (outer for loop)
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == 0){
                    System.out.print(" ");
                }else if (board[r][c] == 1){ //1 corresponds to "there is a player ship here"
                    System.out.print("@");
                }else if (board[r][c] == 5){ //5 corresponds to "the wreck of one of our own ships rests here"
                    System.out.print("!");
                }else if (board[r][c] == 6){ //6 corresponds to "the wreck of a computer ship lies here"
                    System.out.print("x");
                }else if (board[r][c] == 7){ //7 corresponds to "the player guessed this cell"
                    System.out.print("-");
                }else if (board[r][c] == 8){ //8 corresponds to "the computer guessed this cell"
                    System.out.print(" ");
                }else if (board[r][c] == 9){ //9 corresponds to "the player and computer both guessed this cell"
                    System.out.print("-");
                }else if (board[r][c] == 2){ //2 corresponds to "there is a computer ship here"
                    System.out.print(" ");
                    //System.out.print(board[r][c]);
                }
            }
            System.out.println("|" + r); //the corresponding ending row number and pipe symbol, outside the inner for loop and inside the outer for loop
        }
        System.out.println("  123456789"); //bottom column numbers
    }

    /*calls the function to place a player ship 5 times, I separated these functions because I wanted to use recursion and this is the best way I could think of but there might be a better one*/

    public static void playerShips(){
        System.out.println();
        System.out.println("Admiral, where should we deploy our ships?");
        for(int i = 0; i < 5; i++){
            placeShip(i); //passes i so the player can see which ship they are placing
        }
    }

    /*gathers coordinates for the player to place a ship*/

    public static void placeShip(int i){
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter X coordinate for your " + (i+1) + " ship: ");
        int x = input.nextInt();
        System.out.print("Enter Y coordinate for your " + (i+1) + " ship: ");
        int y = input.nextInt();
        if (x <= 10 && y <= 10 && board[x][y] == 0){ //all of these booleans must be true to place a ship (within bounds and empty cell)
            board[x][y] = 1;
        }else{
            System.out.println("You already have a ship there, choose different coordinates. Make sure each coordinate is less than 10.");
            placeShip(i); //recursion - if the player tried to break the rules, restart this ship placement
        }
    }

    /*deploys 5 computer ships*/

    public static void computerShips(){
        System.out.println();
        System.out.println("The computer is deploying its ships. Prepare for battle!");
        System.out.println();
        for(int i = 0; i < 5; i++){
            placeComputerShip(i);
        }
        System.out.println();
    }

    /*same logic as player ships but instead of a scanner it uses this Random object-looking thing I found on google*/

    public static void placeComputerShip(int i){
        Random rand = new Random();
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        if (board[x][y] == 0){
            board[x][y] = 2;
            System.out.println("ship " + (i+1) + " deployed");
        }else{
            System.out.println("Enemy ship failed to deploy and is returning to base to try again!");
            placeComputerShip(i);
        }
    }

    /*now the fun part, uses a while loop to keep exchanging turns until one player runs out of ships
    talks to global variables up there ^^ before the main method*/

    public static void battle(){
        while (numPlayerShips > 0 && numComputerShips > 0){
            playerTurn();
            computerTurn();
            createBoard();
            System.out.println("Player ships: " + numPlayerShips + " | Computer ships: " + numComputerShips);
            if(numPlayerShips == 0){
                System.out.println("You lost the battle. Retreat!");
                System.exit(0);
            }else if(numComputerShips == 0){
                System.out.println();
                System.out.println("You've won the battle, admiral!");
                System.exit(0);
            }
        }
    }

    /*takes in a set of coordinates using a scanner and decides what to change the cell to (assuming the entered coordinate is valid)
    Logically, if the player lands on "8" which corresponds to a computer guess it will change the 8 to a 7 so the "-" appears
    There is a logical loose end that this creates that we will fix in the computer turn :)*/

    public static void playerTurn(){
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter X coordinate of target: ");
        int x = input.nextInt();
        System.out.print("Enter Y coordinate of target: ");
        int y = input.nextInt();
        if (x <= 10 && y <= 10 && board[x][y] == 1){ //makes sure that the input is within bounds
            board[x][y] = 5;
            System.out.println("You sunk your own ship. You fool!");
            System.out.println();
            numPlayerShips = numPlayerShips - 1; //remember that if you just use numPlayerShips - 1 the global variable won't store the new value so be careful
        } else if (x <= 10 && y <= 10 && board[x][y] == 2){
            board[x][y] = 6;
            System.out.println("Boom! You sunk an enemy ship!");
            System.out.println();
            numComputerShips = numComputerShips - 1;
        } else if (x <= 10 && y <= 10 && (board[x][y] == 0 || board[x][y] == 8)){ //very tricky line because of boolean logic order of operations, to make sense it has to be (true AND true AND (true/false OR true/false))
            board[x][y] = 7;
            System.out.println("You missed.");
            System.out.println();
        }else if (x <= 10 && y <= 10){
            board[x][y] = 7;
            System.out.println("You missed.");
            System.out.println();
        }else{ //basically this will happen if the player inputs coordinates that are out of bounds
            System.out.println("That's outside of the battlefield, choose coordinates of less than 10 each.");
            playerTurn(); //recursion to start the player's turn over if they provide invalid coordinates
        }
    }

    /*and finally the computer's turn. very similar to the player's turn except we have a problem because we want the player's guess to always display "-" (a 7 in the cell)
    even if the computer guesses it (which would be an 8). so my solution was, if the computer guesses a 7, to change the cell to a 9 which also diplays a "-" and will prompt
    the computer to restart its turn if it guesses a cell with a 9 in it. I might have left some logical holes here so if I did go ahead and leave a comment
    and obviously try and fix it :)*/

    public static void computerTurn(){
        Random rand = new Random();
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        if (board[x][y] == 2){
            board[x][y] = 6;
            numComputerShips = numComputerShips - 1;
            System.out.println("The computer sank its own ship. Idiot.");
            System.out.println();
        }else if(board[x][y] == 1){
            board[x][y] = 5;
            numPlayerShips = numPlayerShips - 1;
            System.out.println("The computer sank one of your ships!");
            System.out.println();
        }else if(board[x][y] == 0){
            board[x][y] = 8;
            System.out.println("The computer missed.");
            System.out.println();
        }else if(board[x][y] == 7){
            board[x][y] = 9;
            System.out.println("The computer missed");
            System.out.println();
        }else{
            computerTurn(); //recursion so the computer turn restarts if it guesses a previously guessed coordinate (the cell contains 8 or 9)
        }
    }
}