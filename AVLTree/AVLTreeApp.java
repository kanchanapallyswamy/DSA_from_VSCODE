import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// AVL Tree Node
class BST {
    int data, height;
    BST left, right;

    public BST(int data) {
        this.data = data;
        this.height = 1;
    }
}

// AVL Tree Operations
class Solution {
    public BST insert(BST root, int data) {
        if (root == null) return new BST(data);
        if (data < root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        
        updateHeight(root);
        return balance(root);
    }

    public BST remove(BST root, int data) {
        if (root == null) return null;
        
        if (data < root.data) {
            root.left = remove(root.left, data);
        } else if (data > root.data) {
            root.right = remove(root.right, data);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            BST minNode = findMin(root.right);
            root.data = minNode.data;
            root.right = remove(root.right, minNode.data);
        }
        
        updateHeight(root);
        return balance(root);
    }

    private BST findMin(BST node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private void updateHeight(BST node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(BST node) {
        return node == null ? 0 : node.height;
    }

    public int getBalance(BST node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private BST balance(BST node) {
        int balance = getBalance(node);
        if (balance > 1) {
            if (getBalance(node.left) < 0) node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1) {
            if (getBalance(node.right) > 0) node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private BST leftRotate(BST z) {
        BST y = z.right;
        z.right = y.left;
        y.left = z;
        updateHeight(z);
        updateHeight(y);
        return y;
    }

    private BST rightRotate(BST z) {
        BST y = z.left;
        z.left = y.right;
        y.right = z;
        updateHeight(z);
        updateHeight(y);
        return y;
    }
}

// GUI for AVL Tree
class AVLTreeGUI extends JPanel {
    private BST root;
    private Solution solution;

    public AVLTreeGUI() {
        solution = new Solution();
    }

    public void insert(int value) {
        root = solution.insert(root, value);
        repaint();
    }

    public void remove(int value) {
        root = solution.remove(root, value);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, getWidth() / 2, 30, root, getWidth() / 4);
        }
    }

    private void drawTree(Graphics g, int x, int y, BST node, int xOffset) {
        if (node == null) return;
    
        // Draw node circle with black border
        g.setColor(Color.BLACK);
        g.fillOval(x - 20, y - 20, 40, 40); // Outer black border
    
        g.setColor(Color.WHITE);
        g.fillOval(x - 18, y - 18, 36, 36); // Inner white fill
    
        // Draw node value
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(node.data), x - 10, y);
    
        // Draw balance factor
        int balanceFactor = solution.getBalance(node);
        g.drawString("(" + balanceFactor + ")", x - 10, y + 15);
    
        // Draw edges to children
        g.setColor(Color.BLACK);
        if (node.left != null) {
            g.drawLine(x, y, x - xOffset, y + 50);
            drawTree(g, x - xOffset, y + 50, node.left, xOffset / 2);
        }
        if (node.right != null) {
            g.drawLine(x, y, x + xOffset, y + 50);
            drawTree(g, x + xOffset, y + 50, node.right, xOffset / 2);
        }
    }
    
}

// Main Application
public class AVLTreeApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AVL Tree Visualization");
        AVLTreeGUI treePanel = new AVLTreeGUI();
        JTextField inputField = new JTextField(5);
        JButton insertButton = new JButton("Insert");
        JButton removeButton = new JButton("Remove");
        JPanel controlPanel = new JPanel();

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(inputField.getText());
                    treePanel.insert(value);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(inputField.getText());
                    treePanel.remove(value);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        controlPanel.add(new JLabel("Value: "));
        controlPanel.add(inputField);
        controlPanel.add(insertButton);
        controlPanel.add(removeButton);

        frame.setLayout(new BorderLayout());
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(treePanel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
