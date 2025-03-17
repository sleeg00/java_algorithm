package org.example.Boj_23058;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 수수께끼
// 조건 1 : 양면이 0, 1로 이루어진 돌
// 조건 2 : N * N 격자에 0, 1이 차있따
// 조건 3 : 모든 돌을 같은 숫자로 바꾸는데 걸리는 시간은?
// 조건 4 : 각 행동은 1초
//      4-1 : 격자의 가로, 세로를 골라 해당 줄을 전부 1-돌 숫자로 바꾸기
//      4-2 : 돌 1개를 1-돌 숫자로 바꾸기
// 결론 : 모든 돌을 같은 숫자로 바꾸는데 최소 몇 시간을 사용해야 할가?
// 입력
// 입력시 모든 1의 돌 숫자, 0의 돌 숫자 세기
// 방법 1. 1의 돌을 바꿀때
//     2. 1을 찾아 해당 칸의 가로/세로 이어진 것중 가장 큰 것 뒤집기
//     2.1 근데 가장 큰 것 뒤집는게 최선의 수일까? -> 어쩔 수 없다, 시간초과 날것 메모리 초과..

public class Main {
    static int map[][];
    static int map_second[][];
    static int mv[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int N;
    static int first_cnt = 0;
    static int second_cnt = 0;
    public static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        ArrayDeque<Pair> second_queue = new ArrayDeque<>();

        map = new int[N][N];
        map_second = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                map_second[i][j] = value;
                if (value == 0) {
                    first_cnt++;
                    queue.addLast(new Pair(i, j));
                } else {
                    second_cnt++;
                    second_queue.addLast(new Pair(i, j));
                }
            }
        }

        bw.write(Math.min(getColor(queue, map, 1, 0, 0),
                getColor(second_queue, map_second, 0, 0, 0))
                + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int getColor(ArrayDeque<Pair> queue, int[][] map, int status, int ans, int check) {
        while (!queue.isEmpty()) {
            Pair p = queue.pollFirst();
            int x = p.first;
            int y = p.second;
            if(map[x][y]==status) continue;

            int row=0, col=0;

            for(int i=1; i<N; i++) {
                if(x-i>=0 && map[x-i][y]!=status) col++;
                if(x+i<N && map[x+i][y]!=status) col++;
            }

            for(int i=1; i<N; i++) {
                if(y-i>=0 && map[x][y-i]!=status) row++;
                if(y+i<N && map[x][y+i]!=status) row++;
            }

            check=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(status!=map[i][j]) {
                        check++;
                    }
                }
            }
            if(check<=N/2) {
                ans+=check-1;
            }
            if(col>row && col>0) {
                for(int i=0; i<N; i++) {
                    if(map[i][y]==status) queue.addLast(new Pair(i,y));
                    map[i][y] = 1-map[i][y];
                }
            } else if(row>=col && row>0) {
                for(int i=0; i<N; i++) {
                    if(map[x][i]==status) queue.addLast(new Pair(x,i));
                    map[x][i] = 1-map[x][i];
                }
            } else {
                map[x][y] = 1- map[x][y];
            }
            ans++;
        }
        return ans;
    }
}
