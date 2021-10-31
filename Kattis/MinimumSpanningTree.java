package Kattis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

public class MinimumSpanningTree {

    static StringBuilder res = new StringBuilder();
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        solve(reader);
        System.out.println(res);
    }

    static void solve(InputReader reader) {
        int n;
        int m;

        while ((n = reader.nextInt()) > 0 && (m = reader.nextInt()) >= 0) {
            List<Vertex> vertices = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                vertices.add(new Vertex(i));
            }
            List<Edge> edges = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                Vertex v1 = vertices.get(reader.nextInt());
                Vertex v2 = vertices.get(reader.nextInt());
                int weight = reader.nextInt();
                edges.add(new Edge(v1, v2, weight));
            }

            edges.sort(Comparator.comparingInt(e -> e.weight));
            List<Edge> outputEdges = new ArrayList<>();

            int minWeight = 0;
            for (Edge edge : edges) {
                Vertex root1 = findRoot(edge.v1);
                Vertex root2 = findRoot(edge.v2);
                if (root1 != root2) {
                    minWeight += edge.weight;
                    outputEdges.add(edge);
                    root1.root = root2;
                }
            }

            int components = 0;
            for (Vertex vertex : vertices) {
                if (vertex.root == null) {
                    components++;
                }
                if (components > 1) {
                    break;
                }
            }
            if (components > 1) {
                res.append("Impossible").append("\n");
                continue;
            }

            outputEdges.sort(Comparator.comparingInt((Edge e) -> e.v1.id).thenComparingInt(e -> e.v2.id));
            res.append(minWeight).append("\n");
            for (Edge edge : outputEdges) {
                res.append(edge.v1.id).append(" ").
                    append(edge.v2.id).append("\n");
            }
        }
    }

    static Vertex findRoot(Vertex vertex) {
        if (vertex.root == null) {
            return vertex;
        }
        Vertex temp = findRoot(vertex.root);
        vertex.root = temp;
        return temp;
    }

    static class Edge {
        public Vertex v1;
        public Vertex v2;
        public int weight;

        public Edge(Vertex v1, Vertex v2, int weight) {
            if (v1.id < v2.id) {
                this.v1 = v1;
                this.v2 = v2;
            } else {
                this.v2 = v1;
                this.v1 = v2;
            }
            this.weight = weight;
        }
    }

    static class Vertex {
        public int id;
        public Vertex root;

        public Vertex(int id) {
            this.id = id;
            this.root = null;
        }
    }

    static class InputReader {
        public int bufferLength = 0, bufferPointer = 0;
        public InputStream is;
        private byte[] inputBuffer;

        public InputReader(InputStream stream) {
            try {
                inputBuffer = new byte[2 << 23];
                bufferLength = 0;
                bufferPointer = 0;
                is = stream;
                bufferLength = is.read(inputBuffer);
            } catch (Exception ignored) {

            }
        }

        public boolean hasNext() throws IOException {
            if (skip() >= 0) {
                bufferPointer--;
                return true;
            }
            return false;
        }

        public String nextLine() throws IOException {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b) && b != ' ') { // when nextLine, ()
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        private int readByte() {
            if (bufferLength == -1)
                throw new InputMismatchException();
            if (bufferPointer >= bufferLength) {
                return -1;
            }
            return inputBuffer[bufferPointer++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        public Character nextChar() {
            return skip() >= 0 ? (char) skip() : null;
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}
