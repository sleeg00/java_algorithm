package org.example.SilverRandomDepence.Boj_20186;

import java.util.*;
import java.io.*;
// N개 자연수 K개 한 번에 고르기
// 점수 : 자신의 수 - 자신 왼쪽에 있는 수 중 선택된 수의 개수
// 점수가 최대가 되도록
public class Main {
    public static class Node{
        int idx, value;
        Node(int i, int v) {
            this.idx = i;
            this.value = v;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[] arr = new Node[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = new Node(i, value);
        }
        Arrays.sort(arr, (p1,p2) -> {
            if(p1.value < p2.value) return 1;
            return -1;
        });
        Node[] ans = new Node[M];
        for(int i=0; i<M; i++) {
            ans[i] = arr[i];
        }
        Arrays.sort(ans, (p1,p2) -> {
           if(p1.idx < p2.idx) return -1;
           return 1;
        });
        int hap =0;
        for(int i=0; i<ans.length; i++) {
            hap+=(ans[i].value-i);
        }
        bw.write(hap+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
