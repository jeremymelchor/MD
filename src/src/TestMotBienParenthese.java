import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 10/12/2014.
 */
public class TestMotBienParenthese {

    /**
     * Function to multiply two numbers *
     */
    public long multiply(long x, long y) {
        //recupere la longueur des chiffres
        int size1 = getSize(x);
        int size2 = getSize(y);
        /** Maximum of lengths of number **/
        //cherche le max entre les deux chiffres
        int N = Math.max(size1, size2);
        /** for small values directly multiply **/
        if (N < 10)
            return x * y;
        /** max length divided, rounded up **/
        //Divise N par deux, puis arrondi à +1 digit
        N = (N / 2) + (N % 2);
        /** multiplier **/
        // m = 10^N
        long m = (long) Math.pow(10, N);

        /** compute sub expressions **/
        //on calcule nos 4 variable de karatsuba

        // est l'équivalent de décaler à gauche de m
        long b = x / m;
        // récuperer la partie à droite de m
        long a = x - (b * m);


        // la on fait pareil
        long d = y / m;
        long c = y - (d * N);

        /** compute sub expressions **/
        // a * c
        long z0 = multiply(a, c);
        // (a + b) * (c + d)
        long z1 = multiply(a + b, c + d);
        //( b * d)
        long z2 = multiply(b, d);

        //
        return z0 + ((z1 - z0 - z2) * m) + (z2 * (long) (Math.pow(10, 2 * N)));
    }

    /**
     * Function to calculate length or number of digits in a number *
     */
    public int getSize(long num) {
        int ctr = 0;
        while (num != 0) {
            ctr++;
            num /= 10;
        }
        return ctr;
    }

    /**
     * Main function *
     */
    public static void main(String[] args) {
       /* Scanner scan = new Scanner(System.in);
        System.out.println("Karatsuba Multiplication Algorithm Test\n");
        // Make an object of Karatsuba class //
        TestMotBienParenthese kts = new TestMotBienParenthese();

        // Accept two integers //
        System.out.println("Enter two integer numbers\n");
        long n1 = scan.nextLong();
        long n2 = scan.nextLong();
        // Call function multiply of class Karatsuba //
        long product = kts.multiply(n1, n2);
        System.out.println("\nProduct : "+ product);*/
        //ArrayList<String> out = MotBienParenthese.enumMotsBP(4);
        GrandEntier.multiplyFast();
    }
}
