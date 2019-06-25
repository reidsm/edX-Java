import java.util.Scanner;
public class TripPlanner {
    public static void main(String[] args){
        greeting();
        timeBudget();
        timeDiff();
        area();
    }

    public static void greeting(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to vacation planner!");
        System.out.print("What is your name? ");
        String inputName = input.next();
        System.out.print("Nice to meet you " + inputName + ", where are you travelling to? ");
        String destination = input.next();
        System.out.println("Great! " + destination + " sounds like a great trip!");
        System.out.println("**********");
    }

    public static void timeBudget(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        Integer duration = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        Double budget = input.nextDouble();
        System.out.print("What is the currency symbol for your destination? ");
        String currency = input.next();
        System.out.print("How many " + currency + " are there in 1 USD? ");
        Double conversion = input.nextDouble();

        Double dailyBudget = budget/duration;
        Integer formattedBudget = (int)(dailyBudget * 100.0);
        Double correctBudget = (formattedBudget/100.0);

        Double localDailyBudget = (budget*conversion)/duration;
        Integer formattedLocalBudget = (int)(localDailyBudget * 100.0);
        Double correctLocalBudget = (formattedLocalBudget/100.0);

        System.out.println("if you are travelling for " + duration + " days that is " + duration*24 + " hours or " + duration*1440 + " minutes");
        System.out.println("If you are going to spend " + budget + " USD that means per day you can spend up to " + correctBudget + " USD");
        System.out.println("your total budget in " + currency + " is " + budget*conversion + " " + currency + ", which per day is " + correctLocalBudget + " " + currency);
        System.out.println("**********");
    }

    public static void timeDiff(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between hour home and your destination? ");
        Integer timeDiff = input.nextInt();

        Integer localMidnight = timeDiff;
        Integer localNoon = 12 + timeDiff;
        Integer wrappedLocalNoon = localNoon % 24;
        String localMidnightString = localMidnight + ":00";
        String localNoonString = wrappedLocalNoon + ":00";

        System.out.println("That means when it is midnight at home it will be " + localMidnightString + " in your travel destination and when it is noon at home it will be " + localNoonString);
        System.out.println("**********");
    }

    public static void area(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        Integer areaKm = input.nextInt();

        Double milesSq = areaKm/2.59;
        Integer formattedMilesSq = (int)(milesSq * 100.0);
        Double correctMilesSq = (formattedMilesSq/100.0);

        System.out.print("In miles2 that is " + correctMilesSq);
        System.out.println("**********");
    }
}
