public class Fraction {

     private int numerator;
     private int denominator;

    public Fraction(int num, int den){
        this.numerator = num;
        this.denominator = den;
        setFractionValues();
    }

    public Fraction(int num){
        this.numerator = num;
        this.denominator = 1;
        setFractionValues();
    }

    public Fraction(){
        this.numerator = 0;
        this.denominator = 1;
        setFractionValues();
    }

    public String toString(){
        String frac = numerator + "/" + denominator;
        return frac;
    }

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

    public Fraction add(Fraction secondFraction){
        int firstConvertedNumerator = this.denominator * secondFraction.numerator;
        int secondConvertedNumerator = this.numerator * secondFraction.denominator;
        int newNumerator = firstConvertedNumerator + secondConvertedNumerator;
        int newDenominator = this.denominator * secondFraction.denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

    public Fraction subtract(Fraction secondFraction){
        int firstConvertedNumerator = this.denominator * secondFraction.numerator;
        int secondConvertedNumerator = this.numerator * secondFraction.denominator;
        int newNumerator = firstConvertedNumerator - secondConvertedNumerator;
        int newDenominator = this.denominator * secondFraction.denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

    public Fraction multiply(Fraction secondFraction){
        int newNumerator = this.numerator * secondFraction.numerator;
        int newDenominator = this.denominator * secondFraction.denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

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

    public double toDouble(){
        double newNumerator = (double)numerator;
        double newDenominator = (double)denominator;
        double newDouble = newNumerator/newDenominator;
        return newDouble;
    }

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

    public Fraction toLowestTerms(){
        int gcd = gcd(this.numerator, this.denominator);
        int newNumerator = numerator/gcd;
        int newDenominator = denominator/gcd;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

    public static int gcd(int firstNumber, int secondNumber){
        if(secondNumber == 0){
            return firstNumber;
        }
        return gcd(secondNumber, firstNumber % secondNumber);
    }

}
