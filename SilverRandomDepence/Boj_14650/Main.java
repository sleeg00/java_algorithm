package org.example.SilverRandomDepence.Boj_14650;

import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        back(0, "");
        System.out.println(cnt);
    }
    private static void back(int x, String str) {
        if(x==N) {
            if(Integer.parseInt(str)%3==0) {
                cnt++;
            }
            return ;
        }
        for(int i=0; i<=2; i++) {
            if(str.equals("") && i==0) continue;
            back(x+1, str+i);
        }
    }
}
