package org.example.StudyAlgorithm.Boj_1149;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N + 1][3];
        int dp[][] = new int[N + 1][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < N; i++) {
          dp[i][0] = Math.min(arr[i][0]+dp[i-1][1], arr[i][0]+dp[i-1][2]);
          dp[i][1] = Math.min(arr[i][1]+dp[i-1][0], arr[i][1]+dp[i-1][2]);
          dp[i][2] = Math.min(arr[i][2]+dp[i-1][0], arr[i][2]+dp[i-1][1]);
        }
        int ma= Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            ma = Math.min(dp[N-1][i], ma);
        }
        bw.write(ma+" ");
        bw.flush();
        bw.close();
        br.close();
    }
}
