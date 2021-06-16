package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CreatingStrings {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        StringBuilder res = new StringBuilder();
        char[] charArr = reader.next().toCharArray();
        Arrays.sort(charArr);
        res.append(charArr).append("\n");

        int count = 1;
        while (next_permutation(charArr)) {
            count++;
            res.append(charArr).append("\n");
        }
        res.insert(0,count + "\n" );
        System.out.println(res);

    }
    static boolean next_permutation(char[] data) {
        for (int a = data.length - 2; a >= 0; --a) {
            if (data[a] < data[a + 1]) {
                for (int b = data.length - 1;; --b) {
                    if (data[b] > data[a]) {
                        char t = data[a];
                        data[a] = data[b];
                        data[b] = t;
                        for (++a, b = data.length - 1; a < b; ++a, --b) {
                            t = data[a];
                            data[a] = data[b];
                            data[b] = t;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
