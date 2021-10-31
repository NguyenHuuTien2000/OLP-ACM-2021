package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RestaurantCustomers {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n  = reader.nextInt();

        int[] arrive = new int[n];
        int[] depart = new int[n];
        for (int i = 0; i < n; i++) {
            arrive[i] = reader.nextInt();
            depart[i] = reader.nextInt();
        }
        Arrays.sort(arrive);
        Arrays.sort(depart);

        int currCustomers = 0;
        int maxCustomers = 0;
        for (int i = 0, j = 0; i < n; i++) {
            currCustomers++;
            if (arrive[i] > depart[j]) {
                j++;
                currCustomers--;
            }
            maxCustomers = Math.max(maxCustomers,currCustomers);
        }
        System.out.println(maxCustomers);
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
