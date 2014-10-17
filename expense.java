/*-------------------------Expenses Details Window----------------------------*/
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;

class expense implements ActionListener
{
	Container c1;
      JFrame fexp;
      JPanel pexp;
      
      JTextField pertiname,expid,amt;
	  JLabel lexp,lsubmitr1; 
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
 	      expense  expense1=new expense();
       }
       
        public expense()
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
            
            fexp=new JFrame("Expenses");
            pexp=new JPanel();
            pexp.setLayout(null);
            pexp.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            pexp.setBounds(190,100,650,500);
            
           	f1=new Font("Times New Roman",Font.BOLD,35);
	    	f2=new Font("Times New Roman",Font.ITALIC,25);
		    f3=new Font("Times New Roman",Font.BOLD,15);
		    
		     mig=new ImageIcon("images\\b1.jpg");
		     
		     lexp = new JLabel("EXPENSES DETAILS");
	    	 lexp .setFont(f1);
		     lexp .setForeground(Color.red);
		     lexp .setBounds(125,15,500,35);
		     
		     JLabel lborder1=new JLabel(mig);
		     lborder1.setBounds(0,50,650,20);

		     lsubmitr1=new JLabel("Add Expense Item");
		     lsubmitr1.setFont(f2);
		     lsubmitr1.setForeground(Color.magenta);
	       	 lsubmitr1.setBounds(250,75,500,30);
	       	 JLabel lexpid= new JLabel("Particular ID");
	       	 lexpid.setFont(f3);
		     lexpid.setBounds(150,120,120,20);
		     JLabel lpertiname =new JLabel("Particular Name");
             lpertiname.setFont(f3);
		     lpertiname.setBounds(150,150,120,20);
		     JLabel lamt= new JLabel("Amount");
		     lamt.setFont(f3);
		     lamt.setBounds(150,180,100,20);
		     
		     expid = new JTextField();
		     expid.setBounds(300,120,50,20);
		     pertiname= new JTextField();
		     pertiname.setBounds(300,150,250,20);
		     amt = new JTextField();
		     amt.setBounds(300,180,70,20);
        
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
		     
		     pexp.add(lexp);pexp.add(lsubmitr1);

             pexp.add(lexpid);pexp.add(lborder1);pexp.add(expid);
	         pexp.add(lpertiname);pexp.add(pertiname);
             pexp.add(lamt); pexp.add(amt);
             pexp.add(lborder);
        
             pexp.add(ab); pexp.add(eb);
             pexp.add(sb);pexp.add(cb);pexp.add(hb);pexp.add(db);
             
            c1=fexp.getContentPane();
            c1.setLayout(null);
            c1.add(pexp,"Center");
            
            fexp.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fexp.setSize(800,600);
            fexp.setVisible(true);
            fexp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            
            public void clrAll()
      {
                  pertiname.setText("");
                  expid.setText("");
                  amt.setText("");
                  ab.setEnabled(true);
                  eb.setEnabled(false);
      }
      
       public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();

              if(obj==hb)
              {
                 fexp.dispose();
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
			   		   String  ss1="insert into expenses values('"+expid.getText()+"','" +pertiname.getText()+"','" +amt.getText() + "')";
                       s1.executeUpdate(ss1);
                       String msg= " Expenses Record Save Successfully";
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
                       s=expid.getText();
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:Sport","","");
			   		   stat = con.prepareStatement("select * from expenses where expid=?");
			   		   stat.setString(1,expid.getText());
			   		   rs1=stat.executeQuery();

                      if(rs1.next()){
			   		  expid.setText(rs1.getString(1));
			          pertiname.setText(rs1.getString(2));
			          amt.setText(rs1.getString(3));
			          
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
			   		   ps=con.prepareStatement("delete from expenses where expid =  ?");
			   		   ps.setString(1,expid.getText());
                       ps.executeUpdate();
                       String msg= " Expense Record deleted Successfully";
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
                     int i = JOptionPane.showConfirmDialog(fexp,"Do you want to Update","Update?",JOptionPane.YES_NO_OPTION);
                     if(i== JOptionPane.YES_OPTION){
                       String sdistid = expid.getText();
                       s1 = con.createStatement();

                       String q = "UPDATE expenses SET pertiname='"+pertiname.getText()+"',"+
                                  "amt='"+amt.getText()+"',"+
                                  "WHERE expid='"+expid+"'";

                        System.out.println(q);
                       int a = s1.executeUpdate(q);
                        clrAll();
			   		   System.out.println(a);
			   		   String msg= " Expense Record Updated Successfully!!!";
                       JOptionPane.showMessageDialog(fexp,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);
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