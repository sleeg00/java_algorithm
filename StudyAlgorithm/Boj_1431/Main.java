package org.example.StudyAlgorithm.Boj_1431;

import java.util.*;
import java.io.*;

// 다솜이
// 1. 조건 Min(A.length, B.length)
// 2. 조건 if length equals, Math.min(A자리합, B자리합) <- 숫자만
// 3. 조건 if 1 And 2 Not Break, -> 사전순 정렬
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ArrayList<String> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, (p1,p2) -> {
           if(p1.length() != p2.length()) return Integer.compare(p1.length(), p2.length());

           int hap=0;
           int sum=0;
           for(int i=0; i<p1.length(); i++) {
               if(p1.charAt(i)>='0' && p1.charAt(i)<='9') hap+=p1.charAt(i)-'0';
               if(p2.charAt(i)>='0' && p2.charAt(i)<='9') sum+=p2.charAt(i)-'0';
           }

           if(hap!=sum) return Integer.compare(hap, sum);

           return p1.compareTo(p2);

        });

        for(int i=0; i<N; i++) {
            bw.write(list.get(i)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
