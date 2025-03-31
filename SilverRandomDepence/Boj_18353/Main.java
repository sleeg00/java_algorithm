package org.example.SilverRandomDepence.Boj_18353;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        long[] Dp = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Dp[0] = 0;
        long ma = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    Dp[i] = Math.max(Dp[i], Dp[j]+1);
                }
            }
            ma = Math.max(Dp[i], ma);
        }

        System.out.println(N-ma-1);
    }
}
