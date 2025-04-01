package org.example.SilverRandomDepence.Boj_16953;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        back(N, 0);
        if (ans == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(ans + 1);
        }
    }

    private static void back(long value, int cnt) {
        if (value >= M) {
            if (value == M) {
                ans = Math.min(cnt, ans);
            }
            return;
        } else {
            back(value * 2, cnt + 1);
            back(value * 10 + 1, cnt + 1);
        }
    }
}
