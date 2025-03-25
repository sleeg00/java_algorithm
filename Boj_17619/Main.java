package org.example.Boj_17619;

import java.util.*;
import java.io.*;
// 1 <= N(통나무 개수) <= 100,000
// 1 <= Q(질문 개수) <= 100,000
public class Main {
    public static class Node{
        int x, y,idx;
        Node(int x, int y,int idx) {
            this.x=x;
            this.y=y;
            this.idx =idx;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static int p[];
    static Node arr[];
    static HashMap<Integer, Node> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        arr = new Node[N];
        Arrays.fill(p, -1);

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x1,x2, i+1);
        }
        Arrays.sort(arr, (p1,p2) -> {
            if(p1.x < p2.x) return -1;
            return 1;
        });

        int ma =  arr[0].y;
        for(int i=0; i<N-1; i++) {

            if(ma >= arr[i+1].x) {
                union(arr[i].idx, arr[i+1].idx);
                ma = Math.max(ma, arr[i+1].y);
            } else {
                ma = arr[i+1].y;
            }
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(find(x)!=find(y)) bw.write("0\n");
            else bw.write("1\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    private static void union(int v, int u) {

        v = find(v);
        u = find(u);
        if(v==u) return ;

        if(p[v] < p[u]) {
            v = u-v+(u=v);
        }
        if(p[v]==p[u]) p[u]--;
        p[v] = u;
    }
    private static int find(int x) {
        if(p[x] < 0 ) return x;
        return p[x] = find(p[x]);
    }
}
