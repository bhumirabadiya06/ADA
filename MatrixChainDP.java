import java.util.*;

public class MatrixChainDP {
    public static int matrixChainOrder(int[] p, int n) {
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                            + p[i - 1] * p[k] * p[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] p = new int[n + 1];

        System.out.println("Enter dimensions array:");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int result = matrixChainOrder(p, n + 1);

        System.out.println("Minimum multiplication cost = " + result);

        sc.close();
    }
}
