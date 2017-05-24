package Graphique.app;

import Graphique.dessin.*;
import util3.ComplexeInt;

import java.util.LinkedList;


public class Dessin {


    public LinkedList<Forme> Liste=new LinkedList<Forme>() ;
    public String Nom="Sans nom";
    public LPixel pixel=new LPixel();

    public Dessin() { Nom="Premier dessin"; pixel=new LPixel();}

    public   Dessin(String nom) {   Nom=nom;    pixel=new LPixel();}

    public static Dessin test() {   Dessin returned =new Dessin();
            returned.Nom="test";
            returned.Liste.add(new Ligne(50,50,100,50));        returned.Liste.add(new Ligne(150,100,150,150));        returned.Liste.add(new Ligne(300,300,400,400));
            returned.Liste.add(new cercle(300,300,50));        returned.Liste.add(new cercle(300,300,30));
            returned.Liste.add(new ellipse(600,600,50,50));        returned.Liste.add(new ellipse(600,600,50,40));        returned. Liste.add(new ellipse(600,600,40,50));

            returned.pixel=returned.update_pixel();
            return returned;
        }

    public  static Dessin toto() {   Dessin returned =new Dessin();
            returned.Nom="toto";
        int Y = 150, X = 200;



        returned.Liste.add(new cercle(X, Y, 100));
        returned.Liste.add(new Ligne(X - 25, Y, X + 25, Y));
        returned.Liste.add(new Ligne(X, Y + 25, X, Y - 25));
        returned.Liste.add(new cercle(X - 37, Y - 37, 25));
        returned.Liste.add(new cercle(X + 37, Y - 37, 25));
        returned.Liste.add(new ellipse(X, Y + 50, 40, 10));

        Calque toto = new Calque(returned, new ComplexeInt(200, 200));
        returned.Liste.add(toto.clone());

        return returned;
        }

    public static Dessin mouton() {
        Dessin returned = new Dessin();
        returned.Nom = "mouton";


        int X = 400, Y = 400;


        returned.Liste.add(new ellipse(X, Y, 200, 50));
        returned.Liste.add(new cercle(X - 200, Y - 50, 50));


        cercle cercle1 = new cercle(X - 200 - 25, Y - 50, 10);
        returned.Liste.add(cercle1.clone());
        cercle1.deplacement(new ComplexeInt(50, 0));
        returned.Liste.add(cercle1.clone());

        cercle cercle2 = new cercle(X - 200 - 35, Y - 50 - 50, 25);
        returned.Liste.add(cercle2.clone());
        cercle2.deplacement(new ComplexeInt(70, 0));
        returned.Liste.add(cercle2.clone());

        returned.Liste.add(new Ligne(X - 210, Y - 20, X - 190, Y - 20));


        Ligne tmp = new Ligne(new ComplexeInt(X, Y), new ComplexeInt(X, Y - 40), 10);
        tmp.deplacement(new ComplexeInt(-100, 80));
        returned.Liste.add(tmp.clone());
        tmp.deplacement(new ComplexeInt(50, 10));
        returned.Liste.add(tmp.clone());
        tmp.deplacement(new ComplexeInt(50, 0));
        returned.Liste.add(tmp.clone());
        tmp.deplacement(new ComplexeInt(50, 0));
        returned.Liste.add(tmp.clone());


        return returned;
    }
    public LPixel update_pixel() {/*
            pixel=new LPixel();

            try {

                if (Liste.size() > 0) {
                    for (Forme a : Liste)
                    { pixel.ajoue(a.ajoue_pixel());

                    }
                }

            }
            catch (java.lang.NullPointerException e) {}
*/
        // return pixel;
        return new LPixel();
    }


    public void deplacement(ComplexeInt deplacement) {
        for (Forme a : Liste)
        {
            System.out.println(a.toString() + " " + (a.origine.getRe() + deplacement.getRe()) + " " + (a.origine.getIm() + deplacement.getIm()));

            a.deplacement(new ComplexeInt(deplacement.getRe(), deplacement.getIm()));

            System.out.println(a.toString());
            System.out.println("----------------------------");
        }
    }


public void afficher(){for (int i=0;i<Liste.size();i++)       {i++;System.out.println("dessin :"+Liste.get(i).type+" "+i);}}


    @Override
    public String toString() {
        return "Dessin{" +
                "Liste=" + Liste +
                ", Nom='" + Nom + '\'' +
                ", pixel=" + pixel +
                '}';
    }
}
