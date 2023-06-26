package src;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdminFrame extends JFrame {
    private JButton addProductButton;
    private JButton addDetailsButton;
    private JButton addPricesButton;
    private int imageCount = 0;

    private List<String> products;
    private List<String> details;
    private List<String> prices;

    private java.net.URL back;

    public AdminFrame() {
        back = getClass().getResource("resources/Background.png");

        // Create the add product button
        addProductButton = new JButton("Add Product");
        addProductButton.setFont(new Font("joystix manospace", Font.PLAIN, 25));
        addProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform add product functionality
                if (imageCount >= 4) {
                    JOptionPane.showMessageDialog(AdminFrame.this,
                            "Maximum limit of 4 PNG pictures reached.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Select PNG Picture");
                    fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));

                    int result = fileChooser.showOpenDialog(AdminFrame.this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        // Logic to handle the selected PNG picture
                        // Here you can implement the code to process the image file
                        // and perform any necessary actions (e.g., saving, displaying, etc.)
                        imageCount++;
                    }
                }
            }
        });

        // Create the add details button
        addDetailsButton = new JButton("Add Details");
        addDetailsButton.setFont(new Font("joystix manospace", Font.PLAIN, 25));
        addDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform add details functionality
                if (products.size() >= 4) {
                    JOptionPane.showMessageDialog(AdminFrame.this,
                            "Maximum limit of 4 products reached.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String product = JOptionPane.showInputDialog(AdminFrame.this, "Enter product name:");
                    if (product != null && !product.trim().isEmpty()) {
                        if (products.contains(product)) {
                            JOptionPane.showMessageDialog(AdminFrame.this,
                                    "Product already exists.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            products.add(product);
                            String detailsInput = JOptionPane.showInputDialog(AdminFrame.this, "Enter details for " + product + ":");
                            if (detailsInput != null && !detailsInput.trim().isEmpty()) {
                                details.add(detailsInput);
                            }
                        }
                    }
                }
            }
        });

        // Create the add prices button
        addPricesButton = new JButton("Add Prices");
        addPricesButton.setFont(new Font("joystix manospace", Font.PLAIN, 25));
        addPricesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform add prices functionality
                if (products.size() >= 4) {
                    JOptionPane.showMessageDialog(AdminFrame.this,
                            "Maximum limit of 4 products reached.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String product = JOptionPane.showInputDialog(AdminFrame.this, "Enter product name:");
                    if (product != null && !product.trim().isEmpty()) {
                        if (products.contains(product)) {
                            JOptionPane.showMessageDialog(AdminFrame.this,
                                    "Product already exists.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            products.add(product);
                            String pricesInput = JOptionPane.showInputDialog(AdminFrame.this, "Enter prices for " + product + ":");
                            if (pricesInput != null && !pricesInput.trim().isEmpty()) {
                                prices.add(pricesInput);
                            }
                        }
                    }
                }
            }
        });

        // Initialize lists to store products, details, and prices
        products = new ArrayList<>();
        details = new ArrayList<>();
        prices = new ArrayList<>();

        // Set the properties for the frame
        setTitle("Admin Panel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 943);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create a panel to hold the buttons with GridBagLayout
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        // Add the buttons to the panel with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(addProductButton, gbc);

        gbc.gridy = 1;
        buttonPanel.add(addDetailsButton, gbc);

        gbc.gridy = 2;
        buttonPanel.add(addPricesButton, gbc);

        // Create a panel to hold the welcome message
        JPanel welcomePanel = new JPanel();
        welcomePanel.setOpaque(false);
        JLabel welcomeLabel = new JLabel("Welcome Master");
        welcomeLabel.setFont(new Font("joystix manospace", Font.BOLD, 40));
        welcomePanel.add(welcomeLabel);

        // Create a panel to hold both the buttons and welcome message panels
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        mainPanel.add(welcomePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Set the content pane and set the background image
        setContentPane(new JLabel(new ImageIcon(back)));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminFrame();
    }
}

