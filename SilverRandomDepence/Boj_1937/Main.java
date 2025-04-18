package org.example.SilverRandomDepence.Boj_1937;


import java.util.*;
import java.io.*;

// 대나 먹고 상, 하, 좌, 우 이동
// 대나무 먹고 자리 옮기면 -> 옮긴 자리는 그 전지역보다 대나무가 많이 있어야 함
//
public class Main {
    public static class Node {
        int x, y;
        long hap;

        Node(int x, int y, long hap) {
            this.x = x;
            this.y = y;
            this.hap = hap;
        }
    }

    static int N;
    static long ma = 1, ans = -1;
    static int[][] mv = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static long[][] board, dp;
    ;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, getPanda(i, j));
            }
        }
        System.out.print(ans );
    }


    private static long getPanda(int x, int y) {

        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + mv[i][0];
            int ny = y + mv[i][1];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (board[nx][ny] > board[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], getPanda(nx, ny) + 1);
                }
            }
        }
        return dp[x][y];
    }


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new long[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
