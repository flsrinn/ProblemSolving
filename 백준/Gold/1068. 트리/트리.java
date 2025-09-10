import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        private int value;
        private Node parent;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Node[] arr = new Node[n];
        for(int i=0; i<n; i++) {
            Node node = new Node(i);
            arr[i] = node;
        }

        for(int i=0; i<n; i++) {
            int p = Integer.parseInt(st.nextToken());

            if(p != -1) {
                Node parent = arr[p];
                Node node = arr[i];
                node.setParent(parent);

                if(parent.getLeft() == null) {
                    parent.setLeft(node);
                } else {
                    parent.setRight(node);
                }
            }
        }

        int num = Integer.parseInt(br.readLine());
        br.close();

        deleteSubTree(arr, num);

        int count = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] == null) continue;

            Node nod = arr[i];

            if(nod.getLeft() == null && nod.getRight() == null) {
                count++;
            }
        }
        sb.append(count);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void deleteSubTree(Node[] arr, int nodeIndex) {
        if(arr[nodeIndex] == null) return;

        Node node = arr[nodeIndex];

        Node parent = node.getParent();
        if(parent != null) {
            if(parent.getLeft() == node) parent.setLeft(null);
            if(parent.getRight() == node) parent.setRight(null);
        }

        if(node.getLeft() != null) {
            deleteSubTree(arr, node.getLeft().getValue());
        }
        if(node.getRight() != null) {
            deleteSubTree(arr, node.getRight().getValue());
        }

        arr[nodeIndex] = null;
    }
}
