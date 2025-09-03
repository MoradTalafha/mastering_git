import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{

    private JTextField num1;
    private JTextField num2;
    private JTextField operation;
    private JTextField result;
    private JButton calc;
    private JButton exit;

    Calculator(){
        // CREATE FRAME
        setTitle("Calculator");
        setSize(610,400);
        setLocation(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(5,2));
        setBackground(Color.RED);
        

        // CREATE LABELS
        JLabel label1 = new JLabel("Enter the first Number: ");
        JLabel label2 = new JLabel("Enter the second Number: ");
        JLabel label3 = new JLabel("Enter the operation: \n(Symbols only: +,-,*,/)");
        JLabel label4 = new JLabel("The result: ");

        // CREATE TEXT FIELDS
        num1 = new JTextField();
        num2 = new JTextField();
        operation = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        // CREATE BUTTONS
        calc = new JButton("Calc");
        exit = new JButton("Exit");

        //REGISTER THE BUTTONS
        ExitButtonActionListener exitButton = new ExitButtonActionListener();
        exit.addActionListener(exitButton);
        CalculationActionListener calcButton = new CalculationActionListener();
        calc.addActionListener(calcButton);

        //ADD COMPONENTS TO THE FRAME
        this.add(label1);
        this.add(num1);
        this.add(label2);
        this.add(num2);
        this.add(label3);
        this.add(operation);
        this.add(label4);
        this.add(result);
        this.add(calc);
        this.add(exit);
        this.revalidate();

    }
    private class ExitButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    private class CalculationActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){

            double number1 = Double.parseDouble(num1.getText());
            double number2 = Double.parseDouble(num2.getText());
            char sign = operation.getText().charAt(0);
            double answer = 0.0;

            switch(sign){
                case '+' -> answer = number1 + number2;
                case '-' -> answer = number1 - number2;
                case '*' -> answer = number1 * number2;
                case '/' -> {
                    try{
                        answer = number1 / number2;
                    }
                    catch(ArithmeticException exception){
                        exception.getMessage();
                    }
                }
                default -> answer = 0.0;
            }
            result.setText(String.valueOf(answer));
        }
    }
}
