package Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A1Paper {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();

        List<Integer> numberOfPaper = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            numberOfPaper.add(reader.nextInt());
        }

        double tapeLength = 0;
        int paperNeeded = 1;
        double width = Math.pow(2.0, -5.0/4);
        double length = Math.pow(2.0, -3.0/4);

        String res = "";

        for (int i = 0; i < n - 1; i++) {
            tapeLength += paperNeeded * length;

            double temp = width;
            width = length;
            length = temp;

            width /= 2;

            paperNeeded *= 2;
            paperNeeded -= numberOfPaper.get(i);

            if (paperNeeded <= 0) {
                res += tapeLength;
                break;
            }
        }

        if (res.isEmpty()) {
            System.out.println("Impossible");
        } else {
            System.out.println(res);
        }

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
