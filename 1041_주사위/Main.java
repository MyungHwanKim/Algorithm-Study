import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        long result = 0;  // 결과
        int[] dice = new int[6];  // 주사위 숫자 담은 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {  // 주사위 갯수가 1개일 때
            Arrays.sort(dice);
            for (int i = 0; i < 5; i++) {
                result += dice[i];
            }
            System.out.println(result);
        } else {
            long one = (N - 2) * (5 * N - 6); // 한 면이 보일 경우
            long two = 8 * N - 12; // 두 면이 보일 경우
            long three = 4; // 세 면이 보일 경우

            // 한 면일 경우
            long min = dice[0];
            for (int i = 1; i < dice.length; i++) {
                min = Math.min(min, dice[i]);
            }
            result += min * one;

            // 두 면일 경우
            min = Long.MAX_VALUE;
            for (int i = 0; i < dice.length; i++) {
                for (int j = i + 1; j < dice.length; j++) {
                    // 두 면 서로 반대편에 있을 경우 제외
                    // (= 옆으로 이어져 있지 않은 경우 제외)
                    if (j + i != 5) {
                        min = Math.min(min, dice[i] + dice[j]);
                    }
                }
            }
            result += min * two;

            // 세 면일 경우
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += Math.min(dice[i], dice[5 - i]);
            }
            result += sum * three;

            System.out.println(result);
        }
    }
}