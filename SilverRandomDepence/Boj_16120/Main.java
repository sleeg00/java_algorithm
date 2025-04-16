package org.example.SilverRandomDepence.Boj_16120;

import java.util.*;
import java.io.*;

// PPAP 문자열
// 조건 1) 문자열은 P로 시작해, 문자열 내의 P를 PPAP로 바꾸는 과정을 반복해 만들 수 있다.
public class Main {
    public static class Node {
        char ch;
        int count;

        Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Node> stack = new ArrayDeque<>();
        String str = br.readLine();
        if(str.equals("P")) {
            System.out.print("PPAP");
            return ;
        }
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == 'A' && str.charAt(i + 1) == 'P') {
                if (!stack.isEmpty()) {
                    Node node = stack.peek();
                    if (node.ch == 'P' && node.count >= 2) {
                        stack.pollFirst();
                        i++;
                        if(i==str.length()-1 && stack.size()==1) {
                            System.out.print("PPAP");
                            return ;
                        }
                        continue;
                    }
                }
            }

            int count = 0;
            if (!stack.isEmpty()) {
                count = stack.peek().count;
            }
            if(stack.isEmpty() || stack.peek().ch == str.charAt(i)) {
                stack.addFirst(new Node(str.charAt(i), count + 1));
            } else {
                stack.addFirst(new Node(str.charAt(i), 1));
            }

        }
        System.out.print("NP");
    }
}
