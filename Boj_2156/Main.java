package org.example.Boj_2156;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N + 2];
        int dp[] = new int[N + 2];
        for (int i = 1; i <=N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for (int i = 3; i <= N; i++) {
            int first_value = dp[i - 2] + arr[i];
            int second_value = dp[i - 1];
            int third_value = dp[i - 3] + arr[i - 1] + arr[i];
            dp[i] = Math.max(Math.max(first_value, second_value), third_value);
        }
        System.out.println(dp[N]);
    }
}
