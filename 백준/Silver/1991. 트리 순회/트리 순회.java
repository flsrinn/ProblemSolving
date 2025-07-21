import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    // 결과 출력을 위한 StringBuilder
    private static StringBuilder sb = new StringBuilder();

    // 트리의 노드를 나타내는 클래스 Node
    static class Node {
        private String value; // 노드의 값
        private Node leftNode; // 왼쪽 자식
        private Node rightNode; // 오른쪽 자식 

        // 생성자
        public Node(String value) {
            this.value = value;
        }

        // 게터 & 세터 
        public String getValue() {
            return value;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getLeftNode() {
            if (leftNode == null) return null;
            return leftNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public Node getRightNode() {
            return rightNode;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입출력 스트림 설정 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 노드의 값을 key로 하고, Node 객체를 value로 하는 HashMap
        // 이미 생성된 Node를 재사용하기 위해 사용 
        HashMap<String, Node> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        
        // 트리 구성
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String value = st.nextToken(); // 현재 노드
            String left = st.nextToken(); // 왼쪽 자식
            String right = st.nextToken(); // 오른쪽 자식

            // 노드가 이미 있으면 map에서 가져오고, 없으면 새로 생성
            Node node = map.getOrDefault(value, new Node(value));
            map.put(value, node);

            // 왼쪽 자식 설정
            if (left.equals(".")) {
                node.setLeftNode(null);
            } else {
                Node leftNode = map.getOrDefault(left, new Node(left));
                node.setLeftNode(leftNode);
                map.put(left, leftNode);
            }

            // 오른쪽 자식 설정 
            if (right.equals(".")) {
                node.setRightNode(null);
            } else {
                Node rightNode = map.getOrDefault(right, new Node(right));
                node.setRightNode(rightNode);
                map.put(right, rightNode);
            }
        }

        // 루트 노드 = "A"
        Node root = map.get("A");

        // 전위 순회 수행
        preorder(root);
        sb.append("\n");

        // 중위 순회 수행
        inorder(root);
        sb.append("\n");

        // 후위 순회 수행 
        postorder(root);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    // 전위 순회 (preorder): 루트 -> 왼쪽 -> 오른쪽
    private static void preorder(Node node) {
        if (node == null) return;

        sb.append(node.getValue());
        preorder(node.getLeftNode());
        preorder(node.getRightNode());
    }

    // 중위 순회 (inorder): 왼쪽 -> 루트 -> 오른쪽 
    private static void inorder(Node node) {
        if (node == null) return;

        inorder(node.getLeftNode());
        sb.append(node.getValue());
        inorder(node.getRightNode());
    }

    // 후위 순회 (postorder): 왼쪽 -> 오른쪽 -> 루트 
    private static void postorder(Node node) {
        if (node == null) return;

        postorder(node.getLeftNode());
        postorder(node.getRightNode());
        sb.append(node.getValue());
    }
}
