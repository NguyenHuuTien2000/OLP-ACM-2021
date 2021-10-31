package Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Parking_2 {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);

        int[] parkingFee = new int[4];
        for (int i = 1; i <= 3; i++) {
            parkingFee[i] = reader.nextInt();
        }

        int[] parkTime = new int[6];
        int start = 101;
        int end = 0;

        for (int i = 0; i < 6; i+=2) {
            parkTime[i] = reader.nextInt();
            start = Math.min(start,parkTime[i]);

            parkTime[i + 1] = reader.nextInt();
            end = Math.max(end,parkTime[i + 1]);
        }

        int payment = 0;
        for (int i = start; i < end; i++) {
            int current = 0;
            if (i >= parkTime[0] && i < parkTime[1] ) {
                current++;
            }
            if (i >= parkTime[2] && i < parkTime[3] ) {
                current++;
            }
            if (i >= parkTime[4] && i < parkTime[5] ) {
                current++;
            }

            payment += parkingFee[current]*current;
        }
        System.out.println(payment);
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
