package ss4;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant() {
        return b*b - 4*a*c;
    }
    public double getRoot1() {
        if (getDiscriminant() < 0)
            return Double.NEGATIVE_INFINITY;
        else
            return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }
    public double getRoot2() {
        if (getDiscriminant() < 0)
            return Double.NEGATIVE_INFINITY;
        else
            return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }
}

