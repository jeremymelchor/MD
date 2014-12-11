import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by Jeremy and Matthieu on 10/12/2014.
 */
public class MotBienParenthese {

    private static String v, u;
    private static ArrayList<String> listeFinale = new ArrayList<String>();

/* public static void enumMotsBP(int n) {
        String constructeur = "("+u+")"+v;
        if (n==0) System.out.println("Aucun mot de longueur 0");
        listeFinale.add(constructeur);

    }*/

    /*
    * @authors: Matthieu | Jeremy
    */
    public static boolean verifMotBP(String mot) {
        if (mot.charAt(0) == ')') {
            System.out.println("Ce mot n'est pas bien parenthésé !\n");
            return false;
        }
        int compteur = 0;

        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == '(') compteur++;
            else if (mot.charAt(i) == ')') compteur--;
        }

        if (compteur == 0) {
            System.out.println("Mot bien parenthésé !\n");
            return true;
        } else {
            System.out.println("Ce mot n'est pas bien parenthésé !\n");
            return false;
        }
    }

    public static void profondeurParenthese(String mot) {
        if (!verifMotBP(mot)) System.exit(0);
        int altitude = 0, max = 0;

        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == '(') altitude++;
            else if (mot.charAt(i) == ')') altitude--;
            if (altitude > max) max = altitude;
        }

        System.out.println("Profondeur de parenthèses : " + max + '\n');
    }

    public static void displayWord(String w) {

        if (verifMotBP(w)) {
            System.out.println("Ce mot n'est pas bien parenthésé !");
            return;
        }

        String dec = "\t";
        String xdec = "";
        int cpt = 0;

        PrintStream p = System.out;
        //for (int i = 0; i < w.length(); i++) {
        //    p.print(w.charAt(i));
        //}
        p.println();

        for (int i = 0; i != w.length(); i++) {
            // p.print(w.charAt(i));
            // p.print("i: "+ i + "cpt : " + cpt);
            if (w.charAt(i) == ')') {

                xdec = repeat(dec, cpt - 1);
                p.print(xdec);
                cpt--;
            } else {

                xdec = repeat(dec, cpt);
                p.print(xdec);
                cpt++;
            }
            p.println(w.charAt(i));

        }
    }

    public static String repeat(String s, int n) {
        //System.out.println(n);
        if (n == 0) return "";
        for (int i = 0; i < n; i++) {
            s += s;
        }
        return s;
    }
}