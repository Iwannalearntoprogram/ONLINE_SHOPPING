import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel mainPane;
	private JButton cartButton;
	private JButton breadButton;
	private JLabel titleLabel;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame(); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 943); 
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("NAOIMISE");
		
		contentPane = new JPanel(new BorderLayout()) {
	        @Override public void paintComponent(Graphics g) {
	            try {
					g.drawImage(ImageIO.read(new File("Background.png")), 0, 0, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		mainPane = new JPanel();	
		mainPane.setOpaque(false);
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
		mainPane.setPreferredSize(new Dimension(700,440));
		mainPane.setMinimumSize(mainPane.getPreferredSize());
		mainPane.setMaximumSize(mainPane.getPreferredSize());
		

		titleLabel = new JLabel("NAOIMISE");
		titleLabel.setOpaque(false);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setFont(new Font("joystix monospace", Font.PLAIN, 50));

		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(Box.createVerticalGlue());
		box.add(mainPane);
		box.add(Box.createVerticalGlue());
		
		var buttonSize = new Dimension(200,50);
		
		cartButton = new CustomButton();
		cartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		cartButton.setText("CART");
		cartButton.setPreferredSize(buttonSize);
		cartButton.setMinimumSize(buttonSize);
		cartButton.setMaximumSize(buttonSize);
		
		

        ImageIcon bread = new ImageIcon("Bread.png");
        ImageIcon chocolate = new ImageIcon("Chocolate.png");
        
		breadButton = new CustomButton();
    	breadButton.setIcon(bread);
		breadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		breadButton.setPreferredSize(new Dimension(200,200));
		breadButton.setMinimumSize(breadButton.getPreferredSize());
		breadButton.setMaximumSize(breadButton.getPreferredSize());
		breadButton.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            	breadButton.setIcon(chocolate);
            }
            
            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            	breadButton.setIcon(bread);
            }
        });
            

		mainPane.add(titleLabel);
		mainPane.add(Box.createRigidArea(new Dimension(0,100)));
		mainPane.add(cartButton);
		mainPane.add(Box.createRigidArea(new Dimension(0,20)));
		mainPane.add(breadButton);
		mainPane.add(Box.createRigidArea(new Dimension(0,20)));
		
		contentPane.add(box, BorderLayout.CENTER);

		setContentPane(contentPane);

	
	}

}
