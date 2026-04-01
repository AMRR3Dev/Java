public class MatrixAddition {
    
    
 public static void main(String[] args) {

        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrixB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int[][] result = addMatrices(matrixA, matrixB);

        System.out.println("Resulting Matrix:");
        printMatrix(result);
    }

    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {

        int rows = matrixA.length;
        int cols = matrixA[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

}
