package Graphique.app;

import Graphique.dessin.Forme;
import Graphique.dessin.Ligne;
import Graphique.dessin.cercle;
import Graphique.dessin.ellipse;
import util3.Complexe;
import util3.ComplexeInt;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by mathieu on 17/05/2017.
 */
public class Dessin {

    public LinkedList<Forme> Liste=new LinkedList() ;
    public String Nom="sans nom";


    public Dessin()
    {
        Nom="Premier dessin";
    }

    public   Dessin(String nom)
    {   Nom=nom;

        Liste.add(new Ligne(50,50,100,50));
        Liste.add(new Ligne(150,100,150,150));
        Liste.add(new Ligne(300,300,400,400));


         Liste.add(new cercle(300,300,50));
        Liste.add(new cercle(300,300,30));

        Liste.add(new ellipse(600,600,50,50));
        Liste.add(new ellipse(600,600,50,40));
        Liste.add(new ellipse(600,600,40,50));

    }

    public  static Dessin toto()
    {   Dessin returned =new Dessin();
        returned.Nom="toto";

        int X=400,Y=400;
        returned.Liste.add(new cercle(X,Y,200));


        returned.Liste.add(new Ligne(X-50,Y,X+50,Y));
        returned.Liste.add(new Ligne(X,Y+50,X,Y-50));

        returned.Liste.add(new cercle(X-75,Y-75,50));
        returned.Liste.add(new cercle(X-75,Y+75,50));
        returned.Liste.add(new ellipse(X+100,Y,20,80));


        return returned;
    }


    public void ajout_forme()
    {



        int sortie;

        System.out.println("\n\n\n\n\n\n\n----------------------------------------");
        System.out.println("Quel Forme voulez-vous ajoute a votre dessin");

        System.out.println("Un segement par son origine et un second point : 1");
        System.out.println("Un segement par son origine et un second point et choisir sa largeur : 2");

        System.out.println("Un cercle par son origine et son rayon : 3");
        System.out.println("Un cercle par son origine et un point du cercle : 4");
        System.out.println("Une elipse par son origine ,le point le plus proche et le point le plus loin : 5");

        System.out.println("Un rectangle par son origine et le point opose : 6");
        //  System.out.println("Un rectangle  : 7");
        //System.out.println("Un carre  : 8");
        // autre carre
        System.out.println("Un polygone  par la liste de ses sommet: 9");

        System.out.println("retour : 10");

        sortie=util3.scanner.scannerint( 1, 10);




        if(sortie!=10)
        {
            ComplexeInt origine=getPoint("Quel est son origine ");
            ComplexeInt point2;

            switch (sortie)
            {   case 1: point2=getPoint("Quel est le second point");
                Liste.add(new Ligne(origine,point2));
                break;
                case 2:break;

                case 3:Liste.add(new cercle(origine,getint("Quel est le rayon du cercle")));
                    break;

                case 4: point2=getPoint("Quel est le second point");
                    int rayon=(int)Math.sqrt((origine.getRe()-point2.getRe())*(origine.getRe()-point2.getRe())+(origine.getIm()-point2.getIm())*(origine.getIm()-point2.getIm()));
                    Liste.add(new cercle(origine,rayon));
                    break;
                case 5: int rayon1=getint("Quel est le petit rayon de l'elispe");
                    int rayon2=getint("Quel est le grand rayon de l'elispe");
                    Liste.add(new ellipse(origine,new ComplexeInt(rayon1,rayon2)));
                    break;

                case 6:break;




            }
        }
    }

    public ComplexeInt getPoint(String text)
    {   int x,y;

        System.out.println(text+" X ?");
        x=util3.scanner.scannerint(0,2000);

        System.out.println(text+" Y ?");
        y=util3.scanner.scannerint(0,2000);


        return new ComplexeInt(x,y);
    }
    public int getint(String text)
    {   int x;

        System.out.println(text);
        x=util3.scanner.scannerint(0,2000);


        return x;
    }




    public void afficher()
    {
        int i=0;
        for (Forme a:Liste)
        {i++;
            System.out.println("dessin :"+a.type+" "+i);
        }
    }




}
