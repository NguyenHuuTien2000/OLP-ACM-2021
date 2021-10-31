package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppleDivision {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();

        int[] array = new int[n];
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = reader.nextInt();
            totalSum += array[i];
        }
        System.out.println(findDiff(array,n,0,totalSum));
    }

    static int findDiff(int[] arr, int i, long sum1, long totalSum) {
        if (i == 0) {
            return (int) Math.abs((totalSum - sum1) - sum1);
        }

        return Math.min(findDiff(arr, i - 1, sum1 + arr[i - 1], totalSum),
                        findDiff(arr, i - 1, sum1, totalSum));
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
