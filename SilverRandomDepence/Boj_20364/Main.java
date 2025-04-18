package org.example.SilverRandomDepence.Boj_20364;
import java.util.*;
import java.io.*;
public class Main {
    static int ma=Integer.MAX_VALUE;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2,20);
        tree = new int[size+3];
        for(int i=0; i<Q; i++) {
            int duck = Integer.parseInt(br.readLine());
            ma=Integer.MAX_VALUE;
            int check = first_time_space(duck);
            if(ma == Integer.MAX_VALUE) {
                bw.write(0+"\n");
                tree[duck]=1;
            } else {
                bw.write(ma+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static int first_time_space(int index) {
        if(index == 0) {
            return -1;
        }
        if(tree[index]==1) {
            ma = Math.min(ma, index);
        }
        return first_time_space(index/2);
    }
}
