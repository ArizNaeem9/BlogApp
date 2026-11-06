import java.util.ArrayList;
import java.util.List;

public class BogusCode2 {

    public static List<String> makeLabels(String prefix, int amount) {
        List<String> labels = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            labels.add(prefix + "-" + i);
        }
        return labels;
    }

    public static String shout(String message) {
        return message.toUpperCase() + "!";
    }

    public static void main(String[] args) {
        System.out.println(makeLabels("sample", 3));
        System.out.println(shout("bogus code is running"));
    }
}
