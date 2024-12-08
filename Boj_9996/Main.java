package org.example.Boj_9996;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String pattern = sc.nextLine();
        int front = 0, back = 0;
        int sw = 0;
        if (pattern.charAt(0) == '*') {
            sw = 0;
        } else if (pattern.charAt(pattern.length() - 1) == '*') {
            sw = 1;
        } else {
            for (int i = 0; i < pattern.length(); i++) {
                sw = 2;
                if (pattern.charAt(i) == '*') {
                    front = i - 1;
                    back = i + 1;
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            boolean ans = true;
            if (sw == 0) {
                int index = str.length() - 1;
                for (int j = pattern.length() - 1; j >= 1; j--) {
                    if (str.charAt(index--) != pattern.charAt(j)) {
                        ans = false;
                        break;
                    }
                }
            } else if (sw == 1) {
                for (int j = 0; j < pattern.length() - 1; j++) {
                    if (str.charAt(j) != pattern.charAt(j)) {
                        ans = false;
                        break;
                    }
                }
            } else if (sw == 2) {
                for (int j = 0; j <= front; j++) {
                    if (str.charAt(j) != pattern.charAt(j)) {
                        ans = false;
                        break;
                    }
                }
                int index = str.length() - 1;
                for (int j = pattern.length() - 1; j >= back; j--) {
                    if (str.charAt(index) != pattern.charAt(j)  ||index <= front) {
                        ans = false;
                        break;
                    }
                    index--;
                }
            }
            if (ans == false) {
                System.out.println("NE");
            } else {
                System.out.println("DA");
            }
        }
    }
}
