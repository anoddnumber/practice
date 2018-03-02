import java.lang.Math;

public class Five {

    public boolean tryReplace(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        if (str1.length() <= 0) {
            return true;
        }

        return str1.substring(1).equals(str2.substring(1));
    }

    public boolean tryDelete(String str1, String str2) {
        if (str1.length() != str2.length() + 1 && str1.length() + 1 != str2.length()) {
            return false;
        }
        
        return str1.substring(1).equals(str2) || str1.equals(str2.substring(1)); 
    }

    public boolean isOneOff(String str1, String str2) {
        if (str1.length() > str2.length() + 1 || str2.length() > str1.length() + 1) {
            return false;
        }

        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 != c2) {
                return tryReplace(str1.substring(i), str2.substring(i)) || tryDelete(str1.substring(i), str2.substring(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(five.isOneOff("a", "b")); // true
        System.out.println(five.isOneOff("pale", "ple")); // true
        System.out.println(five.isOneOff("pales", "pale")); // true
        System.out.println(five.isOneOff("pale", "bale")); // true
        System.out.println(five.isOneOff("pale", "bake")); // false
    }
}
