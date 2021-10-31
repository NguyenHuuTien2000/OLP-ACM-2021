package Kattis_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ASCII_FigureRotation {
    static StringBuilder res = new StringBuilder();
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);

        int n;
        while ((n = reader.nextInt()) != 0) {
            char[][] figure = new char[n][];
            int width = 0;
            for (int i = 0; i < n; i++) {
                figure[i] = reader.nextLine().toCharArray();
                width = Math.max(width, figure[i].length);
            }

            for (int i = 0; i < n; i++) {
                if (figure[i].length < width) {
                    char[] filler = new char[width];
                    for (int j = 0; j < width; j++) {
                        if (j < figure[i].length) {
                            filler[j] = rotate(figure[i][j]);
                        } else {
                            filler[j] = ' ';
                        }
                    }
                    figure[i] = filler;
                } else {
                    for (int j = 0; j < width; j++) {
                        figure[i][j] = rotate(figure[i][j]);
                    }
                }
            }

            for (int i = 0; i < width; i++) {
                int j = 0;
                while (figure[j][i] <= 32) {
                    figure[j][i] = 0;
                    j++;
                }
            }

            for (int i = 0; i < width; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (figure[j][i] != 0) {
                        res.append(figure[j][i]);
                    }
                }
                res.append("\n");
            }
            res.append("\n");
            reader.nextLine();
        }
        res.deleteCharAt(res.length() - 1);
        System.out.println(res);
    }

    static char rotate(char c) {
        if (c == '-') {
            return '|';
        }
        if (c == '|') {
            return '-';
        }
        return c;
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;

        public InputReader(InputStream stream) {
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

        public String nextLine() {
            try {
                token = reader.readLine();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            return token;
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
