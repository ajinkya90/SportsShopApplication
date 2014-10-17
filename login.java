/*-------------------------Login Window----------------------------*/
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.border.LineBorder;
import java.sql.*;

class login implements ActionListener
{
      Container c1;
      JFrame frmlog;
      JPanel panLog;

      JLabel l1,l2,l3;
	  JLabel luserid,luserpass;
	  JTextField uid;
	  JPasswordField upass;
	  JButton btnok,btnexit;
      Icon mig;
      Font f1;
       
      Connection cnn;
      PreparedStatement ps;
      ResultSet rs;

      public static void main(String args[])
      {
             login l1=new login();
       }

      login()
      {
            frmlog = new JFrame("Login");
            panLog = new JPanel();
            panLog.setLayout(null);

            panLog.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            panLog.setBounds(300,200,400,300);

		    f1=new Font("Times New Roman",Font.BOLD,20);
		    mig=new ImageIcon("images\\b1.jpg");

            luserid=new JLabel("User ID :");
		    luserid.setFont(f1);
		    luserid.setForeground(Color.black);
	     	luserid.setBounds(100,75,600,30);
		    luserpass= new JLabel("Password :");
		    luserpass.setFont(f1);
		    luserpass.setForeground(Color.black);
		    luserpass.setBounds(100,125,600,20);

            uid=new JTextField();
            uid.setText("Sai");
            //uid.setEditable(false);
            uid.setBounds(200,75,100,20);
            upass=new JPasswordField();
            upass.setBounds(200,125,100,20);

            JLabel lborder=new JLabel(mig);
		    lborder.setBounds(0,125,400,150);

            btnok=new JButton("OK");
            btnok.setBounds(100,235,80,25);
		    btnexit=new JButton("EXIT");
		    btnexit.setBounds(225,235,80,25);

            panLog.add(luserid);
            panLog.add(uid);
		    panLog.add(luserpass);
            panLog.add(upass);
            panLog.add(lborder);

            panLog.add(btnok);
            panLog.add(btnexit);

            btnok.addActionListener(this);
            btnexit.addActionListener(this);

            c1=frmlog.getContentPane();
            c1.setLayout(null);
            c1.add(panLog,"Center");

            frmlog.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmlog.setSize(1024,768);
            frmlog.setVisible(true);
            frmlog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
      
    public void actionPerformed(ActionEvent e1)
       {
              
            Object obj=e1.getSource();
            String sPassword = String.valueOf(upass.getPassword());
            String susername = String.valueOf(uid.getText());
            try
			{
			//check from database
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cnn=DriverManager.getConnection("jdbc:odbc:sport");
			ps=cnn.prepareStatement("select * from login where userid=? and pass = ?");
			ps.setString(1,susername);
			ps.setString(2,sPassword);
			rs=ps.executeQuery();  
		  
			  
              if(obj==btnok)
              {
              	//check from database
              	if(rs.next())
              	{
                             frmlog.dispose();
                             newmain1 m1=new newmain1();
                }
                else
                {
                JOptionPane.showMessageDialog(null,"Login Failed! Check Password!","Failed",JOptionPane.ERROR_MESSAGE);
                }
               }
               rs.close();
               ps.close();
               cnn.close();
              }
              catch(Exception e)
              {
              }
              
               
              if(obj==btnexit)
              {
                              System.exit(0);
              }
        }
 }