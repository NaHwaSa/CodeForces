import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        System.out.println(w >= 4 && (w&1)==0 ? "YES" : "NO");
    }
}
