package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberSpiral {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        StringBuilder res = new StringBuilder();

        int t = reader.nextInt();
        while (t-- > 0) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            long value = 0;
            long initialValue;

            if (x >= y) {
                initialValue = (long) x * (x - 1)  + 1;
                value = initialValue + (x % 2 == 0? (x - y) : (y - x));
            }
            if (x < y) {
                initialValue = (long) y * (y - 1)  + 1;
                value = initialValue + (y % 2 == 0? (x - y) : (y - x));
            }
            res.append(value).append("\n");
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
