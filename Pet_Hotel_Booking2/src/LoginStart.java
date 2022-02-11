

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;

public class LoginStart extends JFrame {

   JFrame frmLogIn;
    private JButton btnLogIn;
    private LoginAdmin la;
    private LoginCustomer ca;
    private JTextField txtPetHotelBooking;

	public LoginStart() 
	{
		frmLogIn = new JFrame();
		frmLogIn.getContentPane().setBackground(Color.WHITE);
		frmLogIn.setTitle("Log in");
		frmLogIn.setBounds(100, 100, 997, 640);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		JButton btnCustomer = new JButton("Customer Login");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ca = new LoginCustomer();
				ca.getFrame().setVisible(true);
				frmLogIn.setVisible(false);
			}
		});
		btnCustomer.setBackground(new Color(95, 158, 160));
		btnCustomer.setBounds(642, 142, 193, 58);
		frmLogIn.getContentPane().add(btnCustomer);
		
		btnLogIn = new JButton("Admin Login");
		btnLogIn.setBounds(144, 142, 198, 58);
		frmLogIn.getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				la = new LoginAdmin();
				la.getFrame().setVisible(true);
				frmLogIn.setVisible(false);
			}
		});
		btnLogIn.setForeground(UIManager.getColor("Button.background"));
		btnLogIn.setBackground(new Color(241, 57, 83));
		
		JLabel label = new JLabel("");
		frmLogIn.getContentPane().add(label);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(210, 298, 575, 322);
		label.setIcon(new ImageIcon(LoginCustomer.class.getResource("/images/po.jpg")));
		
		txtPetHotelBooking = new JTextField();
		txtPetHotelBooking.setForeground(new Color(128, 0, 128));
		txtPetHotelBooking.setBackground(new Color(255, 255, 255));
		txtPetHotelBooking.setHorizontalAlignment(SwingConstants.CENTER);
		txtPetHotelBooking.setFont(new Font("Verdana", Font.PLAIN, 17));
		txtPetHotelBooking.setText("PET HOTEL BOOK\u0130NG");
		txtPetHotelBooking.setBounds(336, 42, 283, 46);
		frmLogIn.getContentPane().add(txtPetHotelBooking);
		txtPetHotelBooking.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(27, 351, 193, 216);
		
		String str="                BY"+
		        "\n"+"\n"+"\n"+
				"Zeynep KÖSE 2014510056"+"\n"+
				"Rona CIDA 2017510022"+"\n"+
				"Eray KAPLAN 2018510038"+"\n";
		textArea.append(str);
		frmLogIn.getContentPane().add(textArea);

		
		
		
	}
	
	public JFrame getFrame() {
		return frmLogIn;
	}


	public void setFrame(JFrame frame) {
		this.frmLogIn = frame;
	}
}
