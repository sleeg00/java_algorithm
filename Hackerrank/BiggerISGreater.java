import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {

        int i, ma = Integer.MAX_VALUE;
        String str = "";
        char p = 'a'-1;
        StringBuilder s = new StringBuilder(String.valueOf(p)+w);
        i = s.length()-1;
        if(w.length()==1) return "no answer";
        while(i>=0) {
            int index=0;

            if(s.charAt(i) > s.charAt(i-1)) {
                for(int j=i; j<s.length(); j++) {
                    if(s.charAt(i-1) < s.charAt(j) && ma > Math.abs(s.charAt(j)-s.charAt(i-1))) {
                        ma = Math.abs(s.charAt(j)-s.charAt(i-1));
                        index = j;
                    }
                }
                if(ma!=Integer.MAX_VALUE) {
                    char c = s.charAt(index);
                    s.setCharAt(index, s.charAt(i-1)); // swap
                    s.setCharAt(i-1, c);

                    for(int j=1; j<=i-1; j++) {
                        str+=s.charAt(j);
                    }

                    break;
                }
            }

            i--;
            if(i==1) return "no answer";
        }
        List<String> ch = new ArrayList<>();

        for(int j=i; j<s.length(); j++) {
            ch.add(String.valueOf(s.charAt(j)));
        }
        Collections.sort(ch);
        for(int j=0; j<ch.size(); j++) str+=ch.get(j);


        return str;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
