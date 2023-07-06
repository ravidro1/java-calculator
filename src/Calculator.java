import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numbersButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, multiplyButton, divideButton;
    JButton decimalButton, equalButton, clearButton, deleteButton;
    JPanel panel;
    JPanel textPanel;
    JLabel label;

    Font font = new Font("Arial", Font.BOLD, 30);

    double result = 0;
    Double num1 = null, num2 = null;
    Character operator;

    public Calculator() {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
//        panel.setBackground(Color.GRAY);

        label = new JLabel();
        label.setBounds(50, -10, 300, 50);

//        label.set

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("Clear");
        deleteButton = new JButton("Delete");
        decimalButton = new JButton(".");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = equalButton;
        functionButtons[5] = clearButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = decimalButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numbersButtons[i] = new JButton(String.valueOf(i));
            numbersButtons[i].addActionListener(this);
            numbersButtons[i].setFont(font);
            numbersButtons[i].setFocusable(false);
        }

        clearButton.setBounds(50, 430, 145, 50);
        deleteButton.setBounds(205, 430, 145, 50);


        panel.add(numbersButtons[1]);
        panel.add(numbersButtons[2]);
        panel.add(numbersButtons[3]);
        panel.add(addButton);
        panel.add(numbersButtons[4]);
        panel.add(numbersButtons[5]);
        panel.add(numbersButtons[6]);
        panel.add(subButton);
        panel.add(numbersButtons[7]);
        panel.add(numbersButtons[8]);
        panel.add(numbersButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numbersButtons[0]);
        panel.add(equalButton);
        panel.add(divideButton);


        frame.add(label);
        frame.add(panel);
        frame.add(clearButton);
        frame.add(deleteButton);
        frame.add(textField);

        frame.setVisible((true));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++)
            if (e.getSource() == numbersButtons[i])
                textField.setText((textField.getText()).concat(String.valueOf(i)));


        if (e.getSource() == decimalButton && !textField.getText().isEmpty() && !textField.getText().contains(".")) {
            textField.setText((textField.getText()).concat("."));
        }


        boolean operatorCondition = !textField.getText().isEmpty() && num1 == null;

        if (e.getSource() == addButton && operatorCondition) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            label.setText(textField.getText() + " " + '+');
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            if (textField.getText().isEmpty()) {
                textField.setText("-");
                return;
            } else if (textField.getText().matches(".*[0-9].*")) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                label.setText(textField.getText() + " " + '-');
                textField.setText("");
            }
        }

        if (e.getSource() == multiplyButton && operatorCondition) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            label.setText(textField.getText() + " " + '*');
            textField.setText("");
        }

        if (e.getSource() == divideButton && operatorCondition) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            label.setText(textField.getText() + " " + '/');
            textField.setText("");
        }

        if (e.getSource() == equalButton) {
            if (!textField.getText().isEmpty())
                num2 = Double.parseDouble(textField.getText());

            if (num1 == null || num2 == null || operator == null) return;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            if (result % 1 == 0)
                textField.setText(String.valueOf((int) result));
            else
                textField.setText(String.valueOf(result));


            num1 = null;
            num2 = null;
            operator = null;
            label.setText("");
        }

        if (e.getSource() == clearButton) {
            textField.setText("");
            label.setText("");
            num1 = null;
            num2 = null;
            operator = null;
        }

        if (e.getSource() == deleteButton) {
            String textFieldData = textField.getText();
            textField.setText("");

            for (int i = 0; i < textFieldData.length() - 1; i++) {
                textField.setText(textField.getText() + textFieldData.charAt(i));
            }
        }

    }


}
