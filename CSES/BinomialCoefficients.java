package CSES_2;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class BinomialCoefficients {

    static int mod = 1_000_000_007;
    static int lim = 1_000_001;

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        StringBuilder res = new StringBuilder();

        int t = reader.nextInt();

        long[] inverses = new long[lim];
        inverses[1] = 1;
        for (int i = 2; i < lim; i++) {
            inverses[i] = mod - mod / i * inverses[mod % i] % mod;
        }

        long[] factorials = new long[lim];
        long[] modInverses = new long[lim];
        factorials[0] = modInverses[0] = 1;
        for (int i = 1; i < lim; i++) {
            factorials[i] = factorials[i - 1] * i % mod;
            modInverses[i] = modInverses[i - 1] * inverses[i] % mod;
        }


        while (t-- > 0) {
            int a = reader.nextInt(),
                b = reader.nextInt();

            long coef = factorials[a] * (modInverses[b]) % mod * (modInverses[a - b]) % mod;

            res.append(coef).append("\n");
        }

        System.out.println(res);
    }

    static class InputReader {
        public int bufferLength = 0, bufferPointer = 0;
        public InputStream is;
        private byte[] inputBuffer = new byte[1 << 20];

        public InputReader() {
            try {
                inputBuffer = new byte[2 << 23];
                bufferLength = 0;
                bufferPointer = 0;
                is = System.in;
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
