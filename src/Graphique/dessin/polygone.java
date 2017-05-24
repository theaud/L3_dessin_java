package Graphique.dessin;

import util3.ComplexeInt;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by mathieu on 16/05/2017.
 */
public class polygone extends Forme {

    LinkedList<ComplexeInt> sommets=new LinkedList<ComplexeInt>();

    public polygone(ComplexeInt Origine,LinkedList<ComplexeInt> Sommets)
    {
        origine = Origine.clone();

        for (ComplexeInt a : Sommets) {
            sommets.add(a.clone());
        }


    }


    public void paint(Graphics g) {
        super.paint(g);

        int nb_sommet=1+sommets.size();
      int[] x=new int[nb_sommet];
      int[] y=new int[nb_sommet];
        x[0]=origine.getRe();
        y[0]=origine.getIm();

        for(int i=0;i<sommets.size();i++)
        {
            x[i+1]=sommets.get(i).getRe();
            y[i+1]=sommets.get(i).getIm();
        }

        g.setColor(couleur);
        g.drawPolygon(x, y, nb_sommet);

    }


    @Override
    public void translate(ComplexeInt nouvelle_origine)
    {
        ComplexeInt translation=new ComplexeInt(origine.getRe()-nouvelle_origine.getRe(),origine.getIm()-nouvelle_origine.getIm());

        deplacement(translation);
    }

    @Override
    public void deplacement(ComplexeInt vecteur) {
        for (int i = 0; i < sommets.size(); i++) {
            sommets.get(i).set(sommets.get(i).getRe() + vecteur.getRe(), sommets.get(i).getIm() + vecteur.getIm());
        }
        origine.set(origine.getRe() + vecteur.getRe(), origine.getIm() + vecteur.getIm());
    }


    @Override
    public Forme clone() {
        return new polygone(origine, sommets);
    }
    @Override
    public String toString() {


        String returned = "polygone\t:" +
                "\tID=" + ID +
                "\torigine=" + origine;
        for (ComplexeInt a : sommets) {
            returned += "\n\t\t\t\tsommets=" + a;
        }
        return returned;

    }
}
