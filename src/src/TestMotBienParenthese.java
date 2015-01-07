import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Jeremy and Matthieu on 10/12/2014.
 */
public class TestMotBienParenthese {

    public static void main(String args[]) {

        boolean continu = true;

        while (continu) {
            System.out.println("Que voulez vous utiliser comme méthode ?");
            System.out.println("enumMotsBP()           : 1");
            System.out.println("catalan()              : 2");
            System.out.println("catalan2()             : 3");
            System.out.println("testCatalan2()         : 4");
            System.out.println("verifMotsBP()          : 5");
            System.out.println("displayWord()          : 6");
            System.out.println("profondeurParenthese() : 7");
            System.out.println("quitter                : 8\n");
            try {
                Scanner sc = new Scanner(System.in);
                Scanner a = new Scanner(System.in);

                int word = sc.nextInt();

                switch (word) {
                    case 1:
                        System.out.println("Quelle longueur de demi mot vous voulez ?");
                        MotBienParenthese.enumMotsBP(sc.nextInt());
                        break;
                    case 2:
                        System.out.println("Quelle longueur de demi mot vous voulez ?");
                        System.out.println(MotBienParenthese.catalan(sc.nextInt()));
                        break;
                    case 3:
                        System.out.println("Quelle longueur de demi mot vous voulez ?");
                        System.out.println(MotBienParenthese.catalan2(sc.nextInt()));
                        break;
                    case 4:
                        System.out.println("Quelle longueur de demi mot vous voulez ?");
                        MotBienParenthese.testCatalan2(sc.nextInt());
                        break;
                    case 5:
                        System.out.println("Quel mot voulez-vous tester ?");
                        MotBienParenthese.verifMotBP(a.nextLine());
                        break;
                    case 6:
                        System.out.println("Quel mot voulez-vous tester ?");
                        MotBienParenthese.displayWord(a.nextLine());
                        break;
                    case 7:
                        System.out.println("Quel mot voulez-vous tester ?");
                        MotBienParenthese.profondeurParenthese(a.nextLine());
                        break;
                    case 8:
                        continu = false;
                        break;
                    default:
                        System.out.println("Je n'ai pas compris votre demande");
                        break;
                }
            }
            catch (InputMismatchException e) {
                continu = false;
                System.out.println("Tapez un nombre !");
            }
        }
    }
}
