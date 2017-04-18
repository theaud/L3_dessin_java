package Graphique.aide;


import Graphique.Jpanel.Fenetre;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Lign extends Fenetre {

    public Lign()
    {
        dim=new Dimension(10000,30);
    }


    public static  Lign[] assemblage_ligne(int size)
    { Lign[] lign     =new Lign[size];
        for(int i=0;i<size;i++)
        {lign[i]=new Lign();
         lign[i].setPreferredSize(new Dimension(5000, 35));

        }
        return lign;
    }

    public static  Lign[] assemblage_ligne(Lign[] lign,int size,int height)
    {
        for(int i=0;i<size;i++)
        {lign[i].setPreferredSize(new Dimension(5000, height));}
        return lign;
    }


//---------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------   gestion texte html des Jpanel -----------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------

    public static JLabel mise_en_forme_ligne_jpanel(LinkedList<String> texte)
    {   String traduction="<html><div>";
            for (String ligne:texte) {traduction+=ligne+"<br>";}
        traduction+="</div></html>";
        return new JLabel(traduction) ;
    }


}
