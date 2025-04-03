package org.example.SilverRandomDepence.Boj_10942;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] Dp = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (Math.abs(i - j) > 1) {
                    if(arr[i] == arr[j] && Dp[i+1][j-1]==1) {
                        Dp[i][j] = 1;
                    }
                } else {
                    if(arr[i] == arr[j]) Dp[i][j] = 1;
                }
            }
        }
        int question = Integer.parseInt(br.readLine());
        for(int i=0; i<question; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(Dp[x-1][y-1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
