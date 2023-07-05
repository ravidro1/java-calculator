import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numbersButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,multiplyButton,divideButton;
    JButton decimalButton,equalButton,clearButton,deleteButton;
    JPanel panel;

    Font font = new Font("ink free",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;

    public Calculator(){
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10 ,10));
//        panel.setBackground(Color.GRAY);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
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

        clearButton.setBounds(50,430,145,50);
        deleteButton.setBounds(205,430,145,50);




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


        frame.add(panel);
        frame.add(clearButton);
        frame.add(deleteButton);
        frame.add(textField);

        frame.setVisible((true));

    }




    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++)
            if(e.getSource()==numbersButtons[i])
                textField.setText((textField.getText()).concat(String.valueOf(i)));

//        if(e.getSource() == decimalButton)
//            textField.setText((textField.getText()).concat(".");

    }


}
