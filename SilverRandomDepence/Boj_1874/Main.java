package org.example.SilverRandomDepence.Boj_1874;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        int number = 1;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int now_number = Integer.parseInt(br.readLine());

            if (stack.size() >= 1) {

                if (stack.peek() == now_number) {
                    stack.pop();
                    list.add('-');
                    continue;
                }
                if (stack.peek() > now_number) {
                    bw.write("NO" + "\n");
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }

            while (now_number >= number) {
                stack.push(number++);
                list.add('+');
            }
            list.add('-');
            stack.pop();
        }

        for (Character ch : list) {
            bw.write(ch + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
