package org.example.SilverRandomDepence.Boj_2206;

import java.util.*;
import java.io.*;

// * 주의 *
// 1. 시작하는 칸, 끝 칸 포함해서 세기
// 2. 1000 * 1000 인데 BFS 하기에는 메모리가 좀 걱정 된다. -> 거리순으로 PQ로 뽑기(최적화)
public class Main {
    static int N, M, ans = Integer.MAX_VALUE;
    static int[][][] visit;
    static int[][] arr, mv = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    private static class Node {
        int x, y, distance, broken;

        Node(int x, int y, int distance, int broken) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = (int) (str.charAt(j) - '0');
            }
        }
        bfs(0, 0, 1, 0);
        if (ans == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(ans);
        }
    }

    private static void bfs(int x, int y, int distance, int broken) {
        ArrayDeque<Node> q = new ArrayDeque<>();

        q.addLast(new Node(x, y, distance, broken));
        while (!q.isEmpty()) {
            Node node = q.pollFirst();

            if (node.x == N - 1 && node.y == M - 1) {
                ans = Math.min(ans, node.distance);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int dx = node.x + mv[i][0];
                int dy = node.y + mv[i][1];
                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }
                if (arr[dx][dy] == 0) {
                    if (node.broken == 0 && visit[dx][dy][0] == 0) {
                        q.addLast(new Node(dx, dy, node.distance + 1, node.broken));
                        visit[dx][dy][0] = 1;
                    } else if (node.broken == 1 && visit[dx][dy][1]==0) {
                        q.addLast(new Node(dx, dy, node.distance + 1, node.broken));
                        visit[dx][dy][1] = 1;
                    }
                } else if (arr[dx][dy] == 1 && node.broken == 0) {
                    q.addLast(new Node(dx, dy, node.distance + 1, node.broken + 1));
                    visit[dx][dy][1] = 1;
                }
            }
        }
    }
}
