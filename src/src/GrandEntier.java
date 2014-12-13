import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 11/12/2014.
 */
public class GrandEntier {

    public static final int B = 10;
    public static final int MAXBITLENGTH = 10000000;
    public static ArrayList<Integer> listeChiffres = new ArrayList<Integer>();

    public GrandEntier(int numBits, Random rnd) throws TooBigNumberException {

        try {
            if (!(numBits <= MAXBITLENGTH)) throw new TooBigNumberException();
        } catch (Exception e) {
            System.out.println("La longueur de votre nombre dépasse la longueur autorisée de 10 000 000");
        }

        rnd = new Random();
        //bigInt = rnd.nextInt(Math.pow(2,numBits));
    }

    public GrandEntier(ArrayList<Integer> ge) {

    }
    public static int getSize(long num) {
        int ctr = 0;
        while (num != 0) {
            ctr++;
            num /= 10;
        }
        return ctr;
    }

    public static GrandEntier multiplyFast(/*GrandEntier ge*/) {
        long x = 385;
        long y = 123;

        int N = (int) Math.max(getSize(x),getSize(y));

        N = N / 2 + N % 2;
        int m = (int) Math.pow(B, N);

        long b = x / m;
        long a = x - (b * m);

        long d = y / m;
        long c = y - (d * m);

        long z0 = a * c;
        long z1 = (a + b) * (c + d);
        long z2 = b * d;

        long result = (long) ( z0 + ((z1 - z0 - z2) * m) + (z2 * Math.pow(B, 2 * N)));

        System.out.println("result ! " +result);

        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean compareTo(GrandEntier e) {

        return false;
    }

    public static int lenght() {

        return 0;
    }

    public static GrandEntier shiftLeft(int n) {

        return null;
    }

    public static GrandEntier add(GrandEntier ge) {
        return null;
    }

    public static GrandEntier multiply(GrandEntier ge) {
        return null;
    }
}

class TooBigNumberException extends Exception {
    public TooBigNumberException() {
    }
}
