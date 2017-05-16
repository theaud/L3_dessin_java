package Graphique.dessin;

import util3.ComplexeInt;

import java.awt.*;

/**
 * Created by mathieu on 16/05/2017.
 */
public class Ligne extends forme{

    public ComplexeInt second=new ComplexeInt();

    public Ligne()
    {second.set(10,10);
        type="Ligne";
    }

    public Ligne(ComplexeInt Origine, ComplexeInt Second)
    {origine=Origine;
        second=Second;

    }

    public void paint(Graphics g) {
        super.paint(g);



        g.create(origine.getRe(),origine.getIm(),10,20);
        g.setColor(couleur);
        System.out.println("Ligne Paint");

    }


}
