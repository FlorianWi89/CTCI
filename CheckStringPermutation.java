public class CheckStringPermutation {

    /*Check if two strings are permutatins of each other. We assume case sensitiveness and whitespace matters*/

    //Version one: if the strings are permutations of each other, they have the same chars but in 
    //different order -> sort them

    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return sortString(str1).equals(sortString(str2));
    }
    
    //version 2: if the strings are a permutation they must have the same character count

    public static boolean checkCharsCount(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }

        int[] letters = new int[128]; //ASCII
        for(int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for(int j = 0; j < t.length(); j++) {
            letters[t.charAt(j)]--;
            if (letters[t.charAt(j)] < 0) {
                return false;
            }
        }

        return true;
    }
}
