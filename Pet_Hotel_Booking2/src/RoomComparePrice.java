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

public class RoomComparePrice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
    Connection con;
    Statement st;
    public static ArrayList<Room> rooms = new ArrayList<>();
    private JPanel panel;
    private JButton btnNewButton;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomComparePrice frame = new RoomComparePrice();
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
	public RoomComparePrice() {
		setTitle("ROOM COMPARE PRİCE");
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
	            		"Room ID","Hotel ID","Price", "Type", "Description", "Day", "Month", "Year", "IsAvailable"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false, false, false, false, false
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

        private void fetch() {
            rooms.clear();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_hotel", "root", "");
                String sql = "select * from room";
                st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                	Date date=new Date(rs.getString("day"), rs.getString("month"), rs.getString("year"),Boolean.parseBoolean( rs.getString("isAvailable")));
                    Room room = new Room(Integer.parseInt(rs.getString("room_id")),Integer.parseInt( rs.getString("hotel_id")),Integer.parseInt( rs.getString("price")), rs.getString("type"),rs.getString("descr"), 
                    		date);
                    rooms.add(room);
                }
                //SORTED BY PRİCE
                RoomComparator priceCompare = new RoomComparator(); 
                Collections.sort(rooms, priceCompare); 
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                for (Room room: rooms) {

                    Object[] row = new Object[9];
                    row[0] = room.getRoom_id();
                    row[1] = room.getRoom_hotel_id();
                    row[2] = room.getRoom_price();
                    row[3] = room.getRoom_type();
                    row[4] = room.getRoom_description();
                    row[5] = room.getDate().getDay();
                    row[6] = room.getDate().getMonth();
                    row[7] = room.getDate().getYear();
                    row[8] = room.getDate().isAvailable();

                    model.addRow(row);
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(RoomCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    


}
