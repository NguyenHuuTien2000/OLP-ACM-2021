package CSES_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinCombinations_II {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();
        int x = reader.nextInt();

        int mod = (int) (Math.pow(10, 9) + 7);

        int[] coinSums = new int[x + 1];
        coinSums[0] = 1;

        while (n-- > 0) {
            int coinValue = reader.nextInt();
            for (int j = coinValue; j <= x; j++) {
                if (coinValue <= j) {
                    coinSums[j] = (coinSums[j] + coinSums[j - coinValue]) % mod;
                }
            }
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
