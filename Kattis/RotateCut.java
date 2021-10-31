package Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RotateCut {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int t = reader.nextInt();

        StringBuilder res = new StringBuilder();

        while (t-- > 0) {
            int rotates = reader.nextInt();
            String sentence = reader.next();
            for (int i = 0; i < rotates; i++) {
                int cutLength = (int) Math.floor(sentence.length()/4.0);
                if (cutLength < 1) {
                    break;
                } else {
                    if ((i + 1) % 2 == 0) {
                        sentence = sentence.substring(0,sentence.length() - cutLength);
                    } else {
                        sentence = sentence.substring(cutLength);
                    }
                }
            }

            res.append(sentence).append("\n");
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
