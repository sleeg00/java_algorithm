package org.example.StudyAlgorithm.Boj_16719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// ZOAC
// 보여주지 않은 문자 중 추가했을 때 문자열이 사전 순으로 가장 앞에 오도록 하는 문자를 보여줌
// ZOAC -> 보여주지 않은 것 'Z', 'O', 'A', 'C'
// 1. 문자중 가장 작은 값 추가
// 2. 가장 작은 값 Index 보다 뒤에 있는 가장 작은 값 추가
// 3. 다 썻다면 앞에서 가장 작은 값 추가
//----------
// 1.  가장 작은 값을 String에 더한다 O(100)
// 2.  가장 작은 값 Index보다 뒤에 있는 가장 작은값을 찾는다. O(100)
public class Main {
    public static class Pair {
        char ch;
        int index;

        Pair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();
        List<Pair> list[] = new ArrayList[str.length()];
        HashSet<Integer> set = new HashSet<>();
        int index = -1, length = str.length(), cnt = 0;

        for (int i = 0; i < length; i++) {
            list[i] = new ArrayList<>();
        }
        int sw = 0;
        while (true) {
            if(set.size()>=str.length()) break;
            int ma = Integer.MAX_VALUE;
            for (int i = index + 1; i < length; i++) {
                if (str.charAt(i) < ma && !set.contains(i)) {
                    ma = str.charAt(i);
                    index = i;
                }
            }
            if (ma != Integer.MAX_VALUE) {
                bw.write(str.charAt(index));
                set.add(index);
                list[cnt].add(new Pair(str.charAt(index), index));

            } else {
                if (sw == 1) {
                    sw = 0;
                    length = index;
                    index = -1;
                    cnt++;
                } else {
                    sw = 1;
                    index = list[cnt].get(0).index;
                }
            }
        }
        for(int i=list.length-1; i>=0; i--) {
            if(list[i].size()!=0) {
                for(Pair p : list[i]) {
                    bw.write(p.ch+"");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
