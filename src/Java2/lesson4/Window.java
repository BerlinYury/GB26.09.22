package Java2.lesson4;

import javafx.scene.layout.Background;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Window extends JFrame {
    public Window() {
        setTitle("YurchikChat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(450, 250, 550, 430);
        EmptyBorder border = new EmptyBorder(2, 4, 4, 4);

        JPanel panelX = new JPanel(new BorderLayout());
        add(panelX);

        JPanel panel = new JPanel(new GridLayout());
        panelX.add(panel);

        JPanel panel1 = new JPanel(new BorderLayout());
        panelX.add(panel1, BorderLayout.SOUTH);

        TextArea textArea = new TextArea();
        panel.add(textArea);
        textArea.setEditable(false);
        textArea.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(border);

        TextField textField = new TextField();
        panel1.add(textField);
        textField.setBackground(Color.WHITE);
        panel1.setBorder(border);

        JButton button = new JButton("Send");
        button.setPreferredSize(new Dimension(90, 35));
        panel1.add(button, BorderLayout.EAST);

        setVisible(true);
        textField.requestFocusInWindow();

        textField.addActionListener(actionEvent -> action(textArea, textField));
        button.addActionListener(actionEvent -> action(textArea, textField));
//        ● JButton – кнопка;
//        ● JLabel – надпись;
//        ● JTextField – однострочное текстовое поле;
//        ● JTextArea – многострочное текстовое поле;
//        ● JScrollPane – контейнер для пролистывания контента;
//        ● JMenuBar – верхнее меню программы;
//        ● JTable – таблица;
//        ● JRadioButton – RadioButton;
//        ● JCheckBox – CheckBox.
    }
    private static void action(TextArea textArea, TextField textField) {
        if (textArea.getText().isEmpty()) {
            textArea.setText(textField.getText());
            textField.setText(null);
        } else if (!textField.getText().isEmpty()) {
            textArea.setText(textArea.getText() + "\n" + textField.getText());
            textField.setText(null);
        }
    }

}
