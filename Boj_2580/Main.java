package org.example.Boj_2580;

import static java.lang.System.exit;

import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int first() {
        return this.first;
    }

    public int second() {
        return this.second;
    }

}

public class Main {
    static int map[][] = new int[11][11];
    static int N = 0;
    static List<Pair> list = new ArrayList<>();
    static int visit[] = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    list.add(new Pair(i, j));
                    N++;
                }
            }
        }

        dfs(0, 0);
    }

    public static void dfs(int index, int cnt) {

        List<Integer> list_visit = new ArrayList<>();

        if (cnt == N) {
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            exit(0);
        } else {
            int x = list.get(index).first;
            int y = list.get(index).second;
            for (int i = 1; i <= 9; i++) {
                visit[i] = 0;
            }
            for (int i = 1; i <= 9; i++) {
                visit[map[x][i]] = 1;
                visit[map[i][y]] = 1;
            }
            int st = 0;
            int ed = 0;
            if (x <= 3) {
                st = 1;
            } else if (x > 3 && x <= 6) {
                st = 4;
            } else {
                st = 7;
            }
            if (y <= 3) {
                ed = 1;
            } else if (y > 3 && y <= 6) {
                ed = 4;
            } else {
                ed = 7;
            }
            for (int i = st; i <= st + 2; i++) {
                for (int j = ed; j <= ed + 2; j++) {
                    visit[map[i][j]] = 1;
                }
            }
            for (int i = 1; i <= 9; i++) {
                if (visit[i] == 0) {
                    list_visit.add(i);
                }
            }
            if (list_visit.size() > 0) {
                for (int i = 0; i < list_visit.size(); i++) {
                    map[x][y] = list_visit.get(i);
                    dfs(index + 1, cnt + 1);
                    map[x][y] = 0;
                }
            }
        }
    }
}
