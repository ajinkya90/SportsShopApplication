/*---------------------Customer Details Window------------------------*/
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;

class cust implements ActionListener
{
      Container c1;
      JFrame fcust;
      JPanel pcust;
      JScrollPane sp;

      JTextField custname,custid,custph,custmob;
	  JLabel lcustp,lsubmitr1;
	  JTextArea custaddr;
      JButton ab,eb,sb,cb,hb,db;
      Icon mig;
      Font f1,f2,f3,f4;

      PreparedStatement stat;
      ResultSet rs1;
      Statement s1;
      PreparedStatement ps;
      Connection con;

       public static void main(String args[])
       {
 	          cust cust1=new cust();
       }

      public cust()
      {
            try
            {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               con=DriverManager.getConnection("jdbc:odbc:Sport");
            }
            catch(Exception ex)
            {
               System.out.println(ex);
            }

            fcust=new JFrame("Customer");
            pcust=new JPanel();
            pcust.setLayout(null);
            pcust.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            pcust.setBounds(190,100,650,500);

		f1=new Font("Times New Roman",Font.BOLD,35);
		f2=new Font("Times New Roman",Font.ITALIC,25);
		f3=new Font("Times New Roman",Font.BOLD,15);

        mig=new ImageIcon("images\\b1.jpg");

		lcustp = new JLabel("CUSTOMER DETAILS");
		lcustp.setFont(f1);
		lcustp.setForeground(Color.red);
		lcustp.setBounds(125,15,500,35);

        JLabel lborder1=new JLabel(mig);
		lborder1.setBounds(0,50,650,20);

		lsubmitr1=new JLabel("Add Customer");
		lsubmitr1.setFont(f2);
		lsubmitr1.setForeground(Color.magenta);
		lsubmitr1.setBounds(250,75,500,30);
		JLabel lcustid= new JLabel("Customer ID");
		lcustid.setFont(f3);
		lcustid.setBounds(150,120,120,20);
        JLabel lcustname =new JLabel("Customer Name");
        lcustname.setFont(f3);
		lcustname.setBounds(150,150,120,20);
		JLabel lcustaddr= new JLabel("Address");
		lcustaddr.setFont(f3);
		lcustaddr.setBounds(150,180,100,20);
		JLabel lcustph = new JLabel("Phone No.");
		lcustph.setFont(f3);
		lcustph.setBounds(150,270,150,20);
		JLabel lcustmob= new JLabel("Mobile No.");
		lcustmob.setFont(f3);
		lcustmob.setBounds(150,300,150,20);
		

		custid = new JTextField();
		custid.setBounds(300,120,50,20);
		custname= new JTextField();
		custname.setBounds(300,150,250,20);
		custaddr = new JTextArea();
		custaddr.setLineWrap(true);
        sp = new JScrollPane(custaddr);
		sp.setBounds(300,180,175,70);

		custph= new JTextField();
		custph.setBounds(300,270,100,20);
		custmob= new JTextField();
		custmob.setBounds(300,300,100,20);
        

        JLabel lborder=new JLabel(mig);
		lborder.setBounds(0,300,650,150);

        ab=new JButton("ADD");
        ab.setBounds(40,420,90,25);
        ab.addActionListener(this);
		eb=new JButton("UPDATE");
		eb.setEnabled(false);
		eb.setBounds(140,420,90,25);
		eb.addActionListener(this);
		sb=new JButton("SEARCH");
		sb.setBounds(240,420,90,25);
		sb.addActionListener(this);
		cb=new JButton("CLEAR");
		cb.setBounds(340,420,90,25);
		cb.addActionListener(this);
		hb=new JButton("HOME");
		hb.setBounds(440,420,90,25);
		hb.addActionListener(this);
		db=new JButton("DELETE");
        db.setBounds(540,420,90,25);
		db.addActionListener(this);
		
		pcust.add(lcustp);pcust.add(lsubmitr1);

        pcust.add(lcustid);pcust.add(lborder1);pcust.add(custid);
		pcust.add(lcustname); pcust.add(custname);
        pcust.add(lcustaddr); pcust.add(sp);
        pcust.add(lcustph); pcust.add(custph);
        pcust.add(lcustmob); pcust.add(custmob);
        pcust.add(lborder);

        pcust.add(ab); pcust.add(eb);
        pcust.add(sb);pcust.add(cb);pcust.add(hb);pcust.add(db);

            c1=fcust.getContentPane();
            c1.setLayout(null);
            c1.add(pcust,"Center");

            fcust.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fcust.setSize(800,600);
            fcust.setVisible(true);
            fcust.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
      
      public void clrAll()
      {
                  custname.setText("");
                  custid.setText("");
                  custaddr.setText("");
                  custph.setText("");
                  custmob.setText("");
                  ab.setEnabled(true);
                  eb.setEnabled(false);
      }

       public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();

              if(obj==hb)
              {
                 fcust.dispose();
                 newmain1 m1=new newmain1();
              }
               if(obj==cb)
              {
                  clrAll();
              }
              if(obj==ab)
              {
                    try
                    {
			   		   s1=con.createStatement();
			   		   String  ss1="insert into custinfo values('"+custid.getText()+"','"+custname.getText()+"','" +custaddr.getText() + "','" +custph.getText() + "','" +custmob.getText() + "' )";
                       s1.executeUpdate(ss1);
                       String msg= " Customer Record Save Successfully";
                       JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);
                    s1.close();
                    con.close();

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }

              }
              if(obj==sb)
              {
                    try
                    {
                       String s;
                       s=custid.getText();
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:Sport","","");
			   		   stat = con.prepareStatement("select * from custinfo where custid=?");
			   		   stat.setString(1,custid.getText());
			   		   rs1=stat.executeQuery();

                      if(rs1.next()){
			   		  custid.setText(rs1.getString(1));
			          custname.setText(rs1.getString(2));
			          custaddr.setText(rs1.getString(3));
			          custph.setText(rs1.getString(4));
			          custmob.setText(rs1.getString(5));

			          eb.setEnabled(true);
                      ab.setEnabled(false);
                      }
                      else{
                        String msg= "Record Does not exist";
                        JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);
                      }
                      stat.close();
                      con.close();

                    }
                    catch(SQLException se)
                    {
                        System.err.println(se);

                    }
                    catch(Exception e)
                    {
                        System.err.println(e);
                    }

              }
              
                  if(obj==db)
              {
                    try
                    {
			   		   ps=con.prepareStatement("delete from custinfo where custid =  ?");
			   		   ps.setString(1,custid.getText());
                       ps.executeUpdate();
                       String msg= " Customer Record deleted Successfully";
                       JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);
                       ps.close();
                       con.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
              }
              
                           
              
               if(obj==eb)
              {
                   try
                    {   s1=null;
                     int i = JOptionPane.showConfirmDialog(fcust,"Do you want to Update","Update?",JOptionPane.YES_NO_OPTION);
                     if(i== JOptionPane.YES_OPTION){
                       String sdistid = custid.getText();
                       s1 = con.createStatement();

                       String q = "UPDATE custinfo SET custname='"+custname.getText()+"',"+
                                  "custaddr='"+custaddr.getText()+"',"+
                                  "custph='"+custph.getText()+"',"+
                                  "custmob='"+custmob.getText()+"',"+
                                  "WHERE custid='"+custid+"'";

                        System.out.println(q);
                       int a = s1.executeUpdate(q);
                        clrAll();
			   		   System.out.println(a);
			   		   String msg= " Customer Record Updated Successfully!!!";
                       JOptionPane.showMessageDialog(fcust,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);
			   		}
			   		else{return;}

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }

              }
        }
}