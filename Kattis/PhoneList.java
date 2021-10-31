package Kattis;

import java.io.*;
import java.util.*;

public class PhoneList {
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        StringBuilder res = new StringBuilder();
        int t = reader.nextInt();
        while (t-->0) {
            int n = reader.nextInt();
            List<String> phoneList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                phoneList.add(reader.next());
            }
            phoneList.sort(String::compareTo);
            String status = "YES";
            for (int i = 0; i < n - 1; i++) {
                if (phoneList.get(i + 1).startsWith(phoneList.get(i))) {
                    status = "NO";
                    break;
                }
            }
            res.append(status).append("\n");
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
