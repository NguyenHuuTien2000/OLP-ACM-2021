package Kattis;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SidewaysSorting {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int r = reader.nextInt();
        int c = reader.nextInt();

        StringBuilder res = new StringBuilder();
        while (r != 0 && c != 0) {

            String line = reader.nextLine();
            String[] strArr = line.split("");

            while(r-- > 1) {
                String nLine = reader.nextLine();
                for (int i = 0; i < strArr.length; i++) {
                    strArr[i] += nLine.charAt(i);
                }
            }

            Arrays.sort(strArr,String::compareToIgnoreCase);
            res.append(getVerticalString(strArr)).append("\n");

            r = reader.nextInt();
            c = reader.nextInt();
        }
        System.out.println(res);

    }
    static String getVerticalString(String[] arr) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr[0].length(); i++) {
            for (String s : arr) {
                res.append(s.charAt(i));
            }
            res.append("\n");
        }
        return res.toString();
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
