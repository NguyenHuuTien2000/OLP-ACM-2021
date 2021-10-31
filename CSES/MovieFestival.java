package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MovieFestival {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();

        Movie[] movies = new Movie[n];
        for (int i = 0; i < n; i++) {
            movies[i] = new Movie(reader.nextInt(), reader.nextInt());
        }
        Arrays.sort(movies, Comparator.comparingInt(m -> m.endTime));

        int maxMovie = 0;
        int lastEnd = 0;
        for (int i = 0; i < n; i++) {
            if (movies[i].startTime >= lastEnd) {
                lastEnd = movies[i].endTime;
                maxMovie++;
            }
        }
        System.out.println(maxMovie);
    }
    static class Movie {
        public int startTime;
        public int endTime;

        public Movie(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
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
