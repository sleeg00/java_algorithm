package org.example.GoldRandomDepence.Boj_1197;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Node> list;
    static long ans, cnt;
    static int[] p;

    public static class Node {
        int x, y;
        long value;

        Node(int x, int y, long value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        p = new int[100_001];

        for (int i = 0; i < 100_001; i++)p[i] = -1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            list.add(new Node(x, y, value));
        }

        list.sort(Comparator.comparingLong(n -> n.value));


        for (int i = 0; i < M; i++) {
            if (!is_diff_group(list.get(i).x, list.get(i).y)) continue;
            ans += list.get(i).value;
            cnt++;
            if (cnt == N - 1) break;
        }
        System.out.println(ans);
    }

    private static boolean is_diff_group(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) return false;
        if (p[u] == p[v]) p[u]--;
        if (p[u] < p[v]) p[v] = u;
        else p[u] = v;
        return true;
    }

    private static int find(int x) {
        if (p[x] < 0) return x;
        return p[x] = find(p[x]);
    }
}
