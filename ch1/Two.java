import java.util.Arrays;
import java.util.Hashtable;

public class Two {
    
    String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    boolean isPalindromeSort(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return sort(s1).equals(sort(s2));
    }

    void addCharactersToHashtable(Hashtable<Character, Integer> table, String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (table.get(c) == null) {
                table.put(c, 1);
            } else {
                table.put(c, table.get(c) + 1);
            }
        }
    }

    boolean isPalindromeHashtable(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        Hashtable<Character, Integer> t1 = new Hashtable<>();
        Hashtable<Character, Integer> t2 = new Hashtable<>();

        addCharactersToHashtable(t1, s1);
        addCharactersToHashtable(t2, s2);
        
        return t1.equals(t2);
    }

    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two.isPalindromeSort("abc", "cba")); // true
        System.out.println(two.isPalindromeSort("abcd", "cba")); // false
        System.out.println(two.isPalindromeHashtable("abc", "cba")); // true
        System.out.println(two.isPalindromeHashtable("abcd", "cba")); // false
    }
}
