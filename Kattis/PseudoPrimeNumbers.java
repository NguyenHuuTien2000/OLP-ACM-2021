package Kattis_2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class PseudoPrimeNumbers {
    static StringBuilder res = new StringBuilder();
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int p, a;
        while ((p = reader.nextInt()) != 0 && (a = reader.nextInt()) != 0) {
            if (!checkPrime(p) && powerMod(a,p,p) == a) {
                res.append("yes\n");
            } else {
                res.append("no\n");
            }
        }
        System.out.println(res);
    }

    static Map<Integer, Boolean> primeMap = new HashMap<>();
    static boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n < 4) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        if (n < 25) {
            return true;
        }
        if (!primeMap.containsKey(n)) {
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    primeMap.put(n,false);
                    return false;
                }
            }
            primeMap.put(n,true);
        }
        return primeMap.get(n);
    }

    static int powerMod (int base, int exponent, int mod) {
        int powMod = 1;

        while (exponent > 0) {
            if (exponent % 2 != 0) {
                powMod = (powMod * base) % mod;
            }
            exponent = Math.floorDiv(exponent,2);
            base = (base * base) % mod;
        }

        return powMod;
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
