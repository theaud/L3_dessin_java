package Graphique.aide;

import javax.swing.*;
import java.awt.*;


public class Casee extends JPanel{

    public JLabel top=new JLabel("1");
    public JLabel center=new JLabel("Dame");

    public Casee()
    {
        add("PAGE_START",top);
        add("LINE_END",center);
    }





    @Override
    public Component getComponent(int position) {
        Color background=getBackground();

        if(background.equals(Color.cyan))
        {
            center.setText("dame");


        }
        else if(background.equals(Color.green))
        {
            center.setText("echec");
        }
        else if(background.equals(Color.BLACK) || background.equals(Color.WHITE))
        {
            center.setText("damier");
        }
        else
        {
            center.setText("autre");
        }



        return super.getComponent(position);
    }
}
