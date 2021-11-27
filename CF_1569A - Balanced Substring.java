import java.io.DataInputStream;
import java.io.IOException;
 
public class Main {
   public static void main(String[] args) throws Exception {
       initFI();
       int tc = nextInt();
       StringBuilder sb = new StringBuilder();
       while (tc-->0) {
           int n = nextInt();
           char[] arr = nextLine().toCharArray();
           int[] suma = new int[n+1];
           int[] sumb = new int[n+1];
 
           for (int i = 1; i <= n; i++) {
               suma[i] += suma[i-1] + (arr[i-1] == 'a' ? 1 : 0);
               sumb[i] += sumb[i-1] + (arr[i-1] == 'b' ? 1 : 0);
           }
 
           boolean chk = false;
           for (int i = 1; i < n; i++) {
               for (int j = i+1; j <= n; j++) {
                   if (suma[j]-suma[i-1] == sumb[j]-sumb[i-1]) {
                       chk = true;
                       sb.append(i).append(' ').append(j).append('\n');
                       break;
                   }
               }
               if (chk) break;
           }
 
           if (chk) continue;
           sb.append(-1).append(' ').append(-1).append('\n');
       }
       System.out.println(sb);
   }
 
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;
 
    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }
 
    private static String nextLine() throws IOException {
        byte[] buf = new byte[64]; // line length
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
 
    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
