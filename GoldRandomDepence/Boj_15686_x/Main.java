package org.example.GoldRandomDepence.Boj_15686_x;

import java.util.*;
import java.io.*;

// 빈 칸, 치킨 집, 집
// r * c, "치킨 거리" : 집과 가장 가까운 치킨집 사이 거리, 도이싀 치킨 거리 = 모든 치킨 거리 합
// |r1-r2| + |c1-c2|
// 2 <= N <= 50
// 1 <= M <= 13
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, ans;
    static int[] visit;
    static int[][] map;
    static ArrayList<Point> home = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        ans = Integer.MAX_VALUE;
        visit = new int[chicken.size()];
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < home.size(); i++) {
                int temp = Integer.MAX_VALUE;

                // 어떤 집과 치킨집 중 open한 치킨집의 모든 거리를 비교한다.
                // 그 중, 최소 거리를 구한다.
                for (int j = 0; j < chicken.size(); j++) {
                    if (visit[j] == 1) {
                        int distance = Math.abs(home.get(i).x - chicken.get(j).x)
                                + Math.abs(home.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            ans = Math.min(ans, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                dfs(i + 1, cnt + 1);
                visit[i] = 0;
            }
        }
    }
}
