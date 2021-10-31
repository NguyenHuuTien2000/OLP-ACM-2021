package Kattis;

import java.io.*;
import java.util.StringTokenizer;

public class LowOrderZeros {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);

        StringBuilder res = new StringBuilder();
        long[] arr = new long[1000001];
        long fac = 1;
        for (int i = 1; i <= 1000000; i++) {
            fac *= i;

            while(fac % 10 == 0) {
                fac /= 10;
            }

            arr[i] = (fac % 10);
            fac %= 1000000;
        }

        int n = reader.nextInt();
        while (n != 0) {
            res.append(arr[n]).append("\n");
            n = reader.nextInt();
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
