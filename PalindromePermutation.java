public class PalindromePermutation {

    //solution one: count chars and check if any has odd count, takes O(N) time where N is the length of the string

    //count occurences of char c
    public static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    //map each char to a number
    public static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue('c');

        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    //check that no char has odd count
    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;

        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    //final function to check for permutation palindrome
    public static boolean isPermutationOfPalindrome(String s) {
        int[] table = buildCharFrequencyTable(s);
        return checkMaxOneOdd(table);
    }
    


    //better solution (slightly). we can check for odd count while we go through the string
    public static boolean approach2(String s) {
        int oddCount = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : s.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }
            }
        }
        return oddCount <= 1;
    }

    //another interesting approach: bitvector, O(N)

    //toggle the ith bit in the integer
     static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        bitVector ^= mask;
        return bitVector;
    }

    //create bitVector for string. for each letter with value i, toggle ith bit
    static int createBitVector(String s) {
        int bitVector = 0;
        for (char c : s.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }


}
