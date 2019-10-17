package arrays_strings;

public class MatrixRotation {
    /*
        We will start by preforming circular rotation of the outer top,right,bottom,left layer
        then we will repeat the process on the inside layers

        Time complexity O(n^2) - we have to go through the matrix
        Space complexity O(1) - constant space, we aren't using any extra space
     */


    public static void rotate(int[][] matrix){
        int n = matrix.length;

        for(int i=0;i<n/2;i++){
            int first = i;
            int last = n-i-1;
            for(int j=first;j<last;j++){
                int offset = j-first;

                // top left value
                int top = matrix[first][j];
                //top left value swapped with bottom left value
                matrix[first][j] = matrix[last-offset][first];
                //bottom left value swapped with bottom right value
                matrix[last-offset][first] = matrix[last][last-offset];
                //bottom right value swapped with top left value
                matrix[last][last-offset] = matrix[j][last];

                matrix[j][last] = top;
            }
        }
    }



    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        rotate(matrix);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


    }
}
