import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
 
public class Main {
   public static void main(String[] args) throws Exception {
       initFI();
       int tc = nextInt();
       StringBuilder sb = new StringBuilder();
       while (tc-->0) {
           int n = nextInt();
           String s = nextLine();
           char[][] arr = new char[n][n];
           for (int i = 0; i < n; i++)
               arr[i][i] = 'X';
 
           ArrayList<Integer> list = new ArrayList<>();
           for (int i = 0; i < n; i++) {
               if (s.charAt(i) == '1') {
                   for (int k = 0; k < n; k++) {
                       if (i == k) continue;
                       arr[i][k] = '=';
                       arr[k][i] = '=';
                   }
               } else {
                   list.add(i);
               }
           }
 
           if (list.size() == 1 || list.size() == 2) {
               sb.append('N').append('O').append('\n');
               continue;
           }
 
           if (list.size() != 0) {
               int last = list.get(list.size() - 1);
               int first = list.get(0);
               arr[last][first] = '+';
               arr[first][last] = '-';
               for (int i = 1; i < list.size(); i++) {
                   int bf = list.get(i - 1);
                   int cur = list.get(i);
                   arr[bf][cur] = '+';
                   arr[cur][bf] = '-';
               }
           }
 
           sb.append('Y').append('E').append('S').append('\n');
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                   sb.append(arr[i][j] == 0 ? '=' : arr[i][j]);
               }
               sb.append('\n');
           }
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
