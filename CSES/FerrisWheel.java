package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FerrisWheel {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();
        int x = reader.nextInt();

        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            weights.add(reader.nextInt());
        }
        weights.sort(Integer::compareTo);

        int count = 0;
        for (int i = 0, j = n - 1; j >= i;) {
            if (weights.get(i) + weights.get(j) <= x) {
                i++;
            }
            j--;
            count++;
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
