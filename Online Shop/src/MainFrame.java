import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.stream.events.StartDocument;

import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame{

    public ImageIcon bg;
    public JLabel bglabel;
    public JFrame admin;


    MainFrame(){


        bg = new ImageIcon("Sakura.gif");
        bglabel = new JLabel(bg);
        bglabel.setSize(1300, 900);


        admin = new JFrame();
        admin.add(bglabel);
        admin.setLayout(new FlowLayout());
        admin.setTitle("NAOIMISE");
        admin.setDefaultCloseOperation(EXIT_ON_CLOSE);
        admin.setSize(1300, 900);
        admin.setLocationRelativeTo(null);
        admin.setVisible(true);
        admin.setResizable(false);
        admin.setContentPane( new MainFrame("Sakura.gif"));
       


    }public void paintComponent(Graphics g){




    }









    
 }


        
    


     
        







       










    



    
    

