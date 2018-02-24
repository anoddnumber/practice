import java.util.Arrays;
import java.util.Hashtable;
import java.util.HashSet;
import java.util.Arrays;

public class One {

    public boolean containsUniqueCharactersHashTable(String str) {
        Hashtable<Character, Integer> t = new Hashtable<>();
        for (char c : str.toCharArray()) {
            if (t.get(c) != null) {
                return false;
            }
            t.put(c, 0);
        }
        return true;
    }

    public boolean containsUniqueCharactersSet(String str) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public boolean containsUniqueCharactersNoDataStructure(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        One one = new One();
        System.out.println("hash table: " + one.containsUniqueCharactersHashTable("abac"));
        System.out.println("set: " + one.containsUniqueCharactersSet("abc"));
        System.out.println("no data structure: " + one.containsUniqueCharactersNoDataStructure("sake"));
    }
}
