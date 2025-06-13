package org.example.GoldRandomDepence.Boj_15686_2;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, min = Integer.MAX_VALUE;
    static boolean[] visit = new boolean[100];
    static List<Node> home = new ArrayList<>(), chicken = new ArrayList<>();

    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    home.add(new Node(i, j));
                } else if (value == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        dfs(0,0);
        System.out.println(min);
    }

    private static void dfs(int cnt, int idx) {
        if (cnt == M) {
            int ans = 0;
            for (int i = 0; i < home.size(); i++) {
                int value = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visit[j]) {
                        value = Math.min(value,Math.abs(home.get(i).x - chicken.get(j).x) +
                                Math.abs(home.get(i).y - chicken.get(j).y));
                    }
                }
                ans += value;
            }
            min = Math.min(ans, min);
            return;
        }
        for (int i = idx; i < chicken.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(cnt + 1, i+1);
                visit[i] = false;
            }
        }
    }
}
