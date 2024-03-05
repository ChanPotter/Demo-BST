package bstdemo_ce160059;

/**
 *
 * @author CE160059 Le Ha Phuong Uyen
 */
public class BSTNode {

    private int data;
    private int count;
    private BSTNode leftChild;
    private BSTNode rightChild;
    private BSTNode parent;

    private int level;
    private int order;

    /**
     * Declare the type of node
     */
    public enum NodeType {

        /**
         * The left child of a node
         */
        LEFT_CHILD,
        /**
         * The right child of a node
         */
        RIGHT_CHILD
    }

    /*===== for drawing =====*/
    /**
     * Unit for drawing the tree
     */
    public static final int LEVEL_DY = 60;
    private int x;
    private int y;
    private int width; // from x-canvas-left to x-node

    /*===== for drawing =====*/
    
    /**
     * Constructor
     * @param data
     */
    public BSTNode(int data) {
        this.data = data;
        this.count = 1;
        this.leftChild = this.rightChild = this.parent = null;
        this.level = 0;
        this.order = 0;

        /*===== for drawing =====*/
        this.x = 0;
        this.y = 0;
        this.width = 0;
        /*===== for drawing =====*/
    }

    /**
     * Constructor for balancing tree
     * @param data
     * @param count
     */
    public BSTNode(int data, int count) { 
        this.data = data;
        this.count = count;
        this.leftChild = this.rightChild = this.parent = null;
        this.level = 0;
        this.order = 0;

        /*===== for drawing =====*/
        this.x = 0;
        this.y = 0;
        this.width = 0;
        /*===== for drawing =====*/
    }

    /**
     * Constructor for drawing the tree
     * @param data
     * @param y
     * @param screenWidth
     */
    public BSTNode(int data, int y, int screenWidth) {
        this.data = data;
        this.count = 1;
        this.leftChild = this.rightChild = this.parent = null;
        this.level = 0;
        this.order = 0;

        /*===== for drawing =====*/
        this.x = this.width = screenWidth / 2;
        this.y = y;
        /*===== for drawing =====*/
    }

    /**
     * Check if the node is the leaf or not
     * @return its leftChild and rightChild return null 
     */
    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    /**
     * Check if the node has child or not
     * @return !isLeaf()
     */
    public boolean hasChild() {
        return !isLeaf();
    }

    /**
     * Check if the node has left child or not
     * @return its leftChild
     */
    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    /**
     * Check if the node has right child or not
     * @return its rightChild
     */
    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    /**
     * Check if the node is the root or not
     * @return its parent is null
     */
    public boolean isRoot() {
        return this.parent == null;
    }

    /**
     * Check if the node is inside the tree or not
     * @return The inside node isn't the root or leaf node
     */
    public boolean isInside() {
        return !isLeaf() && !isRoot();
    }

    /**
     * Get data of the node
     * @return data
     */
    public int getData() {
        return data;
    }

    /**
     * Set data to the node
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Get the number of the nodes with the same data are added
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * Set its count
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Get the leftChild of a node, both data and its children
     * @return its left Child
     */
    public BSTNode getLeftChild() {
        return leftChild;
    }

    /**
     * Set the leftChild of a node
     * @param leftChild
     */
    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
        if (leftChild != null) {
            this.leftChild.setParent(this, NodeType.LEFT_CHILD);
        }
    }

    /**
     * Get the rightChild of a node, both data and its children
     * @return its right Child
     */
    public BSTNode getRightChild() {
        return rightChild;
    }

    /**
     * Set the rightChild of a node
     * @param rightChild
     */
    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
        if (rightChild != null) {
            this.rightChild.setParent(this, NodeType.RIGHT_CHILD);
        }
    }

    /**
     * Get the parent of a node
     * @return its parent
     */
    public BSTNode getParent() {
        return parent;
    }

    /**
     * Set the parent of a node
     * @param parent
     * @param type
     */
    public void setParent(BSTNode parent, NodeType type) {
        this.parent = parent;
        this.level = parent.getLevel() + 1;
        if (type == NodeType.LEFT_CHILD) {
            this.order = parent.getOrder() * 2 + 1;
        } else {
            this.order = parent.getOrder() * 2 + 2;
        }

        /*===== for drawing =====*/
        this.width = parent.getWidth() / 2;
        if (type == NodeType.LEFT_CHILD) {
          //this.x = parent.getY() - (this.width + 5 - this.level); -> for better drawing
            this.x = parent.getX() - this.width;
        } else {
            this.x = parent.getX() + this.width;
        }
        this.y = parent.getY() + LEVEL_DY;
        /*===== for drawing =====*/
    }

    /**
     * Get the level of a node
     * @return its level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the level of a node
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get the order of a node
     * @return its order
     */
    public int getOrder() {
        return order;
    }

    /**
     * Set the order of a node
     * @param order
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /*===== for drawing =====*/
    /**
     * Get coordinates X of a node
     * @return X
     */
    public int getX() {
        return x;
    }

    /**
     * Set coordinates X of a node
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get coordinates Y of a node
     * @return Y
     */
    public int getY() {
        return y;
    }

    /**
     * Set coordinates Y of a node
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the width a node
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set the width a node
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /*===== for drawing =====*/

    /**
     * Find the node has the max data
     * @return that node
     */
    public BSTNode findMaxNode() {
        BSTNode node = this;
        while (node.hasRightChild()) {
            node = node.getRightChild();
        }
        return node;
    }

    /**
     * Find the node has the min data
     * @return that node
     */
    public BSTNode findMinNode() {
        BSTNode node = this;
        while (node.hasLeftChild()) {
            node = node.getLeftChild();
        }
        return node;
    }

    /**
     * Remove a leaf child of a node
     * @param node
     * @return true if successfully remove, false if not
     */
    public boolean removeLeafChild(BSTNode node) {
        if (node == null) {
            return false;
        }
        if (node.isLeaf()) {
            if (this.hasLeftChild()) {
                if (this.getLeftChild().getData() == node.getData()) {
                    this.setLeftChild(null); //Remove left node
                    return true;
                }
            }
            if (this.hasRightChild()) {
                if (this.getRightChild().getData() == node.getData()) {
                    this.setRightChild(null); //Remove right node
                    return true;
                }
            }
        }
        return false;
    }
}
