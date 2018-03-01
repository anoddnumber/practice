import java.util.Hashtable;

class Four {

    // Returns true if the given string can be rearranged to be a palindrome
    public boolean isPalindromePermutation(String str) {
        Hashtable<Character, Integer> t = new Hashtable<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (t.get(c) != null) {
                t.put(c, t.get(c) + 1);
            } else {
                t.put(c, 1);
            }
        }

        int numOddCount = 0;
        for (Character c : t.keySet()) {
            if (t.get(c) % 2 == 1) {
                numOddCount++;
            }
        }

        if (str.length() % 2 == 0 ) {
            return numOddCount == 0;
        } else {
            return numOddCount <= 1;
        }
    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.isPalindromePermutation("gigd"));
    }

}
