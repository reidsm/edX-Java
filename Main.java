import java.util.*;
public class Main {
    public static void main(String args[]){
        Fraction fraction1 = validFraction();
        Fraction fraction2 = validFraction();
        System.out.println(fraction1);
        System.out.println(fraction2);
    }

    public static Fraction validFraction(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your fraction");
        String userFraction = input.nextLine();
        if(userFraction.matches(".*[a-zA-Z]+.*")){
            System.out.print("That's not a valid fraction.");
            validFraction();
        }else if(userFraction.matches("[0-9]+")){
            validIntegerParser(userFraction);
        }else if(userFraction.contains(Character.toString(' '))){
            System.out.print("That's not a valid fraction.");
            validFraction();
        }else if(userFraction.contains(Character.toString('-'))){
            if (userFraction.indexOf('-') == 0 && !(userFraction.substring(1).matches("[0-9]+")) && !(Character.getNumericValue(userFraction.charAt(1)) == 0)){
                validNegativeParser(userFraction);
            } else if(userFraction.substring(1).matches("[0-9]+")){
                validNegativeIntegerParser(userFraction);
            }else if(Character.getNumericValue(userFraction.charAt(1)) == 0){
                return new Fraction();
            } else {
                System.out.println("That is not a valid fraction.");
            }
        }else if(userFraction.isEmpty()){
            return new Fraction();
        } else if(Character.getNumericValue(userFraction.charAt(0)) == 0){
            return new Fraction();
        } else{
                validPositiveParser(userFraction);
        }
        return new Fraction();
    }

    public static Fraction validNegativeParser(String userFraction){
        userFraction = userFraction.substring(1);
        int num = -(Character.getNumericValue(userFraction.charAt(0)));
        int den = Character.getNumericValue(userFraction.charAt(2));
        return new Fraction(num, den);
    }

    public static Fraction validPositiveParser(String userFraction){
        int num = Character.getNumericValue(userFraction.charAt(0));
        int den = Character.getNumericValue(userFraction.charAt(2));
        return new Fraction(num, den);
    }

    public static Fraction validIntegerParser(String userFraction){
        int num = Integer.parseInt(userFraction);
        return new Fraction(num);
    }

    public static Fraction validNegativeIntegerParser(String userFraction){
        userFraction = userFraction.substring(1);
        int num = -(Integer.parseInt(userFraction));
        return new Fraction(num);
    }

}
