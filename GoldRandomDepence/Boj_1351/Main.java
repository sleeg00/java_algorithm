package org.example.GoldRandomDepence.Boj_1351;

import java.util.*;
import java.io.*;

// N * N 크기 대나무 숲
// 다 먹으면 상, 하, 좌, 우
// 옮긴 지역에 대나무가 더 많아야 옮긴다
// 최대한 많은 칸 이동시키려면?

public class Main {
    static int N, ma=1;
    static int[][] map, visit, mv = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visit[i][j] == 1) {
                    dfs(i,j);
                }
            }
        }
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                ma = Math.max(ma, visit[i][j]);
            }
        }
        System.out.println(ma);
    }
    public static int dfs(int x, int y) {
        if(visit[x][y]!=1) {
            return visit[x][y];
        }
        for(int i=0; i<4; i++) {
            int dx = mv[i][0] + x;
            int dy = mv[i][1] + y;

            if(dx< 0 || dy<0 || dx>=N || dy>=N) continue;
            if(map[dx][dy] > map[x][y]) {
                dfs(dx,dy);
                visit[x][y] = Math.max(visit[x][y], dfs(dx,dy)+1);
            }
        }
        return visit[x][y];
    }
    public static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                visit[i][j]=1;
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
