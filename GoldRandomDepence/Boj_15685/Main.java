package org.example.GoldRandomDepence.Boj_15685;

import java.util.*;
import java.io.*;

// x, y, d:시작방향, g:세대
// 0 : 오른쪽
// 1 : 위
// 2 : 왼쪽
// 3 : 아래
// (3,3), 0, 1
public class Main {


    private static boolean[][] map = new boolean[101][101];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());
            draw(X, Y, getDir(dir,gen));
        }
        System.out.println(getNumberOfSquare());
    }

    private static int getNumberOfSquare() {
        int cnt = 0;
        for(int x = 0; x<100; x++) {
            for(int y=0; y<100; y++) {
                if(map[x][y] && map[x+1][y] && map[x][y+1] && map[x+1][y+1])
                    cnt++;
            }
        }
        return cnt;
    }

    private static void draw(int x, int y, List<Integer> dir) {
        map[x][y] = true;
        for(int direction : dir) {
            if(direction==0) {
                map[++x][y] = true;
            } else if(direction==1) {
                map[x][--y] = true;
            } else if(direction==2) {
                map[--x][y] = true;
            } else {
                map[x][++y] = true;
            }
        }
    }

    private static List<Integer> getDir(int dir, int gen) {
        List<Integer> directions = new ArrayList<>();
        directions.add(dir);
        while(gen-- > 0) {
            for(int i=directions.size()-1; i>=0; i--) {
                int direction = (directions.get(i)+1)%4;
                directions.add(direction);
            }
        }
        return directions;
    }
}
