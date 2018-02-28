public class Three {

    public void moveRight(char[] chars, int index) {
        for (int i = chars.length - 1; i > index + 2; i--) {
            chars[i] = chars[i - 2];
        }
    }
    
    public String replaceSpaces(String str, int trueLen) {
        char[] chars = str.toCharArray();
        for (int i = trueLen; i >= 0; i--) {
            char c = chars[i];
            if (c == ' ') {
                moveRight(chars, i);
                chars[i] = '%';
                chars[i + 1] = '2';
                chars[i + 2] = '0';
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.replaceSpaces("a b xxxx", 4));
    }
}
