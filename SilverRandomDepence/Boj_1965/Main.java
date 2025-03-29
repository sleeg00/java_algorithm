package org.example.SilverRandomDepence.Boj_1965;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] Dp = new int[N + 1];
        int ma = -1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            Dp[i]=1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    Dp[i] = Math.max(Dp[j] + 1, Dp[i]);
                }
            }
            ma = Math.max(ma, Dp[i]);
        }

        bw.write(ma + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
