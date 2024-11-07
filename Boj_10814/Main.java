package org.example.Boj_10814;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Pair {
    Integer x;
    String y;

    public Pair(Integer x, String y) {
        this.x = x;
        this.y = y;
    }

    public Integer first() {
        return x;
    }

    public String second() {
        return y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Pair> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            String y = sc.next();
            Pair p = new Pair(x, y);
            list.add(p);
        }
        list.sort((p1, p2) -> {
            return p1.first().compareTo(p2.first());
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Pair p : list) {
            bw.write(p.first() + " " + p.second() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
