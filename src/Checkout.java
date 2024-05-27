import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Date;

public class Checkout extends JFrame implements ActionListener{

    Choice ccustomer;
    JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
    JButton checkout,back;
    Checkout(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        // Heading
        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);



        // Customer Id
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,70,100,30);
        lblid.setForeground(Color.BLACK);
        add(lblid);


        ccustomer = new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);


        
        
        // IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);



        // Room
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);



        // Room Number
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);



        // CheckIn 
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);


        // CheckIn time
        lblcheckintime = new JLabel("Checkin Time");
        lblcheckintime.setBounds(150,180,170,30);
        add(lblcheckintime);




        // CheckOut 
        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);


        Date date = new Date();
        // Checkout time
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150,230,180,30);
        add(lblcheckouttime);




        // Checkout
        checkout =  new JButton("Checkout");
        checkout.setBackground(Color.BLACK);        
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);



        // Back
        back =  new JButton("Back");
        back.setBackground(Color.BLACK);        
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);



        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from Customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        // Image 
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);



        setBounds(300,100,800,400);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == checkout) {
            String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Checkout done");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Checkout();
    }

}
