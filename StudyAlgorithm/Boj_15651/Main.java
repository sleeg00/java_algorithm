package org.example.StudyAlgorithm.Boj_15651;


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
            arr[1]=i;
            dfs(i, 1);
        }
    }
    public static void dfs(int i, int cnt) {

        if(cnt==M) {
            for(int j=1; j<=cnt; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        } else if(cnt<M){
            for (int j = 1; j <= N; j++) {
                if (visit[j] == 0) {
                    arr[cnt+1]=j;
                    dfs(j, cnt + 1);
                }
            }
        }
    }
}
