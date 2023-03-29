package Java2.lesson4;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowClient extends JFrame {
    ChatClient echoClient;
    TextArea textArea;

    public WindowClient() {
        echoClient=new ChatClient(this);

        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(450, 250, 550, 430);
        EmptyBorder border = new EmptyBorder(2, 4, 4, 4);

        JPanel panelX = new JPanel(new BorderLayout());
        add(panelX);

        JPanel panel = new JPanel(new GridLayout());
        panelX.add(panel);

        JPanel panel1 = new JPanel(new BorderLayout());
        panelX.add(panel1, BorderLayout.SOUTH);

        textArea = new TextArea();
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

        textField.addActionListener(actionEvent -> eventSend(textArea, textField));
        button.addActionListener(actionEvent -> eventSend(textArea, textField));

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
              echoClient.sendMessage(ChatServer.getEND());
                e.getWindow().dispose();
            }
        });
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
        private void eventSend(TextArea textArea, TextField textField) {
            String msg = textField.getText();
            if (!msg.isEmpty()) {
                echoClient.sendMessage(msg.trim());
                if (textArea.getText().isEmpty()) {
                    textArea.setText(msg);
                    textField.setText(null);
                } else {
                    textArea.setText(textArea.getText() + "\n" + msg);
                    textField.setText(null);
                }
            }
        }

        public void addMessage(String msg) {
            if (!msg.isEmpty()) {
                if (textArea.getText().isEmpty()) {
                    textArea.setText(msg);
                } else {
                    textArea.setText(textArea.getText() + "\n" + msg);
                }
            }
        }
}
