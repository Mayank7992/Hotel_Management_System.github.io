import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{

    JTable table;
    JButton back;

    CustomerInfo() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Document Type
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10,10,100,20);
        add(l1);


        // Document No.
        JLabel l2 = new JLabel("Document No.");
        l2.setBounds(160,10,100,20);
        add(l2);
        

        // Gender
        JLabel l3 = new JLabel("Name");
        l3.setBounds(290,10,100,20);
        add(l3);
                

        // Gender
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(410,10,100,20);
        add(l4);
                

        // Country
        JLabel l5 = new JLabel("Country");
        l5.setBounds(540,10,100,20);
        add(l5);


        // Room No.
        JLabel l6 = new JLabel("Room No.");
        l6.setBounds(640,10,100,20);
        add(l6);


        // Email Id
        JLabel l7 = new JLabel("CheckIn Time");
        l7.setBounds(760,10,100,20);
        add(l7);


        // Aadhar
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(900,10,100,20);
        add(l8);



        // Table
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);



        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");   
            table.setModel(DbUtils.resultSetToTableModel(rs));         
        } catch (Exception e) {
            e.printStackTrace();
        }


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);


        setBounds(300,100,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }

}
