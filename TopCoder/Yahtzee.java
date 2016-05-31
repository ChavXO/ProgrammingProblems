import java.util.Random;
import java.util.Arrays;

public class Yahtzee {

    // strategy: sort and then iterate through
    public static void main(String[] args) {
        int[] dice = new int[5];
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int roll = Math.round(rand.nextInt(6) + 1);
            dice[i] = roll;
        }
        System.out.println(Arrays.toString(dice));
        int highest = yahtzee(dice);
        System.out.println(highest);
    }

    private static int yahtzee(int[] dice) {
        Arrays.sort(dice);
        System.out.println(Arrays.toString(dice));
        int highest = 0;
        int prev = dice[0];
        int currentTotal = prev;
        for (int i = 1; i < dice.length; i++) {
            currentTotal = (dice[i] == prev) ? currentTotal + dice[i]: dice[i]; 
            highest = currentTotal > highest ? currentTotal : highest;
            prev = dice[i];
        }
        return highest;
    }
}