/**
 * We are using an interface inheritance to achieve higher order functionality.
 * IntUnaryFunction is implemented by many classes who have apply(int x) method defined uniquely.
 * When different classes with different definition of that same method outlined by the interface,
 * are need to be passed as argument to another method, we simply use the IntUnaryFunction f which
 * can contain any of its subclasses.
 */
public class HoFDemo {
    public static int do_twice(IntUnaryFunction f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        System.out.println(do_twice(new TenX(), 2));
    }
}