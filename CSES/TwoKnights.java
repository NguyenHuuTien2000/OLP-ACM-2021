package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoKnights {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int totalPositions = (i * i) * ((i * i) - 1) / 2;
            int atkPositions = 4 * (i - 1) * (i - 2);
            int safePositions = totalPositions - atkPositions;
            res.append(safePositions).append("\n");
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
