package org.example.Boj_9663;

import java.util.*;

public class Main {
    static int N;
    static int arr[] = new int[16];
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int d) {

        if(d==N) {
            cnt++;
            return;
        } else {
            for(int i=0; i<N; i++) {
                arr[d]=i;
                if(check(d)) {
                    dfs(d+1);
                }
            }
        }
    }

    public static boolean check(int d) {
        for(int i=0; i<d; i++) {
            if(arr[i] == arr[d]) {
                return false;
            } else if(Math.abs(arr[d]-arr[i]) == Math.abs(d-i)) {
                return false;
            }
        }
        return true;
    }
}
