package org.example.Boj_2563;

// 11:35

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[][] = new int[101][101];
        int ma_x = -1;
        int ma_y = -1;
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ma_x = Math.max(ma_x, x+10);
            ma_y = Math.max(ma_y, y+10);
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        int ans=0;

        for(int i=0; i<=ma_x; i++) {
            for(int j=0; j<=ma_y; j++) {
                if(arr[i][j]==1) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
