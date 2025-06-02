package org.example.GoldRandomDepence.Boj_1987;

import java.util.*;
import java.io.*;

public class Main {
    static int N,M,ans=1;
    static char[][] map;
    static int[][]mv = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        HashSet<Character> set = new HashSet<>();
        set.add(map[0][0]);
        back(0,0,1, set);
        System.out.println(ans);
    }
    public static void back(int x, int y, int cnt, HashSet<Character> set) {
        ans = Math.max(ans, cnt);
        for(int i=0; i<4; i++) {
            int dx = x + mv[i][0];
            int dy = y + mv[i][1];
            if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
            if(!set.contains(map[dx][dy])) {
                set.add(map[dx][dy]);
                back(dx,dy,cnt+1, set);
                set.remove(map[dx][dy]);
            }
        }
    }
}
