package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        StringBuilder res = new StringBuilder();
        long n = reader.nextInt();
        res.append(n).append(" ");
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n*3 + 1;
            }
            res.append(n).append(" ");
        }
        System.out.println(res);

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
