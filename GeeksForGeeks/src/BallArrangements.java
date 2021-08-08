import java.util.*;

public class BallArrangements {
    public static void main(String[] args) {
        BallArrangements ba = new BallArrangements();

        System.out.println(ba.CountWays(2, 2, 2)); // 30
        System.out.println(ba.CountWays(1, 1, 1)); // 6
        System.out.println(ba.CountWays(1, 1, 0)); // 2
        System.out.println(ba.CountWays(2, 1, 1)); // 6
    }

    public int CountWays(int p, int q, int r) {
        int[][][][] dp = new int[p + 1][q + 1][r + 1][3];
        
        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= q; j++) {
                for (int k = 0; k <= r; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        return count(dp, p, q, r, 0) + count(dp, p, q, r, 1) + count(dp, p, q, r, 2);
    }

    int count(int[][][][] dp, int p, int q, int r, int last) {
        // Base case
        if (p < 0 || q < 0 || r < 0) {
            return 0;
        }
        if (p == 1 && q == 0 && r == 0 && last == 0) {
            return 1;
        }
        if (p == 0 && q == 1 && r == 0 && last == 1) {
            return 1;
        }
        if (p == 0 && q == 0 && r == 1 && last == 2) {
            return 1;
        }
        if (dp[p][q][r][last] != -1) {
            // System.out.println("wow " + p + " " + q + " " + r + " " + last);
            return dp[p][q][r][last];
        }

        // Other cases
        if (last == 0) {
            dp[p][q][r][last] = count(dp, p - 1, q, r, 1) + count(dp, p - 1, q, r, 2);
        } else if (last == 1) {
            dp[p][q][r][last] = count(dp, p, q - 1, r, 0) + count(dp, p, q - 1, r, 2);
        } else if (last == 2) {
            dp[p][q][r][last] = count(dp, p, q, r - 1, 0) + count(dp, p, q, r - 1, 1);
        }
        // System.out.println("For p = " + p + ", q = " + q + ", r = " + r + " & last:" + last + ", ans = " + dp[p][q][r][last]);
        return dp[p][q][r][last];
    }
}
