/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rahul
 */
public class AddStaff extends javax.swing.JFrame {

    /**
     * Creates new form AddStaff
     */
    public AddStaff() {
        initComponents();
        Connect();
        load();
    }
    
      Connection con;
     PreparedStatement pst;   
     ResultSet rs;
    
     
    public void Connect()  
   {
       
        try {
            Class.forName("oracle.jdbc.OracleDriver");
              String url="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
               con=DriverManager.getConnection(url,"system","rahul123");
             
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
        }          
            
        
  }
     public void load()
    {
        try {
            pst=con.prepareStatement("select * from staffs");
            rs=pst.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            int c;
            c=rsd.getColumnCount();
             DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
             d.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v=new Vector();
                 for(int i=0;i<=c;i++)
                 {
                    v.add(rs.getString("staff_id"));
                      v.add(rs.getString("staff_name"));
                       v.add(rs.getString("join_date"));
                        v.add(rs.getString("staff_mobile"));
                       v.add(rs.getString("staff_address")); 
                       
                         
                 }
                 
                 d.addRow(v);
             }
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sttaff_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        staff_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        moble = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addbooks = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        detete = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Your Staff");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 301, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1200, 60));

        jLabel5.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel5.setText("Staff_id");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        sttaff_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(sttaff_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 280, 40));

        jLabel3.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel3.setText("Staff_name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        staff_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(staff_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 280, 40));

        jLabel4.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel4.setText("Join_Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        address.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 280, 40));

        jLabel7.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel7.setText("Staff_mobile");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        moble.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobleActionPerformed(evt);
            }
        });
        getContentPane().add(moble, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 280, 40));

        jLabel8.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel8.setText("Staff_address");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 280, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "staff_id", "staff_name", " join_date", "staff_mobile", "staff_address"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 700, 480));

        addbooks.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addbooks.setText("Add book");
        addbooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbooksActionPerformed(evt);
            }
        });
        getContentPane().add(addbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 150, 50));

        edit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 140, 50));

        detete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        detete.setText("Delete");
        detete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deteteActionPerformed(evt);
            }
        });
        getContentPane().add(detete, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, 150, 50));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 580, 150, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 580, 140, 50));

        setSize(new java.awt.Dimension(1209, 683));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobleActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d = (DefaultTableModel)jTable1.getModel();

        int selectIndex=jTable1.getSelectedRow();

        sttaff_id.setText(d.getValueAt(selectIndex,0).toString());
        staff_name.setText(d.getValueAt(selectIndex,1).toString());
         date.setDateFormatString(d.getValueAt(selectIndex,2).toString());
             moble.setText(d.getValueAt(selectIndex,3).toString());
        address.setText(d.getValueAt(selectIndex,4).toString());
    
       

        addbooks.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void addbooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbooksActionPerformed
        // TODO add your handling code here:
        String bookid=sttaff_id.getText();
        String categories=staff_name.getText();
            SimpleDateFormat date_form=new SimpleDateFormat("YYYY-MM-DD");
        String dates=date_form.format(date.getDate());
      
        String authors=moble.getText();
          String addresss=address.getText();
    

        try {
            Connection con=DBconnection.getConnection();
            Statement st=con.createStatement();

            st.executeUpdate("insert into staffs values('"+bookid+"','"+categories+"','"+dates+"','"+authors+"','"+addresss+"')");
            JOptionPane.showMessageDialog(null, "staffs Added Successfully");
           

        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "staffs Already Exist");

        }

    }//GEN-LAST:event_addbooksActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        String bookid=sttaff_id.getText();
        String categories=staff_name.getText();
         SimpleDateFormat date_form=new SimpleDateFormat("YYYY-MM-DD");
        String dates=date_form.format(date.getDate());
       
        String authorS=moble.getText();
         String name=address.getText();
       

        try {
            pst= con.prepareStatement("update staffs set staff_name=?, join_date=?,staff_mobile=?,staff_address=?  where staff_ID=? ");

            pst.setString(1,categories);
             pst.setString(2,dates);
              pst.setString(3,authorS);
            pst.setString(4,name);
           
            pst.setString(5,bookid);
            int k= pst.executeUpdate();

            if(k==1)
            {

                JOptionPane.showMessageDialog(null,"Record Updated Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(null ,"Record  Failed");
            }

            //        else
            //            {
                //                JOptionPane.showMessageDialog(this,"Record Can't Added");
                //            }
            //

            sttaff_id.setText("");
            staff_name.setText("");
            date.setDateFormatString("");
           
            moble.setText("");
             address.setText("");
        
            sttaff_id.requestFocus();

            load();
            edit.setEnabled(true);
        }
        catch (SQLException ex) {
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HomePage r=new HomePage();
        r.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void deteteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deteteActionPerformed
        // TODO add your handling code here:
        String staff_id=sttaff_id.getText();
        
        
       
        try {
             pst= con.prepareStatement("delete from staffs where staff_id=?");
            pst.setString(1,staff_id);
            
            int k= pst.executeUpdate();
            
            
            if(k==1)
            {
   
                 JOptionPane.showMessageDialog(this,"Record Deleted Successfully");
            }
            else 
            {
                JOptionPane.showMessageDialog(this ,"Record  Failed");
            }
         
//        else
//            {
//                JOptionPane.showMessageDialog(this,"Record Can't Added");
//            }
//        
                
        sttaff_id.setText("");
         staff_name.setText("");
        date.setDateFormatString("");
         moble.setText("");
         address.setText("");
         sttaff_id.requestFocus();
       load();
       detete.setEnabled(true);
         
        
        }   
          catch (SQLException ex) {
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
          } 
    
    }//GEN-LAST:event_deteteActionPerformed

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
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbooks;
    private javax.swing.JTextField address;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton detete;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField moble;
    private javax.swing.JTextField staff_name;
    private javax.swing.JTextField sttaff_id;
    // End of variables declaration//GEN-END:variables
}
