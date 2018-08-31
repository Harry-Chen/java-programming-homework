import java.util.*;

class TreeNode {
    int id;
    int left;
    int right;
    boolean left_leaf;
    boolean right_leaf;

    TreeNode(int id, int left, int right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePrinter {

    public static void main(String args[]) {
        var in = new Scanner(System.in);
        var m = in.nextInt();
        var tree = new TreeNode[m];

        for (int i = 0; i < m; ++i) {
            var id = in.nextInt();
            var left = in.nextInt();
            var right = in.nextInt();
            tree[i] = new TreeNode(id, left, right);
        }

        Arrays.sort(tree, Comparator.comparingInt(t -> t.id));

        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < m; ++i) {
            map.put(tree[i].id, i);
        }

        for (int i = 0; i < m; ++i) {

            if (tree[i].left != -1) {
                if (map.get(tree[i].left) == null) {
                    tree[i].left_leaf = true;
                } else {
                    tree[i].left = map.get(tree[i].left);
                }
            }

            if (tree[i].right != -1) {
                if (map.get(tree[i].right) == null) {
                    tree[i].right_leaf = true;
                } else {
                    tree[i].right = map.get(tree[i].right);
                }
            }
        }


        var list = new LinkedList<Integer>();
        int direction = 0;
        list.addFirst(0);

        while (list.size() > 0) {
            var newList = new LinkedList<Integer>();
            var sb = new StringBuilder();
            while (list.size() > 0) {
                int number = list.removeLast();
                if (number < -1) { // previously inserted leaf
                    if (direction == 0) {
                        sb.append(-number - 1).append(" ");
                    }
                    else {
                        sb.insert(0, (-number - 1) + " ");
                    }
                } else if (number != -1) {
                    var node = tree[number];
                    if (direction == 0) {
                        sb.append(node.id).append(" ");
                    }
                    else {
                        sb.insert(0, node.id + " ");
                    }
                    if (node.left != -1) {
                        if (!node.left_leaf) {
                            newList.addFirst(node.left);
                        } else {
                            newList.addFirst(-node.left - 1);
                        }
                    }
                    if (node.right != -1) {
                        if (!node.right_leaf) {
                            newList.addFirst(node.right);
                        } else {
                            newList.addFirst(-node.right - 1);
                        }
                    }
                }
            }
            direction = 1 - direction;
            System.out.println(sb.toString().trim());
            list = newList;
        }
    }

}