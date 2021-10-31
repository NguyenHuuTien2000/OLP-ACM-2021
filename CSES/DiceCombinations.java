package CSES_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceCombinations {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();

        int mod = (int) (Math.pow(10, 9) + 7);
        int maxN = (int) (Math.pow(10,6)  + 1);
        int[] diceSums = new int[maxN  + 1];

        diceSums[0] = 1;
        for (int i = 1; i <= maxN ; i++) {
            for (int j = 1; j <= Math.min(6, i) ; j++) {
                diceSums[i] = (diceSums[i] + diceSums[i - j]) % mod;
            }
        }
        System.out.println(diceSums[n]);

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
