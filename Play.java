package pkgfinal.project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Play implements ActionListener
{
    JFrame j1;
    JLabel l1, l2, l3, l4, l5, l;
    JTextField t1, t2 , t3, t4, t5;
    JButton b;
    Play()
    {
        j1=new JFrame("Information Page");
        
        
        l=new JLabel("STUDENT DETAILS");
        l.setForeground(Color.red);
        l.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        l.setBounds(80,0, 400,60);
        
        l1=new JLabel("Name");
        l1.setBounds(50,100,100,30);
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        
        l2=new JLabel("Registration No.");
        l2.setBounds(50,120,100,30);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        
        l3=new JLabel("Branch");
        l3.setBounds(50,140,100,30);
        l3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        
        l4=new JLabel("Gender");
        l4.setBounds(50,160,100,30);
        l4.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        
        l5=new JLabel("Grade");
        l5.setBounds(50,180,100,30);
        l5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        
        t1 = new JTextField(16);
        t1.setEditable(true);
        t1.setBounds(150,100,150,20);
        
        t2 = new JTextField(16);
        t2.setEditable(true);
        t2.setBounds(150,120,150,20);
        t2.setVisible(false);
        
        t3 = new JTextField(16);
        t3.setEditable(true);
        t3.setBounds(150,140,150,20);
        t3.setVisible(false);
        
        t4 = new JTextField(16);
        t4.setEditable(true);
        t4.setBounds(150,160,150,20);
        t4.setVisible(false);
        
        t5 = new JTextField(16);
        t5.setEditable(true);
        t5.setBounds(150,180,150,20);
        t5.setVisible(false);
        
        b=new JButton("Get details");
        b.setBounds(50,300,100,50);
        b.addActionListener(this);
        
        j1.add(l1);
        j1.add(l2);
        j1.add(l3);
        j1.add(l4);
        j1.add(l5);
        j1.add(t1);
        j1.add(t2);
        j1.add(t3); 
        j1.add(t4);
        j1.add(t5);
        j1.add(l);
        j1.add(b);
        j1.setSize(400,600);
        j1.setLayout(null);
        j1.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            Connection c=null;
            String url="jdbc:mysql://localhost:3306/college";
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver Loaded");
                c=DriverManager.getConnection(url,"root", "blackrider12345");
                System.out.println("connection established");
                Statement stmt=c.createStatement();
                //String sql ="select Email_id,Password from info where Email_Id = "'+t1.getText()+'
                String sql ="select * from student_details where Name =  '" +t1.getText()+ "' ";
                ResultSet re=stmt.executeQuery(sql);
                while(re.next())
                {
                    t2.setText(re.getString(2));
                    t3.setText(re.getString(3));
                    t4.setText(re.getString(4));
                    t5.setText(re.getString(5));
                    t2.setVisible(true);
                    t3.setVisible(true);
                    t4.setVisible(true);
                    t5.setVisible(true);
                    
                    System.out.println(t1.getText());
                    System.out.println(t2.getText());
                    System.out.println(t3.getText());
                    System.out.println(t4.getText());
                    System.out.println(t5.getText());
                    
                }
                // c.close();
            }
           catch(SQLException e1)
        {
            System.out.println("connection not established"+e1);
        }
           catch(ClassNotFoundException e2)
        {
            System.out.println("Driver not Loaded");
        }
        }
    }
    public static void main(String args[])
    {
        Play ob = new Play();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
