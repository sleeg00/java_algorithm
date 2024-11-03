package org.example.Boj_2562;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ma = -1;
        int index = 0;

        for(int i=0; i<9; i++) {
            int number = sc.nextInt();
            if(ma < number) {
                ma = number;
                index = i;
            }
        }
        System.out.println(ma);
        System.out.print(index+1);
    }
}