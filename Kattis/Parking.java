package Kattis;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Parking {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder res = new StringBuilder();
        int t = reader.nextInt();
        while (t-->0) {
            int n = reader.nextInt();
            int[] pos = new int[n];
            for (int i = 0; i < n; i++) {
                pos[i] = reader.nextInt();
            }
            Arrays.sort(pos);
            int parkPos = findMedian(pos);
            int minDis = (parkPos - pos[0])
                    + (pos[pos.length- 1] - pos[0])
                    + (pos[pos.length- 1] - parkPos);

            res.append(minDis).append("\n");
        }
        System.out.println(res);
    }

    static int findMedian(int[] array) {
        int len = array.length;
        if (len % 2 == 0) {
            return (array[len/2] + array[(len/2 -1)]) / 2;
        }
        return array[len/2];
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
