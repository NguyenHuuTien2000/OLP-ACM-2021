package CSES_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinCombinations_I {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();
        int x = reader.nextInt();

        int[] coinValues = new int[n];
        for (int i = 0; i < n; i++) {
            coinValues[i] = reader.nextInt();
        }

        int mod = (int) (Math.pow(10, 9) + 7);
        long[] coinSums = new long[x + 1];
        coinSums[0] = 1;
        for (int i = 1; i <= x; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (coinValues[j] <= i) {
                    sum += coinSums[i - coinValues[j]];
                }
            }
            coinSums[i] = sum % mod;
        }
        System.out.println(coinSums[x]);
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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
