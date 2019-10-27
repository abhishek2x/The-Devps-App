package pkgfinal.project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Login implements ActionListener
{
    JFrame j1;
    JLabel l1, l2, l;
    JTextField t1, t2;
    JTextArea t3;
    JButton b;
    
    Login()
    {
        j1=new JFrame("LOGIN PAGE");
        l=new JLabel("LOGIN CREDENTIALS");
        l.setForeground(Color.red);
        l.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        l.setBounds(80,0, 400,60);
        
        l1=new JLabel("Email Id");
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        l1.setBounds(50,100,100,30);
        l2=new JLabel("Password");
        l2.setBounds(50,150,100,30);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        
        t1 = new JTextField(16);
        t1.setEditable(true);
        t1.setBounds(150,100,150,20);
        t2 = new JTextField(16);
        t2.setEditable(true);
        t2.setBounds(150,150,150,20);
        t3 = new JTextArea();
        t3.setEditable(false);
        t3.setBounds(150,200,200,200);
        t3.setLineWrap(true);
        
        b=new JButton("Get Info.");
        b.setBounds(50,270,100,50);
        b.addActionListener(this);
        j1.add(l);
        j1.add(l1);
        j1.add(l2);
        j1.add(t1);
        j1.add(t2); 
        j1.add(b);
        j1.add(t3);
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
            String url="jdbc:mysql://localhost:3306/Login";
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver Loaded");
                c=DriverManager.getConnection(url,"root", "blackrider12345");
                System.out.println("connection established");
                Statement stmt=c.createStatement();
                //String sql ="select Email_id,Password from info where Email_Id = "'+t1.getText()+'
                String sql ="select Email_id, Password from info where Email_id =  '" +t1.getText()+ "' AND Password = '" +t2.getText()+ "' ";
                ResultSet re=stmt.executeQuery(sql);
                while(re.next())
                {
                    if(t1.getText().equals(re.getString(1)) == true && t2.getText().equals(re.getString(2)) == true)
                    {
                        t3.setText("LOGIN SUCCESSFUL" +" "+ re.getString(1)+" "+re.getString(2));
                        System.out.println("LOGIN SUCCESSFUL");
                    }
                    else
                    {
                        t3.setText("LOGIN UNSUCCESSFUL " +" "+ re.getString(1)+" "+re.getString(2));
                        System.out.println("LOGIN UNSUCCESSFUL");
                    }
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
        Login ob = new Login();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
