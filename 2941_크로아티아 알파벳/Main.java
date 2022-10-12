import java.io.*;

public class Main {
    // 변경된 크로아티아 알파벳
    static String[] CROATIA = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alphabet = br.readLine();  // 입력받은 알파벳
        for (String cro : CROATIA) {
            // 알파벳에 크로아티아 알파벳이 포함된 경우
            // 알파벳에 a 라는 문자로 변경
            if (alphabet.contains(cro)) {
                alphabet = alphabet.replace(cro, "a");
            }
        }
        // 크로아티아 알파벳을 전부 a 라는 문자로 바꾸었기 때문에
        // 알파벳의 길이가 곧 크로아티아 알파벳의 개수이다.
        System.out.println(alphabet.length());
    }
}