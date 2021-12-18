package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//@author Muhaimin
//@co-author Saiham

public class Calculator implements ActionListener
{
    JFrame f;
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bc,ba,bs,bm,bd,br,bAns,bdot;
    JTextField t1,t2,t3;
    JPanel p1,p2,p3;
    
    public Calculator()
    {
        f=new JFrame("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p1.setBounds(10,80,280,270);
        p1.setBackground(Color.gray); 
        b0=new JButton("0");
        b0.addActionListener(this);
        b1=new JButton("1");
        b1.addActionListener(this);
        b2=new JButton("2");
        b2.addActionListener(this);
        b3=new JButton("3");
        b3.addActionListener(this);
        b4=new JButton("4");
        b4.addActionListener(this);
        b5=new JButton("5");
        b5.addActionListener(this);
        b6=new JButton("6");
        b6.addActionListener(this);
        b7=new JButton("7");
        b7.addActionListener(this);
        b8=new JButton("8");
        b8.addActionListener(this);
        b9=new JButton("9");
        b9.addActionListener(this);
        bdot=new JButton(".");
        bdot.addActionListener(this);
        bc=new JButton("C");
        bc.addActionListener(this);
        p1.add(b0);p1.add(b1);p1.add(b2);
        p1.add(b3);p1.add(b4);p1.add(b5);
        p1.add(b6);p1.add(b7);p1.add(b8);
        p1.add(b9);p1.add(bdot);p1.add(bc);
        p1.setLayout(new GridLayout(4,3,7,7));
        //p1.setLayout(new FlowLayout(FlowLayout.RIGHT,30,40));
        
        
        p2=new JPanel();
        p2.setBounds(300,80,75,270);
        p2.setBackground(Color.gray); 
        ba=new JButton("+");
        ba.addActionListener(this);
        bs=new JButton("-");
        bs.addActionListener(this);
        bm=new JButton("X");
        bm.addActionListener(this);
        bd=new JButton("/");
        bd.addActionListener(this);
        br=new JButton("%");
        br.addActionListener(this);
        bAns=new JButton("=");
        bAns.addActionListener(this);
        p2.add(ba);p2.add(bs);p2.add(bm);
        p2.add(bd);p2.add(br);p2.add(bAns);
        p2.setLayout(new GridLayout(6,1,1,3));
        //p2.setLayout(new FlowLayout(FlowLayout.LEADING,20,15));
        
                
        p3=new JPanel();
        p3.setBounds(10,10,365,60);
        p3.setBackground(Color.gray); 
        t1=new JTextField();
        t1.setEditable(false);
        t1.setBackground(Color.gray);
        t1.setFont(new Font("Arial",Font.PLAIN,20));
        //t1.setBounds(12,12,360,26);
        t2=new JTextField();
        t2.setBackground(Color.GRAY);
        t2.setEditable(false);
        t2.setFont(new Font("Arial",Font.PLAIN,20));
        //t2.setBounds(12,42,360,26);
        p3.add(t1);
        p3.add(t2);
        p3.setLayout(new GridLayout(2,1));
        t3=new JTextField();
        

        f.add(p1);
        f.add(p2);
        f.add(p3);
        //f.add(t1);
        //f.add(t2);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        // String a,b,o;
        // double x,y,res;
        if(e.getSource()==b0)
        {
            t1.setText(t1.getText()+"0");
        }
        else if(e.getSource()==b1)
        {
            t1.setText(t1.getText()+"1");
        }
        else if(e.getSource()==b2)
        {
            t1.setText(t1.getText()+"2");
        }
        else if(e.getSource()==b3)
        {
            t1.setText(t1.getText()+"3");
        }
        else if(e.getSource()==b4)
        {
            t1.setText(t1.getText()+"4");
        }
        else if(e.getSource()==b5)
        {
            t1.setText(t1.getText()+"5");
        }
        else if(e.getSource()==b6)
        {
            t1.setText(t1.getText()+"6");
        }
        else if(e.getSource()==b7)
        {
            t1.setText(t1.getText()+"7");
        }
        else if(e.getSource()==b8)
        {
            t1.setText(t1.getText()+"8");
        }
        else if(e.getSource()==b9)
        {
            t1.setText(t1.getText()+"9");
        }
        if(e.getSource()==bdot)
        {
            t1.setText(t1.getText()+".");
        }
        if(e.getSource()==bc)
        {
            if(t1.getText().length()>0)
            {
                t1.setText(t1.getText().substring(0,t1.getText().length()-1));
            }
        }
        if(e.getSource()==ba)
        {
            t1.setText(t1.getText()+"+");
        }
        if(e.getSource()==bs)
        {
            t1.setText(t1.getText()+"-");
        }
        if(e.getSource()==bm)
        {
            t1.setText(t1.getText()+"x");
        }
        if(e.getSource()==bd)
        {
            t1.setText(t1.getText()+"/");
        }
        if(e.getSource()==br)
        {
            t1.setText(t1.getText()+"%");
        }
        if(e.getSource()==bAns)
        {
            t2.setText(calculate(t1.getText()));
        }

    }

    private String calculate(String exp) {
        double ans;
        try {

            String[] tokens = exp.split("[-+x/%]+");
            String[] operators = exp.split("[0-9.]");
            double[] values = new double[tokens.length];
            for(int i=0;i<tokens.length;i++)
            {
                values[i]=Double.parseDouble(tokens[i]);
            }
            ans=values[0];
            for(int i=0;i<operators.length;i++)
            {
                if(operators[i].equals("+"))
                {
                    ans=ans+values[i+1];
                }
                else if(operators[i].equals("-"))
                {
                    ans=ans-values[i+1];
                }
                else if(operators[i].equals("x"))
                {
                    ans=ans*values[i+1];
                }
                else if(operators[i].equals("/"))
                {
                    ans=ans/values[i+1];
                }
                else if(operators[i].equals("%"))
                {
                    ans=ans%values[i+1];
                }
            }
        }
        catch(Exception e)
        {
            ans=0;
            e.printStackTrace();
        }
        // 1 + 2 + 5 * 2
        // 1 2 5 2     // + + *
        // ans=1 ---- // 2 += // 5 += // 2 *= 
        // 123 + 45
        // 123 45   / +


        return Double.toString(ans);
    }
    
}
