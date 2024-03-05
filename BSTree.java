package bstdemo_ce160059;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author CE160059 Le Ha Phuong Uyen
 */
public class BSTree {

    BSTNode root;
    String result;
    ArrayList<BSTNode> path;
    ArrayList<NodeData> treeData;

    /*===== for drawing =====*/
    int screenWidth;
    int yMin;

    /*===== for drawing =====*/
    /**
     * Basic constructor 
     */
    public BSTree() {
        root = null;
        this.screenWidth = 0;
        this.yMin = 0;
        result = "";
        path = new ArrayList<>();
        treeData = new ArrayList<>();
    }

    /**
     * Constructor for drawing the tree
     * @param screenWidth
     * @param yMin
     */
    public BSTree(int screenWidth, int yMin) {
        root = null;
        this.screenWidth = screenWidth;
        this.yMin = yMin;
        result = "";
        path = new ArrayList<>();
        treeData = new ArrayList<>();
    }

    /**
     * Get the root of tree
     * @return root
     */
    public BSTNode getRoot() {
        return this.root;
    }

    /**
     * Get the result after traversing
     * @return
     */
    public String getTraversalResult() {
        return result;
    }

    /**
     * Get the path 
     * @return path
     */
    public ArrayList<BSTNode> getPath() {
        return path;
    }

    /**
     * Method to add a new node to the tree
     * @param data
     */
    public void addNode(int data) {
        if (root == null) {
            root = new BSTNode(data, yMin, screenWidth);
        } else {
            boolean isAdded = false;
            BSTNode node = root;
            while (!isAdded) {
                if (data < node.getData()) {
                    if (node.hasLeftChild()) {
                        node = node.getLeftChild();
                    } else {
                        node.setLeftChild(new BSTNode(data));
                        isAdded = true;
                    }
                } else if (data > node.getData()) {
                    if (node.hasRightChild()) {
                        node = node.getRightChild();
                    } else {
                        node.setRightChild(new BSTNode(data));
                        isAdded = true;
                    }
                } else {
                    node.setCount(node.getCount() + 1);
                    isAdded = true;
                }
            }
        }
    }

    /**
     * Method to add the node to the tree after balancing it
     * @param data
     * @param count
     */
    public void addNode(int data, int count) {
        if (root == null) {
            root = new BSTNode(data, yMin, screenWidth);
        } else {
            boolean isAdded = false;
            BSTNode node = root;
            while (!isAdded) {
                if (data < node.getData()) {
                    if (node.hasLeftChild()) {
                        node = node.getLeftChild();
                    } else {
                        node.setLeftChild(new BSTNode(data, count));
                        isAdded = true;
                    }
                } else if (data > node.getData()) {
                    if (node.hasRightChild()) {
                        node = node.getRightChild();
                    } else {
                        node.setRightChild(new BSTNode(data, count));
                        isAdded = true;
                    }
                } else {
                    node.setCount(node.getCount() + 1);
                    isAdded = true;
                }
            }
        }
    }

    /**
     * Print out the Pre-ordered traversal result
     */
    public void preOrder() {
        result = "";
        preOrder(root);
        System.out.println(result);
    }

    /**
     * Pre-ordered traversal 
     */
    private void preOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < node.getCount(); i++) {
            if (result.equals("")) {
                result += node.getData();
            } else {
                result += ", " + node.getData();
            }
        }

        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    /**
     * Print out the In-ordered traversal result
     */
    public void inOrder() {
        result = "";
        inOrder(root);
        System.out.println(result);
    }

    /**
     * In-ordered traversal 
     */
    private void inOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        for (int i = 0; i < node.getCount(); i++) {
            if (result.equals("")) {
                result += node.getData();
            } else {
                result += ", " + node.getData();
            }
        }
        inOrder(node.getRightChild());
    }

    /**
     * Print out the Post-ordered traversal result
     */
    public void postOrder() {
        result = "";
        postOrder(root);
        System.out.println(result);
    }

    /**
     * In-ordered traversal 
     */
    private void postOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        for (int i = 0; i < node.getCount(); i++) {
            if (result.equals("")) {
                result += node.getData();
            } else {
                result += ", " + node.getData();
            }
        }
    }

    /**
     * Find a node in the tree
     * @param data
     * @return the node if found and null if not
     */
    public BSTNode findNode(int data) {
        BSTNode node = root;
        result = "";

        path.clear();

        while (node != null) {
            if (node == root) {
                System.out.print(node.getData());
                result += node.getData();
            } else {
                System.out.print(" -> " + node.getData());
                result += " -> " + node.getData();
            }
            path.add(node);
            if (data == node.getData()) {
                return node;
            } else if (data < node.getData()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        path.clear();
        return null;
    }

    /**
     * Delete a node by finding it and remove it
     * @param data
     * @return true if found and successfully remove  and false if not
     */
    public boolean removeNode(int data) {
        BSTNode node = findNode(data);
        return removeNode(node);
    }

    /**
     * Method to remove a node 
     * If the node is the leaf then remove it by method removeLeafChild
     * if the node is not the leaf, find another node to replace it and remove the replaced node
     * @param node
     * @return
     */
    public boolean removeNode(BSTNode node) {
        if (node == null) {
            return false;
        }
        node.setCount(node.getCount() - 1);
        if (node.getCount() == 0) {
            if (node.isLeaf()) {
                node.getParent().removeLeafChild(node);
                return true;
            } else {
                BSTNode incomer = null;
                if (node.hasLeftChild()) {
                    incomer = node.getLeftChild().findMaxNode();
                } else {
                    incomer = node.getRightChild().findMinNode();
                }
                node.setData(incomer.getData());
                node.setCount(incomer.getCount());

                incomer.setCount(1);
                return removeNode(incomer);
            }
        } else {
            return true;
        }
    }

    /**
     * Delete a tree by clear all the node starting with the root node
     */
    public void clear() {
        clear(this.root);
        this.root = null;
    }

    /**
     * Delete the tree by using recursive, delete node by node
     * @param node
     */
    public void clear(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            node.getParent().removeLeafChild(node);
        } else {
            clear(node.getLeftChild());
            clear(node.getRightChild());
        }
    }

    /**
     * BFS-traversal by using queue
     */
    public void BFS() {
        this.result = "";
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);

        BSTNode node;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node != null) {
                for (int i = 0; i < node.getCount(); i++) {
                    if (result.equals("")) {
                        System.out.print(node.getData());
                        result += node.getData();
                    } else {
                        System.out.print(", " + node.getData());
                        result += ", " + node.getData();
                    }
                }
                q.add(node.getLeftChild());
                q.add(node.getRightChild());
            }
        }
    }

    /**
     * DFS-traversal by using stack
     */
    public void DFS() {
        this.result = "";
        Stack<BSTNode> s = new Stack<>();
        s.add(root);

        BSTNode node;
        while (!s.isEmpty()) {
            node = s.pop();
            if (node != null) {
                for (int i = 0; i < node.getCount(); i++) {
                    if (result.equals("")) {
                        System.out.print(node.getData());
                        result += node.getData();
                    } else {
                        System.out.print(", " + node.getData());
                        result += ", " + node.getData();
                    }
                }
                s.add(node.getRightChild());
                s.add(node.getLeftChild());
            }
        }
    }

    /**
     * Method to store BSTree into ascending-ordered Array
     * @param node
     */
    public void BSTArray(BSTNode node) {
        if (node == null) {
            return;
        }
        BSTArray(node.getLeftChild());
        treeData.add(new NodeData(node.getData(), node.getCount()));
        BSTArray(node.getRightChild());
    }

    /**
     * Balancing a tree 
     * First, sort it into ascending-ordered Array
     * Then, delete the former tree 
     * Lastly, create the balancing tree by adding the data from the Array using Queue
     * Finish
     */
    public void balancing() {
        treeData.clear();
        BSTArray(this.root); //store BST into ascending-ordered Array

        this.clear(); //remove all node
        Queue<BSTRange> q = new LinkedList<>();
        q.add(new BSTRange(0, treeData.size() - 1));
        BSTRange range;
        NodeData nodeData;
        int middleIndex, leftIndex, rightIndex;
        while (!q.isEmpty()) {
            range = q.poll();
            leftIndex = range.getLeftIndex();
            rightIndex = range.getRightIndex();
            if (leftIndex <= rightIndex) {
                middleIndex = (range.getLeftIndex() + range.getRightIndex()) / 2;
                nodeData = treeData.get(middleIndex);
                this.addNode(nodeData.getData(), nodeData.getCount());

                q.add(new BSTRange(leftIndex, middleIndex - 1));
                q.add(new BSTRange(middleIndex + 1, rightIndex));

            }
        }
    }
}
