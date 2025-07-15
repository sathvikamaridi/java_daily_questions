import java.util.*;

public class VampireBattle {

    public static int minPowerToBeatDamon(int n, String powers) {
        int[] powerArray = new int[n];
        int totalPower = 0;


        for (int i = 0; i < n; i++) {
            powerArray[i] = powers.charAt(i) - '0';
            totalPower += powerArray[i];
        }

        Arrays.sort(powerArray);
        int stephanPower = 0;
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            stephanPower += powerArray[i];
            count++;
            if (stephanPower > totalPower / 2) {
                break;
            }
        }

        return stephanPower;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        String bloodPowers = scanner.next();

        int result = minPowerToBeatDamon(n, bloodPowers);
        System.out.println(result);

        scanner.close();
    }
}
