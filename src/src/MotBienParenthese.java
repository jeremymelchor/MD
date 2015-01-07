import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by Jeremy and Matthieu on 10/12/2014.
 */
public class MotBienParenthese {

    private static String v, u;
    private static ArrayList<String> listeFinale = new ArrayList<String>();
    private static int Nfinal;

    /**
     * Question 1 Affiche tous les mots bien parenthésés de longueur 2n
     *
     * @param n la moitié de la longueur voulue
     * @return une ArrayList contenant tous les mots bien parenthésés de
     * longueur <= 2n
     */
    public static ArrayList<String> enumMotsBP(int n) {

        if (Thread.currentThread().getStackTrace()[2].getMethodName().equals("main")) {
            Nfinal = n;
        }

        if (n == 0) {
            listeFinale.add("");
            return listeFinale;
        } else {

            listeFinale = enumMotsBP(n - 1);
            for (int i = 0; i < listeFinale.size(); i++) {
                for (int j = 0; j < listeFinale.size(); j++) {
                    if (listeFinale.get(i).length() + listeFinale.get(j).length() + 2 == 2 * n) {
                        listeFinale.add("(" + listeFinale.get(i) + ")" + listeFinale.get(j));
                        if (listeFinale.get(listeFinale.size() - 1).length() == 2 * Nfinal) {
                            System.out.println(listeFinale.get(listeFinale.size() - 1));
                        }
                    }

                }
            }
            return listeFinale;
        }
    }

    /**
     * Question 3 Calcule le nombre de Catalan récursivement
     *
     * @param n La moitié de la longueur du mot choisi
     * @return Le nombre de mots bien parenthésés de longueur 2n
     */
    public static int catalan(int n) {
        int c = 0;
        if (n == 0) return 1;
        else {
            for (int i = 0; i < n; i++) c += catalan(i) * catalan(n - i - 1);
        }

        return c;
    }

    /**
     * Question 5 Calcule le nombre de Catalan itérativement
     *
     * @param n la moitié de la longueur voulue
     * @return le nombre de mots bien parenthésés de longueur 2n
     */
    public static long catalan2(int n) {

        long stockage[] = new long[n + 1];
        long res = 0;
        stockage[0] = 1;
        stockage[1] = 1;

        for (int i = 2; i <= n; i++) {
            res = 0;
            for (int j = 0; j < i; j++) res += (stockage[j] * stockage[i - 1 - j]);
            stockage[i] = res;
        }

        return stockage[n];
    }

    /**
     * Question 6 Compare le temps d'execution entre catalan1 et catalan2
     *
     * @param n la moitié de la longueur voulue
     */
    public static void testCatalan2(int n) {
        long catalani;
        long t0, t1;
        long temps1, temps2;
        for (int i = 10; i <= n; i++) {
            t0 = System.currentTimeMillis();
            catalani = catalan(i);
            temps1 = System.currentTimeMillis() - t0;

            t1 = System.currentTimeMillis();
            catalani = catalan2(i);
            temps2 = System.currentTimeMillis() - t1;

            System.out.println("Temps de calcul du " + i + "ème nombre de Catalan :   récursif : " + temps1 + "   itératif : " + temps2);
        }
    }


    /**
     * Question 7 Vérifie si un mot est bien parenthésé
     *
     * @param mot
     *          mot à tester
     * @return
     *          Vrai si le mot est bien parenthésé, faux sinon
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

    /**
     * Question 8 Affiche les parenthèses d'un mot avec une bonne indentation
     *
     * @param w mot à tester
     */
    public static void displayWord(String w) {

        if (!verifMotBP(w)) {
            System.out.println("Ce mot n'est pas bien parenthésé !");
            return;
        }

        String dec = "\t";
        String xdec = "";
        int cpt = 0;
        PrintStream p = System.out;
        p.println();

        for (int i = 0; i != w.length(); i++) {
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

    /**
     * Ajoute n espaces dans s pour afficher la bonne indentation
     *
     * @param s
     *         chaîne remplie d'espaces
     * @param n
     *         nombre de fois qu'on va augmenter la profondeur de s
     * @return
     *
     */
    public static String repeat(String s, int n) {

        if (n == 0) return "";
        for (int i = 0; i < n; i++) s += s;

        return s;
    }

    /**
     * Question 9 Affiche la profondeur de parenthèse d'un mot
     *
     * @param mot Mot à tester
     */
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
}
