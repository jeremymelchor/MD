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
            if(!(numBits <= MAXBITLENGTH)) throw new TooBigNumberException();
        }
        catch (Exception e) { System.out.println("La longueur de votre nombre dépasse la longueur autorisée de 10 000 000"); }

        rnd = new Random();
        bigInt = rnd.nextInt(Math.pow(2,numBits));
    }

    public static int Karatsuba(int n) {

    }
}

class TooBigNumberException extends Exception {
    public TooBigNumberException() {
    }
}
