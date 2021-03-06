// Catalysts Coding Contest 2017
// Hyperloop Level 1 
// Problem statement:
// https://catcoder.catalysts.cc/

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Hyperloop1 solver = new Hyperloop1();
        solver.solve(1, in, out);
        out.close();
    }

    static class Hyperloop1 {
        long[] x;
        long[] y;
        Map<String, Integer> nameToIndex = new HashMap<>();

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            x = new long[n];
            y = new long[n];
            for (int i = 0; i < n; i++) {
                String s = in.next();
                nameToIndex.put(s, i);
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            String first = in.next();
            int firstIndex = nameToIndex.get(first);
            String last = in.next();
            int lastIndex = nameToIndex.get(last);

            double dist = (x[firstIndex] - x[lastIndex]) * (x[firstIndex] - x[lastIndex]);
            dist += (y[firstIndex] - y[lastIndex]) * (y[firstIndex] - y[lastIndex]);
            dist = Math.sqrt(dist) / 250.0 + 200;
            out.println(Math.round(dist));
        }

    }

    static class InputReader {
        private static BufferedReader in;
        private static StringTokenizer tok;

        public InputReader(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            try {
                while (tok == null || !tok.hasMoreTokens()) {
                    tok = new StringTokenizer(in.readLine());
                    //tok = new StringTokenizer(in.readLine(), ", \t\n\r\f"); //adds commas as delimeter
                }
            } catch (IOException ex) {
                System.err.println("An IOException was caught :" + ex.getMessage());
            }
            return tok.nextToken();
        }

    }
}

