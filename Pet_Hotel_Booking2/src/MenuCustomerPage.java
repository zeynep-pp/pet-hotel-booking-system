

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

public class MenuCustomerPage {

	private JFrame frmMenuCustomer;
    private JRadioButton rbtnBooking;
	private JRadioButton rbtnDisplayHotel;
	private JRadioButton rbtnDisplayRating;
    private JRadioButton rbtnDisplayName;
    private JRadioButton rbtnExit;
    private BookingCRUD bs;
    private HotelDisplay hg;
    private HotelCompareRating hl;
    private HotelCompareName hn;
    private JRadioButton rbtnRoomPrice;
    private RoomComparePrice rp;
    private JButton btnNewButton;
    private JTextArea textArea;
    
	public MenuCustomerPage() 
	{
		
		frmMenuCustomer = new JFrame();
		frmMenuCustomer.setTitle("menu customer");
		frmMenuCustomer.getContentPane().setBackground(Color.WHITE);
		frmMenuCustomer.setBounds(100, 100, 1013, 617);
		frmMenuCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuCustomer.getContentPane().setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU CUSTOMER PAGE");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(96, 27, 147, 23);
		frmMenuCustomer.getContentPane().add(lblMenu);
		
		rbtnBooking = new JRadioButton("BOOKING");
		rbtnBooking.setBackground(Color.WHITE);
		rbtnBooking.setBounds(61, 83, 244, 35);
		rbtnBooking.setSelected(true);
		frmMenuCustomer.getContentPane().add(rbtnBooking);
		
		rbtnDisplayHotel = new JRadioButton("HOTEL DISPLAY");
		rbtnDisplayHotel.setBackground(Color.WHITE);
		rbtnDisplayHotel.setBounds(60, 151, 275, 38);
		frmMenuCustomer.getContentPane().add(rbtnDisplayHotel);
		
		rbtnDisplayRating = new JRadioButton("Hotel Compare Rating");
		rbtnDisplayRating.setBackground(Color.WHITE);
		rbtnDisplayRating.setBounds(61, 220, 213, 23);
		frmMenuCustomer.getContentPane().add(rbtnDisplayRating);
		
		rbtnDisplayName = new JRadioButton("Hotel Compare Name");
		rbtnDisplayName.setBackground(Color.WHITE);
		rbtnDisplayName.setBounds(61, 272, 213, 32);
		frmMenuCustomer.getContentPane().add(rbtnDisplayName);
		
		rbtnRoomPrice = new JRadioButton("Room Compare Price");
		rbtnRoomPrice.setBackground(Color.WHITE);
		rbtnRoomPrice.setBounds(61, 317, 213, 32);
		frmMenuCustomer.getContentPane().add(rbtnRoomPrice);
		
		rbtnExit = new JRadioButton("Exit");
		rbtnExit.setBackground(Color.WHITE);
		rbtnExit.setBounds(61, 368, 213, 38);
		frmMenuCustomer.getContentPane().add(rbtnExit);
		
		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rbtnBooking);
		btnG.add(rbtnDisplayHotel);
		btnG.add(rbtnDisplayRating);
		btnG.add(rbtnDisplayName);
		btnG.add(rbtnRoomPrice);
		btnG.add(rbtnExit);
		
		JButton btnOk = new JButton("OK");
		btnOk.setForeground(UIManager.getColor("Button.background"));
		btnOk.setBackground(new Color(241, 57, 83));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rbtnBooking.isSelected())
				{
					bs = new BookingCRUD();
					bs.setVisible(true);
					frmMenuCustomer.setVisible(false);
				}
				else if(rbtnDisplayHotel.isSelected())
				{
					hg = new HotelDisplay();
					hg.setVisible(true);
					frmMenuCustomer.setVisible(false);
				}
				else if(rbtnDisplayRating.isSelected())
				{
					hl= new HotelCompareRating();
					hl.setVisible(true);
					frmMenuCustomer.setVisible(false);
				}
				else if(rbtnDisplayName.isSelected())
				{
					hn= new HotelCompareName();
					hn.setVisible(true);
					frmMenuCustomer.setVisible(false);
				}
				else if(rbtnRoomPrice.isSelected())
				{
					rp= new RoomComparePrice();
					rp.setVisible(true);
					frmMenuCustomer.setVisible(false);
				}
				else
				{
					System.exit(0);
				}
			}
		});
		btnOk.setBounds(684, 400, 177, 44);
		frmMenuCustomer.getContentPane().add(btnOk);
		
		btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin mp = new LoginAdmin();
				mp.getFrame().setVisible(true);
				 getFrame().setVisible(false);	
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(884, 513, 105, 38);
		frmMenuCustomer.getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(753, 109, 147, 22);					
		UserFactory userFactory = new UserFactory();
		//get an object of Customer and call its print method.
		User user1 = userFactory.getUser("CUSTOMER");
		//call draw method of Customer	
		String str=user1.print();
		textArea.append(str);
		frmMenuCustomer.getContentPane().add(textArea);

		
	}


	public JFrame getFrame() {
		return frmMenuCustomer;
	}


	public void setFrame(JFrame frame) {
		this.frmMenuCustomer = frame;
	}
}
