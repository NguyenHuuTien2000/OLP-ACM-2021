package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SumOfTwoValues {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        StringBuilder res = new StringBuilder();
        int n = reader.nextInt();
        int x = reader.nextInt();

        List<Integer> numList = new ArrayList<>(n);
        List<Integer> referList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            numList.add(num);
            referList.add(num);
        }
        numList.sort(Integer::compareTo);

        int i = 0, j = n - 1;
        int numA = 0;
        int numB = 0;
        while (j > i) {
            if (numList.get(i) + numList.get(j) == x) {
                numA = numList.get(i);
                numB = numList.get(j);
                break;
            }
            if (numList.get(i) + numList.get(j) > x) {
                j--;
            }
            if (numList.get(i) + numList.get(j) < x) {
                i++;
            }
        }

        if (numA != 0 && numB != 0) {
            res.append(referList.indexOf(numA) + 1).append(" ")
                    .append(referList.lastIndexOf(numB) + 1);

            System.out.println(res);
        } else {
            System.out.println("IMPOSSIBLE");
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
