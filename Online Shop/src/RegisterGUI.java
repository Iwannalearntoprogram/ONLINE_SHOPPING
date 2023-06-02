import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RegisterGUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("Register Username");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Register Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Register");
        button.setBounds(10, 80, 100, 25);
        button.addActionListener(new RegisterGUI());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = new String(passwordText.getPassword());

        if (user.isEmpty() || password.isEmpty()) {
            success.setText("Please enter a username and password.");
            return;
        }

        // Register the user
        boolean isRegistered = registerUser(user, password);

        if (isRegistered) {
            success.setText("Registration successful!");

            // Encrypt and save email and password
            String encryptedEmail = encryptText(user);
            String encryptedPassword = encryptText(password);
            saveToFile(encryptedEmail, encryptedPassword);

            JOptionPane.showMessageDialog(null, "Registration successful!.");
        } 
        
        
        else {
            success.setText("Registration failed!");
            JOptionPane.showMessageDialog(null, "Registration failed! Please try again.");
        }
    }

		//User registration (still lacks some functions(especially main function that connects to Login Page))
    public boolean registerUser(String user, String password) {
    
        return !user.isEmpty() && !password.isEmpty();
    }

    public String encryptText(String inputText) {
        return new StringBuilder(inputText).toString();
    }

	//Encryption to TextFile (Don't make this public so it can't be accessed)

    private void saveToFile(String encryptedEmail, String encryptedPassword) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_data.txt",true));
            writer.write("Email: " + encryptedEmail);
            writer.write(" Password: " + encryptedPassword + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
