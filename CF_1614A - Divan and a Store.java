import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class Main extends FastInput {
    StringBuilder answer = new StringBuilder();
 
    class Pos {
        int idx, a;
        public Pos(int idx, int a) {
            this.idx = idx;
            this.a = a;
        }
    }
 
    private void solve() throws Exception{
        int n = nextInt();
        ArrayList<Pos> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Pos(i, nextInt()));
        }
        Collections.sort(arr, new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                return o2.a - o1.a;
            }
        });
 
        int[] crd = new int[n];
        int sum = 0;
        int dist = 1;
        for (int i = 0; i < n; i++) {
            Pos cur = arr.get(i);
            if ((i&1)==0) {
                crd[cur.idx] = dist;
            } else {
                crd[cur.idx] = -dist;
                dist++;
            }
            sum += Math.abs(crd[cur.idx]) * cur.a * 2;
        }
        answer.append(sum).append('\n').append(0).append(' ');
        for (int i = 0; i < n; i++) {
            answer.append(crd[i]).append(' ');
        }
        answer.append('\n');
    }
 
    private void solution() throws Exception {
        int t = nextInt();
        while (t-->0) {
            solve();
        }
        System.out.print(answer);
    }
 
    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }
}
 
class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 80;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;
 
    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }
 
    protected static String nextLine() throws IOException {
        byte[] buf = new byte[MAX_CHAR_LEN_FOR_NEXT_LINE];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) break;
                continue;
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
    }
 
    protected static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }
 
    protected static long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }
 
    protected static double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
        if (neg) return -ret;
        return ret;
    }
 
    protected static char nextChar() throws IOException {
        byte c = read();
        while (c <= ' ') c = read();
        return (char)c;
    }
 
    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
