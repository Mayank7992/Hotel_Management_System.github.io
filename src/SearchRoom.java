import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.DataBuffer;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{

    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;

    SearchRoom() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        // Room Search Heading
        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);



        // Bed Type
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        bedType = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedType.setBounds(130,100,150,20);
        bedType.setBackground(Color.WHITE);
        add(bedType);



        // Available
        available = new JCheckBox("Only display Available");
        available.setBounds(650,100,200,25);
        available.setBackground(Color.WHITE);
        add(available);



        // Room 
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);


        // Room Availability
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        add(l2);
        

        // Cleaning Status
        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(450,160,100,20);
        add(l3);
                

        // Price
        JLabel l4 = new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);
                

        // Bed Type
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);
        add(l5);



        // Table
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);



        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from room");   
            table.setModel(DbUtils.resultSetToTableModel(rs));         
        } catch (Exception e) {
            e.printStackTrace();
        }

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,120,30);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,520,120,30);
        back.addActionListener(this);
        add(back);


        setBounds(250,50,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == submit) {
            
            try {
                String query1 = "Select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "Select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";

                Conn conn = new Conn();
                ResultSet rs;

                if (available.isSelected()) {
                    rs = conn.s.executeQuery(query2);
                } else {
                    rs = conn.s.executeQuery(query1);
                }

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new SearchRoom();
    }

}
