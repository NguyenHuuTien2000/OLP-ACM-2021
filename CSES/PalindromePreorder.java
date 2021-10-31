package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PalindromePreorder {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        String str = reader.next();
        if (str.length() == 1) {
            System.out.println(str);
        } else {

            Map<Character, Integer> charMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                Integer freq = charMap.get(str.charAt(i));
                if (freq == null) {
                    freq = 0;
                }
                freq++;
                charMap.put(str.charAt(i),freq);
            }
            List<Character> charList = new ArrayList<>(charMap.keySet());

            StringBuilder firstHalf = new StringBuilder();
            StringBuilder pivot = new StringBuilder();
            StringBuilder res = new StringBuilder();

            for (Character character : charList) {
                Integer freq = charMap.get(character);
                if (freq % 2 == 0) {
                    firstHalf.append(String.valueOf(character).repeat(freq / 2));
                } else {
                    pivot.append(String.valueOf(character).repeat(freq));
                }
            }

            if (str.length() % 2 == 0) {
                if (firstHalf.length() < str.length() / 2) {
                    System.out.println("NO SOLUTION");
                } else {
                    res.append(firstHalf).append(firstHalf.reverse());
                    System.out.println(res);
                }

            } else {
                if (pivot.length() <= str.length() - 2 && pivot.length() > 0) {
                    res.append(firstHalf).append(pivot).append(firstHalf.reverse());
                    System.out.println(res);
                } else {
                    System.out.println("NO SOLUTION");
                }
            }

        }

    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
