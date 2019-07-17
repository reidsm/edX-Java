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
        int newNumerator = this.numerator + secondFraction.numerator;
        int newDenominator = this.denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

}
