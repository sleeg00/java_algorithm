package org.example.review.Boj_16235;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static ArrayList<Point> tree_divide_5 = new ArrayList<>();
    static int[][] food, plus_food, mv = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    static PriorityQueue<Integer>[][] tree;
    public static class Point {
        int x, y;
        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 맵 크기
        M = Integer.parseInt(st.nextToken()); // 나무 개수
        K = Integer.parseInt(st.nextToken()); // 몇 년
        food = new int[N + 1][N + 1];
        plus_food = new int[N + 1][N + 1];
        tree = new PriorityQueue[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tree[i][j] = new PriorityQueue<>((p1, p2) -> {
                    if (p1 < p2) return -1;
                    return 1;
                });
                food[i][j] = 5;
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++)plus_food[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            tree[r][c].add(age);
        }

        for(int i=1; i<=K; i++) {
            spring();
            autumn();
            winter();
        }
        System.out.print(getTreeCount());
    }

    private static int getTreeCount() {
        int ans = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++)ans += tree[i][j].size();
        }
        return ans;
    }

    private static void winter() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) food[i][j]+=plus_food[i][j];
        }
    }

    private static void autumn() {

       for(Point point : tree_divide_5) {
           for(int i=0; i<8; i++) {
               int dx = point.x + mv[i][0];
               int dy = point.y + mv[i][1];
               if(dx<=0 || dy<=0 || dx>N || dy>N) continue;
               tree[dx][dy].add(1);
           }
       }
       tree_divide_5.clear();
    }

    private static void spring() {
        ArrayDeque<Integer> dead = new ArrayDeque<>();
        ArrayDeque<Integer> growth = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                while(!tree[i][j].isEmpty()) {
                    int age = tree[i][j].poll();
                    if(age<=food[i][j]) {
                        food[i][j] -= age;
                        growth.addLast(age+1);
                        if((age+1)%5==0 && age+1>=5) tree_divide_5.add(new Point(i,j));
                    }
                    else dead.addLast(age);
                }
                while(!growth.isEmpty()) {
                    tree[i][j].add(growth.pollFirst());
                }
                while(!dead.isEmpty()) {
                    food[i][j] += dead.pollFirst()/2;
                }
            }
        }
    }
}
