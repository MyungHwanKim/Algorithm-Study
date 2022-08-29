import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 받을 문자열
        String str = br.readLine();
        String UCPC = "UCPC";
        int i = 0;
        for(char c: str.toCharArray()) { // 문자열을 문자로 쪼개어 비교
            if (c == UCPC.charAt(i)) { // UCPC의 문자와 같을 경우
                i++;
            }
            if (i == 4) { // UCPC 문자열을 끝까지 도달했을 경우
                System.out.println("I love UCPC");
                return;
            }
        }
        // for문을 다 돌았음에도 UCPC가 만들어지지 않은 경우
        System.out.println("I hate UCPC");
    }
}