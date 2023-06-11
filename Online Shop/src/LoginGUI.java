import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class LoginGUI implements ActionListener {

    private JPanel contentPane;
    private JPanel mainPane;
    private JButton regButton;
    private JLabel titleLabel;
    private JTextField userText;
    private JPasswordField passwordText;
    private JFrame frame;
    private JButton logButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI();
            }
        });
    }

    public LoginGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 943);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("NAOIMISE");

        contentPane = new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                try {
                    g.drawImage(ImageIO.read(new File("./src/Background.png")), 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        mainPane = new JPanel();
        mainPane.setOpaque(false);
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));

        var buttonSize = new Dimension(300, 50);

        titleLabel = new JLabel("LOGIN");
        titleLabel.setOpaque(false);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("joystix monospace", Font.PLAIN, 50));

        userText = new JTextField();
        userText.setAlignmentX(Component.CENTER_ALIGNMENT);
        userText.setPreferredSize(new Dimension(300, 60));
        userText.setMinimumSize(userText.getPreferredSize());
        userText.setMaximumSize(userText.getPreferredSize());

        passwordText = new JPasswordField();
        passwordText.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordText.setPreferredSize(new Dimension(300, 60));
        passwordText.setMinimumSize(userText.getPreferredSize());
        passwordText.setMaximumSize(userText.getPreferredSize());

        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(Box.createVerticalGlue());
        box.add(mainPane);
        box.add(Box.createVerticalGlue());

        logButton = new JButton("Login");
        logButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logButton.setPreferredSize(buttonSize);
        logButton.setMinimumSize(buttonSize);
        logButton.setMaximumSize(buttonSize);
        logButton.addActionListener(this);

        regButton = new JButton("Register");
        regButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        regButton.setPreferredSize(buttonSize);
        regButton.setMinimumSize(buttonSize);
        regButton.setMaximumSize(buttonSize);
		
        regButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        // Open registration window
        RegGUI register = new RegGUI();
        register.setVisible(true);
    }
});


        mainPane.add(titleLabel);
        mainPane.add(Box.createRigidArea(new Dimension(0, 100)));
        mainPane.add(userText);
        mainPane.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPane.add(passwordText);
        mainPane.add(Box.createRigidArea(new Dimension(0, 100)));
        mainPane.add(regButton);
        mainPane.add(logButton);

        contentPane.add(box, BorderLayout.CENTER);

        frame.setContentPane(contentPane);
        frame.setVisible(true);
    }

   @Override
public void actionPerformed(ActionEvent ae) {
    boolean matched = false;
    String user = userText.getText();
    String password = new String(passwordText.getPassword());

    try {
        FileReader fr = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length == 2 && parts[0].equalsIgnoreCase(user) && parts[1].equals(password)) {
                matched = true;
                break;
            }
        }
        fr.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    if (matched) {
        frame.dispose();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    } else {
        JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
    }
}

}

class MainFrame extends JFrame {

    private JPanel contentPane;
    private JPanel mainPane;
    private JButton cartButton;
    private JButton breadButton;
    private JLabel titleLabel;

    public MainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 943);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("NAOIMISE");
        setVisible(true);

        contentPane = new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                try {
                    g.drawImage(ImageIO.read(new File("./src/Background.png")), 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        mainPane = new JPanel();
        mainPane.setOpaque(false);
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
        mainPane.setPreferredSize(new Dimension(700, 440));
        mainPane.setMinimumSize(mainPane.getPreferredSize());
        mainPane.setMaximumSize(mainPane.getPreferredSize());

        titleLabel = new JLabel("NAOIMISE");
        titleLabel.setOpaque(false);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("joystix monospace", Font.PLAIN, 80));

        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(Box.createVerticalGlue());
        box.add(mainPane);
        box.add(Box.createVerticalGlue());

        var buttonSize = new Dimension(200, 50);

        cartButton = new JButton("CART");
        cartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartButton.setPreferredSize(buttonSize);
        cartButton.setMinimumSize(buttonSize);
        cartButton.setMaximumSize(buttonSize);

        breadButton = new JButton("BREAD");
        breadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        breadButton.setPreferredSize(new Dimension(200, 200));
        breadButton.setMinimumSize(breadButton.getPreferredSize());
        breadButton.setMaximumSize(breadButton.getPreferredSize());

        mainPane.add(titleLabel);
        mainPane.add(Box.createRigidArea(new Dimension(0, 100)));
        mainPane.add(cartButton);
        mainPane.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPane.add(breadButton);
        mainPane.add(Box.createRigidArea(new Dimension(0, 20)));

        contentPane.add(box, BorderLayout.CENTER);

        setContentPane(contentPane);
    }
}