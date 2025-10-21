import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField display_256;
    JPanel panel_256;
    String operator_256;
    double num1_256, num2_256;

    Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display_256 = new JTextField();
        add(display_256, BorderLayout.NORTH);

        panel_256 = new JPanel(new GridLayout(4, 4));
        String[] buttons_256 = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "=", "C", "/"
        };
        for (String text_256 : buttons_256) {
            JButton b_256 = new JButton(text_256);
            panel_256.add(b_256);
            b_256.addActionListener(this);
        }
        add(panel_256, BorderLayout.CENTER);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd_256 = e.getActionCommand();
        if ("0123456789".contains(cmd_256)) {
            display_256.setText(display_256.getText() + cmd_256);
        } else if ("+-*/".contains(cmd_256)) {
            num1_256 = Double.parseDouble(display_256.getText());
            operator_256 = cmd_256;
            display_256.setText("");
        } else if (cmd_256.equals("=")) {
            num2_256 = Double.parseDouble(display_256.getText());
            double result_256 = 0;
            switch (operator_256) {
                case "+": result_256 = num1_256 + num2_256; break;
                case "-": result_256 = num1_256 - num2_256; break;
                case "*": result_256 = num1_256 * num2_256; break;
                case "/": result_256 = num1_256 / num2_256; break;
            }
            display_256.setText("" + result_256);
        } else if (cmd_256.equals("C")) {
            display_256.setText("");
            num1_256 = num2_256 = 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
