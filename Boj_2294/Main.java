package org.example.Boj_2294;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coin = new int[N + 1];
        int[] Dp = new int[K + 1];
        for (int i = 0; i <= K; i++) {
            Dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Dp[0] = 0;

        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                int cost = coin[j];
                if (i + cost <= K && Dp[i]!=Integer.MAX_VALUE) {
                    Dp[i + cost] = Math.min(Dp[i + cost], Dp[i] + 1);
                }
            }

        }

        if (Dp[K] != Integer.MAX_VALUE) {
            System.out.println(Dp[K]);
        } else {
            System.out.println(-1);
        }
    }
}
