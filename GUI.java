import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JComboBox cb;
    private JLabel label;
    Integer weightGross = 0;
    String cbItem = "";

    public GUI() {

        Integer[] weight = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        ImageIcon icon = new ImageIcon("logo.png");

        label = new JLabel();
        label.setIcon(icon);
        label.setSize(60,80);
        label.setText("Choose Weight: ");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setBounds(145,140,100,25);

        cb = new JComboBox(weight);
        cb.setBounds(240,140,50,25);
        cb.addActionListener(this);


        button = new JButton("Enter");
        button.setBounds(150,175,90, 50);
        button.addActionListener(this);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(null);
        panel.add(label, BorderLayout.CENTER);
        panel.add(cb);
        panel.add(button);

        frame = new JFrame();
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("tryGui");
        frame.setResizable(false);
        frame.setSize(420,420);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

            weightGross = (Integer) cb.getSelectedItem();

         // when the user choose weight it will stored in weight gross

        if(e.getSource() == button){
            frame.dispose();
            label.setText("Weight: " + cb.getSelectedItem());

            Knapsackk newWindow = new Knapsackk(weightGross);
        }
    }
}