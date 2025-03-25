package org.example.Boj_20040;

import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static int p[];
    public static void main(String[] args) throws IOException {
        input();
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            if(!union(v, u)) {
                bw.write(i+1+"\n");
                bw.flush();
                return ;
            }
        }
        bw.write("0\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static boolean union(int u, int v) {
        v = find(v);
        u = find(u);
        if(u==v) return false;
        if(p[v] < p[u]) v = u-v+(u=v);
        if(p[v]==p[u]) p[u]--;
        p[v] = u;
        return true;
    }
    private static int find(int x) {
        if(p[x]<0) return x;
        return p[x] = find(p[x]);
    }
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        Arrays.fill(p, -1);
    }
}
