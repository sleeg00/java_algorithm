package org.example.GoldRandomDepence.Boj_9663;

import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    static int map[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1];
        back(0);
        System.out.println(ans);
    }

    public static void back(int index) {
        if (index == N) {
            ans++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            int sw = 0;
            if (index == 0) {
                map[index] = i;
                back(index + 1);
            } else {
                for (int j = 0; j < index; j++) {
                    if (map[j] == i || Math.abs(map[j] - i) == Math.abs(index - j)) {
                        sw = 1;
                        break;
                    }
                }
                if (sw == 0) {
                    map[index] = i;
                    back(index + 1);
                }
            }
        }
    }
}
