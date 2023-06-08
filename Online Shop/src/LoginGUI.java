import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class LoginGUI implements ActionListener {

	private static JPanel contentPane;
	private static JPanel mainPane;
	private static JButton regButton;
	private static JLabel titleLabel;
    private static CustomTextField userText;
    private static CustomPasswordField passwordText;
    private static JFrame frame;


	public static void main(String[] args) {
        frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 943);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("NAOIMISE");
		
		contentPane = new JPanel(new BorderLayout()) {
	        @Override public void paintComponent(Graphics g) {
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
		

		var buttonSize = new Dimension(300,50);
		
		titleLabel = new JLabel("LOGIN");
		titleLabel.setOpaque(false);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setFont(new Font("joystix monospace", Font.PLAIN, 50));
		
		
		userText = new CustomTextField();
		userText.setAlignmentX(Component.CENTER_ALIGNMENT);
		userText.setLabelText("USERNAME");
		userText.setFont(new Font("joystix monospace", Font.PLAIN, 18));
		userText.setPreferredSize( new Dimension(300,60));
		userText.setMinimumSize(userText.getPreferredSize());
		userText.setMaximumSize(userText.getPreferredSize());

	
		passwordText = new CustomPasswordField();
		passwordText.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordText.setLabelText("PASSWORD");
		passwordText.setFont(new Font("joystix monospace", Font.PLAIN, 18));
		passwordText.setPreferredSize( new Dimension(300,60));
		passwordText.setMinimumSize(userText.getPreferredSize());
		passwordText.setMaximumSize(userText.getPreferredSize());

		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(Box.createVerticalGlue());
		box.add(mainPane);
		box.add(Box.createVerticalGlue());
		
		
		regButton = new CustomButton();
		regButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		regButton.setText("Register");
		regButton.setPreferredSize(buttonSize);
		regButton.setMinimumSize(buttonSize);
		regButton.setMaximumSize(buttonSize);
		
		

       

		mainPane.add(titleLabel);
		mainPane.add(Box.createRigidArea(new Dimension(0,100)));
		mainPane.add(userText);
		mainPane.add(Box.createRigidArea(new Dimension(0,10)));
		mainPane.add(passwordText);
		mainPane.add(Box.createRigidArea(new Dimension(0,100)));
		mainPane.add(regButton);
		
		contentPane.add(box, BorderLayout.CENTER);

		frame.setContentPane(contentPane);
		frame.setVisible(true);
	}

	
	 @Override
	    public void actionPerformed(ActionEvent ae) {
	        boolean matched = false;
	        String user = userText.getText().toString();
	        String password = passwordText.toString();

	        try{
	        FileReader fr = new FileReader("data.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        while((line=br.readLine())!=null){
	            if(line.equals(user+ "\t" + password)){

	                matched = true;
	                break;
	            }
	        }
	        fr.close();
	    }catch(Exception e){}
	        if(matched){

	            frame.dispose();
	            new MainFrame();
	        }
	        else{
	            Frame frame1 = new JFrame();
	                    JOptionPane.showMessageDialog(frame1, "Invalid Username or Password");
	                    frame1.dispose();



	        }
	        
	    }
}