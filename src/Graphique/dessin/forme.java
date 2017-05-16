package Graphique.dessin;

import util3.ComplexeInt;

import javax.swing.*;
import java.awt.*;


public class forme extends JPanel{


    public ComplexeInt origine=new ComplexeInt();
    public Color couleur=new Color(128,255,64);

    public String type;
    public forme()
    {


    origine.set(50,50);
        type="forme";


    }


    public void paint(Graphics g) {
        super.paint(g);

    }

}

