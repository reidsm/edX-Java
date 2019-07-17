import java.util.*;
public class Main {
    public static void main(String args[]) {
        char operation = getOperation();
        //System.out.println(operation);
        String firstFractionString = input();
        String secondFractionString = input();
        Fraction firstFraction = getFraction(firstFractionString);
        Fraction secondFraction = getFraction(secondFractionString);
        if(operation == '+'){
            Fraction newFraction = firstFraction.add(secondFraction);
            System.out.println(newFraction);
        }
        //Fraction newFraction = firstFraction.add(secondFraction);
        //System.out.println(newFraction);
        //System.out.println(firstFraction);
        //System.out.println(secondFraction);
    }

    public static char getOperation(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your operation");
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
            System.out.println("Invalid operation.");
            return getOperation();
        }
    }

    public static String input(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your fraction");
        String userFraction = input.nextLine();
        if (!(validFraction(userFraction))){
            System.out.print("That's not a valid fraction.");
            userFraction = input();
        }return userFraction;
    }

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
        }else if(userFraction.matches(".*[a-zA-Z]+.*")){
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
        }else if(fractionString.matches("[0-9]+")){
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
