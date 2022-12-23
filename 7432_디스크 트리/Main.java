import java.util.*;
import java.io.*;

class Node {
    HashMap<String, Node> child;
    boolean isVisit;

    public Node() {
        this.child = new HashMap<>();
        this.isVisit = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (String s : str.split(" ")) {
            // 현재 노드의 자식 노드에 디렉토리가 포함되어 있지 않는 경우
            if (!cur.child.containsKey(s)) {
                cur.child.put(s, new Node());
            }
            // 현재 디렉토리를 자식 디렉토리로 업데이트
            cur = cur.child.get(s);
            cur.isVisit = false;
        }
    }

    public void getResult(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for (String str : arr) {
            Node cur = root;

            for (int j = 0; j < str.split(" ").length; j++) {
                String s = str.split(" ")[j];  // 현재 디렉토리
                // 현재 노드의 자식 노드에 디렉토리가 포함되어 있는 경우
                if (cur.child.containsKey(s)) {
                    cur = cur.child.get(s);
                    // 이동한 현재 노드의 방문 했을 경우 continue
                    if (cur.isVisit) {
                        continue;
                    }
                    // 하위 디렉토리를 위한 " " 추가
                    sb.append(" ".repeat(j));
                    sb.append(s).append("\n");
                    cur.isVisit = true;  // 현재 디렉토리를 방문했음을 표시
                }
            }
        }
        // 출력
        System.out.println(sb);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 중요한 디렉토리 전체 경로의 개수
        String[] arr = new String[N];  // 디렉토리 정보 담을 배열
        Trie trie = new Trie();  // 트라이 구성

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();  // 디렉토리 경로
            // 디렉토리는 역슬래쉬로 구분되어 있으므로 역슬래쉬로 나눈다.
            for (int j = 0; j < str.split("\\\\").length; j++) {
                String s = str.split("\\\\")[j];
                sb.append(s).append(" ");
            }
            trie.insert(sb.toString());  // 디렉토리 추가
            arr[i] = sb.toString();
        }
        // 사전순을 위한 정렬
        Arrays.sort(arr);
        trie.getResult(arr);  // 결과
    }
}