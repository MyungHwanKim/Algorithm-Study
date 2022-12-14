import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine());  // 영어 단어
        StringBuilder T = new StringBuilder(br.readLine());  // 영어 단어

        // T의 영어 단어가 더 길 경우만 while 실행
        while (T.length() > S.length()) {
            // 맨 뒤 문자
            char temp = T.charAt(T.length() - 1);

            // 맨 뒤가 'A' 이든 'B' 이든 제거
            T.deleteCharAt(T.length() - 1);
            // 맨 뒤 문자이 'B' 였다면
            // 문자열을 뒤집는다.
            if (temp == 'B') {
                T.reverse();
            }
        }

        // 두 문자열이 동일할 경우 S를 T로 만들 수 있기 때문에
        // 1 반환
        if (S.toString().equals(T.toString())) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}