
//check if a string has only unique chars,
//1st version: with additional Space
//O(N) Time and O(1) Space

public class UniqueChars {

    public static boolean checkUniqueChars(String str) {

        if (str.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {
                return false;
            } 
            charSet[val] = true;
        }
        return true;
    }

    //this version reduces the space usage by factor of eight

    public static boolean checkUniqueChars2(String str) {
        int checker = 0;
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    //solution without extra space
    //sort the string and check for neighss

}