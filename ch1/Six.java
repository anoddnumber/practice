import java.lang.StringBuilder;

class Six {

    public String compress(String str) {
        int count = 1;
        Character currentChar = null;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i + 1 >= str.length() || c != str.charAt(i + 1)) {
                builder.append(c);
                builder.append(count);
                currentChar = c;
                count = 1;
            } else {
                count++;
            }
        }
        return str.length() > builder.length() ? builder.toString() : str;
    }

    public static void main(String[] args) {
        Six six = new Six();
        System.out.println(six.compress("")); // nothing
        System.out.println(six.compress("a")); // a
        System.out.println(six.compress("aaaa")); // a4
        System.out.println(six.compress("aabbccdd")); // aabbccdd
        System.out.println(six.compress("aaabbbcccddd")); // a3b3c3d3
        System.out.println(six.compress("aabcccccaaa")); // a2b1c5a3
    }
}
