package org.example.Boj_12891;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[] = new int[4];
        Character dna[] = new Character[4];
        dna[0] = 'A';
        dna[1] = 'C';
        dna[2] = 'G';
        dna[3] = 'T';
        sc.nextLine();
        String str = sc.nextLine();
        int dp[] = new int[1000001];
        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                if (str.charAt(i) == dna[j]) {
                    dp[j]++;
                }
            }
        }
        int front = 0, back = M;
        int ans = 0;
        while (front < back) {

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                if (dp[i] >= arr[i]) {
                    cnt++;
                }
            }
            if (cnt == 4) {
                ans++;
            }
            if (str.charAt(front) == 'A') {
                dp[0]--;
            } else if (str.charAt(front) == 'C') {
                dp[1]--;
            } else if (str.charAt(front) == 'G') {
                dp[2]--;
            } else if (str.charAt(front) == 'T') {
                dp[3]--;
            }

            if (back == str.length()) {
                break;
            }
            if (str.charAt(back) == 'A') {
                dp[0]++;
            } else if (str.charAt(back) == 'C') {
                dp[1]++;
            } else if (str.charAt(back) == 'G') {
                dp[2]++;
            } else if (str.charAt(back) == 'T') {
                dp[3]++;
            }
            front++;
            back++;

        }
        System.out.println(ans);
    }

}
