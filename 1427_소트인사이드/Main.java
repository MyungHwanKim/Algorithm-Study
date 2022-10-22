import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();  // 정렬하려고 하는 수의 문자 배열 변경
        Arrays.sort(N);  // 내림차순을 위한 정렬
        // 정렬된 문자 배열 맨 끝부터 StringBuilder 에 추가
        for (int i = N.length - 1; i >= 0; i--) {
            sb.append(N[i]);
        }
        // 결과
        System.out.println(sb.toString());
    }
}