package arrays_strings;

public class ZeroMatrix {

    /*
        Time complexity O(n^2) - we have to traverse the whole matrix
        Space complexity O(n) - where n is the bigger boolean array
     */


    public static void zeroMatrix(int[][] matrix){
        boolean[] rowIndex = new boolean[matrix.length];
        boolean[] colIndex = new boolean[matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rowIndex[i] = true;
                    colIndex[j] = true;
                }
            }
        }
        for(int i=0;i<rowIndex.length;i++){
            if(rowIndex[i])
                rowsNull(i,matrix);
        }
        for(int i=0;i<colIndex.length;i++){
            if(colIndex[i])
                colsNull(i,matrix);
        }
    }


    private static void colsNull(int index,int[][] matrix){
        for(int i=0;i<matrix.length;i++)
            matrix[i][index] = 0;
    }

    private static void rowsNull(int index,int[][] matrix){
        for(int i = 0;i<matrix[0].length;i++)
            matrix[index][i] = 0;
    }

    public static void main(String[] args){

        int[][] matrix = {
                {1,5,3,1,6},
                {0,5,6,8,9},
                {9,1,2,0,4}
        };
        zeroMatrix(matrix);

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
