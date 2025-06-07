package org.example.GoldRandomDepence.Boj_14890;

// N * N 칸의 높이
// 길 : 2N개
// 길에 속한 모두 칸의 높이가 같아야 한다. 또는, 경사로를 놓아서 지나갈 수 있어야 함 ,경사로는 높이가 항상 1, 길이는 L
// 1. 경사로는 낮은 칸에 놓임, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.
// 2. 낮은 칸과 높은 카의 차이는 1
// 3. 경사로를 놓은 낮은 칸 높이는 모두 같아야 함, L개의 칸이 연속되어 있어야 함
// 즉 경사로를 놓을 때 낮은 칸에 놓고, 낮은 칸 L칸은 확보해놓고 평평해야 함, 높은 칸 차이는 1
// L : 2 -> arr[i][j] == arr[i][j+1], arr[i][j+2]는 == arr[i][j]+1
// 지나갈 수 있는 길의 개수를 구해라.

// [0][0] -> [0][N]까지 N으로 돌면서 조건 체크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < N; i++) {
            if (getRow(i)) {
                answer++;
            }
            if (getCol(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean getRow(int row) {
        boolean[] incline = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];
            if (Math.abs(diff) > 1) return false;
            if(diff==-1) { // 다음 칸이 한 칸 높으면
                for(int j=0;  j<L; j++) {
                    if(i-j<0 || incline[i-j]) return false; // 뒤로 갈수 없으면 또는 경사면 겹치면
                    if(map[row][i]!= map[row][i-j]) return false;
                    incline[i-j] = true;
                }
            } else if(diff==1) {
                for(int j=1; j<=L; j++) {
                    if(i+j>=N || incline[i+j]) return false;
                    if(map[row][i]-1!=map[row][i+j]) return false;
                    incline[i+j]=true;
                }
            }
        }
        return true;
    }
    private static boolean getCol(int col) {
        boolean[] incline = new boolean[N];
        for(int i=0; i<N-1; i++) {
            int diff = map[i][col] - map[i+1][col];
            if(Math.abs(diff)>1) return false;
            if(diff==-1) {
                for(int j=0;  j<L; j++) {
                    if(i-j<0 || incline[i-j]) return false; // 뒤로 갈수 없으면 또는 경사면 겹치면
                    if(map[i][col]!= map[i-j][col]) return false;
                    incline[i-j] = true;
                }
            } else if(diff==1) {
                for(int j=1; j<=L; j++) {
                    if(i+j>=N || incline[i+j]) return false;
                    if(map[i][col]-1!=map[i+j][col]) return false;
                    incline[i+j]=true;
                }
            }
        }
        return true;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
