/*-------------------------Report Window----------------------------*/
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.border.LineBorder;

class report extends MouseAdapter implements ActionListener
{
      Container c1;
      JFrame fm;
      JPanel pm;
      JLabel l10,l11;
      JLabel lstock,lbil,ldist,cpr;
      JButton btnAbout;
	  JButton bcust,bsbil,bpbil,bdist,bhome,bpl,breject;
      Icon mig,mig2,mig1,mign;
      Font f1,f2,f3,f4;
      Window w;
      JPanel p;
      JLabel lbla;
      JOptionPane optDialog;

       public static void main(String args[])
       {
 	          report r1=new report();
 	          r1.setVisible(true);
       }

      public report()
      {
          	try
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch(Exception ex)
            {
               System.out.println(ex);
            }

            fm=new JFrame("Report Window");
            pm=new JPanel();
            pm.setLayout(null);
            pm.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            pm.setBounds(190,100,650,500);

            	f1=new Font("Times New Roman",Font.BOLD,35);
		        f2=new Font("Times New Roman",Font.ITALIC,25);
		        f3=new Font("Times New Roman",Font.BOLD,15);

        mig=new ImageIcon("images\\b1.jpg");
        JLabel lborder=new JLabel(mig);
		lborder.setBounds(0,350,650,150);

        mig2=new ImageIcon("images\\report.png");
        l10=new JLabel(mig2);
        l10.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
        l10.setBounds(80,10,500,90);

        mig1=new ImageIcon("images\\Sport.jpg");
        l11=new JLabel(mig1);
        l11.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
        l11.setBounds(75,140,200,200);

       JLabel lborder1=new JLabel(mig);
		lborder1.setBounds(0,100,650,20);
	
        bpl=new JButton("",new ImageIcon("images\\images\\p&l.png"));
        bpl.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
        bpl.setBounds(350,120,220,44);
        
     	bdist=new JButton("",new ImageIcon("images\\images\\distrpt.png"));
		bdist.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
		bdist.setBounds(350,170,220,44);

        bsbil=new JButton("",new ImageIcon("images\\images\\salerpt.png"));
        bsbil.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
		bsbil.setBounds(350,220,220,44);

		bpbil=new JButton("",new ImageIcon("images\\newpur.png"));
		bpbil.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
		bpbil.setBounds(350,270,220,44);
		
		bcust=new JButton("",new ImageIcon("images\\images\\custrpt.png"));
        bcust.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
        bcust.setBounds(350,320,220,44);
        
        breject=new JButton("",new ImageIcon("images\\rejectrpt.png"));
        breject.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
        breject.setBounds(350,370,220,44);
		
		bhome=new JButton("HOME");
		pm.add(bhome);
        bhome.setBounds(75,430,90,50);
        bhome.addActionListener(this);
	  
	    bpl.addActionListener(this);
        bsbil.addActionListener(this);
        bdist.addActionListener(this);
        bpbil.addActionListener(this);
       	bhome.addActionListener(this);
		bcust.addActionListener(this);
		breject.addActionListener(this);
	

		pm.add(l10);pm.add(l11);
        pm.add(lborder1);
        pm.add(bpl);pm.add(bdist);pm.add(bsbil);pm.add(bpbil);pm.add(bcust);pm.add(breject);
        pm.add(bhome);
        c1=fm.getContentPane();
        c1.setLayout(null);
        c1.add(pm,"Center");
        fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fm.setSize(800,600);
        //fm.setVisible(true);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public void mouseClicked(MouseEvent me)
   {
          Object ob = me.getSource();
          if(ob==w)
          {
             abClose();
          }
   }
   
   public void abClose()
   {
          w.dispose();
   }
   
   public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();
              if(obj==btnAbout)
              {
                    w=new Window(fm);

                    p = new JPanel();
                    p.setLayout(null);
                    mign=new ImageIcon("images\\About1.jpeg");
                    JLabel lbla=new JLabel(mign);
                    lbla.setBounds(10,9,512,384);
                    p.add(lbla);
                    w.add(p);

                    w.setSize(530,400);
                    p.setBackground(Color.pink);
                    w.setLocation(260,180);
                    w.setVisible(true);
                    w.addMouseListener(this);
              }
              if(obj==bpl)
              {
                  fm.dispose();
                  ProfitReport pr1=new ProfitReport();
               
               }
                if(obj==bsbil)
              {
                  fm.dispose();
                  SaleReport S1=new SaleReport();

               }
               if(obj==bdist)
              {
                  fm.dispose();
                 DistReport d1=new DistReport();

               }
               if(obj==bpbil)
               {
                    fm.dispose();
                    PurchaseReport p1=new PurchaseReport();
               }
               
              if(obj==bhome)
              {
                  fm.dispose();
                 newmain1 m1=new newmain1();
              }
               if(obj==bcust)
               {
                    fm.dispose();
                    CustReport c1=new CustReport();
               }
               if(obj==breject)
               {
                    fm.dispose();
                    RejectReport r1=new RejectReport();
               }
      }
      public void exitframe()
      {

		int i = optDialog.showConfirmDialog(fm,"Do you want to Exit?","Exit?",JOptionPane.YES_NO_OPTION);

            if( i == JOptionPane.YES_OPTION)
            {
				System.exit(0);
			}
			else
            {
				return;
			}
	 }

}