import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{

    JTable table;
    JButton back;

    EmployeeInfo() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Name
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40,10,100,20);
        add(l1);


        // Age
        JLabel l2 = new JLabel("Age");
        l2.setBounds(170,10,100,20);
        add(l2);
        

        // Gender
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290,10,100,20);
        add(l3);
                

        // Job
        JLabel l4 = new JLabel("Job Profile");
        l4.setBounds(400,10,100,20);
        add(l4);
                

        // Salary
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540,10,100,20);
        add(l5);


        // Phone No.
        JLabel l6 = new JLabel("Phone No.");
        l6.setBounds(670,10,100,20);
        add(l6);


        // Email Id
        JLabel l7 = new JLabel("Email ID");
        l7.setBounds(790,10,100,20);
        add(l7);


        // Aadhar
        JLabel l8 = new JLabel("Aadahar No.");
        l8.setBounds(897,10,100,20);
        add(l8);



        // Table
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);



        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from employee");   
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


        setBounds(250,100,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new EmployeeInfo();
    }

}
