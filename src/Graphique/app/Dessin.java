package Graphique.app;

import Graphique.dessin.*;
import util3.ComplexeInt;

import java.util.LinkedList;


public class Dessin {

    public static int HEIGHT = 800;
    public static int WIDTH = 800;
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
            int X=400,Y=400;
            returned.Liste.add(new cercle(X,Y,200));
            returned.Liste.add(new Ligne(X-50,Y,X+50,Y));        returned.Liste.add(new Ligne(X,Y+50,X,Y-50));
            returned.Liste.add(new cercle(X-75,Y-75,50));        returned.Liste.add(new cercle(X-75,Y+75,50));        returned.Liste.add(new ellipse(X+100,Y,20,80));

        returned.Liste.add(new Ligne(0, 800, 800, 800));

        Y = 1200;
        returned.Liste.add(new cercle(X, Y, 200));
        returned.Liste.add(new Ligne(X - 50, Y, X + 50, Y));
        returned.Liste.add(new Ligne(X, Y + 50, X, Y - 50));
        returned.Liste.add(new cercle(X - 75, Y - 75, 50));
        returned.Liste.add(new cercle(X - 75, Y + 75, 50));
        returned.Liste.add(new ellipse(X + 100, Y, 20, 80));

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

public void ajout_forme()
    {
        int sortie;

        System.out.println("\n\n\n\n\n\n\n----------------------------------------");
        System.out.println("Quel Forme voulez-vous ajoute a votre dessin");

        System.out.println("1) Un segement par son origine et un second point : ");
        System.out.println("2) Un segement par son origine et un second point et choisir sa largeur : ");

        System.out.println("3) Un cercle par son origine et son rayon : ");
        System.out.println("4) Un cercle par son origine et un point du cercle : ");
        System.out.println("5) Une elipse par son origine ,le point le plus proche et le point le plus loin : ");

        System.out.println("6) Un rectangle par son origine et le point opose : ");
        System.out.println("7) Un rectangle avec hauteur et largeur : ");
        System.out.println("8) Un carre  : ");
        // autre carre
        System.out.println("9) Un polygone  par la liste de ses sommet: ");

        System.out.println("&10) Ajoue de la forme copier (preselectionner) : ");
        System.out.println("&11) copier un calque deja existante : ");
        System.out.println("12) retour : ");

        sortie=util3.scanner.scannerint( 1, 12);

        if (sortie != 12)
        {

            ComplexeInt origine=getPoint("Quel est son origine ");
            ComplexeInt point2;
            int largeur, hauteur;

            switch (sortie)
            {   case 1: point2=getPoint("Quel est le second point");
                Liste.add(new Ligne(origine,point2));
                break;

                case 2:
                    point2 = getPoint("Quel est le second point");
                    largeur = getint("Quel est sa largeur?");
                    Liste.add(new Ligne(origine, point2, largeur));
                    break;

                case 3:Liste.add(new cercle(origine,getint("Quel est le rayon du cercle")));
                    break;

                case 4: point2=getPoint("Quel est le second point");
                    int rayon = origine.difference(point2);

                    Liste.add(new cercle(origine, rayon));
                    break;
                case 5: int rayon1=getint("Quel est le petit rayon de l'elispe");
                    int rayon2=getint("Quel est le grand rayon de l'elispe");
                    Liste.add(new ellipse(origine,new ComplexeInt(rayon1,rayon2)));
                    break;

                case 6:
                    point2 = getPoint("Quel est le point opose");
                    Liste.add(new Graphique.dessin.Rectangle(origine, point2));
                    break;
                case 7:
                    hauteur = getint("Quel est est la valeur de sa hauteur");
                    largeur = getint("Quel est est la valeur de sa largeur");
                    Liste.add(new Graphique.dessin.Rectangle(origine, new ComplexeInt(origine.getRe() + hauteur, origine.getIm() + largeur)));
                    break;
                case 8:
                    largeur = getint("Quel est est la valeur de son coter");
                    Liste.add(new Graphique.dessin.Rectangle(origine, new ComplexeInt(origine.getRe() + largeur, origine.getIm() + largeur)));
                    break;
                case 9:
                    origine = getPoint("Quel est son premier sommet ?");
                    LinkedList<ComplexeInt> sommets = new LinkedList<ComplexeInt>();
                    while (1 == getint("1) Ajouter un sommet ")) {
                        sommets.add(getPoint("Donner les coordonnées de ce sommet"));

                    }
                    Liste.add(new polygone(origine, sommets));

                    break;
                case 10:
                    System.out.println("Quel forme voulez vous copier");
                    int i;
                    for (i = 0; i < Liste.size(); i++) {
                        System.out.println(i + ") " + Liste.get(i).toString() + "");
                    }
                    System.out.println(" Selectionner une forme : son numero");
                    System.out.println(" retour : " + (i + 1));
                    int choix = util3.scanner.scannerint(0, i + 1);

                    if (choix != i + 1) {
                        Forme copy = Liste.get(choix).copy();
                        copy.translate(origine);
                        Liste.add(copy);
                    }

                    break;
                case 11:
                    break;
                case 12:
                    break;

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

public void afficher(){for (int i=0;i<Liste.size();i++)       {i++;System.out.println("dessin :"+Liste.get(i).type+" "+i);}}




}
