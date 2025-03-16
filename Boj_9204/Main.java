package org.example.Boj_9204;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] mv = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}}; // 대각선 이동
    static int[][] visit;
    static boolean found = false; // 경로 발견 여부
    static char[] ch = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char x = st.nextToken().charAt(0);
            int y = Integer.parseInt(st.nextToken());
            char fx = st.nextToken().charAt(0);
            int fy = Integer.parseInt(st.nextToken());

            x -= 64; // A~H → 1~8
            y = 9 - y; // 1~8 → 8~1
            fx -= 64;
            fy = 9 - fy;
            cnt = 0;
            visit = new int[9][9];
            found = false;
            visit[y][x] = 1;
            String result = dfs(y,x,fy,fx,0);
            if(found) {
                bw.write(cnt + " " + result + "\n");
            } else {
                bw.write(result+"\n");
            }
            visit[y][x] = 0;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static String dfs(int x, int y, int fx, int fy, int depth) {
        if (found || depth >= 5) {
            return "Impossible"; // 경로가 너무 길거나 이미 찾았으면 종료
        }

        if (x == fx && y == fy) {  // 목표 도착 시
            cnt = depth;
            found = true;
            return ch[y] + " " + (9 - x); // 도착점 출력
        }

        for (int k = 8; k >= 1; k--) { // 이동 거리 조정
            for (int i = 0; i < 4; i++) {
                int dx = x + k * mv[i][0];
                int dy = y + k * mv[i][1];

                if (dx <= 0 || dy <= 0 || dx >= 9 || dy >= 9 || visit[dx][dy] == 1) {
                    continue;
                }

                visit[dx][dy] = 1;
                String res = dfs(dx, dy, fx, fy, depth + 1);
                visit[dx][dy] = 0;

                if (found) {
                    return ch[y] + " " + (9 - x) + " " + res;
                }
            }
        }

        return "Impossible"; // 찾을 수 없는 경우
    }
}
