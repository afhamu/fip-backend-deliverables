import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkingWithJavaCollectionsFramework {

    public static void main(String[] args) {
        // Create a list of words (states)
        List<String> states = new ArrayList<>();
        states.add("Kano");
        states.add("Kaduna");
        states.add("Katsina");
        states.add("Jigawa");
        states.add("Zamfara");
        states.add("Kebbi");
        states.add("Borno");

        // In this example, we remove "Borno" because it is not part of the Northwestern region
        String target = "Borno";

        // Call the method to remove all occurrences of the target word from the list
        removeWord(states, target);

        System.out.println("Filtered States: " + states);
    }

    public static void removeWord(List<String> words, String target) {
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (word.equals(target)) {
                iterator.remove(); // Remove target word using iterator
            }
        }
    }
}

