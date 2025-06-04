package StringSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KarpRabinAlgo {
    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int prime = 101;
        int baseL = 1;
        int base = 256;
        int count = 0;
        int hashPattern = 0;
        int hashText = 0;

        for (int i = 0; i < m ; i++) {
            baseL = (baseL * base) % prime;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            hashPattern = (base * hashPattern + pattern.charAt(i)) % prime;
            hashText = (base * hashText + text.charAt(i)) % prime;
        }
        map.computeIfAbsent(hashText, k -> new ArrayList<>()).add(0);

        for (int i = 1; i <= n - m; i++) {
            hashText = (hashText * base - text.charAt(i - 1) * baseL + text.charAt(i + m - 1)) % prime;
            if (hashPattern == hashText) {
                for (int index : map.getOrDefault(hashText, new ArrayList<>())) {
                    if (text.substring(index, index + m).equals(pattern)) {
                        count++;
                    }
                }

            }
            map.computeIfAbsent(hashText, k -> new ArrayList<>()).add(i);
        }

        return count;
    }

    public static void main(String[] args) {
        String text = "BANANANA";
        String pattern = "NA";
        int result = search(text, pattern);
        if (result != 1) {
            System.out.println("Number of duplicates found: " + result);
        } else {
            System.out.println("No duplicates found");
        }
    }
}
