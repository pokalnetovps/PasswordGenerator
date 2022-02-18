package app;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;

public class Form extends JFrame {
    PasswordGenerator pass = new PasswordGenerator(8);
    public JTextArea area0 = new JTextArea(pass.getNewPass());

    public Form() {

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int widthSc = gd.getDisplayMode().getWidth();
        int heigthSc = gd.getDisplayMode().getHeight();
        setTitle("Генератор пароля");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds((widthSc - 350) / 2, (heigthSc - 130) / 2, 350, 130);
        setLayout(null);
        JButton bt0 = new JButton("Новый пароль");
        JButton bt1 = new JButton("Скопировать");
        area0.setBounds(10, 10, 310, 40);
        area0.setEditable(false);
        area0.setFont(new Font("Courier", Font.BOLD, 24));
        bt0.setBounds(10, 60, 150, 20);
        bt1.setBounds(170, 60, 150, 20);
        add(bt0);
        add(bt1);
        add(area0);


        MyActions listener = new MyActions();
        bt0.addActionListener(listener);
        bt1.addActionListener(listener);


        setAlwaysOnTop(true);
        setResizable(false);
        setVisible(true);
    }

    public class MyActions implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand() == "Новый пароль") {
                area0.setText(pass.getNewPass());
            }
            if (e.getActionCommand() == "Скопировать") {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                String str = area0.getText();
                StringSelection selection = new StringSelection(str);
                clipboard.setContents(selection, selection);
            }
        }
    }

}

