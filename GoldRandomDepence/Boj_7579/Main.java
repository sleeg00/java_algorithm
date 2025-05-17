package org.example.GoldRandomDepence.Boj_7579;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] memory = new int[N];
        int[] cost = new int[N];
        int maxCostSum = 0;

        for (int i = 0; i < N; i++) {
            memory[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
            maxCostSum += cost[i]; // 전체 비용의 최대합
        }

        int[] dp = new int[maxCostSum + 1]; // dp[c] = 이 비용으로 얻을 수 있는 최대 메모리

        for (int i = 0; i < N; i++) {
            for (int j = maxCostSum; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        // 최소 비용 c 중에서 dp[c] >= M인 것
        for (int c = 0; c <= maxCostSum; c++) {
            if (dp[c] >= M) {
                System.out.println(c);
                return;
            }
        }
    }
}
