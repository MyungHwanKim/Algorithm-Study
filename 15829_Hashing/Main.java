import java.io.*;

public class Main {
    static int M = 1234567891;  // mod
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());  // str 문자열의 길이
        String str = br.readLine();

        long result = 0;  // 해시 값
        long pow = 1;  // 31의 n승
        for (int i = 0; i < L; i++) {
            // result, pow 값이 M을 넘어설 수 있으므로 M으로 나눈 나머지 값으로 적용
            result += ((str.charAt(i) - 'a' + 1) * pow) % M;
            pow = (pow * 31) % M;
        }

        // 결과
        System.out.println(result % M);
    }
}