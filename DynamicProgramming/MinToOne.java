import static java.lang.Math.*;
public class MinToOne {
    int[] memo;
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Not enough arguments.");
            return;
        }
        int n = Integer.parseInt(args[0]);
        memo = new int[n + 1];
        for (int i = 0; i < n; i++) memo[i] = -1;
        int minSteps = minToOne(n);
        System.out.println(minSteps);
    }

    public static int minToOne(int n) {
        if (n == 1) return 0;

        if (memo[n] == -1) return memo[n];

        int r = 1 + minToOne(n - 1);

        if (n % 2 == 0) r = min(r, 1 + minToOne(n / 2));
        if (n % 3 == 0) r = min(r, 1 + minToOne(n / 3));
        memo[n] = r;
        return r;
    }
}