package org.example.Boj_1976;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] p;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 1; i <=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int v=1;
            while(st.hasMoreTokens()) {
                int connection = Integer.parseInt(st.nextToken());
                if(connection==1)
                    union(i,v);
                v++;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        HashSet<Integer> set = new HashSet<>();
        while(st.hasMoreTokens()){
            int value = find(Integer.parseInt(st.nextToken()));
            set.add(value);
            if(set.size()>=2) {
                bw.write("NO\n");
                bw.flush();
                return ;
            }
        }
        bw.write("YES\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u==v) return false;
        if(v<u) {
            v = u-v+(u=v);
        }
        if(p[u]==p[v])
            p[u]--;
        p[v]=u;
        return true;
    }
    private static int find(int x) {
        if(p[x]<0) return x;
        return p[x] = find(p[x]);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        p = new int[N + 2];
        Arrays.fill(p, -1);
    }
}
