import java.util.*;

//input:  number of nodes, each line consists of key, left, right,
// the line number is the i-th node, left is the location of left node,
// right is location of right node, if location is -1, no child goes there

//output: inorder, preorder, and postorder traversal of tree, checks if tree is Binary Search Tree

class Main{

    public static long[] process(){
        Scanner in = new Scanner(System.in);
        int totalNodes = in.nextInt();
        long[] tree = new long[totalNodes];
        Queue<Integer> queue = new LinkedList<Integer>();
        int index = 0;

        Arrays.fill(tree, Long.MAX_VALUE);
        queue.add(0);
        for(int i = 0; i < totalNodes; i++){
            index = queue.poll();
            tree[index] = in.nextLong();
            for(int j = 0 ; j < 2; j++){
                index = in.nextInt();
                if(index != -1)
                    queue.add(index);
            }
        }

        in.close();
        return tree;
    }

    public static void main(String[] args){
        BinaryTree tree;
        long[] arr;
        Node root;
        Boolean isBST;
        Scanner in = new Scanner(System.in);
        
        arr = process();
        tree = new BinaryTree(new Node(arr[0]));
        root = tree.convertArrayToTree(arr, tree.getRoot(), 0);
        
        BinaryTree.InOrderTraversal(root);
        System.out.print("\n");
        BinaryTree.PreOrderTraversal(root);
        System.out.print("\n");
        BinaryTree.PostOrderTraversal(root);
        System.out.println();

        isBST = BinaryTree.checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    
        if(isBST)
            System.out.println("CORRECT");
        else
            System.out.println("INCORRECT");
    }
}