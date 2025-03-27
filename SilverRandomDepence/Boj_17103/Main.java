package org.example.SilverRandomDepence.Boj_17103;

import java.util.*;
import java.io.*;
// 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new LinkedHashSet<>();
        set.add(2);
        for (int i = 3; i < 1000000; i++) {
            boolean sw = false;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    sw = true;
                    break;
                }
            }
            if (!sw) {
                set.add(i);
            }
        }

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            int cnt = 0;
            int j = 1;
            for (int number : set) {
                if(number>value/2) break;
                if(value-number>0) {
                    if (set.contains(value - number)) {
                        cnt++;
                    }
                }

            }
            bw.write(cnt+"\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
