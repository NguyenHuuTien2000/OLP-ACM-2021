package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ConcertTickets {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        StringBuilder res = new StringBuilder();
        int n = reader.nextInt();
        int m = reader.nextInt();

        TreeMap<Integer, Integer> ticketsMap = new TreeMap<>();
        Integer ticket;
        for (int i = 0; i < n; i++) {
            ticket = reader.nextInt();
            if (!ticketsMap.containsKey(ticket)) {
                ticketsMap.put(ticket,1);
            } else {
                ticketsMap.put(ticket,(ticketsMap.get(ticket) + 1));
            }
        }

        for (int i = 0; i < m; i++) {
            Integer customerPrice = reader.nextInt();
            ticket = ticketsMap.floorKey(customerPrice);
            if (ticket == null) {
                res.append(-1);
            } else {
                res.append(ticket);
                Integer available = ticketsMap.get(ticket);
                if (available == 1) {
                    ticketsMap.remove(ticket);
                } else {
                    ticketsMap.put(ticket, available - 1);
                }
            }
            res.append("\n");
        }

        System.out.println(res);
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
