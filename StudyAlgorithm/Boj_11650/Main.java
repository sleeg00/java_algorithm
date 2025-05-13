package org.example.StudyAlgorithm.Boj_11650;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

class Pair {
    Integer x;
    Integer y;

    public Pair(Integer x, Integer y) {
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
        List<Pair> arr = new LinkedList<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Pair pair = new Pair(x, y);
            arr.add(pair);
        }
        arr.sort((p1, p2) -> {
            if (p1.first().equals(p2.first())) {
                return p1.second().compareTo(p2.second());
            } else {
                return p1.first().compareTo(p2.first());
            }
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Pair p : arr) {
            bw.write(p.first() + " " + p.second() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
