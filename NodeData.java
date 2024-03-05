package bstdemo_ce160059;

/**
 * Class for saving the data to balancing the tree
 * @author CE160059 Le Ha Phuong Uyen
 */
public class NodeData {

    private int data;
    private int count;

    /**
     * Constructor
     * @param data
     * @param count
     */
    public NodeData(int data, int count) {
        this.data = data;
        this.count = count;
    }

    /**
     * Get data of a node
     * @return data
     */
    public int getData() {
        return data;
    }

    /**
     * Set data of a node
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Get count of a node
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * Set count of a node
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

}
