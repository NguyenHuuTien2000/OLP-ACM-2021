package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();
        long maxSum = Integer.MIN_VALUE,
             currentSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            currentSum = Math.max(num, num + currentSum);
            maxSum = Math.max(currentSum, maxSum);
        }
        System.out.println(maxSum);
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
