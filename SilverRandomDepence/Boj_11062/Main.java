package org.example.SilverRandomDepence.Boj_11062;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            boolean turn = true;
            if (N % 2 == 0) {
                turn = false;
            }
            int[][] dp = new int[N + 1][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N - j; j++) {
                    int row = j;
                    int col = j + k - 1;
                    if (turn) {
                        dp[row][col] = Math.max(dp[row + 1][col] + arr[row], dp[row][col - 1] + arr[col]);
                    } else {
                        dp[row][col] = Math.min(dp[row + 1][col], dp[row][col - 1]);
                    }
                }
                turn = !turn;
            }
            bw.write(dp[1][N - 1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
