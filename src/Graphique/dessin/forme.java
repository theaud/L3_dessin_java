package Graphique.dessin;

import Graphique.app.LPixel;
import util3.ComplexeInt;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Forme extends JPanel{


    public ComplexeInt origine=new ComplexeInt();
    public Color couleur=new Color(128,255,64);
    public static int compteur=0;

    public String type;
    public Forme()
    {Random rand = new Random();
       int valeur=rand.nextInt(1236) + 1;
        couleur=new Color((valeur*31)%255,(valeur*101)%255,(valeur*13)%255);

        origine.set(50,50);
        type="Forme";
        compteur++;

    }


    public void paint(Graphics g) {
        super.paint(g);


    }

    public LPixel ajoue_pixel()
    {

    return new LPixel();
    }

    @Override
    public String toString() {
        return "Forme{" +
                "origine=" + origine +
                ", couleur=" + couleur +
                ", type='" + type + '\'' +
                '}';
    }
}

