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

public class HotelCompareName extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
    Connection con;
    Statement st;
    public static ArrayList<Hotel> hotels = new ArrayList<>();
    private JPanel panel;
    private JButton btnNewButton;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelCompareName frame = new HotelCompareName();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HotelCompareName() {
		setTitle("HOTEL COMPARE NAME");
		setBackground(Color.WHITE);	
    	getContentPane().setBackground(Color.WHITE);
        initComponents();
        fetch();
	}
        private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.NORTH);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
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
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(75, 0, 0, 0));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCustomerPage mp = new MenuCustomerPage();
				mp.getFrame().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(240, 230, 140));
		btnNewButton.setBounds(886, 528, 164, 31);
		panel.add(btnNewButton);

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
            }
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
    


}
