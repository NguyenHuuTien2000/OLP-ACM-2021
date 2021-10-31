package Kattis;

import java.io.*;
import java.util.StringTokenizer;

public class FenwickTree {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        int q = reader.nextInt();

        StringBuilder res = new StringBuilder();
        int[] array = new int[n + 1];

        for (int i = 0; i < q; i++) {
            if (reader.next().equals("+")) {
                updateTree(array, (reader.nextInt() + 1), reader.nextInt());
            } else {
                res.append(getSum(array, reader.nextInt()));
                res.append("\n");
            }
        }

        System.out.println(res);
    }

    static void updateTree(int[] arr, int pos, int value) {
        int len = arr.length;
        for (; pos < len; pos += pos & (-pos)) {
            arr[pos] += value;
        }
    }
    
    static long getSum(int[] arr, int pos) {
        long sum = 0;
        for (; pos > 0 ; pos -= pos & (-pos)) {
            sum += arr[pos];
        }
        return sum;
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public boolean hasNext() throws IOException {
            if (tokenizer != null && tokenizer.hasMoreTokens()) {
                return true;
            }
            temp = reader.readLine();
            return (temp != null && temp.length() > 0);
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
