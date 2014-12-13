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
        //bigInt = rnd.nextInt(Math.pow(2,numBits));
    }

    public GrandEntier(ArrayList<Integer> ge){

    }

    public static GrandEntier multiplyFast(GrandEntier ge){

    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean compareTo(GrandEntier e){

    }

    public static int lenght(){

    }

    public static GrandEntier shiftLeft(int n){

    }

    public static GrandEntier add(GrandEntier ge){

    }

    public static multiply(GrandEntier ge){

    }
}

class TooBigNumberException extends Exception {
    public TooBigNumberException() {
    }
}
