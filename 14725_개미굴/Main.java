import java.io.*;
import java.util.*;

class Node { // 트라이에 구성할 Node
    HashMap<String, Node> child = new HashMap<>();
    boolean isVisited = false; // 방문 여부
}

class Trie { // 트라이 구성
    Node root = new Node();

    // 삽입
    public void insert(String str) {
        Node cur = this.root;

        for(String s: str.split(" ")) {
            // 현재 cur에 s가 포함되어 있지 않을 경우
            if (!cur.child.containsKey(s)) {
                cur.child.put(s, new Node());
            }
            cur = cur.child.get(s);
            cur.isVisited = false;
        }
    }

    // 결과 반환
    public void getResult(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            Node cur = root;

            for (String s : str.split(" ")) {
                // 문자열이 Trie cur.child에 key로 포함된 경우
                if (cur.child.containsKey(s)) {
                    cur = cur.child.get(s);
                    // 이전에 방문했었을 경우
                    if (cur.isVisited) {
                        continue;
                    }
                    // sb에 결과를 담고 방문했음을 표시
                    sb.append(s).append("\n");
                    cur.isVisited = true;
                }
            }
        }
        System.out.println(sb.toString());
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        String[] arr = new String[N]; // 먹이 정보를 담을 배열

        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                String s = st.nextToken();
                // 처음에는 그냥 입력한 값 등록
                if (j == 0) {
                    sb.append(s).append(" ");
                } else {
                    // 그 외 경우에는 한 층씩 내려갈 때마다 "--"를 앞에 추가
                    for (int k = 0; k < j; k++) {
                        sb.append("--");
                    }
                    sb.append(s).append(" ");
                }
            }
            // 트라이에 삽입
            trie.insert(sb.toString());
            // arr 배열에도 삽입
            arr[idx++] = sb.toString();
        }
        // 사전 순서로 나와야하기 때문에 정렬
        Arrays.sort(arr);
        // 결과 출력
        trie.getResult(arr);
    }
}