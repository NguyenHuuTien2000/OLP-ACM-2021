package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IncreasingArray {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int n = reader.nextInt();

        long moves = 0;
        int max = -1;
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = reader.nextInt();
            max = Math.max(max,array[i]);
        }

        if (array[n - 1] < max) {
            moves += max - array[n - 1];
            array[n - 1] = max;
        }

        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                moves += array[i] - array[i + 1];
                array[i + 1] = array[i];
            }
        }
        System.out.println(moves);
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
