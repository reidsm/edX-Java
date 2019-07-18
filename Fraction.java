public class Fraction {

     private int numerator;
     private int denominator;

    /*the first constructor for when we provide the constructor two parameters
    it checks the setFractionValues method because the assignment said to, but I'm not sure
    what it really does given the ironclad nature of the validation method in the main class*/

    public Fraction(int num, int den){
        this.numerator = num;
        this.denominator = den;
        setFractionValues();
    }

    /*the constructor for an integer input, sets the denominator to 1 so the math methods don't get weird*/

    public Fraction(int num){
        this.numerator = num;
        this.denominator = 1;
        setFractionValues();
    }

    /*and finally sets the fraction to 0/1 for when the numerator is 0 or there are no parameters*/

    public Fraction(){
        this.numerator = 0;
        this.denominator = 1;
        setFractionValues();
    }

    /*pretty self explanatory, makes the numerator and denominator into a string*/

    public String toString(){
        String frac = numerator + "/" + denominator;
        return frac;
    }

    /*tbh not sure if this is needed but I made it early on because the assignment said to and now I'm afraid to
    touch it lol*/

    public void setFractionValues(){
        if(numerator < 0 && denominator < 0){
            this.numerator = Math.abs(numerator);
            this.denominator = Math.abs(denominator);
        }else if(numerator < 0 || denominator < 0){
            this.numerator = -(Math.abs(numerator));
            this.denominator = Math.abs(denominator);
        }else if (this.denominator == 0){
            throw new IllegalArgumentException("You cannot divide by 0.");
        }
    }

    /*basically goes through the math of adding two fractions, assumes that bases will be different
    * and so it always converts the base no matter what since the toLowestTerms function will auto-reduce the answer anyway*/

    public Fraction add(Fraction secondFraction){
        int firstConvertedNumerator = this.denominator * secondFraction.numerator;
        int secondConvertedNumerator = this.numerator * secondFraction.denominator;
        int newNumerator = firstConvertedNumerator + secondConvertedNumerator;
        int newDenominator = this.denominator * secondFraction.denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

    /*Originally I had this as basically a copy of the addition method but with a '-' instead of the
    * '+'. Then when I tested 1/4 - 1/4 I got -8/16 or something crazy, so I had to add conditional
    logic that worked with the absolute values to get the math to work out. Probably a better way of doing this, could
    have a mistake*/

    public Fraction subtract(Fraction secondFraction){
        int firstConvertedNumerator = Math.abs(this.denominator * secondFraction.numerator);
        int secondConvertedNumerator = Math.abs(this.numerator * secondFraction.denominator);
        int newDenominator = this.denominator * secondFraction.denominator;
        if(this.numerator < 0 && secondFraction.numerator > 0){
            int newNumerator = -(firstConvertedNumerator + secondConvertedNumerator);
            Fraction newFraction = new Fraction(newNumerator, newDenominator);
            return newFraction;
        }else if(secondFraction.numerator < 0 && this.numerator > 0){
            int newNumerator = firstConvertedNumerator + secondConvertedNumerator;
            Fraction newFraction = new Fraction(newNumerator, newDenominator);
            return newFraction;
        }else if((this.numerator < 0) && (secondFraction.numerator < 0)){
            int newNumerator = -(firstConvertedNumerator) + secondConvertedNumerator;
            Fraction newFraction = new Fraction(newNumerator, newDenominator);
            return newFraction;
        }else {
            Fraction newFraction = new Fraction();
            return newFraction;
        }
    }

    public Fraction multiply(Fraction secondFraction){
        int newNumerator = this.numerator * secondFraction.numerator;
        int newDenominator = this.denominator * secondFraction.denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

    /*had to google this to remember how to divide fractions - gotta take the recirpocal! 7th grade me would have been
    disappointed*/

    public Fraction divide(Fraction secondFraction){
        int reciprocalNumerator = secondFraction.denominator;
        int reciprocalDenominator = secondFraction.numerator;
        int newNumerator = this.numerator * reciprocalNumerator;
        int newDenominator = this.denominator * reciprocalDenominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    /*don't try dividing two ints, it gives weird answers. convert the ints to doubles first*/

    public double toDouble(){
        double newNumerator = (double)numerator;
        double newDenominator = (double)denominator;
        double newDouble = newNumerator/newDenominator;
        return newDouble;
    }

    /*Logically this converts two fractions to doubles and checks if they are the same double*/

    public boolean equals(Fraction otherFraction){
        double newNumerator = (double)this.numerator;
        double newDenominator = (double)this.denominator;
        double newDouble = newNumerator/newDenominator;
        double otherNumerator = (double)otherFraction.numerator;
        double otherDenominator = (double)otherFraction.denominator;
        double otherDouble = otherNumerator/otherDenominator;
        if(newDouble == otherDouble){
            return true;
        }return false;
    }

    /*passes numerator and denominator ints to the gcd function to find the gcd, divides both the numerator and the
    denominator by the gcd, and then returns the new, reduced fraction*/

    public Fraction toLowestTerms(){
        int gcd = gcd(this.numerator, this.denominator);
        int newNumerator = numerator/gcd;
        int newDenominator = denominator/gcd;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

    /*honestly I googled this, don't 100% understand how this works*/

    public static int gcd(int firstNumber, int secondNumber){
        if(secondNumber == 0){
            return firstNumber;
        }
        return gcd(secondNumber, firstNumber % secondNumber);
    }

}
