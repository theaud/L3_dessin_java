package Graphique.aide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Bouton extends JButton {

    public Bouton(String str){super(str);setPreferredSize(new Dimension(200,50)); }
    public Bouton(String str, ActionListener listener){super(str); addActionListener(listener); setPreferredSize(new Dimension(200,50));}

//------------------------------------ set bouton  ----------------------------------------------------------------------------------------------------------------------------
    public void setBouton(String text, ActionListener listener,int height ,int weight)    {setBouton(text,listener,new Dimension(height,weight)); }

   // public void setBouton(String text, ActionListener listener,Dimension dim,Color color)    {setForeground(color);setSize(dim); setBouton( text,  listener); }

    public void setBouton(String text, ActionListener listener,Dimension dim)    {setSize(dim); setBouton( text,  listener); }

   // public void setBouton(String text, ActionListener listener,Color color)    {setForeground(color);setText(text); addActionListener(listener);}
    public void setBouton(String text, ActionListener listener)    {setText(text); addActionListener(listener);}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.white);
        g2d.drawString(getText(), this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);
    }*/
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static  Bouton[] Tableau_Bouton(int size)
    { Bouton[] Bouton     =new Bouton[size];
        for(int i=0;i<size;i++)
        {Bouton[i]=new Bouton("Bouton "+i);}
        return Bouton;
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------


}