package Graphique.dessin;

import util3.Complexe;
import util3.ComplexeInt;

import java.awt.*;

/**
 * Created by mathieu on 16/05/2017.
 */
public class cercle extends forme{

    public ComplexeInt rayon=new ComplexeInt();


    public cercle()
    {rayon.set(10,10);
        type="cercle";
    }

    public cercle(ComplexeInt Origine,ComplexeInt Rayon)
    {origine=Origine;
        rayon=Rayon;

    }
    {rayon.set(10,10);
        type="cercle";
    }
    public void paint(Graphics g) {
        super.paint(g);



        g.fillOval(origine.getRe(),origine.getIm(),rayon.getRe(),rayon.getIm());
        g.setColor(couleur);
        System.out.println("cercle Paint");

    }



}
