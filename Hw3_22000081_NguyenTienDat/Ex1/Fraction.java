package Hw3_22000081_NguyenTienDat.Ex1;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        c.normalize();
        this.normalize();
        c.setNumerator(c.numerator*(-1));
        return minus(c);
    }

    public Fraction minus(Fraction c) {
        c.normalize();
        this.normalize();
        float newNumerator, newDenominator = 0;
        if (c.denominator == this.denominator) {
            newNumerator = this.numerator - c.numerator;
            newDenominator = this.denominator;
        } else {
            newNumerator = this.numerator * c.denominator + this.denominator * c.numerator;
            newDenominator = this.denominator * c.denominator;
        }
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    public Fraction multi(Fraction c) {
        float newNumerator = this.numerator * c.numerator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    public Fraction divi(Fraction c) {
        if (c.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by a fraction with zero numerator.");
        }
        float newNumerator = this.numerator * c.denominator;
        float newDenominator = this.denominator * c.numerator;
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    public Fraction normalize() {
        if (denominator < 0) {
            this.denominator = denominator*(-1);
            this.numerator = numerator*(-1);
        }

        float gcd = gcd(denominator, numerator);
        return new Fraction(numerator/gcd,denominator/gcd);
    }

    public float gcd(float a, float b) {
        if (b == 0) {
            return a;
        }
        return gcd(b,a % b);
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public void setNumerator(float numerator) {
        this.numerator = numerator;
        normalize();
    }

    public void setDenominator(float denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.denominator = denominator;
        normalize();
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
