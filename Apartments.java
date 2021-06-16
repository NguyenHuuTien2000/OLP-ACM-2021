package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Apartments {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();
        int m = reader.nextInt();
        int k = reader.nextInt();

        List<Integer> baseSize = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            baseSize.add(reader.nextInt());
        }
        baseSize.sort(Integer::compareTo);

        List<Integer> actualSize = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            actualSize.add(reader.nextInt());
        }
        actualSize.sort(Integer::compareTo);

        int count = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < m && actualSize.get(j) < baseSize.get(i) - k) {
                j++;
            }

            if (j < m && actualSize.get(j) <= baseSize.get(i) + k) {
                count++;
                j++;
            }
        }
        System.out.println(count);
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
