package bstdemo_ce160059;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author CE160059 Le Ha Phuong Uyen
 */
public class BSTPaper extends JPanel {

    /**
     * variable for the radius of node when drawing
     */
    public static final int NODE_RADIUS = 20;

    /**
     * variable for the font size of node when drawing
     */
    public static final int FONT_SIZE = 20;
    BSTree tree;
    int screenWidth;
    int yMin;

    Graphics2D g;

    /**
     * Constructor 
     * @param tree
     * @param screenWidth
     * @param yMin
     */
    public BSTPaper(BSTree tree, int screenWidth, int yMin) {
        this.tree = tree;
        this.screenWidth = screenWidth;
        this.yMin = yMin;
    }

    /**
     * Add a node with given data and draw it
     * @param data
     */
    public void addNode(int data) {
        this.tree.addNode(data);
        repaint();
    }

    /**
     * Delete a former node by remove it and redraw the path
     * @param data
     */
    public void deleteNode(int data) {
        this.tree.removeNode(data);
        this.tree.path.clear();
        repaint();
    }

    /**
     * Determine the position of a node
     * Ex: the root is the center of the field, its children is the center of its left side or right side
     * @param g
     * @param text
     * @param rect
     * @param font
     */
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }

    /**
     * Draw a node in the form 
     * @param node
     */
    public void drawNode(BSTNode node) {
        if (node == null) {
            return;
        }

        int x = node.getX();
        int y = node.getY();

        g.setColor(Color.black);
        // draw left child link
        if (node.hasLeftChild()) {
            g.drawLine(x, y, node.getLeftChild().getX(), node.getLeftChild().getY());
        }

        // draw right child link
        if (node.hasRightChild()) {
            g.drawLine(x, y, node.getRightChild().getX(), node.getRightChild().getY());
        }

        // fill the node
        g.setColor(Color.white);
        g.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);

        // draw outline 
        g.setColor(Color.black);
        g.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);

        //display data inside the circle of the node
        drawCenteredString(g, node.getData() + "", new Rectangle(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2), new Font("Cambria", Font.PLAIN, FONT_SIZE));

        //display count label below the node
        drawCenteredString(g, "c=" + node.getCount() + "", new Rectangle(x - NODE_RADIUS, y + NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2), new Font("Cambria", Font.PLAIN, FONT_SIZE));

        drawNode(node.getLeftChild());
        drawNode(node.getRightChild());
    }

    /**
     * Draw a path from the root to the finding node, using when finding a node
     */
    public void drawPath() {
        repaint();
    }

    @Override
    public void paint(Graphics graph) {
        super.paint(graph);
        this.g = (Graphics2D) graph;
        drawNode(this.tree.getRoot());

        ArrayList<BSTNode> path = this.tree.getPath();

        if (path != null) {
            //draw line
            BSTNode n1, n2;
            g.setColor(Color.red);
            for (int i = 1; i < path.size(); ++i) {
                n1 = path.get(i - 1);
                n2 = path.get(i);
                g.drawLine(n1.getX(), n1.getY(), n2.getX(), n2.getY());

            }
            //draw node
            int x, y;
            for (int i = 0; i < path.size(); ++i) {
                n1 = path.get(i);
                x = n1.getX();
                y = n1.getY();
                // fill the node
                g.setColor(Color.yellow);
                g.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);

                // draw outline 
                g.setColor(Color.red);
                g.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);

                //display data inside the circle of the node
                drawCenteredString(g, n1.getData() + "", new Rectangle(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2), new Font("Cambria", Font.PLAIN, FONT_SIZE));

                //display count label below the node
                drawCenteredString(g, "c=" + n1.getCount() + "", new Rectangle(x - NODE_RADIUS, y + NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2), new Font("Cambria", Font.PLAIN, FONT_SIZE));
            }
        }
    }

    /**
     * Clear a tree
     */
    public void clear() {
        this.tree.clear();
        repaint();
    }

    /**
     * Balancing a former tree
     */
    public void balancing() {
        this.tree.balancing();
        repaint();
    }

}
