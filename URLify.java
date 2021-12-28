

public class URLify {

    //the task ist to replace all whitespace in a string with %20, 
    //we use the approach to start from the end of the string
    //the true length is given

    public static void replaceChars(char[] str, int trueLength) {
        int numberOfSpaces = countOfChar(str, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;

        if (newIndex + 1 < str.length) str[newIndex + 1] = '\0';

        for(int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
            if (str[oldIndex] == ' ') {
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                str[newIndex] = str[oldIndex];
                newIndex -= 1;
            }
        }
    }


    public static int countOfChar(char[] str, int start, int end, int target) {
        int count = 0;
        for(int i = start; i < end; i++) {
            if (str[i] == target) {
                count++;
            }
        }
        return count;
    }
    
}
