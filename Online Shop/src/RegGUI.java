import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegGUI extends JFrame {

    private JTextField t1, t2;
    private JButton b1;
    private JLabel username, password;

    // Register method
    RegGUI() {
        setLayout(null);

        username = new JLabel("Username");
        username.setBounds(10, 20, 80, 25);
        password = new JLabel("Password");
        password.setBounds(10, 65, 80, 25);

        t1 = new JTextField(60);
        t2 = new JPasswordField(60);
        b1 = new JButton("Register");

        t1.setBounds(100, 20, 200, 30);
        t2.setBounds(100, 65, 200, 30);
        b1.setBounds(100, 110, 85, 30);

        // Actionlistener for button to register data
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    FileWriter fw = new FileWriter("data.txt", true);
                    fw.write(t1.getText() + "\t" + t2.getText() + "\n");
                    fw.close();
                    Frame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Registered Successfully");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        add(t1);
        add(t2);
        add(b1);
        add(username);
        add(password);
    }
}
