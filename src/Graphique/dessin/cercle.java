package Graphique.dessin;

import Graphique.app.LPixel;
import util3.ComplexeInt;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by mathieu on 16/05/2017.
 */
public class cercle extends Forme {

    public int rayon;


    public cercle()
    {rayon=10;
        origine=new ComplexeInt(50,50);
        type="cercle";

    }



    public cercle(ComplexeInt Origine,int Rayon)
    {origine=Origine;
        rayon=Rayon; type="cercle";
    }
    public cercle(int origineX,int origineY,int Rayon)
    {origine=new ComplexeInt(origineX,origineY);
        rayon=Rayon; type="cercle";
    }


    public void paint(Graphics g) {
        super.paint(g);

        if(origine.getRe()-rayon>0 && origine.getIm()-rayon>0 || true) {
            g.fillOval(origine.getRe() - rayon, origine.getIm() - rayon, rayon * 2, rayon * 2);
            g.setColor(couleur);
        }

    }
    public LPixel ajoue_pixel()
    {super.ajoue_pixel();

        return new LPixel();
    }

    @Override
    public String toString() {
        return  "cercle\t{" +
                "origine=" + origine +
                "\trayon=" + rayon +
                '}';
    }
}
