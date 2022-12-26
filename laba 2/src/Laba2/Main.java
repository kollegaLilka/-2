package Laba2;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

@SuppressWarnings("serial")
class Main extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;

    public Main() throws Exception {
        super("Вычисление значения функции");

        setSize(WIDTH, HEIGHT);

        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);

        JTextField textPar = new JTextField("0", 5);

        textPar.setMaximumSize(
                new Dimension(2 * textPar.getPreferredSize().width,
                        textPar.getPreferredSize().height));

        Box hboxParValue = Box.createHorizontalBox();

        hboxParValue.add(Box.createHorizontalGlue());
        hboxParValue.add(new JLabel("P:"));
        hboxParValue.add(Box.createHorizontalStrut(10));
        hboxParValue.add(textPar);
        hboxParValue.add(Box.createHorizontalStrut(10));

        JButton Plus = new JButton("+");
        Plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {

                    Double P = Double.parseDouble(textPar.getText());
                    textPar.setText(Double.toString(P + 1));
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(),
                            "Ошибка!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        hboxParValue.add(Plus);
        hboxParValue.add(Box.createHorizontalStrut(10));

        JButton Minus = new JButton("-");
        Minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {

                    Double P = Double.parseDouble(textPar.getText());
                    textPar.setText(Double.toString(P - 1));
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(),
                            "Ошибка!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        hboxParValue.add(Minus);
        hboxParValue.add(Box.createHorizontalGlue());

        Box Func = Box.createHorizontalBox();
        Func.add(Box.createHorizontalGlue());
        Func.add(new JLabel("Формула f(x) = Х-Р"));
        Func.add(Box.createHorizontalGlue());

        JTextField textFieldX = new JTextField("", 5);

        textFieldX.setMaximumSize(
                new Dimension(2 * textFieldX.getPreferredSize().width,
                        textFieldX.getPreferredSize().height));

        JLabel labelY = new JLabel("");
        labelY.setMinimumSize(textFieldX.getMaximumSize());
        labelY.setPreferredSize(textFieldX.getPreferredSize());

        Box hboxXValue = Box.createHorizontalBox();

        hboxXValue.add(Box.createHorizontalGlue());
        hboxXValue.add(new JLabel("X:"));
        hboxXValue.add(Box.createHorizontalStrut(10));
        hboxXValue.add(textFieldX);
        hboxXValue.add(Box.createHorizontalGlue());

        hboxXValue.setMaximumSize(
                new Dimension(hboxXValue.getMaximumSize().width,
                        hboxXValue.getPreferredSize().height));


        Box hboxYValue = Box.createHorizontalBox();
        hboxYValue.add(Box.createHorizontalGlue());
        hboxYValue.add(new JLabel("Y:"));
        hboxYValue.add(Box.createHorizontalStrut(10));
        // Добавить метку для вывода значения Y
        hboxYValue.add(labelY);
        hboxYValue.add(Box.createHorizontalGlue());

        hboxYValue.setMaximumSize(
                new Dimension(hboxYValue.getMaximumSize().width,
                        hboxYValue.getPreferredSize().height));
        JButton Test = new JButton("Test");
        Test.setAlignmentX(CENTER_ALIGNMENT);

        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.setAlignmentX(CENTER_ALIGNMENT);

        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {

                    Double X = Double.parseDouble(textFieldX.getText());
                    Double P = Double.parseDouble(textPar.getText());
                    labelY.setText(Double.toString(X - P));

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(),
                            "Ошибка!!", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        Box vboxParam = Box.createVerticalBox();
        vboxParam.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(Color.green, Color.green),
                "Параметры функции:"));
        vboxParam.add(Box.createVerticalGlue());
        vboxParam.add(hboxParValue);
        vboxParam.add(Box.createVerticalStrut(30));
        vboxParam.add(Func);
        vboxParam.add(Box.createVerticalStrut(30));

        vboxParam.add(Box.createVerticalGlue());

        vboxParam.setMaximumSize(new Dimension(vboxParam.getMaximumSize().width, 100));
        getContentPane().add(vboxParam);
        Box Knop = Box.createHorizontalBox();
        Knop.add(Box.createHorizontalGlue());
        Knop.add(buttonCalc);
        Knop.add(Box.createHorizontalStrut(10));
        Knop.add(Test);
        Knop.add(Box.createHorizontalStrut(10));
        Knop.add(Box.createHorizontalGlue());

        Box vboxCalculator = Box.createVerticalBox();

        vboxCalculator.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(Color.red, Color.red),
                "Расчет значения функции:"));
        vboxCalculator.add(Box.createVerticalGlue());
        vboxCalculator.add(hboxXValue);
        vboxCalculator.add(Box.createVerticalStrut(50));
        vboxCalculator.add(hboxYValue);
        vboxCalculator.add(Box.createVerticalStrut(10));
        vboxCalculator.add(Knop);
        vboxCalculator.add(Box.createVerticalGlue());
        getContentPane().add(vboxCalculator);

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    }



    public static void main(String[] args) throws Exception {


        Main frame = new Main();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
