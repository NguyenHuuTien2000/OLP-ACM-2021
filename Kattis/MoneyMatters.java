package Kattis;

import java.io.*;
import java.util.*;

public class MoneyMatters {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();

        Map<Integer, Integer> relations = new HashMap<>();
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[n] = reader.nextInt();
            relations.put(i,null);
        }
        for (int i = 0; i < m; i++) {
            relations.put(reader.nextInt(),reader.nextInt());
        }
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
