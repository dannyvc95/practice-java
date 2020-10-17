/**
 * Solution for the two dimensional array spiral traversal problem using the 
 * boundaries approach to traverse the outside perimeter first and then update
 * the boundaries to the inner perimeter.
 * 
 * @author Daniel Valle
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    /**
     * Returns a integers list with the numbers of array in the order that
     * where traversed.
     * @param array a two dimensional array of integers
     * @return a list of integers in spiral traversal order
     */
    public static List<Integer> spiralTraverse(int[][] array) {
        var result = new ArrayList<Integer>();
        
        int startRow = 0;
        int endRow = array.length-1;
        int startCol = 0;
        int endCol = array[0].length-1;

        // stop traversing the array when start boundaries be greater or equal
        // than end boundaries
        while (startRow <= endRow && startCol <= endCol) {
            for (int col=startCol; col<=endCol; col++) {
                result.add(array[startRow][col]);
            }

            for (int row=startRow+1; row<=endRow; row++) {
                result.add(array[row][endCol]);
            }

            for (int col=endCol-1; col>=startCol; col--) {
                if (startRow == endRow) {
                    break;
                }
                result.add(array[endRow][col]);
            }

            for (int row=endRow-1; row>=startRow+1; row--) {
                if (startCol == endCol) {
                    break;
                }
                result.add(array[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[][] {
            {1,   2,  3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10,  9,  8, 7}
        };
        System.out.println(spiralTraverse(array).toString());
    }
}