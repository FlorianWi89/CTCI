public class ZeroMatrix {

    //write an algo such that if an element in MxN Matrix is 0 its entire row and col are set to 0

    //we could get a second array in which we store all the 0 positions , but we actually dont care 
    //about the exact location so we can instead use two arrays for cols and rows
    //this reduce Space from O(NM) to O(N) Space

    public static void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        //store row and col index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    cols[j] = true;
                }
            }
        }


        //nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) nullifyRow(matrix, i);
        }

        //Nullify colums
        for (int j = 0; j < cols.length; j++) {
            if (cols[j]) nullifyCol(matrix, j);
        }
    }

    public static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void nullifyCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}