
import java.util.*;

class Node{
    long key;
    Node left, right;

    public Node(long item){
        key = item;
        left = right = null;
    }
}

class BinaryTree{

    private Node root;
    private int nodeCount = 0;

    public BinaryTree(Node node){
        root = node;
    }
    
    public Node getRoot(){
        return root;
    }

    public void setRoot(Node node){
        root = node;
    }

    public static Node goLeft(Node node){
        return node.left;
    }

    public static Node goRight(Node node){
        return node.right;
    }

    public void incrementNodeCount(){
        nodeCount++;
    }

    public int getNodeCount(){
        return nodeCount;
    }

    public Node convertArrayToTree(long[] arr, Node root, int i){
        if(i < arr.length){
            Node node = new Node(arr[i]);
            root = node;

            root.left = convertArrayToTree(arr, root.left, 2 * i + 1);
            root.right = convertArrayToTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void InOrderTraversal(Node node){
        if(node == null){
            return;
        }
        InOrderTraversal(node.left);
        System.out.print(node.key + " ");
        InOrderTraversal(node.right);
    }

    public static void PreOrderTraversal(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.key + " ");
        PreOrderTraversal(node.left);
        PreOrderTraversal(node.right);
    }

    public static void PostOrderTraversal(Node node){
        if (node == null)
            return;
        
        PostOrderTraversal(node.left);
        PostOrderTraversal(node.right);
        System.out.print(node.key + " ");
    }

    public static boolean checkBST(Node node, long min, long max){
        if(node == null)
            return true;
        if(node.key < min || node.key > max)
            return false;
        return checkBST(node.left, min, node.key) 
                && checkBST(node.right, node.key, max);
    }
}