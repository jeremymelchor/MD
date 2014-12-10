import java.util.ArrayList;

/**
 * Created by user on 10/12/2014.
 */
public class MotBienParenthese {

    private static String v, u;
    private static ArrayList<String> listeFinale = new ArrayList<String>();

/* public static void enumMotsBP(int n) {
        String constructeur = "("+u+")"+v;
        if (n==0) System.out.println("Aucun mot de longueur 0");
        listeFinale.add(constructeur);

    }*/

    public static String verifMotBP(String mot) {
        if (mot.charAt(0) == ')') return "Ce mot n'est pas bien parenthésé !";
        int compteur = 0;
        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == '(') compteur++;
            else if(mot.charAt(i) == ')') compteur--;
        }
        if (compteur == 0) return "Mot bien parenthésé !";
        else return "Ce mot n'est pas bien parenthésé !";
    }
}