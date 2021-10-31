package Kattis;

import java.io.*;
import java.util.StringTokenizer;

public class VirusReplication {
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        String before = reader.nextLine();
        String after = reader.nextLine();

        int i = 0;
        while (before.charAt(i) == after.charAt(i)) {
            i++;
            if (i >= before.length() || i >= after.length()) {
                break;
            }
        }

        before = before.substring(i);
        after = after.substring(i);

        i = before.length() - 1;
        int j = after.length() - 1;
        while (i >= 0 && j >= 0 && before.charAt(i) == after.charAt(j)) {
            i--;
            j--;
        }
        after = after.substring(0,j + 1);
        System.out.println(after.length());
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
