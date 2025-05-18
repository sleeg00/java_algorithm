package org.example.GoldRandomDepence.Boj_1949;

import java.util.*;
import java.io.*;
// 우수 마을의 마을 주민 수 총 합 최대
// 우수 마을끼리는 인접 불가
// 우수 마을 선정되지 못한 마을은 적어도 하나의 우수 마을과 인접 해야 함

public class Main {
    static int N;
    static int[] value;
    static ArrayList<Integer>[] list;
    static int[] Dp1, Dp2;

    public static void main(String[] args) throws IOException {
        init();
        dfs(1, 0);
        System.out.println(Math.max(Dp1[1], Dp2[1]));
    }

    public static void dfs(int cur, int par) {
        Dp1[cur] = value[cur];
        Dp2[cur] = 0;
        for (int next : list[cur]) {
            if (par == next) {
                continue;
            }
            dfs(next, cur);
            Dp1[cur] += Dp2[next];
            Dp2[cur] += Math.max(Dp1[next], Dp2[next]);
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        value = new int[N + 1];
        list = new ArrayList[N + 1];
        Dp1 = new int[N + 1];
        Dp2 = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N-1; i++) {
             st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
    }
}
