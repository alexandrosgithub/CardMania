import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Menu extends JFrame{
	
	private ImagePanel masterPanel = new ImagePanel("images/background1.jpeg");
	private JButton agony, blackJack, credits;
	
	public Menu(){
		super("Card Mania");
		ImageIcon image57 = new ImageIcon("images/pokerimage.jpg");
		this.setContentPane(masterPanel);
		masterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		masterPanel.setLayout(null);
		this.setSize(500, 500);
		this.setIconImage(image57.getImage());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		agony = new JButton("Agony");
		agony.setSize(150, 60);
		agony.setLocation(175, 100);
		agony.addActionListener(new agonyListener());
		masterPanel.add(agony);
		blackJack = new JButton("Black Jack");
		blackJack.setSize(150, 60);
		blackJack.setLocation(175, 190);
		blackJack.addActionListener(new blackJackListener());
		masterPanel.add(blackJack);
		credits = new JButton("Credits");
		credits.setSize(150, 60);
		credits.setLocation(175, 280);
		credits.addActionListener(new creditsListener());
		masterPanel.add(credits);
	}
	
	public class agonyListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			dispose();
			new AgonyFrame();
		}
	}
	
	public class blackJackListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			dispose();
			new BlackJackFrame();
		}
	}
	
	public class creditsListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			dispose();
			new Credits();
		}
	}
}
