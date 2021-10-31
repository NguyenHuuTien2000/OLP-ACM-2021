package Kattis_2;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class EqualSums {

    static StringBuilder res = new StringBuilder();

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int testCases = reader.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = reader.nextInt();

            List<Integer> numberList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                numberList.add(reader.nextInt());
            }

            Map<Integer, Integer> sumMap = new HashMap<>();
            for (int i = 0; i < (1<<n); i++) {
                int sum = getSum(numberList, i);
                Integer subset = sumMap.get(sum);

                if (sumMap.containsKey(sum) && (subset ^ i) != 0) {
                    res.append("Case #").append(caseNum).append(":\n");

                    List<Integer> outList = new ArrayList<>();
                    getValue(numberList, outList, i);
                    for (Integer num : outList) {
                        res.append(num).append(" ");
                    }
                    res.append("\n");
                    outList.clear();
                    getValue(numberList, outList, subset);
                    for (Integer num : outList) {
                        res.append(num).append(" ");
                    }
                    res.append("\n");
                    break;
                }
                sumMap.put(sum, i);
            }
        }
        System.out.println(res);
    }

    static void getValue(List<Integer> values, List<Integer> list, int subset) {
        int curr = 0;
        while(subset > 0) {
            if(subset % 2 == 1) {
                list.add(values.get(curr));
            }
            subset >>= 1;
            curr++;
        }
    }

    static int getSum(List<Integer> values, int subset) {
        List<Integer> tempList = new ArrayList<>();
        getValue(values, tempList, subset);
        int total = 0;
        for(Integer i : tempList) {
            total += i;
        }
        return total;
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
