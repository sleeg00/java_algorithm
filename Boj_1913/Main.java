package org.example.Boj_1913;

import java.util.*;
import java.io.*;

public class Main {
    // 홀수인 자연수 N
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int key = Integer.parseInt(br.readLine());
        int[][] mv = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] arr = new int[N + 2][N + 2];
        int number = N * N;
        int i = 1;
        int j = 1;
        int cnt = 0;
        int x=0, y=0;
        while (true) {
            if (number == 0) {
                break;
            }
            if (number == key) {
                x = i;
                y = j;
            }
            arr[i][j] = number--;

            if (i + mv[cnt % 4][0] < 1 || i + mv[cnt % 4][0] >= N + 1 || j + mv[cnt % 4][1] < 1
                    || j + mv[cnt % 4][1] >= N + 1 ||
                    arr[i + mv[cnt % 4][0]][j + mv[cnt % 4][1]] > 0) cnt++;
            i += mv[cnt % 4][0];
            j += mv[cnt % 4][1];
        }
        for (i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write(x + " "+ y + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
