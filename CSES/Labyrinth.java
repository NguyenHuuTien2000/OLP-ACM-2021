package CSES_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Labyrinth {

    static int n;
    static int m;
    static char[][] labyrinth;

    public static void main(String[] args) {

        InputReader reader = new InputReader();

        n = reader.nextInt();
        m = reader.nextInt();
        labyrinth = new char[n][m];

        int startRow = 0, startCol = 0;
        int endRow = 0, endCol = 0;
        for (int i = 0; i < n; i++) {
            String row = reader.next();
            if (row.contains("A")) {
                startRow = i;
                startCol = row.indexOf("A");
            }

            if (row.contains("B")) {
                endRow = i;
                endCol = row.indexOf("B");
            }

            labyrinth[i] = row.toCharArray();
        }

        if (bfs(startRow, startCol)) {
            StringBuilder res = new StringBuilder();

            int length = pathLength[endRow][endCol];

            while (length > 0) {
                int index = movementIndex[endRow][endCol];
                res.append(movement[index]);

                endRow -= horizontalIn[index];
                endCol -= verticalIn[index];
                length--;
            }
            res.reverse().insert(0, "YES\n" + res.length() + "\n");
            System.out.println(res);
        } else {
            System.out.println("NO");
        }

    }

    static char[] movement = {'U','D','L','R'};
    static int[] horizontalIn = {-1, 1, 0, 0};
    static int[] verticalIn = {0, 0, -1, 1};

    static int[][] pathLength;
    static int[][] movementIndex;

    static boolean bfs(int startRow, int startCol) {
        Queue<int[]> indexQueue = new ArrayDeque<>();

        int[] index = {startRow, startCol};
        indexQueue.offer(index);
        labyrinth[startRow][startCol] = '#';

        pathLength = new int[n][m];
        movementIndex = new int[n][m];

        while (!indexQueue.isEmpty()) {
            index = indexQueue.poll();
            int length = pathLength[index[0]][index[1]] + 1;

            for (int i = 0; i < 4; i++) {
                int nextRow = index[0] + horizontalIn[i];
                int nextCol = index[1] + verticalIn[i];
                if (checkMovement(nextRow, nextCol)) {
                    pathLength[nextRow][nextCol] = length;
                    movementIndex[nextRow][nextCol] = i;

                    if (labyrinth[nextRow][nextCol] == 'B') {
                        return true;
                    }

                    labyrinth[nextRow][nextCol] = '#';
                    indexQueue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return false;
    }

    static boolean checkMovement(int row, int column) {
        boolean vertical = row >= 0 && row < n;
        boolean horizontal = false;
        if (vertical) {
            horizontal = column >= 0 && column < m;
        }
        return  vertical && horizontal && labyrinth[row][column] != '#';
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
