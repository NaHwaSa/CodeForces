import java.io.DataInputStream;
import java.io.IOException;
 
public class Main {
    private static int res(int max, int cnt, int cur) {
        if (max == cur && cnt > 1)
            return 1;
        if (max == cur)
            return 0;
        return max-cur+1;
    }
 
    private static void solution() throws Exception {
        int t = nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            int max = Math.max(a, Math.max(b, c));
            int cnt = 0;
            if (a==max) cnt++;
            if (b==max) cnt++;
            if (c==max) cnt++;
 
            sb.append(res(max,cnt,a)).append(' ').append(res(max,cnt,b)).append(' ').append(res(max,cnt,c)).append('\n');
        }
        System.out.println(sb);
 
    }
 
    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }
 
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 64;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;
 
    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }
 
    private static String nextLine() throws IOException {
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
 
    private static int nextInt() throws IOException {
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
 
    private static long nextLong() throws IOException {
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
 
    private static double nextDouble() throws IOException {
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
 
    private static char nextChar() throws IOException {
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
