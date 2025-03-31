package org.example.SilverRandomDepence.Boj_12891;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine(), " ");
        int[][] Dp = new int[4][str.length() + 1];
        int[] arr = new int[4];
        char[] alpa = new char[4];
        alpa[0] = 'A';
        alpa[1] = 'C';
        alpa[2] = 'G';
        alpa[3] = 'T';
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == alpa[i]) {
                    if (j == 0) {
                        Dp[i][j] = 1;
                    } else {
                        Dp[i][j] = Dp[i][j - 1] + 1;
                    }
                } else if (j != 0) {
                    Dp[i][j] = Dp[i][j - 1];
                }
            }
        }

        int ans = 0;
        for (int i = M-1; i < str.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                int value = -1;
                if(i-M<0) {
                    value = Dp[j][i];

                } else {
                    value = Dp[j][i]-Dp[j][i-M];
                }
                if (value>= arr[j]) {
                    cnt++;
                } else break;
            }
            if (cnt == 4) {
                ans++;
            }
        }
        System.out.print(ans);
    }
}
