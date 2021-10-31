package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tower {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();
        List<Integer> towers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cube = reader.nextInt();
            int index = customBinarySearch(towers, cube);
            if (index < towers.size()) {
                towers.set(index, cube);
            } else {
                towers.add(cube);
            }
        }

        System.out.println(towers.size());
    }

    static int customBinarySearch(List<Integer> list, int key) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = left + right >>> 1;
            int pivot = list.get(mid);
            if (key < pivot) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
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
