package org.example.StudyAlgorithm.Boj_17609;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            int front = 0;
            int back = str.length() - 1;
            int sw = 0;
            int im = 0;
            while (true) {
                if (front >= back) {
                    break;
                }
                if (str.charAt(front) == str.charAt(back)) {
                    front++;
                    back--;
                } else if (str.charAt(front + 1) == str.charAt(back) && sw == 0) {
                    front++;
                    sw = 1;
                } else if (str.charAt(front) == str.charAt(back - 1) && sw == 0) {
                    back--;
                    sw = 1;
                } else {
                    sw = 2;
                    break;
                }
            }
            front = 0;
            back = str.length() - 1;
            while (true) {
                if (front >= back) {
                    break;
                }
                if (str.charAt(front) == str.charAt(back)) {
                    front++;
                    back--;
                } else if (str.charAt(front) == str.charAt(back - 1) && im == 0) {
                    back--;
                    im = 1;
                } else if (str.charAt(front + 1) == str.charAt(back) && im == 0) {
                    front++;
                    im = 1;
                } else {
                    im = 2;
                    break;
                }
            }
            System.out.println(Math.min(im, sw));
        }
    }
}
