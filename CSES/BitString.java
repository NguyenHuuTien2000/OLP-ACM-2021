package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BitString {
    public static void main(String[] args) {
        InputReader reader = new InputReader();

        int n = reader.nextInt();
        BigInteger a = BigInteger.TWO.pow(n);
        BigInteger b = BigInteger.TEN.pow(9).add(BigInteger.valueOf(7));
        BigInteger ans = a.mod(b);
        System.out.println(ans);
    }

    static long mod = (long) (Math.pow(10,9) + 7);
    static long powerMod (long num, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return num;
        }
        long pow = powerMod(num,exponent / 2);
        if (exponent % 2 == 0) {
            return (pow * pow) % mod;
        } else {
            return (num * pow * pow) % mod;
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
