
public class Sommer {
    public static void main(String[] args) {
        Somme<Integer> sommeInt = (x, y) -> x + y;
        Somme<Double> sommeDouble = (x, y) -> x + y;
        Somme<Long> sommeLong = (x, y) -> x + y;
        Somme<String> sommeString = (x, y) -> x.concat(y);
    }
}
