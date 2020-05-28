import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polinom {
    LinkedList<Monom> a = new LinkedList<Monom>();

    public Polinom(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        String l = sc.nextLine();
        String[] t = l.split(" ");
        for (int j = 0; j < t.length; j = j + 2) {
            Monom m = new Monom();
            m.coef = Integer.parseInt(t[j]);
            m.deg = Integer.parseInt(t[j + 1]);
            a.add(m);
        }
    }

    public String toString() {
        String d = "";
        for (int i = 0; i < a.size() - 1; i++) {
            d += a.get(i) + "+";
        }
        return "" + d + a.get(a.size() - 1);
    }

    public void insert(int coef, int deg) {
        Monom k = new Monom(coef, deg);
        Monom d = new Monom();
        if ((d = (Monom)a.get(0)).deg <= deg)
            a.add(0,k);
        if ( a.size() == 0) {
            a.add(k);
        } else {
            for (int j = a.size()-1; j >= 0; j--) {
                  d = (Monom) a.get(j);
                  if (deg < d.deg) {
                      a.add(j + 1, k);
                      break;
                  }
            }
            Monom f = (Monom) a.get(a.size()-1);
            if (f.deg > deg)
                a.add(k);
            }
        }

    public void combine() {
        int t = a.size();
        Monom d = new Monom();
        Monom v = new Monom();
        for (int i = 0; i < t - 1; i++) {
            d = (Monom) a.get(i);
            for (int j = i + 1; j < t; j++) {
                v = (Monom) a.get(j);
                if (d.deg == v.deg) {
                    d.coef += v.coef;
                    a.remove(j);
                    t--;
                    j--;
                }
            }
        }
    }

    public void delete(int deg) {
        for (int i = 0; i < a.size(); i++) {
            Monom d = new Monom();
            d = (Monom) a.get(i);
            if (d.deg == deg) {
                a.remove(i);
                break;
            }
        }
    }

    public void sum(Polinom p) {
        Monom k = new Monom();
        for (int i = 0; i < p.a.size(); i++) {
            k = (Monom) p.a.get(i);
            insert(k.coef,k.deg);
        }
        combine();
    }

    public void derivate() {
        Monom d = new Monom();
        for (int i = 0; i < a.size(); i++) {
            d = (Monom) a.get(i);
            if (d.deg == 0) {
                a.remove(i);
                i--;
            }
            d.coef *= d.deg;
            d.deg--;
        }
    }

    public int value(int x) {
        int result = 0;
        Monom m = (Monom) a.get(0);
        int maxDeg = m.deg;
        int [] s = new int[maxDeg+1];
        for (int i = 0; i < a.size(); i++) {
            Monom b = (Monom) a.get(i);
            s[b.deg] = b.coef;
        }
        result = m.coef;
        for (int i = maxDeg; i > 0; i--) {  // метод Горнера
            result = (x*result) +s[i-1];
        }
        return result;
    }

    public void deleteOdd()  {
        int t = a.size();
        for (int i = 0; i < t; i++) {
            Monom d = new Monom();
            d = (Monom) a.get(i);
            if ((d.coef % 2) != 0) {
                a.remove(i);
                i--;
                t--;
            }
            if (a.size() == 0){
                throw new ArrayIndexOutOfBoundsException("no elements in List");
            }
        }
        }



    public static void main(String[] args) throws FileNotFoundException {
        Polinom g = new Polinom("file.txt");
        Polinom p = new Polinom("file1.txt");
        System.out.println("Полином : "+g.toString());
          g.insert(7,6);
          System.out.println("Вставка монома : "+g);
          g.combine();
          System.out.println("Приведение подобных членов : "+g);
          g.delete(1);
          System.out.println("Удаление элемента по степени : "+g);
          g.sum(p);
          System.out.println("Сумма с полиномом "+p.toString()+" = "+g);
          g.derivate();
          System.out.println("Производная полинома : "+g);
          System.out.println("Значение полинома в точке : "+g.value(1));
          g.deleteOdd();
          System.out.println("Удаление мономов с нечетными коэффициентами : "+g);
    }
}