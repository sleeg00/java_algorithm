package org.example.SilverRandomDepence.Boj_17135;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D;
    static int[][] map;
    static int[][] copyMap;
    static int ans;
    static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init(br);

        ans = 0;
        comb(1, new ArrayList<>());

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        copyMap = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = map[i][j];
            }
        }
    }

    public static void rollBack() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }

    public static int distance(int r1, int r2, int c1, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    // 조합
    public static void comb(int start, ArrayList<Integer> archer) {
        if (archer.size() == 3) {
            rollBack();
            attack(archer);
            return;
        }

        for (int i = start; i <= M; i++) {
            archer.add(i);
            comb(i + 1, archer);
            archer.remove(archer.size() - 1);
        }
    }


    public static void attack(ArrayList<Integer> archer) {
        int res = 0;
        for (int top = 1; top <= N; top++) {
           shotArrow(archer, res);
        }
    }

    private static void shotArrow(ArrayList<Integer> archer, int res) {
        visited = new boolean[N + 1][M + 1];
        for (int k = 0; k < 3; k++) {
            getMinShot(archer.get(k));
        }
        res = isCanAttack(res);
        changeMap();
        ans = Math.max(ans, res);
    }

    private static void getMinShot(int archer_x) {
        int minD = Integer.MAX_VALUE; // 최소 거리
        int minR = Integer.MAX_VALUE; // 최소 거리의 y좌표
        int minC = Integer.MAX_VALUE; // 최소 거리의 x좌표

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) { // 적이 있을 경우
                    if (minD >= distance(i, N + 1, j, archer_x)) {
                        if (minD > distance(i, N + 1, j, archer_x)) {
                            minD = distance(i, N + 1, j, archer_x);
                            minR = i;
                            minC = j;
                        } else {
                            if (minC > j) {
                                minR = i;
                                minC = j;
                            }
                        }
                    }
                }
            }
        }

        if (minD <= D) {
            visited[minR][minC] = true;
        }
    }

    private static int isCanAttack(int res) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j]) {
                    map[i][j] = 0;
                    res++;
                }
            }
        }
        return res;
    }

    private static void changeMap() {
        for (int i = 1; i <= M; i++) {
            map[N][i] = 0;
        }

        for (int i = N; i >= 1; i--) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = map[i - 1][j];
            }
        }
    }
}
