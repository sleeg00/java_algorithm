package org.example.Boj_2738;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[][] = new int[N][M];
        int second_arr[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                second_arr[i][j] = sc.nextInt();
                System.out.print(arr[i][j]+second_arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
