package org.example.SilverRandomDepence.Boj_2508;

import java.io.*;
import java.util.*;

// 사탕 개수, 없는 곳 개수
//
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] ch;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ch = new char[r][c];
            for(int j=0; j<r; j++) {
                String s = br.readLine();
                for(int k=0; k<c; k++) {
                    ch[j][k] = s.charAt(k);
                }
            }
            int cnt=0;
            for(int j=0; j<r; j++) {
                for(int k=0; k<c; k++) {
                    if(ch[j][k]==('o')) {
                        if(j-1>=0 && j+1<r) {
                            if(ch[j-1][k]==('v') && ch[j+1][k]==('^')) cnt++;
                        }
                        if(k-1>=0 && k+1<c) {
                            if(ch[j][k-1]==('>') && ch[j][k+1]==('<')) cnt++;
                        }
                    }
                }
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
