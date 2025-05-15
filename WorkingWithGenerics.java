import java.util.*;

public class WorkingWithGenerics {
    public static void main(String[] args) {
        // Example for odd integers
        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int oddCount = ElementCounter.countIf(numbers, new OddPredicate());
        System.out.println("Number of odd integers = " + oddCount);

        // Example for prime numbers
        int primeCount = ElementCounter.countIf(numbers, new PrimePredicate());
        System.out.println("Number of prime numbers = " + primeCount);

        // Example for palindromes
        Collection<String> words = Arrays.asList("radar", "hello", "level", "world", "madam");
        int palindromeCount = ElementCounter.countIf(words, new PalindromePredicate());
        System.out.println("Number of palindromes = " + palindromeCount);
    }
}

// Generic counter class with a more descriptive name
class ElementCounter {
    public static <T> int countIf(Collection<T> c, UnaryPredicate<T> p) {
        int count = 0;
        for (T elem : c)
            if (p.test(elem))
                ++count;
        return count;
    }
}

// Predicate interface
interface UnaryPredicate<T> {
    boolean test(T obj);
}

// Implementation for odd integers
class OddPredicate implements UnaryPredicate<Integer> {
    public boolean test(Integer i) {
        return i % 2 != 0;
    }
}

// Implementation for prime numbers
class PrimePredicate implements UnaryPredicate<Integer> {
    public boolean test(Integer n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

// Implementation for palindromes
class PalindromePredicate implements UnaryPredicate<String> {
    public boolean test(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
