package org.example.SilverRandomDepence.Boj_12101;

import java.util.*;
import java.io.*;

public class Main {
    static int N, K, cnt;
    static boolean found;
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dfs(0, "");
        if(result==null) {
            System.out.print(-1);
            return ;
        }
        for(int i=0; i<result.length(); i++) {
            if(i!=result.length()-1) {
                System.out.print(result.charAt(i)+"+");
            } else{
                System.out.print(result.charAt(i));
            }
        }

    }

    private static void dfs(int sum, String path) {
        if (found) {
            return;
        }

        if (sum == N) {
            cnt++;

            if (cnt == K) {
                result = path;
                found = true;
            }
            return;
        }

        if (sum > N) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            dfs(sum + i, path + i);
        }
    }
}
