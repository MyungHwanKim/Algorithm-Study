import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // nCm 구하기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 조합값이 엄청 커지므로 BigInteger 로 받는다.
        BigInteger pResult = BigInteger.ONE;
        for (int i = n; i >= n - m + 1; i--) {
            pResult = pResult.multiply(new BigInteger(String.valueOf(i)));
        }

        // 조합값이 엄청 커지므로 BigInteger 로 받는다.
        BigInteger fResult = BigInteger.ONE;
        for (int i = 1; i <= m; i++) {
            fResult = fResult.multiply(new BigInteger(String.valueOf(i)));
        }

        // 결과
        System.out.println(pResult.divide(fResult));
    }
}