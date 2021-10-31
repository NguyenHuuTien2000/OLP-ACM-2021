package Kattis;

import java.io.*;
import java.util.*;

public class BaconEggsSpam {
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        StringBuilder res = new StringBuilder();
        int day = reader.nextInt();
        while (day != 0) {
            Map<String, Food> mapFood = new HashMap<>();

            for (int i = 0; i < day; i++) {
                String orderLine = reader.nextLine();
                String[] order = orderLine.split(" ");

                for (int j = 1; j < order.length; j++) {
                    Food food = mapFood.get(order[j]);
                    if (food == null) {
                        mapFood.put(order[j],new Food (order[j],order[0]));
                    } else {
                        food.addCustomer(order[0]);
                    }
                }

            }

            List<Food> listFood = new ArrayList<>(mapFood.values());
            listFood.sort(Comparator.comparing(o -> o.name));

            for (Food food : listFood) {
                res.append(food.name)
                    .append(food.sortName())
                        .append("\n");
            }

            res.append("\n");
            day = reader.nextInt();
        }
        System.out.println(res);
    }
    static class Food {
        public String name;
        public List<String> nameList;

        public Food(String name, String customer) {
            this.name = name;
            this.nameList = new ArrayList<>();
            this.nameList.add(customer);
        }

        public void addCustomer(String name) {
            this.nameList.add(name);
        }

        public String sortName() {
            String names = " ";
            this.nameList.sort(String::compareTo);
            for (String custName : this.nameList) {
                names += custName + " ";
            }
            return names;
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
