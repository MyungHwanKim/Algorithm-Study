import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 알고 싶은 번째의 영화의 제목

        int num = 666;  // 영화 제목
        int count = 1;  // 순서

        while (count != N) {
            num++;

            // 종말을 나타내는 숫자가 포함되어 있을 경우
            // 순서를 늘려준다.
            if (String.valueOf(num).contains("666")) {
                count++;
            }
        }

        // N번째 영화의 제목에 들어간 수
        System.out.println(num);
    }
}