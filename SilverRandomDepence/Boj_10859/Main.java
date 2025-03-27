package org.example.SilverRandomDepence.Boj_10859;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringBuilder s = new StringBuilder(str);
        s = s.reverse();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='3' || s.charAt(i)=='4'||s.charAt(i)=='7') {
                bw.write("no\n");
                bw.flush();
                return ;
            } else if(s.charAt(i)=='6') {
                s.setCharAt(i, '9');
            } else if(s.charAt(i)=='9') {
                s.setCharAt(i, '6');
            }
        }


        long value = Long.parseLong(str);
        if(value==1L) {
            bw.write("no\n");
            bw.flush();
            return ;
        }
        for(long j=2; j*j<=value; j++) {
            if(value%j==0) {
                bw.write("no\n");
                bw.flush();
                return;
            }
        }
        str = String.valueOf(s);

        value = Long.parseLong(str);
        if(value==1L) {
            bw.write("no\n");
            bw.flush();
            return ;
        }
        for(long j=2; j*j<=value; j++) {
            if(value%j==0) {
                bw.write("no\n");
                bw.flush();
                return;
            }
        }
        bw.write("yes\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
