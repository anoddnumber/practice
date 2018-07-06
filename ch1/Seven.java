import java.util.Arrays;

// You can rotate a matrix 90 degrees to the right by swapping every row with its column, then reversing it. However, this will require n x n memory (where n is the length of the matrix)
// Another way, shown here, is to rotate the numbers one at a time, layer by layer.
class Seven {
    
    public static void rotate(int[][] matrix) {
        // the number of layers we actually need to swap is length / 2
        // since if the length is odd, the last layer in the middle will always be a single square/pixel
        // that pixel, when rotated, will still be itself
        int numLayers = matrix.length / 2;

        for (int i = 0; i < numLayers; i++) {
            int beginningPixel = i;
            int lastPixel = matrix.length - i - 1;
            // don't swap the last pixel because it was already swapped as the first pixel of another row
            for (int j = beginningPixel; j < lastPixel; j++) {
                int top = matrix[i][j];
                // left -> top
                matrix[i][j] = matrix[matrix.length - j - 1][i];

                // bottom -> left
                matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j - 1];

                // right -> bottom
                matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];

                // top -> right
                matrix[j][matrix.length - i - 1] = top;
            }
        }
    }



    public static void main(String[] args) {
        int matrixLength = 4;
        int[][] myMatrix = new int[matrixLength][matrixLength];

        int num = 0;
        for (int i = 0; i < myMatrix.length; i++) {
            for (int j = 0; j < myMatrix.length; j++) {
                myMatrix[i][j] = num;
                num++;
            }
        }

        System.out.println("myMatrix: " + Arrays.deepToString(myMatrix));
        rotate(myMatrix);
        System.out.println("after swap: " + Arrays.deepToString(myMatrix));


    }

}
