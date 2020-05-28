import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class PolinomTest {

    @Test
    public void toStringTest() throws Exception {
        Polinom a = new Polinom("test.txt");
        String b = "(7*x^6)+(5*x^4)";
        Assert.assertEquals(b, a.toString());
    }

    @Test
    public void insertTest() throws FileNotFoundException {
        Polinom a = new Polinom("test.txt");
        a.insert(3, 2);
        a.insert(1, 0);
        a.insert(12, 11);
        String b = "(12*x^11)+(7*x^6)+(5*x^4)+(3*x^2)+(1)";
        Assert.assertEquals(b, a.toString());
    }

    @Test
    public void combineTest() throws Exception {
        Polinom a = new Polinom("test.txt");
        a.insert(7, 6);
        a.combine();
        String b = "(14*x^6)+(5*x^4)";
        Assert.assertEquals(b, a.toString());
    }

    @Test
    public void deleteTest() throws Exception {
        Polinom a = new Polinom("test.txt");
        a.delete(4);
        String b = "(7*x^6)";
        Assert.assertEquals(b, a.toString());
    }

    @Test
    public void sumTest() throws Exception {
        Polinom a = new Polinom("test.txt");
        Polinom c = new Polinom("test.txt");
        a.sum(c);
        String b = "(14*x^6)+(10*x^4)";
        Assert.assertEquals(b, a.toString());
    }

    @Test
    public void derivateTest() throws Exception {
        Polinom a = new Polinom("test.txt");
        a.derivate();
        String b = "(42*x^5)+(20*x^3)";
        Assert.assertEquals(b, a.toString());
    }

    @Test
    public void valueTest() throws Exception {
        Polinom a = new Polinom("test.txt");
        int b = 12;
        int c = a.value(1);
        Assert.assertEquals(b,c);
    }

    @Test
    public void deleteOddTest() throws Exception {
        Polinom a = new Polinom("test.txt");
        a.insert(4,3);
        a.deleteOdd();
        String b = "(4*x^3)";
        Assert.assertEquals(b, a.toString());
    }
}