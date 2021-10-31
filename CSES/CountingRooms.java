package CSES_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CountingRooms {
    public static void main(String[] args) {

        InputReader reader = new InputReader();

        int n = reader.nextInt();
        int m = reader.nextInt();

        char[][] building = new char[n][m];
        for (int i = 0; i < n; i++) {
            building[i] = reader.next().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (building[i][j] == '.') {
                    dfs(building, i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(char[][] building, int i, int j) {
        building[i][j] = '#';
        if (checkFloor(building, i - 1, j)) {
            dfs(building, i - 1, j);
        }
        if (checkFloor(building, i + 1, j)) {
            dfs(building, i + 1, j);
        }
        if (checkFloor(building, i, j + 1)) {
            dfs(building, i , j + 1);
        }
        if (checkFloor(building, i, j - 1)) {
            dfs(building, i , j - 1);
        }
    }

    static boolean checkFloor(char[][] building, int row, int column) {
        boolean vertical = row >= 0 && row < building.length;
        boolean horizontal = false;
        if (vertical) {
            horizontal = column >= 0 && column < building[row].length;
        }
        return  vertical && horizontal && building[row][column] == '.';
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
