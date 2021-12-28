public class StringCompression {

    //compress a string by counting the chars: e.g aaabbc becomes a3b2c1 (bad example)

    //naive version: count consecutive and use stringBuilder

    public static String compressString(String str) {
        StringBuilder compressed = new StringBuilder();
        int consecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            consecutive++;

            //if next char is different than current append it to result
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(consecutive);
                consecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    //this solution first builds the compressed string and then returnn the shorter one
    //you can check in advance

    public static String compress1(String s) {
        int finalLength = countCompression(s);
        if (finalLength >= s.length()) return s;

        StringBuilder compressed = new StringBuilder(finalLength);

        int countConsecutive = 0;
        for (int i = 0; i < s.length(); i++) {
            countConsecutive++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressed.append(s.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }

        }
        return compressed.toString();
    }

    static int countCompression(String s) {
        int compressedLen = 0;
        int countConsecutive = 0;
        for(int i = 0; i < s.length(); i++) {
            countConsecutive++;

            //if next char is different to current increase the lenght
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressedLen += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLen;
    }
    
}
