import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog("Elyse", 3), new Dog("Sture", 9),
                new Dog("Benjamin", 15)};
        Dog maxDog = (Dog) Maximizer.max(dogs);
        maxDog.bark();

        Comparator<Dog> nc = Dog.getNameComparator();
        Dog d1 = new Dog("Rex", 15);
        Dog d2 = new Dog("Tillerson", 88);
        if (nc.compare(d1, d2) > 0) {
            d1.bark();
        } else {
            d2.bark();
        }
    }
}
