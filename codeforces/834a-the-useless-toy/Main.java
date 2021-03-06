// Codeforces Round 426
// The Useless Toy
// Problem statement:
// http://codeforces.com/problemset/problem/834/A

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            char start = in.next().charAt(0);

            char end = in.next().charAt(0);
            int t = in.nextInt();

            if (t % 4 == 0 || t % 4 == 2) {
                out.println("undefined");
                return;
            }

            if (t % 4 == 1) {
                if ((start == '^' && end == '>') || (start == '>' && end == 'v') || (start == 'v' && end == '<') || (start == '<' && end == '^')) {
                    out.println("cw");
                } else {
                    out.println("ccw");
                }
            }
            if (t % 4 == 3) {
                if ((start == '^' && end == '<') || (start == '>' && end == '^') || (start == 'v' && end == '>') || (start == '<' && end == 'v')) {
                    out.println("cw");
                } else {
                    out.println("ccw");
                }
            }
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

