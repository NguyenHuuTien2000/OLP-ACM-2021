package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutations {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        StringBuilder res = new StringBuilder();

        int n = reader.nextInt();
        if (n != 3 && n != 2) {
            for (int i = 1, j = 0; i <= n; i++) {
                if (i * 2 <= n) {
                    res.append(i * 2).append(" ");
                } else if (j * 2 + 1 <= n) {
                    res.append(j * 2 + 1).append(" ");
                    j++;
                }
            }
            System.out.println(res);
        } else {
            System.out.println("NO SOLUTION");
        }
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
