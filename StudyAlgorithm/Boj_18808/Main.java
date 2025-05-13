package org.example.StudyAlgorithm.Boj_18808;

import java.util.*;
import java.io.*;


public class Main {
    static int row, col, sticker_count;
    static ArrayList<int[][]> sticker = new ArrayList<>();
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        sticker_count = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        for (int i = 0; i < sticker_count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sticker.add(new int[N][M]); // 0, 90, 180, 270
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    sticker.get(i)[j][k] = Integer.parseInt(st.nextToken());
                }
            }

        }

        for (int count = 0; count < sticker_count; count++) {

            int rotation = 0;
            int[][] obj = sticker.get(count);
            while (rotation <= 3) {
                boolean sw = false;
                int check_x = 0, check_y = 0;
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {

                        sw = makeMap(i, j, obj);
                        if (sw) {
                            check_x = i;
                            check_y = j;
                            break;
                        }

                    }
                    if (sw) {
                        break;
                    }
                }
                if (sw) {
                    insertMap(check_x, check_y, obj);
                    break;
                } else {
                    rotation++;
                    obj = rotationSticker(obj);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1) {
                    ans++;
                }
            }
        }
        bw.write(ans + " ");
        bw.flush();
        bw.close();
        br.close();

    }

    private static boolean makeMap(int i, int j, int[][] obj) {
        for (int x = 0; x < obj.length; x++) {
            for (int y = 0; y < obj[x].length; y++) {
                if (i + x >= row || j + y >= col) {
                    return false;
                }
                if (obj[x][y] == 1 && map[i + x][j + y] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean insertMap(int i, int j, int[][] obj) {

        for (int x = 0; x < obj.length; x++) {
            for (int y = 0; y < obj[x].length; y++) {
                if(obj[x][y]==1)
                map[i + x][j + y] = obj[x][y];
            }
        }
        return true;
    }

    private static int[][] rotationSticker(int[][] arr) {
        int[][] obj = new int[arr[0].length][arr.length];
        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj[i].length; j++) {
                obj[i][j] = arr[arr.length - 1 - j][i];
            }
        }
        return obj;
    }
}
