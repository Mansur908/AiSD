public class Monom {

    public int coef;
    public int deg;

    public Monom(int coef, int deg) {
        this.coef = coef;
        this.deg = deg;
    }

    public Monom() {
        this(0,0);
    }

    @Override
    public String toString() {
        String a ="";
        if (coef == 0)
            a = "("+0+")";
        if (deg == 0)
            a = "("+coef+")";
        if (coef != 0 & deg != 0)
        a = "("+coef+"*x^"+deg+")";
    return a;
    }
}
