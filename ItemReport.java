import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;

class CustReport extends JFrame implements WindowListener, ActionListener
{
	int count = 0;
	java.util.Date date3;
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	JButton bprint = new JButton("PRINT");
	JButton bhome = new JButton("HOME");
	JButton bexit = new JButton("EXIT");
	Font f = new Font ("Bodoni MT",Font.BOLD,17);
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	Font h1 = new Font ("Wide Latin",Font.BOLD,22);
	JLabel logo = new JLabel("", new ImageIcon("image1.png"), JLabel.CENTER);
	JLabel img = new JLabel("", new ImageIcon("text2.png"), JLabel.RIGHT);

	CustReport()
	{
		super(" Report for Customer");
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

		 JLabel h2=new JLabel(" Report of  Customers");
	  	 h2.setBounds(300,50,500,30);
	   	 h2.setFont(h1);
	   	 add(h2);

		c.add(logo);
		logo.setBounds(890,-40, 150,150);
		c.add(img);
	   	img.setBounds(-30,-10, 150,150); 
		c.add(p1);
		c.add(p2);
		setSize(1034, 776);
		setLocation(-4,-5);

		bprint.addActionListener(this);
		bhome.addActionListener(this);
		bexit.addActionListener(this);

		p2.add(bprint);
		p2.add(bhome);
		p2.add(bexit);

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:Sport");
			st =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

			p1.setBounds(0,130, 1024, 500);
			p2.setBounds(0, 648, 0, 0);


			p1.setBackground(new Color(168, 81, 255));
			p2.setBackground(new Color(168, 81, 255));

			p1.setLayout(new BorderLayout());
			p2.setLayout(null);


			bprint.setBounds(400, 660, 100,25);
			bhome.setBounds(920,675,90,30);
			bexit.setBounds(540, 660, 100, 25);
			
			bprint.setToolTipText("This Button Prints Document");
			bhome.setToolTipText("This Button Goes to the Main Screen");
			bexit.setToolTipText("This Button Come out From the Software");

			String[] colHeads = { "Customer Id", "Customer Name", "Customer Address", "Customer Phone","Customer Mobile"};

			rs = st.executeQuery("select * from custinfo");

			while (rs.next())
			{
				count++;
			}

			Object[][] results = new Object[count][5];
			rs.first();

			for (int i = 0; i < count; i++)
			{
				results[i][0] = rs.getString(1);
				results[i][1] = rs.getString(2);
				results[i][2] = rs.getString(3);
				results[i][3] = rs.getString(4);
				results[i][4] = rs.getString(5);
				rs.next();
			}

			JTable table = new JTable(results, colHeads);

			int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

			JScrollPane jsp = new JScrollPane(table, v, h);

			p1.add(jsp, BorderLayout.CENTER);
		}
		catch (Exception e)
		{
			String dt = " ERROR";
			String dm = " ERROR : " + e;
			int dtype = JOptionPane.ERROR_MESSAGE;

			JOptionPane.showMessageDialog((Component)null, dm, dt, dtype);
		}

		 
		setVisible(true);
		c.setBackground(new Color(168, 81, 255));
		addWindowListener(this);
	}
	
	 public static void main(String args[])
	  {
	     CustReport cr=new CustReport();
	  }

	public void actionPerformed(ActionEvent a)
	{
		String s = a.getActionCommand();

		if (s.equals("HOME"))
		{
			setVisible(false);
		}
		else
		if(s.equals("PRINT"))
		{
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