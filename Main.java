import java.util.*;
public class Main {

    /*The main class on the client side asks for the operation by calling the getOperation method,
    then gathers two strings that are meant to be fractions by calling the input method (which itself then
    calls the validation method). Then it passes only valid strings to the fraction converter function,
    and finally calls fraction-specific methods depending on the type of input stored in the operation variable*/

    public static void main(String args[]) {
        char operation = getOperation();
        String firstFractionString = input();
        String secondFractionString = input();
        Fraction firstFraction = getFraction(firstFractionString);
        Fraction secondFraction = getFraction(secondFractionString);
        if(operation == '+'){
            Fraction newFraction = firstFraction.add(secondFraction);
            System.out.println(newFraction.toLowestTerms());
        }else if(operation == '-'){
            Fraction newFraction = firstFraction.subtract(secondFraction);
            System.out.println(newFraction.toLowestTerms());
        }else if(operation == '*'){
            Fraction newFraction = firstFraction.multiply(secondFraction);
            System.out.println(newFraction.toLowestTerms());
        }else if(operation == '/'){
            Fraction newFraction = firstFraction.divide(secondFraction);
            System.out.println(newFraction.toLowestTerms());
        }else if (operation == '='){
            System.out.println(firstFraction.equals(secondFraction));
        }else if (operation == 'q' || operation == 'Q'){
            System.out.println("Goodbye");
            System.exit(0);
        }
    }

    /*Not too hard here, we know it has to be one of 7 characters so if it doesn't
    match one then we call the method again to start over and print a little "try again"
    message*/

    public static char getOperation(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your operation: ");
        String operation = input.next();
        if(operation.equals(Character.toString('+'))){
            return '+';
        }else if(operation.equals(Character.toString('-'))){
            return '-';
        }else if(operation.equals(Character.toString('*'))){
            return '*';
        }else if(operation.equals(Character.toString('/'))){
            return '/';
        }else if(operation.equals(Character.toString('='))){
            return '=';
        }else if(operation.equals(Character.toString('q'))){
            return 'q';
        }else if(operation.equals(Character.toString('Q'))){
            return 'Q';
        }else{
            System.out.println("Invalid operation. ");
            return getOperation();
        }
    }

    /*This one is harder because the fraction string has many, many more valid inputs than
   the operation method. So it calls the validFunction method for the boolean and basically
   if the fraction string is not valid then the input method prints little "try again" method
   and then uses recursion to re-prompt the user for a valid string*/

    public static String input(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your fraction: ");
        String userFraction = input.nextLine();
        if (!(validFraction(userFraction))){
            System.out.print("That's not a valid fraction. ");
            userFraction = input();
        }return userFraction;
    }

    /*I found this to be the second most challenging part of the program. In fact, this is not perfect and is
    incomplete but I need to move on now. Basically this method checks to see if the fraction provided is in the
    'a/b' format by looking for the character '/'. If so, it makes sure that the denominator is not 0.
    The method then makes sure there are no letters using a regex, and then starts making sure there's no other
    misc. punctuation (though I didn't include all of it because I had to restart this two times and enough is enough)*/

    public static boolean validFraction(String userFraction){
        if(userFraction.contains(Character.toString('/'))){
            String[] fract = userFraction.split("/");
            int num = Integer.parseInt(fract[0]);
            int den = Integer.parseInt(fract[1]);
            if(den==0){
                return false;
            }else if(den < 0){
                return false;
            }
        }else if(userFraction.matches(".*[a-zA-Z]+.*")){//regex: "if this contains one or more letters then return true, and thus return a false condition for being a valid string"
            return false;
        }else if(userFraction.contains(Character.toString(' '))){
            return false;
        }else if (userFraction.contains(Character.toString('.'))){
            return false;
        }else if (userFraction.contains(Character.toString('?'))){
            return false;
        }else if (userFraction.contains(Character.toString('!'))){
            return false;
        }else if (userFraction.contains(Character.toString('$'))){
            return false;
        }return true;
    }

    /*The hardest part of the program. Here I learned that you can indeed have more than one return statement in
    a function as long as you don't try to refactor longer bits of code outside of the function and every single if/else
    clause has a return statement. I also had to start this over many times due to misunderstandings about domains and
    such (num and den not showing up outside of conditional and loop statements)

    Logically, it first checks to see basically if the fraction is not an integer (do you have a '/' in you?) If so,
    it checks to see if the numerator is 0, and if it is, it makes the fraction 0/1 by calling the parameterless constructor
    which I'll get into later. Otherwise, it uses the regular constructor since we know from the validFraction method that the
    denominator will not be 0.

    It took me a few attempts before I figured out how to use the fractionString.split and then parse strings to int. Before this I
    tried manipulating strings in really convoluted ways that got in each others way and it was a mess.

     If the string doesn't have a '/' in it we can pretty safely assume that this is an integer by this point. If it starts with a '-' it's
     a negative integer, so I made some more use of the Integer.parseInt method again.

     There is a high chance that this has a mistake in it somewhere, but again, time to move on.*/

    public static Fraction getFraction(String fractionString){
        if(fractionString.contains(Character.toString('/'))){
            String[] fract = fractionString.split("/");
            int num = Integer.parseInt(fract[0]);
            int den = Integer.parseInt(fract[1]);
            if (num == 0){
                Fraction newFraction = new Fraction();
                return newFraction;
            }else {
                Fraction newFraction = new Fraction(num, den);
                return newFraction;
            }
        }else if(fractionString.matches("[0-9]+")){ //If you contain at least one number and nothing else then return true (*I THINK, could be wrong so be careful)
            int num = Integer.parseInt(fractionString);
            Fraction newFraction = new Fraction(num);
            return newFraction;
        }else if((fractionString.indexOf('-') == 0) && (fractionString.substring(1).matches("[0-9]+"))){
            int num = -(Integer.parseInt(fractionString.substring(1)));
            Fraction newFraction = new Fraction(num);
            return newFraction;
        }else{
            Fraction newFraction = new Fraction();
            return newFraction;
        }
    }
}
