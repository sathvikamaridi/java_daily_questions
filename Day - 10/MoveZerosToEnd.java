import java.util.Arrays;

public class MoveZerosToEnd {

    
    public static void moveZeros(int[] arr) {
        int nonZeroIndex = 0;

  
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
        }


        while (nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
    }


    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 12};

        System.out.println("Before: " + Arrays.toString(input));
        moveZeros(input);
        System.out.println("After : " + Arrays.toString(input));
    }
}
