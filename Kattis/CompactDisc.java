package Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CompactDisc {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();

        StringBuilder res = new StringBuilder();

        while (n != 0 && m != 0) {
            int sold = 0;

            int[] jackCD = new int[n];
            int[] jillCD = new int[m];

            for (int i = 0; i < n; i++) {
                jackCD[i] = reader.nextInt();
            }
            for (int i = 0; i < m; i++) {
                jillCD[i] = reader.nextInt();
            }

            for (int i = 0, j = 0; i < n && j < m;) {
                if (jackCD[i] == jillCD[j]) {
                    sold++;
                    i++;
                    j++;
                }
                else if (jackCD[i] > jillCD[j]) {
                    j++;
                } else {
                    i++;
                }

            }

            res.append(sold).append("\n");

            n = reader.nextInt();
            m = reader.nextInt();
        }

        System.out.println(res);
    }
    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String temp;

        public InputReader(InputStream stream) {
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

        public String nextLine() {
            String line;
            try {
                line = reader.readLine();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
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
