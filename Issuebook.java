/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rahul
 */
public class Issuebook extends javax.swing.JFrame {

    /**
     * Creates new form Issuebook
     */
    public Issuebook() {
        initComponents();
        Connect();
        Book_id();
        student_id();
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
    
         
    public void  student_id()
    {
        try {
            pst=con.prepareStatement("select student_id  from student");
            rs=pst.executeQuery();
           stuid.removeAllItems();
            while(rs.next())
            {
                stuid.addItem(rs.getString(1));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
        
    public void  Book_id()
    {
        try {
            pst=con.prepareStatement("select book_id  from books");
            rs=pst.executeQuery();
           book_id.removeAllItems();
            while(rs.next())
            {
                book_id.addItem(rs.getString(1));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
    
    
    
    
  
    public void load()
    {
        String splace=book_id.getSelectedItem().toString();
      
         
        
        try {
            pst=con.prepareStatement("SELECT  book_name,book_category,book_author  from books where book_id=?");
            pst.setString(1, splace);
        
            
            rs=pst.executeQuery();
            
            if(rs.next()==true)
            {
              book_name.setText(rs.getString(1));
              
              book_category.setText(rs.getString(2));
              book_author.setText(rs.getString(3));
              
            }
      
            
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    
    public void  issuebook(){
        
       String stu_ids=stuid.getSelectedItem().toString();
          String choosebooks=book_id.getSelectedItem().toString();
        String stuname=book_name.getText();
          String bookcategory=book_category.getText();
           String bookauthor=book_author.getText();
           SimpleDateFormat date_forms=new SimpleDateFormat("YYYY-MM-DD");
          String issues=date_forms.format(issue.getDate());
    
           
    
        

        
         
        try {
             pst= con.prepareStatement("insert into issue values(?,?,?,?,?,?)");
            pst.setString(1,stu_ids);
            pst.setString(2,choosebooks);
            pst.setString(3,stuname);
            pst.setString(4,bookcategory);
            pst.setString(5, bookauthor);
            pst.setString(6,issues);
           
           
            int k= pst.executeUpdate();
            

                if(k==1){
                  
                    JOptionPane.showMessageDialog(this,"Book Issued Successfully");
                }else
                {
                     JOptionPane.showMessageDialog(null,"Failed to issue Books");

                }
           
            
 
       
        }   
          catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"This Book is Not Available");
             Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
          } 
        
        
    }
    
       
     public boolean checkDuplicateuser(){
    String stu_ids=stuid.getSelectedItem().toString();
          
        boolean isExist=false;
        try{
           Class.forName("oracle.jdbc.OracleDriver");
              String url="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
                     con=DriverManager.getConnection(url,"system","rahul123");
                     pst=con.prepareStatement("select * from return where student_id=?");
                    pst.setString(1,stu_ids);
                    
                     rs=pst.executeQuery();
                    if(rs.next())
                    {
                        isExist=true;
                    }else{
                        
                        isExist=false;
                    }
        }catch(Exception e)
        {
            
        }
        return isExist;
    }
    
    
    
   
     
       
    
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        book_category = new javax.swing.JTextField();
        issue = new com.toedter.calendar.JDateChooser();
        search = new javax.swing.JButton();
        issuebtn = new javax.swing.JButton();
        book_id = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        book_author = new javax.swing.JTextField();
        book_name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        stuid = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Book ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Student ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Book_Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Issue Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 104, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, 90, 40));

        book_category.setText(" ");
        getContentPane().add(book_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 320, 40));
        getContentPane().add(issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 320, 40));

        search.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, -1, -1));

        issuebtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        issuebtn.setText("Issue");
        issuebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuebtnActionPerformed(evt);
            }
        });
        getContentPane().add(issuebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, 90, 40));

        getContentPane().add(book_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 320, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Book_Author");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, 30));

        book_author.setText(" ");
        getContentPane().add(book_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 320, 40));

        book_name.setText(" ");
        getContentPane().add(book_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 320, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Book_Category");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, -1, 20));

        getContentPane().add(stuid, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 320, 40));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Issue your Book");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 301, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1020, 60));

        setSize(new java.awt.Dimension(1035, 678));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void issuebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebtnActionPerformed
        // TODO add your handling code here:
          
                     issuebook();
          
           
         
    
        
        
    }//GEN-LAST:event_issuebtnActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HomePage r=new HomePage();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issuebook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField book_author;
    private javax.swing.JTextField book_category;
    private javax.swing.JComboBox<String> book_id;
    private javax.swing.JTextField book_name;
    private com.toedter.calendar.JDateChooser issue;
    private javax.swing.JButton issuebtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton search;
    private javax.swing.JComboBox<String> stuid;
    // End of variables declaration//GEN-END:variables
}
