package org.example.SilverRandomDepence.Boj_2688;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] Dp = new long[1002][10];
        long im = 0, hap = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 10; i++) {
            Dp[0][i] = 1;
            im += Dp[0][i];
        }
        for (int i = 1; i <= 1000; i++) {
            hap = im;
            im = 0;
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    Dp[i][j] = hap;
                } else {
                    Dp[i][j] = Dp[i][j - 1] - Dp[i - 1][j - 1];
                }
                im += Dp[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(Dp[Integer.parseInt(br.readLine())][0] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
