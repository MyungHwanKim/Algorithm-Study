import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BigInteger 를 초기화하기 위해서는 문자열을 인자 값으로 넘겨줘야 함
        BigInteger n = new BigInteger(br.readLine());
        System.out.println(n.sqrt());
    }
}