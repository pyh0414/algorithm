
// https://www.welcomekakao.com/learn/courses/30/lessons/42888?language=java
// 길 찾기 게임

import java.util.*;

class Solution {

    static int index = 0;

    public int[][] solution(int[][] nodeinfo) {

        List<Node> list = new ArrayList<Node>();

        for (int a = 0; a < nodeinfo.length; a++) {
            list.add(new Node(nodeinfo[a][0], nodeinfo[a][1], a + 1));
        }

        Collections.sort(list, new Comparator<Node>() { // 노드들을 y가 높은 순으로 정렬, y가 같다면 x가 낮은 순으로 정렬
            public int compare(Node n1, Node n2) {
                if (n1.y > n2.y) {
                    return -1;
                } else if (n1.y < n2.y) {
                    return 1;
                } else {
                    if (n1.x > n2.x) {
                        return 1;
                    } else if (n1.x < n2.x) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        Node root = list.get(0);
        int[][] answer = new int[2][list.size()];

        for (int i = 1; i < list.size(); i++) {
            addNode(root, list.get(i));
        }

        preorder(answer, root);
        index = 0;
        postorder(answer, root);

        return answer;
    }

    void addNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                addNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                addNode(parent.right, child);
            }
        }
    }

    void preorder(int[][] arr, Node root) { // 전위순회

        if (root != null) {
            arr[0][index++] = root.num;
            preorder(arr, root.left);
            preorder(arr, root.right);
        }
    }

    void postorder(int[][] arr, Node root) { // 후위순회
        if (root != null) {
            postorder(arr, root.left);
            postorder(arr, root.right);
            arr[1][index++] = root.num;
        }
    }
}

class Node {
    int x;
    int y;
    int num;
    Node left;
    Node right;

    Node(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}