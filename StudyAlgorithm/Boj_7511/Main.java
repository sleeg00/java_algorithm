package org.example.StudyAlgorithm.Boj_7511;

import java.io.*;
import java.util.*;

// 1 <= N(유저 수) <= 1,000,000
// 1 <= K(친구 관계 수) <= 100,000
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] p;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        p = new int[1000002];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < p.length; j++) p[j] = -1;
            bw.write("Scenario "+ String.valueOf(i+1)+":\n");
            int K = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                union(u, v);
            }
            M = Integer.parseInt(br.readLine());
            for(int j=0; j<M; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                u = find(u);
                v = find(v);
                if(u==v) bw.write("1\n");
                else bw.write("0\n");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int x) {
        if (p[x] < 0) {
            return x;
        }
        return find(p[x]);
    }

    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return false;
        }
        if (v < u) {
            v = u - v + (u = v);
        }
        if (p[v] == p[u]) {
            p[u]--;
        }
        p[v] = u;
        return false;
    }
}
