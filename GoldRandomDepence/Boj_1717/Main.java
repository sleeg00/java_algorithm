package org.example.GoldRandomDepence.Boj_1717;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            p[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int condition = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (condition == 1) {
                if (find(x) == find(y)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                union(x, y);
            }
        }
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        if (x < y) {
            p[y] = x;
        } else {
            p[x] = y;
        }
        return true;
    }

    public static int find(int x) {
        if (p[x] == -1) {
            return x;
        }
        return p[x] = find(p[x]);
    }
}
