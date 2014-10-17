/*-------------------------Stock Details Window----------------------------*/
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;

class Sporttabpan implements ActionListener
{
    Container c1;
    JFrame sfrm;
    JPanel pIndoor;
    JPanel poutdoor;
    JPanel pstat;
    Icon mig;
    Font f1,f2,f3,f4;
    String ch;
    String str;
    JLabel ldisp,lsubmitr1;

    PreparedStatement stat;
    ResultSet rs1;
    Statement s1;
    Connection con;
    /*----------------for Indoor details-----------------------*/
    JTextField Indoorname,Indoorid,bauther,bscost,bpcost,bquantity;
	JButton ab,eb,sb,cb,hb;
	/*----------------for Outdoor details-----------------------*/
     JTextField outdoorname,outdoorid,nbtype,nbscost,nbpcost,nbquantity;
     JComboBox nbpagesjcb,nbsizejcb,nbcomjcb;
	JButton ab1,eb1,sb1,cb1,hb1;
	 /*----------------for Accessories details-----------------------*/
	JTextField stname,stid,stscost,stmanuf,stpcost,stquantity;
	JButton ab2,eb2,sb2,cb2,hb2;



    public static void main(String args[])
    {
 	       Sporttabpan book1=new Sporttabpan();
    }

    public Sporttabpan(){
         try{
              UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              con=DriverManager.getConnection("jdbc:odbc:sport");
            }
        catch(Exception ex){
             System.out.println(ex);
            }
            sfrm=new JFrame("Stock Details");
            pIndoor= new JPanel();
            pIndoor.setLayout(null);
            poutdoor= new JPanel();
            poutdoor.setLayout(null);
            pstat= new JPanel();
            pstat.setLayout(null);
            JTabbedPane jtp = new JTabbedPane();
            jtp.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            jtp.addTab("Indoor Details",pIndoor);
            jtp.addTab("Outdoor Details",poutdoor);
            jtp.addTab("Accessories Details",pstat);
            c1=sfrm.getContentPane();
            c1.setLayout(null);
            jtp.setBounds(190,100,650,500);
            c1.add(jtp);

		    f1=new Font("Times New Roman",Font.BOLD,35);
		    f2=new Font("Times New Roman",Font.ITALIC,25);
		    f3=new Font("Times New Roman",Font.BOLD,15);

		    mig=new ImageIcon("images\\b1.jpg");

            /*-----------------------Indoor details start-----------------*/
            ldisp = new JLabel("!Indoor DETAILS!");
		    ldisp.setFont(f1);
		    ldisp.setForeground(Color.red);
		    ldisp.setBounds(200,7,300,35);

            JLabel lborder1=new JLabel(mig);
		    lborder1.setBounds(0,40,650,20);

		    lsubmitr1=new JLabel("Indoors Record ");
		    lsubmitr1.setFont(f2);
		    lsubmitr1.setForeground(Color.blue);
		    lsubmitr1.setBounds(260,60,450,20);

            JLabel lIndoorid= new JLabel("Indoors ID ");
		    lIndoorid.setFont(f3);
		    lIndoorid.setBounds(150,100,120,20);
            JLabel lIndoorname =new JLabel("Indoors Name");
            lIndoorname.setFont(f3);
		    lIndoorname.setBounds(150,130,120,20);
		    JLabel lauther= new JLabel("Company");
		    lauther.setFont(f3);
		    lauther.setBounds(150,160,120,20);
		   
		    JLabel lscost  = new JLabel("Indoors Sale Cost");
		    lscost.setFont(f3);
		    lscost.setBounds(150,220,150,20);
		    JLabel lpcost= new JLabel("Indoors Purchase Cost");
		    lpcost.setFont(f3);
		    lpcost.setBounds(150,250,150,20);
	        JLabel lbquantity =new JLabel("Quantity");
		    lbquantity.setFont(f3);
		    lbquantity.setBounds(150,280,150,20);

            JLabel lborder=new JLabel(mig);
            lborder.setBounds(0,280,650,150);

            Indoorid = new JTextField();
		    Indoorid.setBounds(300,100,50,20);
		    Indoorname= new JTextField();
		    Indoorname.setBounds(300,130,200,20);
		    bauther= new JTextField();
		    bauther.setBounds(300,160,150,20);
		   
		    bscost= new JTextField();
		    bscost.setBounds(300,220,50,20);
		    bpcost= new JTextField();
		    bpcost.setBounds(300,250,50,20);
		    bquantity= new JTextField();
		    bquantity.setBounds(300,280,50,20);

            ab=new JButton("ADD");
            ab.setBounds(80,400,90,25);
            ab.addActionListener(this);
		    eb=new JButton("UPDATE");
		    eb.setBounds(180,400,90,25);
		    eb.addActionListener(this);
		    sb=new JButton("SEARCH");
		    sb.setBounds(280,400,90,25);
		    sb.addActionListener(this);
		    cb=new JButton("CLEAR");
		    cb.setBounds(380,400,90,25);
		    cb.addActionListener(this);
		    hb=new JButton("HOME");
		    hb.setBounds(480,400,90,25);
		    hb.addActionListener(this);

            pIndoor.add(ldisp);pIndoor.add(lborder1);pIndoor.add(lsubmitr1);
            pIndoor.add(lIndoorid);pIndoor.add(Indoorid);
		    pIndoor.add(lIndoorname); pIndoor.add(Indoorname);
            pIndoor.add(lauther);pIndoor.add(bauther);
            pIndoor.add(lscost); pIndoor.add(bscost);
            pIndoor.add(lpcost); pIndoor.add(bpcost);
            pIndoor.add(lbquantity);pIndoor.add(bquantity); pIndoor.add(lborder);

            pIndoor.add(ab);pIndoor.add(eb);
            pIndoor.add(sb);pIndoor.add(cb);pIndoor.add(hb);

          /*---------------------Outdoor Details start------------------*/
        ldisp = new JLabel("!Outdoor DETAILS!");
		ldisp.setFont(f1);
		ldisp.setForeground(Color.red);
		ldisp.setBounds(150,7,500,35);

        JLabel lborder2=new JLabel(mig);
        lborder2.setBounds(0,40,650,20);

		lsubmitr1=new JLabel("Outdoors Record");
		lsubmitr1.setFont(f2);
		lsubmitr1.setForeground(Color.magenta);
		lsubmitr1.setBounds(250,60,450,20);
		JLabel loutdoorid= new JLabel("Outdoors ID");
		loutdoorid.setFont(f3);
		loutdoorid.setBounds(150,100,120,20);
        JLabel loutdoorname =new JLabel("Outdoors Name");
        loutdoorname.setFont(f3);
		loutdoorname.setBounds(150,130,120,20);
		JLabel lnbcompany= new JLabel("Company");
		lnbcompany.setFont(f3);
		lnbcompany.setBounds(150,160,100,20);
		
		JLabel lnbscost =new JLabel("Sale Cost");
		lnbscost.setFont(f3);
		lnbscost.setBounds(150,280,150,20);
		JLabel lnbpcost =new JLabel("Purchase Cost");
		lnbpcost.setFont(f3);
		lnbpcost.setBounds(380,280,100,20);
		JLabel lnbquantity =new JLabel("Quantity");
		lnbquantity.setFont(f3);
		lnbquantity.setBounds(150,310,150,20);

        outdoorid = new JTextField();
		outdoorid.setBounds(300,100,50,20);
		outdoorname= new JTextField();
		outdoorname.setBounds(300,130,200,20);
		nbcomjcb = new JComboBox();
                 nbcomjcb.addItem(" Addidas");
				 nbcomjcb.addItem(" Reebok");
				 nbcomjcb.addItem(" Nike");
				 nbcomjcb.addItem(" Babolat");
				 nbcomjcb.addItem(" Puma");
				 nbcomjcb.addItem(" ShivNaresh");
				 nbcomjcb.addItem(" Other");
        nbcomjcb.setBounds(300,160,100,20);
       
		nbscost= new JTextField();
		nbscost.setBounds(300,280,50,20);
		nbpcost= new JTextField();
		nbpcost.setBounds(500,280,50,20);
		nbquantity= new JTextField();
		nbquantity.setBounds(300,310,50,20);

        JLabel lborder3=new JLabel(mig);
		lborder3.setBounds(0,280,650,150);

        ab1=new JButton("ADD");
        ab1.setBounds(80,400,90,25);
        ab1.addActionListener(this);
		eb1=new JButton("UPDATE");
		eb1.setBounds(180,400,90,25);
		eb1.addActionListener(this);
		sb1=new JButton("SEARCH");
		sb1.setBounds(280,400,90,25);
		sb1.addActionListener(this);
		cb1=new JButton("CLEAR");
		cb1.setBounds(380,400,90,25);
		cb1.addActionListener(this);
		hb1=new JButton("HOME");
		hb1.setBounds(480,400,90,25);
        hb1.addActionListener(this);

		poutdoor.add(ldisp);	poutdoor.add(lsubmitr1);

        poutdoor.add(loutdoorid);poutdoor.add(lborder2);poutdoor.add(outdoorid);
		poutdoor.add(loutdoorname); poutdoor.add(outdoorname);
        poutdoor.add(lnbcompany); poutdoor.add(nbcomjcb);
       
        poutdoor.add(lnbscost); poutdoor.add(nbscost);
        poutdoor.add(lnbpcost); poutdoor.add(nbpcost);
        poutdoor.add(lnbquantity);poutdoor.add(nbquantity);poutdoor.add(lborder3);

        poutdoor.add(ab1); poutdoor.add(eb1);
        poutdoor.add(sb1);poutdoor.add(cb1);poutdoor.add(hb1);

         /*-----------------------Accessories details start----------------------*/

         ldisp = new JLabel("!Accessories DETAILS!");
		ldisp.setFont(f1);
		ldisp.setForeground(Color.red);
		ldisp.setBounds(140,7,500,35);

        JLabel lborder4=new JLabel(mig);
		lborder4.setBounds(0,40,650,20);

		lsubmitr1=new JLabel("Accessories Record ");
		lsubmitr1.setFont(f2);
		lsubmitr1.setForeground(Color.magenta);
		lsubmitr1.setBounds(250,60,450,25);

        JLabel lstid= new JLabel("Accessories ID ");
		lstid.setFont(f3);
		lstid.setBounds(150,100,120,20);
        JLabel lstname =new JLabel("Accessories Name");
        lstname.setFont(f3);
		lstname.setBounds(150,130,120,20);
		JLabel lstmanuf= new JLabel("Manufacturer");
		lstmanuf.setFont(f3);
		lstmanuf.setBounds(150,160,150,20);
        JLabel lstscost= new JLabel("Sale Cost");
		lstscost.setFont(f3);
		lstscost.setBounds(150,190,120,20);
		JLabel lstpcost= new JLabel("Purchase Cost");
		lstpcost.setFont(f3);
		lstpcost.setBounds(150,220,100,20);
		JLabel lstquantity = new JLabel("Quantity");
		lstquantity.setFont(f3);
		lstquantity.setBounds(150,250,150,20);

	    JLabel lborder5=new JLabel(mig);
        lborder5.setBounds(0,280,650,150);

        stid = new JTextField();
		stid.setBounds(300,100,50,20);
		stname= new JTextField();
		stname.setBounds(300,130,200,20);
		stmanuf= new JTextField();
		stmanuf.setBounds(300,160,75,20);
		stscost= new JTextField();
		stscost.setBounds(300,190,50,20);
		stpcost= new JTextField();
		stpcost.setBounds(300,220,50,20);
		stquantity= new JTextField();
		stquantity.setBounds(300,250,50,20);

        ab2=new JButton("ADD");
        ab2.setBounds(80,400,90,25);
        ab2.addActionListener(this);
		eb2=new JButton("UPDATE");
		eb2.setBounds(180,400,90,25);
		eb2.addActionListener(this);
		sb2=new JButton("SEARCH");
		sb2.setBounds(280,400,90,25);
		sb2.addActionListener(this);
		cb2=new JButton("CLEAR");
		cb2.setBounds(380,400,90,25);
		cb2.addActionListener(this);
		hb2=new JButton("HOME");
		hb2.setBounds(480,400,90,25);
		hb2.addActionListener(this);

		pstat.add(ldisp); pstat.add(lborder4); pstat.add(lsubmitr1);
        pstat.add(lstid);pstat.add(stid);
		pstat.add(lstname); pstat.add(stname);
		pstat.add(lstmanuf);pstat.add(stmanuf);
        pstat.add(lstscost); pstat.add(stscost);
		pstat.add(lstpcost);pstat.add(stpcost);
        pstat.add(lstquantity);pstat.add(stquantity); pstat.add(lborder5);

        pstat.add(ab2); pstat.add(eb2);
        pstat.add(sb2);pstat.add(cb2); pstat.add(hb2);

             sfrm.setExtendedState(JFrame.MAXIMIZED_BOTH);
             sfrm.setSize(760,550);
             sfrm.setVisible(true);
             sfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

    public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();

              /*------------Buttons on Indoor Details--------------*/
              if(obj==hb) //home
              {
                 sfrm.dispose();
                 newmain1 m1=new newmain1();
              }
              if(obj==cb) //clear
              {
                  Indoorname.setText("");
                  Indoorid.setText("");
                  bauther.setText("");
                  bscost.setText("");
                  bpcost.setText("");
                  bquantity.setText("");
                  ab.setEnabled(true);
                  eb.setEnabled(false);
              }
              if(obj==ab) //Indoor add
              {

				 try
			  	 {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection con=DriverManager.getConnection("jdbc:odbc:Sport");
			   		Statement s1=con.createStatement();
                    String  ss1=("insert into Indoors values('"+Indoorid.getText()+"','"+Indoorname.getText()+"','" +bauther.getText() + "','" +bscost.getText()+ "','" +bpcost.getText() + "','"+bquantity.getText()+ "')");
                    s1.executeUpdate(ss1);
                    String msg= " Indoors Record Save Successfully";
                    JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);


                    con.close();
                 }
                 catch(Exception ex)
			  	 {
			    		System.out.println(ex);
			    		String msg= "Record of this Id is already present. Please Change The Indoorid";
                        JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);
			   	 }

			 }
			 if(obj==sb) //Indoor search
             {
			      try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:Sport");
			   		   stat = con.prepareStatement("select * from Indoors where Indoor_id=?");
			   		   stat.setString(1,Indoorid.getText());
			   		   rs1=stat.executeQuery();
			   		   if(rs1.next())
                        {
                         Indoorid.setText(rs1.getString(1));
			             Indoorname.setText(rs1.getString(2));
			             bauther.setText(rs1.getString(3));
			             bscost.setText(rs1.getString(4));
			             bpcost.setText(rs1.getString(5));
			             bquantity.setText(rs1.getString(6));

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
               if(obj==eb) //Indoor update
              {
                   try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:Sport","","");
                       s1 = con.createStatement();
                       String q = "update Indoors set Indoor_name='"+Indoorname.getText()+"',company='" +bauther.getText()+ "',sale_cost='" +bscost.getText()+ "',purchase_cost='" +bpcost.getText() + "',quantity='"+bquantity.getText()+ "'where Indoor_id='" +Indoorid.getText() + "'";
                       s1.executeUpdate(q);
                       System.out.println(q);
                       String msg= " Book Record Updated Successfully!!!";
                       JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
              }

		      /*------------Buttons on Outdoor Details--------------*/
              if(obj==hb1)//home
              {
                 sfrm.dispose();
                 newmain1 m1=new newmain1();
              }
              if(obj==cb1) //clear
              {
                  outdoorname.setText("");
                  outdoorid.setText("");
                  nbscost.setText("");
                  nbpcost.setText("");
                  nbtype.setText("");
                  nbquantity.setText("");
                  ab1.setEnabled(true);
                  eb1.setEnabled(false);
              }
              if(obj==ab1) //Outdoor add
              {
                    try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:Sport");
			   		   Statement s1=con.createStatement();
			   		   String  ss1=("insert into Outdoors values('"+outdoorid.getText()+"','"+outdoorname.getText()+"','" +nbcomjcb.getSelectedItem() + "','"+nbscost.getText()+"','"+nbpcost.getText()+"','"+nbquantity.getText()+"')");
                       s1.executeUpdate(ss1);
                       String msg= " Outdoor Record Save Successfully";
                       JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);

                    con.close();

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                        String msg= "Record of this Id is already present. Please Change The outdoorid";
                       JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);
                    }
              }
              if(obj==sb1) //Outdoor search
             {
			      try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:Sport");
			   		   stat = con.prepareStatement("select * from Outdoors where outdoorid=?");
			   		   stat.setString(1,outdoorid.getText());
			   		   rs1=stat.executeQuery();
			   		   if(rs1.next())
                        {
			   		     outdoorid.setText(rs1.getString(1));
			             outdoorname.setText(rs1.getString(2));
			             nbcomjcb.setSelectedItem(rs1.getString(3));
			             nbscost.setText(rs1.getString(4));
			             nbpcost.setText(rs1.getString(5));
			             nbquantity.setText(rs1.getString(6));

			             eb1.setEnabled(true);
                         ab1.setEnabled(false);
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
                     if(obj==eb1) //Outdoor update
              {
                   try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:Sport","","");
                       s1 = con.createStatement();
                       String q = "update Outdoors set outdoorname='"+outdoorname.getText()+"',company='" +nbcomjcb.getSelectedItem() + "',nbsale_cost='"+nbscost.getText()+"',nbpurchase_cost='"+nbpcost.getText()+"',quantity='"+nbquantity.getText()+"'where outdoorid='" +outdoorid.getText() + "'";
                       s1.executeUpdate(q);
                       System.out.println(q);
                       String msg= " Outdoor Record Updated Successfully!!!";
                       JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
              }

               /*------------Buttons on Accessories Details--------------*/
              if(obj==hb2) //home
              {
                 sfrm.dispose();
                 newmain1 m1=new newmain1();
              }
              if(obj==cb2) //clear
              {
                  stname.setText("");
                  stid.setText("");
                  stmanuf.setText("");
                  stscost.setText("");
                  stpcost.setText("");
                  stquantity.setText("");
                  ab2.setEnabled(true);
                  eb2.setEnabled(false);
              }
              if(obj==ab2)  //Accessories add
              {
                    try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:Sport");
			   		   Statement s1=con.createStatement();
			   		   String  ss1=("insert into Accessoriess values('"+stid.getText()+"','"+stname.getText()+"','" +stmanuf.getText() + "','" +stscost.getText() + "','" +stpcost.getText() + "','" +stquantity.getText() +"')");
                       s1.executeUpdate(ss1);
                       String msg= " Accessories Record Save Successfully";
                       JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);


                    con.close();

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                        String msg= "Record of this Id is already present. Please Change The stid";
                       JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);
                    }
              }
              if(obj==sb2) //Accessories search
             {
			      try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:Sport");
			   		   stat = con.prepareStatement("select * from Accessories where stid=?");
			   		   stat.setString(1,stid.getText());
			   		   rs1=stat.executeQuery();
			   		   if(rs1.next())
                          {
			   		       stid.setText(rs1.getString(1));
			               stname.setText(rs1.getString(2));
			               stmanuf.setText(rs1.getString(3));
			               stscost.setText(rs1.getString(4));
			               stpcost.setText(rs1.getString(5));
			               stquantity.setText(rs1.getString(6));

			               eb2.setEnabled(true);
                           ab2.setEnabled(false);
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
              if(obj==eb2) //Accessories update
              {
                   try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:Sport","","");
                       s1 = con.createStatement();
                       String q = "update Accessories set stname='"+stname.getText()+"',manufacturar='" +stmanuf.getText() + "',Sale_cost='" +stscost.getText() + "',Purchase_cost='" +stpcost.getText() + "',Quantity='" +stquantity.getText() +"'where stid='" +stid.getText() + "'";
                       s1.executeUpdate(q);
                       System.out.println(q);
                       String msg= " Accessories Record Updated Successfully!!!";
                       JOptionPane.showMessageDialog((Component)null,msg,"Sport",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
              }
       }
 }