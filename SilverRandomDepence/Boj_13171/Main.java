package org.example.SilverRandomDepence.Boj_13171;

import java.io.*;

//
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long A, x;

    public static void main(String[] args) throws IOException {
        A = Long.parseLong((br.readLine()));
        x = Long.parseLong(br.readLine());
        String binary = Long.toBinaryString(x);
        StringBuffer str = new StringBuffer(binary);
        str = str.reverse();
        long hap = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                hap = hap * f((long) Math.pow(2, i)) % 1000000007;
            }
        }

        bw.write(hap + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long f(long z) {
        if (z == 0) return 1;
        if (z == 1) return A%1000000007;
        long half = f(z/2);
        long result = half*half %1000000007;
        if (z % 2 == 1) {
            result  = result * A % 1000000007;
        }
        return result;
    }
}
