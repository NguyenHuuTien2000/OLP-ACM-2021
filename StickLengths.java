package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StickLengths {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();

        int[] stickLengths = new int[n];
        for (int i = 0; i < n; i++) {
            stickLengths[i] = reader.nextInt();
        }
        Arrays.sort(stickLengths);
        
        int median = stickLengths[n/2];
        long cost = 0;
        for (int i = 0; i < n; i++) {
            cost += Math.abs(median - stickLengths[i]);
        }
        System.out.println(cost);
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
