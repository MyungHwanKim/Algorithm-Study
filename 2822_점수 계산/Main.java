import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[8]; // 참가자의 점수를 담을 배열
        int[] temp = new int[8]; // 참가자의 점수를 오름차순으로 정렬한 배열
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            temp[i] = arr[i];
        }
        // 정렬
        Arrays.sort(temp);

        int sum = 0; // 가장 높은 5개의 점수 합
        for (int i = 3; i < temp.length; i++) {
            sum += temp[i];
        }
        sb.append(sum).append("\n");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 3; j < temp.length; j++) {
                // 입력받은 점수의 값과 정렬된 높은 5개의 점수들이 일치하는 순서를 추가
                if (arr[i] == temp[j]) {
                    // 인덱스는 0부터 시작하므로 + 1를 시켜준다.
                    sb.append(i + 1).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}