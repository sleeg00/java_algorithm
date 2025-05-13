package org.example.StudyAlgorithm.Boj_15683;

import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int visit[][];
    static int map[][];
    static List<int[][]> mv = new ArrayList<>();
    static int mi = -1;

    static ArrayList<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        visit = new int[N][M];
        init();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    visit[i][j] = 1;
                    list.add(new Node(i, j));
                } else if (map[i][j] == 6) {
                    visit[i][j] = 1;
                    cnt++;
                }
            }
        }
        back(0, 0);
        bw.write(N * M - (mi + list.size() + cnt) + " ");
        bw.flush();
        br.close();
        bw.close();
    }

    static void back(int idx, int ans) {
        if (idx == list.size()) {

            mi = Math.max(ans, mi);
            return;
        }

        Node node = list.get(idx);

        int cctv = map[node.x][node.y];
        int[][] move = mv.get(cctv);

        for (int i = 0; i < 4; i++) {
            int hap = 0;
            int[][] visitBackup = new int[N][M];
            for (int x = 0; x < N; x++) {
                visitBackup[x] = visit[x].clone(); // 배열 복사
            }
            for (int j = 0; j < move.length; j++) {

                    move[j][0] += 1;
                    move[j][1] += 1;
                    if (move[j][0] > 1) { // 1,0 -> 2,1 -> 0,-1
                        move[j][0] = 0;
                        move[j][1] = -1;
                    } else if (move[j][1] > 1) { // 0,1 -> 1, 2 -> 1,0
                        move[j][0] = 1;
                        move[j][1] = 0;
                    } else if (move[j][1] == 0) { // 0,-1 -> 1,0 -> -1,0
                        move[j][0] = -1;
                        move[j][1] = 0;
                    }

                for (int cnt = 1; ; cnt++) {
                    int dx = node.x + cnt * move[j][0];
                    int dy = node.y + cnt * move[j][1];
                    if (dx < 0 || dy < 0 || dx >= N || dy >= M || map[dx][dy] == 6) {
                        break;
                    }
                    if (visit[dx][dy] == 1) {
                        continue;
                    }
                    visit[dx][dy] = 1;
                    hap++;
                }
            }
            back(idx + 1, ans + hap);
            visit = visitBackup;
        }

    }

    static void init() {
        mv.add(new int[][]{{}});
        mv.add(new int[][]{{0, 1}});
        mv.add(new int[][]{{0, 1}, {0, -1}});
        mv.add(new int[][]{{0, 1}, {-1, 0}});
        mv.add(new int[][]{{0, 1}, {-1, 0}, {0, -1}});
        mv.add(new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}});

    }
}