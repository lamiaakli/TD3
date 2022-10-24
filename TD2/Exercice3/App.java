

import java.util.Set;
import td2.universite.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiPredicate;


public class App {

    Predicate<Etudiant> aNoteEliminatoire = x -> {
        for (int i = 0; i < x.notes().size(); i++) {
            if (x.notes().get(x.notes().keySet()) < 6) {
                return false;
            }
        }
        return true;
    };
    public static void main(String[] args) {
        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");
        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
        Matiere m3 = new Matiere("MAT3");
        UE ue2 = new UE("UE2", Map.of(m3, 1));
        Annee a1 = new Annee(Set.of(ue1, ue2));
        Etudiant e1 = new Etudiant("42001", "Lamia", "Merveille", a1);
        e1.noter(m1, 12.0);
        e1.noter(m2, 14.0);
        e1.noter(m3, 10.0);
        System.out.println(e1);
        Etudiant e2 = new Etudiant("42002", "Damien", "Corse", a1);
        e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("42003", "Alexandre", "Paris", a1);
        e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);
    }
}
