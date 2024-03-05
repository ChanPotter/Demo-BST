package bstdemo_ce160059;

/**
 * Supporting class for balancing the former tree
 * @author CE160059 Le Ha Phuong Uyen
 */
public class BSTRange {

    private int leftIndex;
    private int rightIndex;

    /**
     * Constructor
     * @param leftIndex
     * @param rightIndex
     */
    public BSTRange(int leftIndex, int rightIndex) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

    /**
     * Get the left index
     * @return leftIndex
     */
    public int getLeftIndex() {
        return leftIndex;
    }

    /**
     * Set the left index
     * @param leftIndex
     */
    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    /**
     * Get the right index
     * @return rightIndex
     */
    public int getRightIndex() {
        return rightIndex;
    }

    /**
     * Set the right index
     * @param rightIndex
     */
    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

}
