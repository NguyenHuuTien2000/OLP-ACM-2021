package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSets {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();
        StringBuilder res = new StringBuilder();

        long totalSum = (long) n * (n + 1) / 2;
        if (totalSum % 2 == 0) {
            res.append("YES").append("\n");

            long half = totalSum / 2;

            int[] array = new int[n + 1];
            long currSum = 0;
            int count = 0;
            for (int i = 1, j = n; currSum < half; j--) {
                if (currSum + j + i <= half) {
                    currSum += j + i;
                    array[i] = 1;
                    array[j] = 1;
                    count += 2;
                    i++;
                }
            }
            res.append(count).append("\n");
            for (int i = 1; i < array.length; i++) {
                if (array[i] == 1) {
                    res.append(i).append(" ");
                }
            }

            res.append("\n");

            res.append(n - count).append("\n");
            for (int i = 1; i < array.length; i++) {
                if (array[i] == 0) {
                    res.append(i).append(" ");
                }
            }

        } else {
            res.append("NO");
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
