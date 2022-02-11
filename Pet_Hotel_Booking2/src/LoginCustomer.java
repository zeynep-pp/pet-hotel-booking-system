

import java.awt.Color;
import java.awt.EventQueue;

import java.sql.*;
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

public class LoginCustomer {

	private JFrame frmLogIn;
	private JTextField txtUserName;
	private JPasswordField passwordField;
    private JButton btnLogIn;
	
	public LoginCustomer() 
	{
		frmLogIn = new JFrame();
		frmLogIn.getContentPane().setBackground(Color.WHITE);
		frmLogIn.setTitle("Customer Log in");
		frmLogIn.setBounds(100, 100, 1105, 737);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name: ");
		lblUserName.setBounds(697, 150, 78, 14);
		frmLogIn.getContentPane().add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(696, 200, 188, 31);
		txtUserName.setColumns(10);
		frmLogIn.getContentPane().add(txtUserName);
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(697, 268, 78, 14);
		frmLogIn.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(696, 318, 188, 31);
		frmLogIn.getContentPane().add(passwordField);
		
		btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_hotel","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from customer where username='"+txtUserName.getText()+"' and password='"+passwordField.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Successfully...");
						MenuCustomerPage mp = new MenuCustomerPage();
						mp.getFrame().setVisible(true);
						frmLogIn.setVisible(false);						
					}
						
					else
						JOptionPane.showMessageDialog(null, "Incorrect username and password..");
					con.close();
				}catch(Exception e) {System.out.print(e);}
			}
		});
		
		btnLogIn.setBounds(697, 403, 187, 39);
		btnLogIn.setForeground(UIManager.getColor("Button.background"));
		btnLogIn.setBackground(new Color(241, 57, 83));
		frmLogIn.getContentPane().add(btnLogIn);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 104, 473, 418);
		frmLogIn.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(0, 0, 420, 454);
		label.setBounds(-40, 10, 420, 454);
		label.setIcon(new ImageIcon(LoginCustomer.class.getResource("/images/pet_hotel.jpg")));
		panel.add(label);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterCustomer mp = new RegisterCustomer();
				mp.getFrame().setVisible(true);
				frmLogIn.setVisible(false);	
			}
		});
		btnRegister.setBackground(new Color(240, 230, 140));
		btnRegister.setBounds(886, 528, 164, 31);
		frmLogIn.getContentPane().add(btnRegister);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginStart mp = new LoginStart();
				mp.getFrame().setVisible(true);
				getFrame().setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(980, 619, 101, 39);
		frmLogIn.getContentPane().add(btnNewButton);

		
		
		
	}
	
	public JFrame getFrame() {
		return frmLogIn;
	}


	public void setFrame(JFrame frame) {
		this.frmLogIn = frame;
	}
}
