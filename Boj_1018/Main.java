package org.example.Boj_1018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Character arr[][] = new Character[N + 1][M + 1];
        Character first[][] = new Character[8][8];
        Character second[][] = new Character[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    first[i][j] = 'W';
                    second[i][j] = 'B';
                } else if (i % 2 == 0 && j % 2 == 1) {
                    first[i][j] = 'B';
                    second[i][j] = 'W';
                } else if (i % 2 == 1 && j % 2 == 0) {
                    first[i][j] = 'B';
                    second[i][j] = 'W';
                } else if(i%2==1 && j%2==1){
                    first[i][j] = 'W';
                    second[i][j] = 'B';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int ans = 100;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int first_cnt = 0;
                int second_cnt = 0;
                int x = 0;
                if (i + 8 <=N && j + 8 <=M) {

                    for (int k = i; k < i + 8; k++) {
                        int y = 0;
                        for (int p = j; p < j + 8; p++) {
                            if (arr[k][p] != first[x][y]) {
                                first_cnt++;
                            }
                            if (arr[k][p] != second[x][y]) {
                                second_cnt++;
                            }
                            y++;
                        }
                        x++;
                    }
                    ans = Math.min(Math.min(first_cnt, second_cnt), ans);
                }

            }
        }
        System.out.println(ans);
    }
}
