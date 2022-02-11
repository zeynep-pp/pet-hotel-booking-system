

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoginAdmin {

	private JFrame frmLogIn;
	private JTextField txtUserName;
	private JPasswordField passwordField;
    private JButton btnLogIn;
	
	public LoginAdmin() 
	{
		frmLogIn = new JFrame();
		frmLogIn.getContentPane().setBackground(Color.WHITE);
		frmLogIn.setTitle(" ADMIN Log in");
		frmLogIn.setBounds(100, 100, 1147, 711);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name: ");
		lblUserName.setBounds(630, 144, 78, 14);
		frmLogIn.getContentPane().add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(630, 196, 188, 31);
		txtUserName.setColumns(10);
		frmLogIn.getContentPane().add(txtUserName);
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(630, 271, 78, 14);
		frmLogIn.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(630, 307, 188, 31);
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
					String sql="Select * from admin where username='"+txtUserName.getText()+"' and password='"+passwordField.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Successfully...");
						MenuAdminPage mp = new MenuAdminPage();
						mp.getFrame().setVisible(true);
						frmLogIn.setVisible(false);						
					}
						
					else
						JOptionPane.showMessageDialog(null, "Incorrect username and password..");
					con.close();
				}catch(Exception e) {System.out.print(e);}
			}
		});
		btnLogIn.setBounds(630, 395, 188, 39);
		btnLogIn.setForeground(UIManager.getColor("Button.background"));
		btnLogIn.setBackground(new Color(241, 57, 83));
		frmLogIn.getContentPane().add(btnLogIn);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 88, 473, 418);
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
				RegisterAdmin mp = new RegisterAdmin();
				mp.getFrame().setVisible(true);
				frmLogIn.setVisible(false);	
			}
		});
		btnRegister.setBackground(new Color(240, 230, 140));
		btnRegister.setBounds(883, 493, 160, 39);
		frmLogIn.getContentPane().add(btnRegister);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginStart mp = new LoginStart();
				mp.getFrame().setVisible(true);
				getFrame().setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setBounds(1024, 611, 99, 31);
		frmLogIn.getContentPane().add(btnNewButton);

		
		
		
	}
	
	public JFrame getFrame() {
		return frmLogIn;
	}


	public void setFrame(JFrame frame) {
		this.frmLogIn = frame;
	}
}
