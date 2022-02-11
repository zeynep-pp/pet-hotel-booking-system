

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BookingCRUD extends javax.swing.JFrame {

    /**
     * Creates new form BookingCRUD
     */
    Connection con;
    Statement st;
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();
    
    public BookingCRUD() {
    	getContentPane().setBackground(Color.WHITE);
        initComponents();
        fetch();
        fetch1();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookings = new javax.swing.JTable();
        tblBookings.setBackground(Color.WHITE);
        btnSave = new javax.swing.JButton();
        btnSave.setBackground(new Color(240, 230, 140));
        btnUpdate = new javax.swing.JButton();
        btnUpdate.setBackground(new Color(240, 230, 140));
        btnDelete1 = new javax.swing.JButton();
        btnDelete1.setBackground(new Color(240, 230, 140));
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BOOKING");

        tblBookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
            		"Room ID","Customer Name","Duration"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBookings.setCellSelectionEnabled(true);
        tblBookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoomsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBookings);
        if (tblBookings.getColumnModel().getColumnCount() > 0) {
            tblBookings.getColumnModel().getColumn(2).setResizable(false);
        }

        btnSave.setText("Save");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.setIconTextGap(0);
        btnSave.setInheritsPopupMenu(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete1.setText("Delete");
        btnDelete1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("BOOKING CRUD APPLICATION");
        
        textRoomID = new JTextField();
        textRoomID.setColumns(10);
        
        lblRoomID = new JLabel("Room ID");
        lblRoomID.setFont(new Font("Verdana", Font.PLAIN, 12));
        
        textName = new JTextField();
        textName.setColumns(10);
        
        lblName = new JLabel("Customer Name");
        lblName.setFont(new Font("Verdana", Font.PLAIN, 12));
        
        textDuration = new JTextField();
        textDuration.setColumns(10);
        
        lblDuration = new JLabel("Duration");
        lblDuration.setFont(new Font("Verdana", Font.PLAIN, 12));
        
        scrollPaneRoomD = new JScrollPane();
        
        btnNewButton = new JButton("BACK");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				MenuCustomerPage mp = new MenuCustomerPage();
				mp.getFrame().setVisible(true);
				setVisible(false);
        	}
        });
        btnNewButton.setBackground(new Color(199, 21, 133));
        btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 13));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(124)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(lblRoomID, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
        							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
        							.addComponent(lblDuration, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(textRoomID, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(textDuration, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        								.addComponent(textName, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED)))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(75)
        							.addComponent(btnDelete1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(268)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
        								.addComponent(scrollPaneRoomD, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))))
        					.addGap(50)
        					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
        					.addGap(175))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(242)
        					.addComponent(jLabel4)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        					.addGap(127)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(textRoomID, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblRoomID))
        					.addGap(59)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(textName, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblName))
        					.addGap(64)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(textDuration, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblDuration))
        					.addGap(52))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(scrollPaneRoomD, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
        					.addGap(131)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
        			.addGap(46)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnDelete1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
        			.addGap(197))
        );
        
        tableRoomD = new JTable();
        tableRoomD.setModel(new javax.swing.table.DefaultTableModel(
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
        
        scrollPaneRoomD.setViewportView(tableRoomD);
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    	String room_id = textRoomID.getText().trim();
        String name = textName.getText().trim();
        String duration = textDuration.getText().trim();
        
        if (!room_id.isEmpty() && !name.isEmpty() && !duration.isEmpty() ) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_hotel", "root", "");
                String sql = "select * from booking where name='" + name + "'";
                st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (!rs.first()) {
                    saveHotel(room_id,name,duration);
                    DefaultTableModel model = (DefaultTableModel) tblBookings.getModel();
                    Object[] row = new Object[9];
                    row[0] = room_id;
                    row[1] = name;
                    row[2] = duration; 
                    model.addRow(row);
                } else {
                    alert("Please provide a different id number", "Similar id found");
                }

                clear();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(HotelCRUD.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    con.close();
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelCRUD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } //        else if (!id.matches("^[0-9]{8}$")) {
        //            alert("please provide a valid id number", "Wrong id");
        //        } 
        else {
            alert("please fill in all the details");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
     	String room_id = textRoomID.getText().trim();
        String name = textName.getText().trim();
        String duration = textDuration.getText().trim();
        
        if (!room_id.isEmpty() && !name.isEmpty() && !duration.isEmpty() ) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_hotel", "root", "");
                String sql = "select * from booking where name='" + name + "'";
                st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.first()) {
                    update(room_id,name,duration);
                    DefaultTableModel model = (DefaultTableModel) tblBookings.getModel();
                    model.setRowCount(0);                   
                    fetch();
                    alert("Update was successful");
                    
                } else {
                    alert("There is no such room", "Update error");
                    clear();
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(HotelCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            alert("There is nothing to update :(","No row selected");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    //set the values of a row to the textfields
    private void tblRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoomsMouseClicked
        // TODO add your handling code here:
        int i = tblBookings.getSelectedRow();
        TableModel model = tblBookings.getModel();
        textRoomID.setText(model.getValueAt(i, 0).toString());
        textName.setText(model.getValueAt(i, 1).toString());
        textDuration.setText(model.getValueAt(i, 2).toString());
    }//GEN-LAST:event_tblRoomsMouseClicked

    //handles delete button action
    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        int i = tblBookings.getSelectedRow();
        if (i >= 0) {
            int option = JOptionPane.showConfirmDialog(rootPane,
                    "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                TableModel model = tblBookings.getModel();

                String id = model.getValueAt(i, 0).toString();
                if (tblBookings.getSelectedRows().length == 1) {
                    delete(id);
                    DefaultTableModel model1 = (DefaultTableModel) tblBookings.getModel();
                    model1.setRowCount(0);
                    fetch();
                    clear();
                }
            }
        } else {
            alert("Please select a row to delete");
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    //method to show an info alert
    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    //method to show an error alert
    public void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }
  
    //method to save room to the db
    public void saveHotel(String room_id, String name, String duration) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_hotel", "root", "");
            String sql = "INSERT INTO `booking`(`room_id`, `name`, `duration`) "
                    + "VALUES ('" + room_id + "','" + name + "','" + duration + "')";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HotelCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fetch();
    }

    //update the db
    public void update(String room_id, String name, String duration) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_hotel", "root", "");
            String sql = "UPDATE `booking`SET room_id='" + room_id+ "',duration='" + duration  + "'WHERE name='" + name + "'";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HotelCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fetch();
    }

    //delete details in the db
    public void delete(String name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_hotel", "root", "");
            String sql = "DELETE FROM `booking` WHERE name='" + name + "'";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HotelCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fetch();
    }

    //method to clear the txt fields
    private void clear() {
        textRoomID.setText("");
        textName.setText("");
        textDuration.setText("");
    }

    //fetch 
    private void fetch() {
    	bookings.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_hotel", "root", "");
            String sql = "select * from booking";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Room room = new Room(Integer.parseInt(rs.getString("room_id")));
                Booking booking=new Booking(rs.getString("duration"), rs.getString("name"), room);
                bookings.add(booking);
            }
            DefaultTableModel model = (DefaultTableModel) tblBookings.getModel();
            for (Booking booking: bookings) {

                Object[] row = new Object[3];
                row[0] = booking.room.getRoom_id();
                row[1] = booking.getCustomer_name();
                row[2] = booking.getDuration();

                model.addRow(row);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fetch1() {
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
            DefaultTableModel model = (DefaultTableModel) tableRoomD.getModel();
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
            Logger.getLogger(BookingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookingCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BookingCRUD().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBookings;
    private JTextField textRoomID;
    private JLabel lblRoomID;
    private JTextField textName;
    private JLabel lblName;
    private JTextField textDuration;
    private JLabel lblDuration;
    private JScrollPane scrollPaneRoomD;
    private JTable tableRoomD;
    private JButton btnNewButton;
}