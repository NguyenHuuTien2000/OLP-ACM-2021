package Kattis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AliceInDigital {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int t = reader.nextInt();

        StringBuilder res = new StringBuilder();
        while (t-- > 0) {
            int n = reader.nextInt();
            int m = reader.nextInt();

            int[] arr = new int[n];
            List<Integer> index = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
                if (arr[i] == m) {
                    index.add(i);
                }
            }

            long max = 0;

            for (Integer i : index) {
                long total = m;

                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] <= m) {
                        break;
                    }
                    total += arr[j];
                }

                for (int j = i + 1; j < n; j++) {
                    if (arr[j] <= m) {
                        break;
                    }
                    total += arr[j];
                }

                max = Math.max(max,total);
            }

            res.append(max).append("\n");
        }

        System.out.println(res);

    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
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
