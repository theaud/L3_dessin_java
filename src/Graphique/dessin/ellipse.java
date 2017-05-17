package Graphique.dessin;

import util3.ComplexeInt;

import java.awt.*;

/**
 * Created by mathieu on 16/05/2017.
 */
public class ellipse extends Forme {

    public ComplexeInt rayon;


    public ellipse()
    {rayon=new ComplexeInt(10,10);
        type="ellipse";
    }



    public ellipse(int origineX,int origineY,int Rayon1,int Rayon2)
    {origine=new ComplexeInt(origineX,origineY);
    rayon=new ComplexeInt(Rayon1,Rayon2);
    }
    public ellipse(ComplexeInt Origine,ComplexeInt  Rayon)
    {origine=Origine;
    rayon= Rayon;
    }
    public ellipse(ComplexeInt Origine,int Rayon1,int Rayon2)
    {origine=Origine;
        rayon=new ComplexeInt(Rayon1,Rayon2);
    }


    public void paint(Graphics g) {
        super.paint(g);

        g.fillOval(origine.getRe()-rayon.getRe(),origine.getIm()-rayon.getIm(),rayon.getRe()*2,rayon.getIm()*2);
        g.setColor(couleur);


    }


    @Override
    public String toString() {
        return "ellipse{" +
                "rayon=" + rayon +
                '}';
    }
}
