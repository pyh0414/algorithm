public class Main {
    public static void main(String[] args) {

        TreeNode bt1 = new TreeNode("One");

        TreeNode bt2 = new TreeNode("Two");

        TreeNode bt3 = new TreeNode(3);

        TreeNode bt4 = new TreeNode(4);

        bt1.makeLeft(bt2);
        bt1.makeRight(bt3);
        bt2.makeLeft(bt4);

        System.out.println(bt1.getLeft().getData());
        System.out.println(bt1.getRight().getData());
    }
}

class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private Object data;

    TreeNode(Object item) {
        left = null;
        right = null;
        data = item;
    }

    void makeLeft(TreeNode node) {
        if (this.left == null) {
            this.left = node;
        }
    }

    void makeRight(TreeNode node) {
        if (this.right == null) {
            this.right = node;
        }
    }

    Object getData() {
        return this.data;
    }

    TreeNode getLeft() {
        return this.left;
    }

    TreeNode getRight() {
        return this.right;
    }
}