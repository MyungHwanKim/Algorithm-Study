import java.math.BigInteger;
import java.io.*;

public class BinarySearchSol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BigInteger 를 초기화하기 위해서는 문자열을 인자 값으로 넘겨줘야 함
        BigInteger n = new BigInteger(br.readLine());  // 정수 n
        BigInteger left = new BigInteger("1");
        BigInteger right = n;

        StringBuilder sb = new StringBuilder();
        while (true) {
            // (left + right) / 2 와 같은 표기
            BigInteger mid = left.add(right).divide(new BigInteger("2"));

            // mid^2와 n이 동일한 지 파악 (일치 : 0, mid^2 더 크면 : 1, mid^2 더 작으면 : -1)
            int result = mid.multiply(mid).compareTo(n);
            if (result == 0) {
                sb.append(mid);
                break;
            } else if (result > 0) {
                // right 에서 -1
                right = mid.subtract(new BigInteger("1"));
            } else {
                // left 에서 +1
                left = mid.add(new BigInteger("1"));
            }
        }
        System.out.println(sb);
    }
}
