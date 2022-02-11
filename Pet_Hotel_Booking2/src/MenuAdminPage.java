

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JTextArea;

public class MenuAdminPage {

	private JFrame frmMenuAdmin;
    private JRadioButton rbtnRoomCRUD;
	private JRadioButton rbtnHotelCRUD;
    private JRadioButton rbtnHotelName;
    private JRadioButton rbtnExit;
    private RoomCRUD bs;
    public static HotelCRUD hc;
    private HotelQueue hl;
   
    
	public MenuAdminPage() 
	{
		
		frmMenuAdmin = new JFrame();
		frmMenuAdmin.setTitle("menu admin");
		frmMenuAdmin.getContentPane().setBackground(Color.WHITE);
		frmMenuAdmin.setBounds(100, 100, 934, 530);
		frmMenuAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuAdmin.getContentPane().setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU ADM\u0130N PAGE");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(61, 31, 158, 23);
		frmMenuAdmin.getContentPane().add(lblMenu);
		
		rbtnRoomCRUD = new JRadioButton("ROOMS MANAGE");
		rbtnRoomCRUD.setBackground(Color.WHITE);
		rbtnRoomCRUD.setBounds(61, 83, 244, 35);
		rbtnRoomCRUD.setSelected(true);
		frmMenuAdmin.getContentPane().add(rbtnRoomCRUD);
		
		rbtnHotelCRUD = new JRadioButton("HOTELS MANAGE");
		rbtnHotelCRUD.setBackground(Color.WHITE);
		rbtnHotelCRUD.setBounds(60, 151, 275, 38);
		frmMenuAdmin.getContentPane().add(rbtnHotelCRUD);
		
		rbtnHotelName = new JRadioButton("Hotel Name Compare ");
		rbtnHotelName.setBackground(Color.WHITE);
		rbtnHotelName.setBounds(61, 221, 213, 32);
		frmMenuAdmin.getContentPane().add(rbtnHotelName);
		
		rbtnExit = new JRadioButton("Exit");
		rbtnExit.setBackground(Color.WHITE);
		rbtnExit.setBounds(61, 289, 213, 38);
		frmMenuAdmin.getContentPane().add(rbtnExit);
		
		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rbtnRoomCRUD);
		btnG.add(rbtnHotelCRUD);
		btnG.add(rbtnHotelName);
		btnG.add(rbtnExit);
		
		JButton btnOk = new JButton("OK");
		btnOk.setForeground(UIManager.getColor("Button.background"));
		btnOk.setBackground(new Color(241, 57, 83));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rbtnRoomCRUD.isSelected())
				{
					bs = new RoomCRUD();
					bs.setVisible(true);
					frmMenuAdmin.setVisible(false);
				}
				else if(rbtnHotelCRUD.isSelected())
				{
					hc= new HotelCRUD();
					hc.setVisible(true);
					frmMenuAdmin.setVisible(false);
				}
				else if(rbtnHotelName.isSelected())
				{
					hl= new HotelQueue();
					hl.getFrame().setVisible(true);
					frmMenuAdmin.setVisible(false);
				}
				else
				{
					System.exit(0);
				}
			}
		});
		btnOk.setBounds(541, 384, 177, 44);
		frmMenuAdmin.getContentPane().add(btnOk);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin mp = new LoginAdmin();
				mp.getFrame().setVisible(true);
				frmMenuAdmin.setVisible(false);	
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(812, 454, 98, 29);
		frmMenuAdmin.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(653, 55, 188, 38);				
		UserFactory userFactory = new UserFactory();
		//get an object of Admin and call its print method.
		User user1 = userFactory.getUser("ADMIN");
		//call draw method of Admin		
		String str=user1.print();
		textArea.append(str);
		frmMenuAdmin.getContentPane().add(textArea);
	}


	public JFrame getFrame() {
		return frmMenuAdmin;
	}


	public void setFrame(JFrame frame) {
		this.frmMenuAdmin = frame;
	}
}
