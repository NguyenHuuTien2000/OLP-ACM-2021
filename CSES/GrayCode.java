
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class GrayCode {
    static StringBuilder res = new StringBuilder();
    public static void main(String[] args) {
        int n = nextInt();
        int lim = 1 << n;
        int[] bits = new int[17];
        bitToString(bits,n);
        for (int i = 1; i < lim; i++) {
            int checkBit = 1, index = 1;
            while ((i & checkBit) == 0 ) {
                index++;
                checkBit <<= 1;
            }
            bits[index] ^= 1;
            bitToString(bits,n);
        }
        System.out.print(res);
    }

    static void bitToString(int[] bits, int n) {
        for (int i = n; i > 0; i--) {
            res.append(bits[i]);
        }
        res.append("\n");
    }

    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 20];
    static int lenbuf = 0, ptrbuf = 0;

    static int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    static boolean isSpaceChar(int c) {
        return !(c >= 32 && c <= 126);
    }

    static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    static double nextDouble() {
        return Double.parseDouble(next());
    }

    static char nextChar() {
        return (char) skip();
    }

    static String next() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static String nextLine() throws IOException {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b) && b != '\n') { // when next, ()
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static char[] nextCharArray(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    static int nextInt() {
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

    static long nextLong() {
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
