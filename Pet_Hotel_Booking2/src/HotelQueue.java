import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;

public class HotelQueue  {
	/**
	 * Launch the application.
	 */
	 static JFrame frmLogIn;
    Connection con;
    Statement st;
    JTextArea hotelTextArea = new JTextArea();
    
    
    static Queue q = new Queue(new HotelNameComparator());
    public static ArrayList<Hotel> hotels = new ArrayList<>();
    private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelQueue frame = new HotelQueue();
					frame.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HotelQueue() {
        initComponents();
        fetch();
	}
        private void initComponents() {
    		frmLogIn = new JFrame();
    		frmLogIn.getContentPane().setBackground(Color.WHITE);
    		frmLogIn.setTitle("HOTEL COMPARE NAME");
    		frmLogIn.setBounds(100, 100, 997, 640);
    		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frmLogIn.getContentPane().setLayout(null);
    		
    		
    		hotelTextArea.setBounds(21, 346, 860, 139);
    		frmLogIn.getContentPane().add(hotelTextArea);
    		
    		JButton btnBack = new JButton("BACK");
    		btnBack.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				MenuAdminPage mp = new MenuAdminPage();
    				mp.getFrame().setVisible(true);
    				frmLogIn.setVisible(false);	
    			}
    		});
    		btnBack.setBackground(new Color(240, 230, 140));
    		btnBack.setFont(new Font("Verdana", Font.PLAIN, 14));
    		btnBack.setBounds(776, 509, 106, 46);
    		frmLogIn.getContentPane().add(btnBack);
    		
    		JScrollPane scrollPane = new JScrollPane();
    		scrollPane.setBounds(21, 24, 860, 309);
    		frmLogIn.getContentPane().add(scrollPane);
    		
    		table = new JTable();
    		table.setModel(new javax.swing.table.DefaultTableModel(
    	            new Object [][] {

    	            },
    	            new String [] {
    	            		"Hotel ID","Name", "Type", "Description", "Rating", "Address", "Town", "City"
    	            }
    	        ) {
    	            boolean[] canEdit = new boolean [] {
    	                false, false, false, false, false, false, false, false
    	            };

    	            public boolean isCellEditable(int rowIndex, int columnIndex) {
    	                return canEdit [columnIndex];
    	            }
    	        });
    		scrollPane.setViewportView(table);
    		frmLogIn.setBounds(100, 100, 941, 639);
	}

    public  void fetch() {
        hotels.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_hotel", "root", "");
            String sql = "select * from hotel";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	Address address=new Address(rs.getString("address"), rs.getString("town"), rs.getString("city"));
                Hotel hotel = new Hotel(Integer.parseInt(rs.getString("hotel_id")), rs.getString("name"), rs.getString("type"),rs.getString("descr"), 
                		Integer.parseInt(rs.getString("rating")),address);
                hotels.add(hotel);
                q.enqueue(hotel);
            }
            //SORTED BY NAME
               
               hotelTextArea.append (q.toString());
               //SORTED BY NAME
               HotelNameComparator nameCompare = new HotelNameComparator(); 
               Collections.sort(hotels, nameCompare);
               DefaultTableModel model = (DefaultTableModel) table.getModel();
               for (Hotel hotel : hotels) {

                   Object[] row = new Object[8];
                   row[0] = hotel.getHotel_id();
                   row[1] = hotel.getHotel_name();
                   row[2] = hotel.getHotel_type();
                   row[3] = hotel.getHotel_description();
                   row[4] = hotel.getHotel_rating();
                   row[5] = hotel.getHotel_address().getAddress();
                   row[6] = hotel.getHotel_address().getTown();
                   row[7] = hotel.getHotel_address().getCity();

                   model.addRow(row);
               }
            

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HotelCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
	public JFrame getFrame() {
		return frmLogIn;
	}


	public void setFrame(JFrame frame) {
		this.frmLogIn = frame;
	}
}
