import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class Credits extends JFrame{
	
	private ImagePanel masterPanel = new ImagePanel("images/Joker.jpg");
	private JLabel name1, name2, name3, name4, name5, name6, teamname;
	private JButton back;
	
	public Credits(){
		super("Credits");
		ImageIcon image57 = new ImageIcon("images/pokerimage.jpg");
		this.setContentPane(masterPanel);
		masterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		masterPanel.setLayout(null);
		this.setSize(600, 600);
		this.setIconImage(image57.getImage());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		teamname = new JLabel("MassiveQQ");
		teamname.setBounds(175, 50, 250, 80);
		teamname.setFont(new Font("Serif", Font.PLAIN, 50));
		teamname.setForeground(Color.BLACK);
		masterPanel.add(teamname);
		name1 = new JLabel("Θεοδόσιος Σιώμος");
		name1.setBounds(175, 150, 240, 50);
		name1.setFont(new Font("Serif", Font.PLAIN, 30));
		name1.setForeground(Color.YELLOW);
		masterPanel.add(name1);
		name2 = new JLabel("Αλέξανδρος Τσαλίδης");
		name2.setBounds(175, 200, 280, 50);
		name2.setFont(new Font("Serif", Font.PLAIN, 30));
		name2.setForeground(Color.YELLOW);
		masterPanel.add(name2);
		name3 = new JLabel("Χρύσα Φώτογλου");
		name3.setBounds(175, 250, 240, 50);
		name3.setFont(new Font("Serif", Font.PLAIN, 30));
		name3.setForeground(Color.YELLOW);
		masterPanel.add(name3);
		name4 = new JLabel("Μαρίνα Κυρμανίδου");
		name4.setBounds(175, 300, 280, 50);
		name4.setFont(new Font("Serif", Font.PLAIN, 30));
		name4.setForeground(Color.YELLOW);
		masterPanel.add(name4);
		name5 = new JLabel("Φαίδρα Σεβαστίδου");
		name5.setBounds(175, 350, 240, 50);
		name5.setFont(new Font("Serif", Font.PLAIN, 30));
		name5.setForeground(Color.YELLOW);
		masterPanel.add(name5);
		name6 = new JLabel("Χαριτίνη Ζήση");
		name6.setBounds(175, 400, 240,50);
		name6.setFont(new Font("Serif", Font.PLAIN, 30));
		name6.setForeground(Color.YELLOW);
		masterPanel.add(name6);
		back = new JButton("<");
		back.addActionListener(new backListener());
		back.setBounds(50, 500, 50, 40);
		masterPanel.add(back);
	}
	
	public class backListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				new Menu();
		}
	}

}
