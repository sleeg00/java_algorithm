package org.example.StudyAlgorithm.Boj_2839;

import java.util.*;

// 14:10
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int ans = 0;
        int dp[] = new int[5001];
        int i = 6;
        dp[0] = -1;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;
        while (i <= N) {
            if (dp[i - 3] != -1) {
                if (dp[i - 5] != -1) {
                    dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
                } else {
                    dp[i] = dp[i - 3] + 1;
                }
            } else if (dp[i - 5] != -1) {
                dp[i] = dp[i - 5] + 1;
            } else {
                dp[i] = -1;
            }
            i++;
        }
        System.out.println(dp[N]);
    }
}
