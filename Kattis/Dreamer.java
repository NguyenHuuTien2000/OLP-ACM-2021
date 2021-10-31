package Kattis;

import java.io.*;
import java.util.*;

public class Dreamer {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int t = reader.nextInt();
        StringBuilder res = new StringBuilder();
        while (t-- > 0) {
            char[] dateChar = reader.nextLine().replace(" ","").toCharArray();
            int[] dateDigits = new int[8];
            for (int i = 0; i < 8; i++) {
                dateDigits[i] = dateChar[i] - '0';
            }

            Arrays.sort(dateDigits);
            List<PokeDate> pokeDateList = new ArrayList<>();
            do {
                int day = dateDigits[0] * 10 + dateDigits[1];
                int month = dateDigits[2] * 10 + dateDigits[3];
                int year = dateDigits[4] * 1000 + dateDigits[5] * 100 + dateDigits[6] * 10 + dateDigits[7];

                if (checkDate(day,month,year)) {
                    pokeDateList.add(new PokeDate(day,month,year));
                }

            } while (next_permutation(dateDigits));

            pokeDateList.sort(Comparator.
                    comparingInt((PokeDate o) -> o.year).
                    thenComparingInt(o -> o.month).
                    thenComparingInt(o -> o.day));

            res.append(pokeDateList.size());

            if (!pokeDateList.isEmpty()) {
                res.append(pokeDateList.get(0).toString());
            }
            res.append("\n");
        }

        System.out.println(res);
    }

    static boolean checkDate(int day, int month, int year) {

        if (day < 1) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (year < 2000) {
            return false;
        }

        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            days[2]++;
        }

        if(day > days[month]) {
            return false;
        }

        return true;
    }

    static boolean next_permutation(int[] data) {
        for (int a = data.length - 2; a >= 0; --a) {
            if (data[a] < data[a + 1]) {
                for (int b = data.length - 1;; --b) {

                    if (data[b] > data[a]) {
                        int t = data[a];
                        data[a] = data[b];
                        data[b] = t;
                        for (++a, b = data.length - 1; a < b; ++a, --b) {
                            t = data[a];
                            data[a] = data[b];
                            data[b] = t;
                        }

                        return true;
                    }
                }
            }

        }

        return false;
    }

    static class PokeDate {
        public int day;
        public int month;
        public int year;

        public PokeDate(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public String toString() {
            String date = " ";
            if (day < 10) {
                date += "0";
            }
            date += day + " ";
            if (month < 10) {
                date += "0";
            }
            date += month + " ";
            date += year;
            return date;
        }
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
