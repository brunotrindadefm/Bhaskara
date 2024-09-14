import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen extends JFrame implements ActionListener {

    JTextField textFieldA;
    JTextField textFieldB;
    JTextField textFieldC;
    JLabel deltaLabel;
    JLabel bhaskaraLabel;
    JLabel resultLabel;

    public Screen() {

        setTitle("Tela para calcular delta e fórmula de bhaskara!");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel titleLabel = new JLabel("Calculadora de equações de 2 grau");
        titleLabel.setBounds(200, 10, 500, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 23));
        add(titleLabel);

        JLabel formulaLabel = new JLabel("Fórmula de bhaskara");
        formulaLabel.setBounds(313, 40, 500, 30);
        formulaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(formulaLabel);

        textFieldA = new JTextField();
        textFieldA.setBounds(183, 150, 150, 30);
        textFieldA.setFont(new Font("Arial", Font.BOLD, 15));
        add(textFieldA);

        textFieldB = new JTextField();
        textFieldB.setBounds(183, 200, 150, 30);
        textFieldB.setFont(new Font("Arial", Font.BOLD, 15));
        add(textFieldB);

        textFieldC = new JTextField();
        textFieldC.setBounds(183, 250, 150, 30);
        textFieldC.setFont(new Font("Arial", Font.BOLD, 15));
        add(textFieldC);
 
        JLabel labelA = new JLabel("a");
        labelA.setBounds(153, 150, 50, 30);
        labelA.setFont(new Font("Arial", Font.BOLD, 15));
        add(labelA);

        JLabel labelB = new JLabel("b");
        labelB.setBounds(153, 200, 50, 30);
        labelB.setFont(new Font("Arial", Font.BOLD, 15));
        add(labelB);

        JLabel labelC = new JLabel("c");
        labelC.setBounds(153, 250, 50, 30);
        labelC.setFont(new Font("Arial", Font.BOLD, 15));
        add(labelC);

        JButton calculateButton = new JButton("Calcular");
        calculateButton.setBounds(180, 300, 150, 40);
        calculateButton.setFont(new Font("Arial", Font.BOLD, 15));
        calculateButton.setForeground(new Color(237, 241, 238));
        calculateButton.setBackground(new Color(2, 2, 2));
        add(calculateButton);
        
        calculateButton.addActionListener(this);

        deltaLabel = new JLabel(); 
        deltaLabel.setBounds(480, 150, 300, 30);
        deltaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(deltaLabel);

        bhaskaraLabel = new JLabel(); 
        bhaskaraLabel.setBounds(475, 185, 500, 100);
        bhaskaraLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bhaskaraLabel.setText("<html></html>");
        add(bhaskaraLabel);

        resultLabel = new JLabel(); 
        resultLabel.setBounds(490, 260, 300, 100);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultLabel.setText("<html></html>");
        add(resultLabel);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            int numberA = Integer.parseInt(textFieldA.getText());
            int numberB = Integer.parseInt(textFieldB.getText());
            int numberC = Integer.parseInt(textFieldC.getText());

            double delta = (numberB * numberB) - (4 * numberA * numberC);

            deltaLabel.setText("O delta é: " + delta);
            revalidate();
            repaint();

            if (delta > 0) {

                double sqrtDelta = Math.sqrt(delta);
                double x1 = (-numberB + sqrtDelta) / (2 * numberA);
                double x2 = (-numberB - sqrtDelta) / (2 * numberA);

                bhaskaraLabel.setText("<html>A equação tem<br>duas raízes<br>reais e distintas.</html>");
                resultLabel.setText(String.format("<html>x1 = %.2f,<br>x2 = %.2f</html>", x1, x2));

            } else if (delta == 0) {
                double x1 = -numberB / (2 * numberA);
                bhaskaraLabel.setText("<html>A equação tem<br>uma raiz<br>real e dupla.</html>");
                resultLabel.setText(String.format("x = %.2f", x1));

            } else {
                bhaskaraLabel.setText("Não há raízes reais.");
                resultLabel.setText("");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, insira números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
