
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App<T> {
    Predicate<Paire<Integer, Double>> tropPetite = p -> p.fst < 100;
    Predicate<Paire<Integer, Double>> tropGrande = p -> p.fst > 200;
    Predicate<Paire<Integer, Double>> tailleIncorrecte = p -> tropPetite.test(p) || tropGrande.test(p);
    Predicate<Paire<Integer, Double>> tailleCorrecte = Predicate.not(tailleIncorrecte);
    Predicate<Paire<Integer, Double>> tropLourd = p -> p.snd > 150.0;
    Predicate<Paire<Integer, Double>> poidsOk = Predicate.not(tropLourd);
    Predicate<Paire<Integer, Double>> accesAutorise = p -> tailleCorrecte.test(p) && poidsOk.test(p);

    // Méthode qui prend une liste de prédicats sur un type T,
    // une liste d’éléments de type T, et qui renvoie la liste des éléments
    // qui vérifient la conjonction des prédicats

    public <T> List<T> filtragePredicatif(List<Predicate<T>> PS, List<T> elmts) {
        List<T> rtn = new ArrayList<>();
        // On récupère les prédicats
        Predicate<T> predicat = x -> true;
        // Boucle
        for (Predicate<T> p : PS) {
            predicat = predicat.and(p);
        }
        for (T e : elmts) {
            if (predicat.test(e)) {
                rtn.add(e);
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        App app = new App<>();

        Paire PoidOk = new Paire(150, 100.0); // taille: 150, poids: 100.0 -> ok
        Paire PoidGrand = new Paire(273, 100.0); // taille: 273, poids: 100.0 -> trop Grand
        Paire PoidFat = new Paire(159, 200.0); // taille: 159, poids: 200.0 -> trop Lourd

        System.out.println(app.accesAutorise.test(PoidOk));
        System.out.println(app.accesAutorise.test(PoidGrand));
        System.out.println(app.accesAutorise.test(PoidFat));

    }
}
