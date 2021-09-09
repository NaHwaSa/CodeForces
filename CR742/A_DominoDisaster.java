import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'D') sb.append('U');
                else if (c == 'U') sb.append('D');
                else sb.append(c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
