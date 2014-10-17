/*-------------------------Profit & Loss Window----------------------------*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;

class ProfitReport extends JFrame implements WindowListener, ActionListener
{
	Connection con;
	Statement st1,st2,st3;
	ResultSet rs1,rs2,rs3;
	PreparedStatement pst;
	java.util.Date date3;
	
	JFrame fm;
	JButton bprint = new JButton("PRINT");
	JButton bhome = new JButton("HOME");
	JButton bexit = new JButton("EXIT");
	Font f = new Font ("Bodoni MT",Font.BOLD,17);
	JPanel p1 = new JPanel();
    
	Font h1 = new Font ("Wide Latin",Font.BOLD,22);
	JLabel logo = new JLabel("", new ImageIcon("image1.png"), JLabel.CENTER);
	JLabel img = new JLabel("", new ImageIcon("text2.png"), JLabel.RIGHT);
	JLabel l1,l2,l3,l5;
	JTextField t1,t2,t3,t4;
	
	ProfitReport() 
	{
		super(" Profit & Loss Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container c = getContentPane();
		JLabel l4=new JLabel("DATE:");
	   	l4.setBounds(840,90,100,25);
	   	l4.setFont(f);
	   	add(l4);

		JTextField t4 =new JTextField();
		t4.setBounds(900,90,75,25);
		add(t4);
		t4.setEditable(false);

		date3=new java.util.Date();
	   	SimpleDateFormat sdf3= new SimpleDateFormat("dd MMM yyyy");
	   	String s3= sdf3.format(date3);
	   	t4.setText(s3);

		JLabel l1=new JLabel("Total Sales :");
	   	l1.setBounds(200,150,100,25);
	   	l1.setFont(f);
	   	add(l1);

		JTextField t1 =new JTextField();
		t1.setBounds(350,150,100,25);
		add(t1);
		t1.setEditable(false);

	    JLabel l2=new JLabel("Total Expenses :");
	   	l2.setBounds(200,190,100,25);
	   	l2.setFont(f);
	   	add(l2);

		JTextField t2 =new JTextField();
		t2.setBounds(350,190,100,25);
		add(t2);
		t2.setEditable(false);
		
		JLabel l3=new JLabel("Total Purchases :");
	   	l3.setBounds(200,230,100,25);
	   	l3.setFont(f);
	   	add(l3);

		JTextField t3 =new JTextField();
		t3.setBounds(350,230,100,25);
		add(t3);
		t3.setEditable(false);
		
		JLabel l5=new JLabel("Profit/Loss :");
	   	l5.setBounds(200,270,100,25);
	   	l5.setFont(f);
	   	add(l5);

		JTextField t5 =new JTextField();
		t5.setBounds(350,270,100,25);
		add(t5);
		t5.setEditable(false);

		JLabel h2=new JLabel(" Profit & Loss Report");
	  	h2.setBounds(300,50,500,30);
	   	h2.setFont(h1);
	   	add(h2);

		c.add(logo);
		logo.setBounds(890,-40, 150,150);
		c.add(img);
	   	img.setBounds(-30,-10, 150,150); 
		c.add(p1);
	
		setSize(1034, 776);
		setLocation(-4,-5);

		bprint.addActionListener(this);
		bhome.addActionListener(this);
		bexit.addActionListener(this);
		
		p1.add(bprint);
		p1.add(bhome);
		p1.add(bexit);
         
         try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:Sport");
			st1 =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			st2 =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			st3 =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs1 = st1.executeQuery("select * from pbill");
			rs2 = st2.executeQuery("select * from expenses");
			rs3 = st3.executeQuery("select * from sbill");
			int sum1=0,sum2=0,sum3=0;

			p1.setBounds(0,130, 1024, 500);
		

            p1.setBackground(new Color(168, 81, 255));
		

			p1.setLayout(new BorderLayout());
		

        	bprint.setBounds(400, 660, 100,25);
			bhome.setBounds(920,675,90,30);
			bexit.setBounds(540, 660, 100, 25);
			
			bprint.setToolTipText("This Button Prints Document");
			bhome.setToolTipText("This Button Goes to the Main Screen");
			bexit.setToolTipText("This Button Come out From the Software");   			
			
			while(rs1.next())
			{
				sum1 = sum1 + Integer.parseInt(rs1.getString(7));
			}
		    t3.setText(" " +sum1);
			
			while(rs2.next())
			{
				sum2 = sum2 + Integer.parseInt(rs2.getString(3));
			}
			 t2.setText(" " +sum2);
			
			while(rs3.next())
			{
				sum3 = sum3 + Integer.parseInt(rs3.getString(5));
			}
			 t1.setText(" " +sum3);
			
			double prof = sum3 - (sum1+sum2);
			
			if(prof < 0)
			{
				t5.setText("Loss=  " +prof);
			}
		
			else
			{
				t5.setText("Profit=  " +prof);
			}
		 }
	       
	       catch(Exception e)
	       {
	       	}
	}
	
	public static void main(String args[])
	{
		ProfitReport p = new ProfitReport();
		p.show();
	}
	
	public void actionPerformed(ActionEvent a)
	{
     	String s = a.getActionCommand();

		if (s.equals("HOME"))
		{
			
		}
		else
		if(s.equals("PRINT"))
		{
			fm.dispose();
            report r1= new report();
//			PrintUtilities.printComponent (this);
		}
		else
		if (s.equals("EXIT"))
		{
			System.exit(0);
		}
	}

	public void windowClosing(WindowEvent w)
	{
		setVisible(false);
	}

	public void windowClosed(WindowEvent w) { }
	public void windowOpened(WindowEvent w) { }
	public void windowActivated(WindowEvent w) { }
	public void windowDeactivated(WindowEvent w) { }
	public void windowIconified(WindowEvent w) { }
	public void windowDeiconified(WindowEvent w) { }
	}
