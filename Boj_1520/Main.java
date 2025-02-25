package org.example.Boj_1520;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] mv = { {0, 1}, {0, -1},{-1, 0}, {1, 0}};
    static int[][] visit ;
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                visit[i][j]=-1;
                map[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
       bw.write(dfs(0,0) +" ");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dfs(int x, int y) {
        if(x==N-1 && y==M-1) return 1;
        if(visit[x][y]==-1) {
            visit[x][y]=0;
            for (int i = 0; i < 4; i++) {
                int dx = x + mv[i][0];
                int dy = y + mv[i][1];
                if (dx < 0 || dy < 0 || dx >= N || dy >= M) continue;
                if (map[dx][dy] < map[x][y]) {
                    visit[x][y] += dfs(dx, dy);
                }
            }
        }
        return visit[x][y];
    }
}
