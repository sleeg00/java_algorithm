package org.example.Boj_27866;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int index = sc.nextInt();

        System.out.println(str.charAt(index-1));
    }
}
