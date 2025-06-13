package org.example.GoldRandomDepence.Boj_15685_2;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[][] map = new boolean[102][102];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());

            writeDragon(x,y,getDir(dir, gen));
        }
        System.out.println(getDotOfSquare());
    }

    private static void writeDragon(int x, int y, List<Integer> dir) {
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

    private static int getDotOfSquare() {
        int ans = 0;
        for(int i=0; i<=100; i++) {
            for(int j=0; j<=100; j++) {
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) ans++;
            }
        }
        return ans;
    }

    private static List<Integer> getDir(int dir, int gen) {
        List<Integer> directions = new ArrayList<>();
        directions.add(dir);
        while (gen-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int direction = (directions.get(i)+1)%4;
                directions.add(direction);
            }
        }
        return directions;
    }
}
