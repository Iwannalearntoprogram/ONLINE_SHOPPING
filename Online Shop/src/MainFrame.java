import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends JFrame {

    private JPanel contentPane; 
    private JPanel mainPane; 
    private JButton cartButton; 
    private JButton breadButton; 
    private JButton chocolateButton; 
    private JLabel titleLabel; 
    private JButton deliveryButton; 

    public MainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 943);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("NAOIMISE");

        contentPane = new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                try {
                    g.drawImage(ImageIO.read(new File("Background.png")), 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Create the main panel
        mainPane = new JPanel();
        mainPane.setOpaque(false);
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));


        // Create the title label
        titleLabel = new JLabel("NAOIMISE"); 
        titleLabel.setOpaque(false);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("joystix monospace.otf", Font.PLAIN, 50));

        //For cart button
        cartButton = new JButton("CART"); 
        cartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        Dimension buttonSize = new Dimension(100, 100);
        cartButton.setPreferredSize(buttonSize);
        cartButton.setMinimumSize(buttonSize);
        cartButton.setMaximumSize(buttonSize);

        ImageIcon bread = new ImageIcon("Bread.png"); 
        ImageIcon chocolate = new ImageIcon("Chocolate.png"); 

        Dimension buttonSize1 = new Dimension(150, 118);
        
        //For bread button 
        breadButton = new JButton(); 
        breadButton.setIcon(bread);
        breadButton.setPreferredSize(buttonSize1);
        breadButton.setMinimumSize(buttonSize1);
        breadButton.setMaximumSize(buttonSize1);

        Dimension buttonSize2 = new Dimension(150, 118);
       
        //For chocolate button
        chocolateButton = new JButton(); 
        chocolateButton.setIcon(chocolate);
        chocolateButton.setPreferredSize(buttonSize2);
        chocolateButton.setMinimumSize(buttonSize2);
        chocolateButton.setMaximumSize(buttonSize2);

        Dimension buttonSizeBread = new Dimension(50, 40);

        //PLus button for bread
        JButton plusButtonBread = new JButton("-"); 
        plusButtonBread.setPreferredSize(buttonSizeBread);
        plusButtonBread.setMinimumSize(buttonSizeBread);
        plusButtonBread.setMaximumSize(buttonSizeBread);

        //Minus button for bread
        JButton minusButtonBread = new JButton("+"); 
        minusButtonBread.setPreferredSize(buttonSizeBread);
        minusButtonBread.setMinimumSize(buttonSizeBread);
        minusButtonBread.setMaximumSize(buttonSizeBread);

        //Plus button for chocolate
        JButton plusButtonChocolate = new JButton("-"); 
        plusButtonChocolate.setPreferredSize(buttonSizeBread);
        plusButtonChocolate.setMinimumSize(buttonSizeBread);
        plusButtonChocolate.setMaximumSize(buttonSizeBread);

        //Minus button for chocolate
        JButton minusButtonChocolate = new JButton("+"); 
        minusButtonChocolate.setPreferredSize(buttonSizeBread);
        minusButtonChocolate.setMinimumSize(buttonSizeBread);
        minusButtonChocolate.setMaximumSize(buttonSizeBread);


        // Create the panel for bread
        JPanel breadPanel = new JPanel(); 
        breadPanel.setOpaque(false);
        breadPanel.setLayout(new BoxLayout(breadPanel, BoxLayout.X_AXIS));
        // Add the bread button
        breadPanel.add(breadButton); 
        breadPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        // Add the minus button for bread
        breadPanel.add(plusButtonBread); 
        // Add the minus button for bread
        breadPanel.add(minusButtonBread); 

        // Create the panel for chocolate
        JPanel chocolatePanel = new JPanel(); 
        chocolatePanel.setOpaque(false);
        chocolatePanel.setLayout(new BoxLayout(chocolatePanel, BoxLayout.X_AXIS));
        //Add the chocolate button
        chocolatePanel.add(chocolateButton); 
        chocolatePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        //add the plus button for chocolate
        chocolatePanel.add(plusButtonChocolate); 
        //Add the minus button for chocolate
        chocolatePanel.add(minusButtonChocolate); 

        //Deliver button
        deliveryButton = new JButton("DELIVER"); 
        deliveryButton.setPreferredSize(new Dimension(100, 30));
        deliveryButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        deliveryButton.setOpaque(false);
        deliveryButton.setContentAreaFilled(true);
        deliveryButton.setBorderPainted(true);

        //Creating top panel
        JPanel topPanel = new JPanel(); 
        topPanel.setOpaque(false);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(deliveryButton); 

        mainPane.add(Box.createVerticalGlue());
        // Add the top panel
        mainPane.add(topPanel); 
        mainPane.add(Box.createVerticalStrut(50));
        // Add the top panel
        mainPane.add(titleLabel); 
        mainPane.add(Box.createVerticalStrut(50));
        // Add the cart button
        mainPane.add(cartButton); 
        mainPane.add(Box.createVerticalStrut(50));
        // Add the bread panel
        mainPane.add(breadPanel); 
        mainPane.add(Box.createVerticalStrut(10));
        // Add the chocolate panel
        mainPane.add(chocolatePanel); 
        mainPane.add(Box.createVerticalStrut(50));
        mainPane.add(Box.createVerticalGlue());

        contentPane.add(mainPane, BorderLayout.CENTER);

        setContentPane(contentPane);
    }
}
