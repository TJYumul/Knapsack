import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Knapsackk implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTable table = new JTable();
    JScrollPane sp = new JScrollPane();
    JLabel label = new JLabel();
    private int weightGross;

    public Knapsackk(int weightGross) {
        this.weightGross = weightGross;

        this.panel.setBackground(new Color(232, 196, 196));
        this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        this.panel.setLayout((LayoutManager) null);

        this.frame.setDefaultCloseOperation(3);
        this.frame.setTitle("2ndPage");
        this.frame.add(this.panel, "Center");
        this.frame.setResizable(false);
        this.frame.setSize(600, 600);

        // Prompt user to input data for each product
        String[][] data = new String[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = JOptionPane.showInputDialog("Enter data for product " + (i + 1) + ", field " + (j + 1));
            }
        }

        String[] column = {"Product Name", "Weight/box", "Amount"};

        // Initialize weights and values arrays
        double[] weights = new double[4];
        int[] values = new int[4];
        for (int i = 0; i < 4; i++) {
            weights[i] = Double.parseDouble(data[i][1]); // Convert weight string to double
            values[i] = Integer.parseInt(data[i][2]); // Convert amount string to integer
        }

        // Calculate total amount using knapsack algorithm
        double totalAmount = calculateTotalAmount(weightGross, weights, values);

        label = new JLabel("Total Amount: " + String.valueOf(totalAmount));
        label.setBounds(30, 135, 200, 25);

        table = new JTable(data, column);
        table.setBounds(30, 40, 540, 150); // location to window

        sp = new JScrollPane(table);
        sp.setBounds(30, 40, 540, 88); // Adjusted bounds to fit the panel
        this.panel.add(sp);
        this.panel.add(label);
        this.frame.add(this.panel); // Added panel to the frame
        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    }

    public double calculateTotalAmount(int weightLimit, double[] weights, int[] values) {
        int n = weights.length;
        int[] dp = new int[weightLimit + 1];

        for (int i = 0; i < n; i++) {
            for (int j = weightLimit; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[(int) (j - weights[i])] + values[i]);
            }
        }

        return dp[weightLimit];
    }

    public static void main(String[] args) {
        Knapsackk knapsackk = new Knapsackk(20); // Adjust weightGross as per requirement
    }
}
