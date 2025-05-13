package org.example.StudyAlgorithm.Boj_18870;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Integer first() {
        return x;
    }

    public Integer second() {
        return y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int N = sc.nextInt();
        List<Pair> list = new ArrayList<>();
        int arr[] = new int[N + 1];
        int answer[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            int y = i;
            Pair p = new Pair(arr[i], y);
            list.add(p);
        }
        list.sort((p1, p2) -> {
            return p1.first().compareTo(p2.first());
        });
        int cnt=0;
        for (int i = 0; i < N; i++) {
            int x = list.get(i).first();
            int index = list.get(i).second();
            if(map.get(x)==null) {
                map.put(x,cnt);
                answer[index] = cnt++;
            } else {
                answer[index] = map.get(x);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=1; i<=N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
