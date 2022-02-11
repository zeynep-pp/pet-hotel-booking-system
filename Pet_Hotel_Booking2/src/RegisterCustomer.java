

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

public class RegisterCustomer {

	private JFrame frmLogIn;
	private JTextField txtUserName;
	private JPasswordField passwordField;
    private JButton btnRegister;
    private JTextField txtName;
    private JTextField textEmail;
	
	public RegisterCustomer() 
	{
		frmLogIn = new JFrame();
		frmLogIn.getContentPane().setBackground(Color.WHITE);
		frmLogIn.setTitle("Customer Register");
		frmLogIn.setBounds(100, 100, 1116, 734);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name: ");
		lblUserName.setBounds(137, 94, 95, 39);
		frmLogIn.getContentPane().add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(242, 94, 225, 39);
		txtUserName.setColumns(10);
		frmLogIn.getContentPane().add(txtUserName);
		
		txtName = new JTextField();
		txtName.setBounds(242, 205, 225, 39);
		frmLogIn.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(137, 205, 98, 39);
		frmLogIn.getContentPane().add(lblName);
		
		textEmail = new JTextField();
		textEmail.setBounds(242, 287, 225, 39);
		frmLogIn.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(137, 287, 98, 39);
		frmLogIn.getContentPane().add(lblEmail);
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(137, 388, 98, 39);
		frmLogIn.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(242, 388, 225, 39);
		frmLogIn.getContentPane().add(passwordField);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_hotel","root","");									
	                PreparedStatement Pstatement=con.prepareStatement("insert into customer values(?,?,?,?)");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,txtName.getText());
	                Pstatement.setString(2,txtUserName.getText());
	                Pstatement.setString(3,textEmail.getText());
	                Pstatement.setString(4,passwordField.getText());
	                
	                    //Executing query
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");

				}catch(Exception e) {System.out.print(e);}
												
			}
		});
		
		btnRegister.setBounds(243, 559, 224, 57);
		btnRegister.setForeground(UIManager.getColor("Button.background"));
		btnRegister.setBackground(new Color(241, 57, 83));
		frmLogIn.getContentPane().add(btnRegister);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginCustomer mp = new LoginCustomer();
				mp.getFrame().setVisible(true);
				frmLogIn.setVisible(false);	
			}
		});
		btnNewButton.setBackground(new Color(255, 182, 193));
		btnNewButton.setBounds(939, 627, 122, 39);
		frmLogIn.getContentPane().add(btnNewButton);
		


		
		
		
	}
	
	public JFrame getFrame() {
		return frmLogIn;
	}


	public void setFrame(JFrame frame) {
		this.frmLogIn = frame;
	}
}
