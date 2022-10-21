import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        int count = 0;  // 자연수의 개수
        int num = 1;  // 자연수
        while (true) {
            // 자연수의 합에서 자연수를 뺐을 때 0보다 작을 경우
            if (S - num < 0) {
                break;
                // 자연수의 합에서 서로 다른 자연수를 뺐을 때 0과 일치할 경우
            } else if (S - num == 0) {
                count++;
                break;
            }
            // 자연수 합에서 자연수를 빼고
            // 자연수 + 1
            // 개수 + 1
            S-= num; num++; count++;
        }
        // 결과
        System.out.println(count);
    }
}