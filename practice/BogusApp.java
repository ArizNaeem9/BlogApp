import java.util.ArrayList;
import java.util.List;

public class BogusApp {

    private String name;
    private int count;

    public BogusApp(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public List<String> generateList() {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(name + "_item_" + i);
        }
        return items;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static String repeat(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(reversed);
    }

    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static List<Integer> filterEvens(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        for (int n : numbers) {
            if (n % 2 == 0) evens.add(n);
        }
        return evens;
    }

    public void resetCount() {
        this.count = 0;
    }

    public String summary() {
        return name + " has " + count + " item(s)";
    }

    public static void main(String[] args) {
        BogusApp app = new BogusApp("widget", 5);

        System.out.println("Name: " + app.getName());
        System.out.println("Count: " + app.getCount());
        System.out.println("List: " + app.generateList());
        System.out.println("Summary: " + app.summary());
        System.out.println("3 + 4 = " + add(3, 4));
        System.out.println(repeat("ha", 3));
    }
}
