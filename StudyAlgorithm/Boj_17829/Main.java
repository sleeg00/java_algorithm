package org.example.StudyAlgorithm.Boj_17829;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//
public class Main {
    static BufferedWriter bw;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (N != 1) {
            int x = 1, y = 1;
            for (int i = 1; i <= N; i += 2) {
                for (int j = 1; j <= N; j += 2) {
                    map[x][y] = f(i, j);
                    y++;
                    if (y > N / 2) {
                        y = 1;
                        x++;
                    }
                }
            }
            N /= 2;

        }
        bw.write(map[1][1]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int f(int x, int y) throws IOException {
        int cnt = 0;
        int arr[] = new int[4];
        for (int i = x; i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {
                arr[cnt++] = map[i][j];
            }
        }

        Arrays.sort(arr);
        return arr[2];
    }
}
