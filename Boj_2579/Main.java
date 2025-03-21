package org.example.Boj_2579;

import java.util.*;
import java.io.*;

// 조건 1 : x+1 or x*2
// 조건 2 : 연속 3계단 불가
// 조건 3 : N계단 무조건 밣아야 함
// -------
public class Main {
    static int arr[];
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 4];
        dp = new int[N + 4];
        for (int i = 0; i <= N + 3; i++) {
            arr[i] = 0;
            dp[i] = 0;
        }
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[1] + arr[2], arr[0] + arr[2]);

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);

        }
        bw.write(dp[N - 1] + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
