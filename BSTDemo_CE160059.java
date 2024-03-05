package bstdemo_ce160059;

/**
 *
 * @author CE160059 Le Ha Phuong Uyen
 */
public class BSTDemo_CE160059 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BSTree tree = new BSTree();

        tree.addNode(15);
        tree.addNode(12);
        tree.addNode(27);
        tree.addNode(5);
        tree.addNode(13);
        tree.addNode(19);
        tree.addNode(36);
        tree.addNode(11);
        tree.addNode(14);
        tree.addNode(22);
        tree.addNode(33);
        tree.addNode(48);
        tree.addNode(25);
        tree.addNode(28);

        System.out.print("Pre-order: ");
        tree.preOrder();
        System.out.print("In-order: ");
        tree.inOrder();
        System.out.print("Post-order: ");
        tree.postOrder();
        System.out.println("");

    }

}
