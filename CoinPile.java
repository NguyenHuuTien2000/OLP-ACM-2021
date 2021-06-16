package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinPile {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int t = reader.nextInt();
        StringBuilder res = new StringBuilder();
        while (t-- > 0) {
            int a = reader.nextInt();
            int b = reader.nextInt();

            int max = Math.max(a,b);
            int min = (a + b) - max;

            if ((a + b) % 3 == 0 || (min * 2) >= max) {
                res.append("YES").append("\n");
            } else {
                res.append("NO").append("\n");
            }
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
