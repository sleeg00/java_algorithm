package org.example.Boj_9663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, cnt = 0;
    static int[] visit;
    static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visit = new int[N + 1];
        col = new int[N + 1];

        back(1);
        bw.write(cnt + " ");
        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int idx) {

        if (idx == N + 1) {
            cnt++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            boolean sw = true;
            for (int j = 1; j < idx; j++) {
                if (Math.abs(i - col[j]) == Math.abs(idx - j) || col[j] == i) {
                    sw = false;
                    break;
                }
            }
            if (sw) {
                col[idx]=i;
                back(idx + 1);
            }
        }
    }
}
