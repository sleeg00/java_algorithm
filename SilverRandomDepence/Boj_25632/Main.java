package org.example.SilverRandomDepence.Boj_25632;

import java.util.*;
import java.io.*;
// 용태 : 소수 범위 A ~ B -> A <= 소수 <= B
// 유진 : 소수 범위 C ~ D -> C <= 소수 <= D

public class Main {
    static  int arr[] = new int[1001];
    static HashSet<Integer> tae_map = new HashSet<>();
    static HashSet<Integer> you_map = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr[2]=1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int tae_x = Integer.parseInt(st.nextToken());
        int tae_y = Integer.parseInt(st.nextToken());
        getTaeSosu(tae_x, tae_y);
        st = new StringTokenizer(br.readLine(), " ");
        int you_x = Integer.parseInt(st.nextToken());
        int you_y = Integer.parseInt(st.nextToken());
        getYouSosu(you_x, you_y);

        int size = tae_map.size();
        int size2 = you_map.size();
        int gong=0;
        for(int value : tae_map) {
            if(you_map.contains(value)) {
                gong++;
            }
        }
        size-=gong;
        size2-=gong;
        if(size==size2 && gong%2==1)
            bw.write("yt\n");
        else if(size>size2)
            bw.write("yt\n");
        else bw.write("yj\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static void getTaeSosu(int x, int y) {
        for (int i = x; i <= y; i++) {
            boolean sw = false;
            for (int j = 2; j <= i-1; j++) {
                if (i % j == 0) {
                    sw = true;
                    break;
                }
            }
            if(!sw)
            tae_map.add(i);
        }
    }
    private static void getYouSosu(int x, int y) {
        for (int i = x; i <= y; i++) {
            boolean sw = false;
            for (int j = 2; j <= i-1; j++) {
                if (i % j == 0) {
                    sw = true;
                    break;
                }
            }
            if(!sw)
            you_map.add(i);
        }
    }
}
