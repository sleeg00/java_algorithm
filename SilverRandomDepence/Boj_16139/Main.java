package org.example.SilverRandomDepence.Boj_16139;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[29][str.length()];
        for (int i = 0; i <= 28; i++) {
            for (int j = 0; j < str.length(); j++) {
                if (j != 0) {
                    arr[i][j] = arr[i][j - 1];
                }
                if (str.charAt(j) == (char) (i + 97)) {
                    arr[i][j]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String ch = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == 0) {
                bw.write(arr[ch.charAt(0) - 97][end] + "\n");
            } else {
                bw.write(arr[(ch.charAt(0)) - 97][end] - arr[(ch.charAt(0) - 97)][start-1] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
