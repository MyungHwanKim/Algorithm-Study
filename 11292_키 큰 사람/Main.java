import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());  // 학생의 수

            // 프로그램을 종료하는 경우
            if (N == 0) {
                break;
            }

            String[] str = new String[N];
            double max = 0;  // 최대 키의 값
            for (int i = 0; i < N; i++) {
                String temp = br.readLine(); // String으로 받은 이름과 키
                str[i] = temp;
                String[] tmp = temp.split(" ");
                // max 보다 입력받은 키가 더 클 경우
                if (max < Double.parseDouble(tmp[1])) {
                    max = Double.parseDouble(tmp[1]);
                }
            }

            for (int i = 0; i < N; i++) {
                // 키가 가장 큰 학생의 이름을 추가하는 경우
                if (max == Double.parseDouble(str[i].split(" ")[1])) {
                    sb.append(str[i].split(" ")[0]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}