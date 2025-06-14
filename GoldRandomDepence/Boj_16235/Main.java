package org.example.GoldRandomDepence.Boj_16235;

import java.util.*;
import java.io.*;

// N x N, 모든 칸 5 고정
// M개 나무 구매후 땅에 심음, 한 칸에 여러개 나무 중첩 가능
// 봄
// - 나무 나이만큼 양분 먹고, 나이 1증가
// - 여러개 나무 존재시 어린 나무 부터,
// - 나이보다 양분 부족시 사망
// 여름
// - 봄에 죽은 나무가 양분으로 변함, 죽은 나무 나이/2 만큼 더함
// 가을
// - 나무 번식, 나무는 나이/5일때만, 인접한 8개 칸에 나이가 1인 나무 생성
// 겨울
// - 돌아다니며 양분 추가
// ANS : K년이 지난 후 땅에 살아있는 나무 개수 구하기
public class Main {

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, K, ans;
    static PriorityQueue<Integer>[][] tree;
    static int[][] food, mv = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}, plus;
    static ArrayDeque<Point> treeDivide5 = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 땅 크기
        M = Integer.parseInt(st.nextToken()); // 나무 갯수
        K = Integer.parseInt(st.nextToken()); // 몇 년 지난후 개수 구할지
        tree = new PriorityQueue[N + 1][N + 1];  // 2차원 배열 선언
        food = new int[N + 1][N + 1];
        plus = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tree[i][j] = new PriorityQueue<>((p1, p2) -> {
                    if (p1 < p2) {
                        return -1;
                    }
                    return 1;
                });
                food[i][j] = 5;
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                plus[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= M; i++) { // 나무
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            tree[r][c].add(age);
        }
        for (int i = 0; i < K; i++) { // 몇년이 지난후
            spring();
            autumn();
            winter();
        }
        System.out.println(getTreeCount());
    }

    private static int getTreeCount() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ans += tree[i][j].size();
            }
        }
        return ans;
    }

    private static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                food[i][j] += plus[i][j];
            }
        }
    }

    private static void autumn() {
        while (!treeDivide5.isEmpty()) {
            Point point = treeDivide5.pollFirst();

            for (int i = 0; i < 8; i++) {
                int dx = point.x + mv[i][0];
                int dy = point.y + mv[i][1];
                if (dx <= 0 || dy <= 0 || dx > N || dy > N) {
                    continue;
                }
                tree[dx][dy].add(1); // 번식 성공
            }
        }
    }

    private static void spring() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> {
                    if (p1 < p2) {
                        return -1;
                    }
                    return 1;
                });
                List<Integer> list = new ArrayList<>();
                while (!tree[i][j].isEmpty()) {
                    list.add(tree[i][j].poll());
                }
                int sw = 0;

                for (int idx = 0; idx < list.size(); idx++) {
                    if (list.get(idx) > 0 && food[i][j] >= list.get(idx) && sw == 0) {
                        pq.add(list.get(idx) + 1);
                        if ((list.get(idx) + 1) %5==0 && list.get(idx) + 1 >= 5){ // 번식 나무 찾기
                            treeDivide5.addLast(new Point(i, j));
                        }
                        food[i][j] -= list.get(idx);
                    } else { // 여름 죽은 나무 양분 추가
                        sw = 1;
                        food[i][j] += list.get(idx) / 2;
                    }
                }
                tree[i][j] = pq;
            }
        }
    }
}
