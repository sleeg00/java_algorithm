package org.example.Boj_15650;

import java.util.*;

public class Main {
    static int visit[] = new int[10];
    static int N;
    static int M;
    static int arr[] = new int[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=1; i<=N; i++) {
            visit[i]=1;
            arr[1]=i;
            dfs(i, 1);
            visit[i]=0;
        }
    }
    public static void dfs(int i, int cnt) {

        if(cnt==M) {
            for(int j=1; j<=cnt; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        } else if(cnt<M){
            for (int j = i+1; j <= N; j++) {
                if (visit[j] == 0) {
                    visit[j] = 1;
                    arr[cnt+1]=j;
                    dfs(j, cnt + 1);
                    visit[j] = 0;
                }
            }
        }
    }
}
