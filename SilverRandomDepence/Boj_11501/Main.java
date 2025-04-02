package org.example.SilverRandomDepence.Boj_11501;

import java.util.*;
import java.io.*;
public class Main {
    public static class Node {
        int value, index;
        Node(int value, int idx) {
            this.value = value;
            this.index = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            long hap = 0;
            st = new StringTokenizer(br.readLine()," ");

            for(int p=0; p<N; p++) {
                arr[p] = Integer.parseInt(st.nextToken());
            }
            int ma = -1;
            for(int p=N-1; p>=0; p--) {
                if(ma < arr[p]) {
                    ma = arr[p];
                } else {
                    hap+=(ma-arr[p]);
                }
            }

            bw.write(hap+"\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
