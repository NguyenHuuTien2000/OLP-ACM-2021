package CSES_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildingRoads {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        StringBuilder res = new StringBuilder();

        int n = reader.nextInt();
        int m = reader.nextInt();

        City[] cities = new City[n];
        for (int i = 0; i < n; i++) {
            cities[i] = new City(i + 1);
        }

        for (int i = 0; i < m; i++) {
            City c1 = cities[reader.nextInt() - 1];
            City c2 = cities[reader.nextInt() - 1];

            c1.addCity(c2);
            c2.addCity(c1);
        }

        int roads = -1;
        int count = 0;
        int[] cityPair = new int[2];
        for (City city : cities) {
            if (!city.visited) {
                dfs(city);
                roads++;
                cityPair[count++] = city.id;
            }
            if (count == 2) {
                count = 1;
                res.append(cityPair[0]).append(" ")
                   .append(cityPair[1]).append("\n");
                cityPair[0] = cityPair[1];
            }
        }
        res.insert(0,roads + "\n");
        System.out.println(res);
    }

    static void dfs(City city) {
        city.visited = true;
        for (City nextCity : city.nearbyCities) {
            if (!nextCity.visited) {
                dfs(nextCity);
            }
        }
    }

    static class City {
        public int id;
        public boolean visited;
        public List<City> nearbyCities;

        public City(int id) {
            this.id = id;
            this.visited = false;
            this.nearbyCities = new ArrayList<>();
        }

        public void addCity(City city) {
            this.nearbyCities.add(city);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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
