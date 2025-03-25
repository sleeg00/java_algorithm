package org.example.Boj_18116;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int p[];
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        input();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if(st.nextToken().equals("I")) {
                int v = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                union(v,u);
            } else {
                int value = find(Integer.parseInt(st.nextToken()));
                if(!map.containsKey(value)) bw.write("1\n");
                else bw.write(map.get(value)+"\n");
            }
        }
        print();
    }

    private static void print() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean union(int v, int u) {
        v = find(v);
        u = find(u);
        if(v==u) return false;
        if(p[v] < p[u]) v = u-v+(u=v);
        if(p[v]==p[u]) p[u]--;
        p[v] = u;
        if(!map.containsKey(u)) {
            map.put(u, 1);
        }
        if(map.containsKey(v)) {
            map.put(u, map.get(u)+map.get(v));
        } else {
            map.put(u, map.get(u)+1);
        }
        return true;
    }
    private static int find(int x) {
        if(p[x] < 0) return x;
        return p[x] = find(p[x]);
    }
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        p = new int[1000005];
        Arrays.fill(p, -1);
    }
}
