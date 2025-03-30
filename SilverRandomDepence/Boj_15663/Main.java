package org.example.SilverRandomDepence.Boj_15663;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr, ans;
    static boolean[] visit;
    static BufferedReader br;
    static BufferedWriter bw;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        visit = new boolean[N];
        ans = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);
        back(0);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void back(int idx) throws IOException {
        if(idx==M) {
            String str = "";
            for(int i=0; i<M; i++) {
               str+=ans[i]+" ";
            }
            if(!set.contains(str)) {
                set.add(str);
                bw.write(str+"\n");
            }
            return ;
        }
        for(int i=0; i<N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                ans[idx] = arr[i];
                back(idx+1);
                visit[i] = false;
            }
        }
    }
}
