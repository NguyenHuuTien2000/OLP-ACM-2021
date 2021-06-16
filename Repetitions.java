package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Repetitions {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        String dna = reader.next();
        int length = 1;
        int maxLength = -1;
        for (int i = 0; i < dna.length() - 1; i++) {
            if (dna.charAt(i) == dna.charAt(i + 1)) {
                length ++;
            } else {
                maxLength = Math.max(length, maxLength);
                length = 1;
            }
        }
        maxLength = Math.max(length, maxLength);
        System.out.println(maxLength);
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
