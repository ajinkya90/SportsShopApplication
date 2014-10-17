/*-------------------------Rejection Order Window----------------------------*/
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import java.util.Date;
import java.util.Calendar;
import javax.swing.border.LineBorder;
import java.sql.*;

class reject extends JPanel implements ActionListener,ItemListener
{
      Container c1;
      JFrame freject;
      JPanel preject;
      JLabel ldisp,lsubmitr1,l4,l6,l7,ldistid,ldistname,lperti,lpcost,lrejectquantity,lamount;
      JTextField distname,distid,distfor,pcost,rejectquantity,amount,tf1,tf2;
      JComboBox perti;
      Thread datimeThread;
	  Date date;
	  GregorianCalendar calendar;
	  String strDate, strTime, strStatus,sss;
      Icon mig;
      Font f1,f2,f3,f4;
      JComboBox amttype;
      JButton bsave,bnew,bhome,bclear,bnext,bprev,bshow;


      PreparedStatement stat;
      ResultSet rs1;
      ResultSet rs2;
      Statement s1,s2;
      Connection con;

      public static void main(String args[])
       {
 	          reject p1=new reject();
       }

      public reject()
      {

            try
            {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch(Exception ex)
            {
               System.out.println(ex);
            }
            try
            {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   	    con=DriverManager.getConnection("jdbc:odbc:Sport","","");
			   	    s1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			   	    s2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			   	    rs1 = s1.executeQuery("select * from distinfo");
			   	 
			}
			catch(Exception e)
			{
			 System.out.println(e);
            }
            freject=new JFrame("Rejection Order");
            preject=new JPanel();
            preject.setLayout(null);
            preject.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            preject.setBounds(190,100,650,500);

        f1=new Font("Times New Roman",Font.BOLD,35);
		f2=new Font("Times New Roman",Font.ITALIC,25);
		f3=new Font("Times New Roman",Font.BOLD,15);

        mig=new ImageIcon("images\\b1.jpg");

		ldisp = new JLabel("!REJECTION OF ORDER!");
		ldisp.setFont(f1);
		ldisp.setForeground(Color.red);
		ldisp.setBounds(135,15,500,35);

        JLabel lborder1=new JLabel(mig);
		lborder1.setBounds(0,50,650,20);

		date=new Date();
		calendar=new GregorianCalendar();
		calendar.setTime(date);

		strDate =
		calendar.get(Calendar.DATE)+" / "+(calendar.get(Calendar.MONTH)+1)+" / "+calendar.get(Calendar.YEAR);

		l4=new JLabel("Date :-");
		l4.setFont(f3);
        l4.setBounds(430,90,90,20);
		l6=new JLabel(strDate);
        l6.setBounds(480,90,90,20);

        ldistid= new JLabel("Distributor ID");
		ldistid.setFont(f3);
		ldistid.setBounds(150,120,120,20);
        ldistname =new JLabel("Distributor Name");
        ldistname.setFont(f3);
		ldistname.setBounds(150,150,120,20);
		JLabel ldistfor= new JLabel("Distributor for");
		ldistfor.setFont(f3);
		ldistfor.setBounds(150,180,150,20);
	
		l7=new JLabel("______________________________________________________________________________");
        l7.setBounds(100,200,650,20);
        lperti= new JLabel("Particulars");
		lperti.setFont(f3);
		lperti.setBounds(150,230,120,20);
		lpcost= new JLabel("Purchase Cost");
		lpcost.setFont(f3);
		lpcost.setBounds(150,260,120,20);
		lrejectquantity= new JLabel("Rejectquantity");
		lrejectquantity.setFont(f3);
		lrejectquantity.setBounds(420,260,80,20);
		lamount= new JLabel("Amount");
		lamount.setFont(f3);
		lamount.setBounds(150,290,120,20);
		

		distid = new JTextField();
		distid.setBounds(300,120,50,20);
		distid.setEditable(false);
		distname= new JTextField();
		distname.setBounds(300,150,250,20);
		distname.setEditable(false);
		distfor = new JTextField();
		distfor.setBounds(300,180,100,20);
		distfor.setEditable(false);
		perti=new JComboBox();
		perti.setBounds(300,230,150,20);
		perti.addItemListener(this);
		pcost=new JTextField();
		pcost.setBounds(300,260,70,20);
		rejectquantity=new JTextField();
		rejectquantity.setBounds(500,260,50,20);

		KeyListen k2 = new KeyListen();
		rejectquantity.addKeyListener(k2);

		amount=new JTextField();
		amount.setBounds(300,290,70,20);
	

		JLabel lborder=new JLabel(mig);
		lborder.setBounds(0,320,650,150);

        bsave=new JButton("SAVE");
        bsave.setBounds(150,430,80,25);
        bsave.addActionListener(this);
        bnew=new JButton("NEW");
        bnew.setBounds(240,430,80,25);
        bnew.addActionListener(this);
        bclear=new JButton("CLEAR");
        bclear.setBounds(330,430,80,25);
        bclear.addActionListener(this);
        bhome=new JButton("HOME");
        bhome.setBounds(420,430,80,25);
        bhome.addActionListener(this);
        bnext=new JButton(">>");
        bnext.setBounds(470,120,50,20);
        bnext.addActionListener(this);
        bprev=new JButton("<<");
        bprev.setBounds(400,120,50,20);
        bprev.addActionListener(this);
        bshow=new JButton("Show Particulars");
        bshow.addActionListener(this);
        bshow.setFont(f3);
		bshow.setBounds(410,180,150,20);
        preject.add(bshow);
            preject.add(l4);
            preject.add(l6);preject.add(l7);
            preject.add(ldisp);preject.add(lborder1);
            preject.add(ldistid);preject.add(distid);
		    preject.add(ldistname); preject.add(distname);
		    preject.add(ldistfor);preject.add(distfor);
		    preject.add(lperti);preject.add(perti);
            preject.add(lpcost);preject.add(pcost);
            preject.add(lrejectquantity);preject.add(rejectquantity);
            preject.add(lamount);preject.add(amount);
            preject.add(lborder);

            preject.add(bsave);preject.add(bnew);
            preject.add(bclear);preject.add(bhome);preject.add(bprev);preject.add(bnext);

            c1=freject.getContentPane();
            c1.setLayout(null);
            c1.add(preject,"Center");

            freject.setExtendedState(JFrame.MAXIMIZED_BOTH);
            freject.setSize(800,600);
            freject.setVisible(true);
            freject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    class  KeyListen extends KeyAdapter
        {
               public void keyReleased(KeyEvent ke)
               {
               Object obj = ke.getSource();
               if(obj==rejectquantity){
                    try{
                    int a=Integer.parseInt(pcost.getText())*Integer.parseInt(rejectquantity.getText());
                    amount.setText(String.valueOf(a));
                    }
                    catch(Exception ex){System.out.println(ex);}
               }
               }
        }
        
     public void itemStateChanged(ItemEvent e)
     {
     	    
            ResultSet rs3=null;
             try
             {
                     rs3 = s2.executeQuery("select * from "+ sss);
                     while(rs3.next())
                     {
                      String s = perti.getSelectedItem().toString();
                      //String s = String.valueOf(itemname.getSelectedItem());
                      if(s.equals(rs3.getString(2)))
                      {
                         pcost.setText(rs3.getString(1));
                      }
                     }
                     rs3.close();
     			}
     			catch(Exception ee){}
		}   

     public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();

              
              if(obj==bshow)
              {
              	 		try
              	 		{
              	 		sss = distfor.getText().toString().trim();
                        stat = con.prepareStatement("select * from " + sss);
			   	    	rs2 = stat.executeQuery();
                    	perti.removeAllItems();
                    	while(rs2.next())
                        {
                         perti.addItem(rs2.getString(2));
                         }
                         }
                         catch(SQLException e)
                         {
                         }
              }
               if(obj==bsave){
                       try{
                        s1=null;
			   		    s1=con.createStatement();
			   		    String  ss1="insert into reject values('"+strDate+"',"+
                          "'" +distid.getText()+ "',"+
                          "'" +distname.getText() + "',"+
                          "'" +perti.getSelectedItem() + "',"+
                          "'" +pcost.getText() + "',"+
                          "'" +rejectquantity.getText() + "',"+
                          "'" +amount.getText() + "')";
                       s1.executeUpdate(ss1);
                       String msg= "rejected Order Save  Successfully";
                       JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
              }
              if(obj==bhome)
              {
                 freject.dispose();
                 newmain1 m1= new newmain1();
              }
               if(obj==bnew)
              {
                  //perti.setText("");
                  pcost.setText("");
                  rejectquantity.setText("");
                  amount.setText("");
              }
               if(obj==bclear)
              {
                  distid.setText("");
                  distname.setText("");
                  distfor.setText("");
                 // perti.setText("");
                  pcost.setText("");
                  rejectquantity.setText("");
                  amount.setText("");
              }
              if(obj==bnext)
              {
                    try{
                         rs1.next();
                         rs1.refreshRow();
                         distid.setText(rs1.getString(1));
                         distname.setText(rs1.getString(2));
                         distfor.setText(rs1.getString(6));
                    }

                    catch(Exception e)
                    {
                         System.out.println(e);
                         String msg= "Record Does not exist";
                         JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);
                    }

              }
              if(obj==bprev)
              {
                    try{
                         rs1.previous();
                         rs1.refreshRow();
                         distid.setText(rs1.getString(1));
                         distname.setText(rs1.getString(2));
                         distfor.setText(rs1.getString(6));

                    }
                    catch(Exception e)
                    {
                         System.out.println(e);
                         String msg= "Record Does not exist";
                         JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);
                    }
              }
       }
}