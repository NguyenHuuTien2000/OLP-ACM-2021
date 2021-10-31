package Kattis;

import java.io.*;
import java.util.StringTokenizer;

public class Baloni {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        int res = 0;
        int[] balloons = new int[1000001];
        for (int i = 0; i < n; i++) {
            int heights = reader.nextInt();
            balloons[heights - 1]++;
            if (balloons[heights] == 0) {
                res++;
            } else {
                balloons[heights]--;
            }
        }
        System.out.println(res);
    }
    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;

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
            token = reader.readLine();
            return (token != null && token.length() > 0);
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (token != null) {
                        tokenizer = new StringTokenizer(token);
                        token = null;
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
