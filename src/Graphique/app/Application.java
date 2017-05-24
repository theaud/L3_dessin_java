package Graphique.app;

import Graphique.Jpanel.Jframeadd;
import Graphique.dessin.*;
import util3.ComplexeInt;

import java.awt.*;
import java.util.LinkedList;

public class Application extends Jframeadd {

    public LinkedList<Dessin> List_Dessin = new LinkedList();
    public LinkedList<Calque> List_Calque = new LinkedList();
    public Dessin Dessin_courant ;

    public  String title;


    public Application(){
        List_Dessin.add(Graphique.app.Dessin.mouton());
        List_Dessin.add(Graphique.app.Dessin.toto());
        List_Dessin.add(Graphique.app.Dessin.test());


        for (Graphique.app.Dessin copy : List_Dessin) {
            List_Calque.add(new Calque(copy, new ComplexeInt(0, 0)));

        }


        List_Dessin.add(new Dessin());

        Dessin_courant = List_Dessin.get(0);
         title="Dessine moi un mouton ";
        this.setTitle(title);

        }

public void paint(Graphics g) {
        super.paint(g);

        try {
            if (Dessin_courant.Liste.size() > 0) {
                for (Forme a : Dessin_courant.Liste)
                { a.paint(g);}
            }
            this.setTitle(title);
        }
        catch (java.lang.NullPointerException e) {}
    }

public int air(Graphics g) {

/*int air = 0;
    Color red=new Color(255,0,0);
    for(int y = 0; y < HEIGHT; y++)
    {for(int x = 0; x < WIDTH; x++)
        {if(getGraphics().getColor().getRed()==red.getRed() && getGraphics().getColor().getGreen()==red.getGreen() && getGraphics().getColor().getBlue()==red.getBlue() &&x%10==0)
            {
                System.out.println(getGraphics().getColor().getRed()+" "+getGraphics().getColor().getGreen()+" "+getGraphics().getColor().getBlue()+" ");
                System.out.println(getGraphics().getColor());
                air++;
            }
        }
    }
    System.out.println(air);
        return air;*/
    return 1;
    }

public  int Menu() {

        int sortie;

        System.out.println("\n\n----------------------------------------");
        System.out.println("Menu : que souhaitez-vous faire?");
        System.out.println("1) Ajoutez une Forme :");
        System.out.println("2) Consulter les formes deja présente :");//voir detaille , deplacer / supprimer
        System.out.println("&3) Trier les formes :");
        System.out.println("&4) gestion dessin :");

        System.out.println("5) Quitter :");

        sortie = util3.scanner.scannerint(1, 10);

        return sortie;
    }


public  void fonction() {

        boolean test = true;
        int menu;
         paint(getGraphics());

        do {menu = Menu();
            switch (menu) {
                case 1:
                    ajout_forme();
                    break;
                    case 2:Menu_consultation_forme( );                        break;
                    case 3://trier les forme
                        break;
                    case 4:Menu_gestion_dessin();                        break;

                }
            this.setTitle(Dessin_courant.Nom);



            paint(getGraphics());

        } while (menu != 5);

    System.exit(0);
    }


public void Menu_consultation_forme() {

        int i;
        int choix;
    System.out.println(" Dessin :" + Dessin_courant.Nom);
        for ( i =0;i<Dessin_courant.Liste.size();i++)
        {System.out.println(i+") "+Dessin_courant.Liste.get(i).toString()+"");
        }

        System.out.println(" Selectionner une forme : son numero");
        System.out.println(" retour : "+(i));

        choix = util3.scanner.scannerint(0, i);

        if(choix<i)
        {   Forme Forme_choisie=Dessin_courant.Liste.get(choix);
            ComplexeInt origine=new ComplexeInt(0,0);

            System.out.println("\n\n\n "+Forme_choisie.toString()+"");
            System.out.println("\nSon air vaut "+ Forme_choisie.get_air()+" pixel");
            System.out.println("Son perimetre vaut "+ Forme_choisie.get_perimetre()+" pixel");
            System.out.println("La distance a l'origine de l'origine de cette forme vaut "+ origine.difference(Forme_choisie.origine)+" pixel"+"\n");

                    System.out.println(" Que souhaitez-vous faire");
            System.out.println("1) Deplacer la forme :  ");//
            System.out.println("2) supprimer la forme :  ");
            System.out.println("3) retour :  ");

            switch (util3.scanner.scannerint(1, 3))
            {case 1:ComplexeInt nouvelle_origine=getPoint("Quel son les nouvelles coordonnes de cette forme");
                Dessin_courant.Liste.get(choix).translate(nouvelle_origine);

                break;//homothétie, translation, rotation,  symétrie centrale, symétrie axiale.

            case 2:Dessin_courant.Liste.remove(choix);
                    break;

            }


        }


    }

    public void Menu_gestion_dessin()
    {  System.out.println("1) charger un autre dessin :");
        System.out.println("2) cree un nouveau dessin (et basculer dessus) :");
        System.out.println("3) deplacer tous le dessin courant:");
        System.out.println("4) Copier le dessin courant dans un nouveau ensemble de forme");
        System.out.println("5) Retour");
        switch (util3.scanner.scannerint(1, 5)) {
            case 1:
                if (List_Dessin.size() == 1) {
                    System.out.println("Il n'y a pas d'autre dessin");
                }
            else{int i=0;
                System.out.println("Choix du nouveau dessin :");
                    for (Dessin a : List_Dessin) {
                        i++;
                        System.out.println(i + ") Dessin " + a.Nom + " ");
                    }

                System.out.println("retour  "+(i+1));
                int  choix = util3.scanner.scannerint(1,i+1);
                    if (choix != i + 1) {
                        Dessin_courant = List_Dessin.get(choix - 1);
                    }
                }
            break;

        case 2: System.out.println("Quel est le nom de votre nouveau dessin");
                Dessin_courant=new Dessin(util3.scanner.scannerString());

            List_Dessin.add(Dessin_courant);
            break;

            case 3:
                ComplexeInt deplacement = getPoint("De quel vecteur souhaitez-vous deplacer le dessin", -2000);
                Dessin_courant.deplacement(deplacement);
                break;

        }
                        /*
                        if(Dessin.size()==1) { System.out.println("Il n'y a pas d'autre dessin");}
                        else
                        {int i=0;
                            System.out.println("Choix du nouveau dessin :");
                            for(Dessin a:Dessin)
                            {i++;
                                System.out.println(i+") "+a.Nom+" ");
                            }
                            System.out.println("retour  "+(i+1));
                            int  choix = util3.scanner.scannerint(1,i+1);
                            if(choix!=i+1)
                            {
                                Dessin_courant= Dessin.get(choix-1);
                            }
                        }
                        */

    }

    public void ajout_forme() {
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

        sortie = util3.scanner.scannerint(1, 12);

        if (sortie != 12) {

            ComplexeInt origine = getPoint("Quel est son origine ");
            ComplexeInt point2;
            int largeur, hauteur;

            switch (sortie) {
                case 1:
                    point2 = getPoint("Quel est le second point");
                    Dessin_courant.Liste.add(new Ligne(origine, point2));
                    break;

                case 2:
                    point2 = getPoint("Quel est le second point");
                    largeur = getint("Quel est sa largeur?");
                    Dessin_courant.Liste.add(new Ligne(origine, point2, largeur));
                    break;

                case 3:
                    Dessin_courant.Liste.add(new cercle(origine, getint("Quel est le rayon du cercle")));
                    break;

                case 4:
                    point2 = getPoint("Quel est le second point");
                    int rayon = origine.difference(point2);

                    Dessin_courant.Liste.add(new cercle(origine, rayon));
                    break;
                case 5:
                    int rayon1 = getint("Quel est le petit rayon de l'elispe");
                    int rayon2 = getint("Quel est le grand rayon de l'elispe");
                    Dessin_courant.Liste.add(new ellipse(origine, new ComplexeInt(rayon1, rayon2)));
                    break;

                case 6:
                    point2 = getPoint("Quel est le point opose");
                    Dessin_courant.Liste.add(new Graphique.dessin.Rectangle(origine, point2));
                    break;
                case 7:
                    hauteur = getint("Quel est est la valeur de sa hauteur");
                    largeur = getint("Quel est est la valeur de sa largeur");
                    Dessin_courant.Liste.add(new Graphique.dessin.Rectangle(origine, new ComplexeInt(origine.getRe() + hauteur, origine.getIm() + largeur)));
                    break;
                case 8:
                    largeur = getint("Quel est est la valeur de son coter");
                    Dessin_courant.Liste.add(new Graphique.dessin.Rectangle(origine, new ComplexeInt(origine.getRe() + largeur, origine.getIm() + largeur)));
                    break;
                case 9:

                    LinkedList<ComplexeInt> sommets = new LinkedList<ComplexeInt>();
                    do {
                        sommets.add(getPoint("Donner les coordonnées de ce sommet"));

                    } while (1 == getint("1) Ajouter un sommet "));
                    Dessin_courant.Liste.add(new polygone(origine, sommets));

                    break;
                case 10:
                    System.out.println("Quel forme voulez vous copier");
                    int i;
                    for (i = 0; i < Dessin_courant.Liste.size(); i++) {
                        System.out.println(i + ") " + Dessin_courant.Liste.get(i).toString() + "");
                    }
                    System.out.println(" Selectionner une forme : son numero");
                    System.out.println(" retour : " + (i + 1));
                    int choix = util3.scanner.scannerint(0, i + 1);

                    if (choix != i + 1) {
                        Forme clone = Dessin_courant.Liste.get(choix).clone();
                        clone.translate(origine);
                        Dessin_courant.Liste.add(clone);
                    }

                    break;
                case 11:
                    ajoue_calque(origine);
                    break;


            }
        }
    }


    public void ajoue_calque(ComplexeInt origine) {
        System.out.println("Quel calque voulez-vous utiliser");
        int i;
        for (i = 0; i < List_Calque.size(); i++) {
            System.out.println(i + ") " + List_Calque.get(i).Nom);
        }
        System.out.println(i + " ) retour");
        int choix = util3.scanner.scannerint(0, i);
        if (choix == i) {
            return;
        }

        List_Calque.get(choix).translate(origine);

        Dessin_courant.Liste.add(List_Calque.get(choix).clone());

    }
    
    
    
    
    public ComplexeInt getPoint(String text)
    {   int x,y;

        System.out.println(text+" X ?");
        x=util3.scanner.scannerint(0,2000);

        System.out.println(text+" Y ?");
        y=util3.scanner.scannerint(0,2000);

        return new ComplexeInt(x,y);
    }

    public ComplexeInt getPoint(String text, int min) {
        int x, y;

        System.out.println(text + " X ?");
        x = util3.scanner.scannerint(min, 2000);

        System.out.println(text + " Y ?");
        y = util3.scanner.scannerint(min, 2000);

        return new ComplexeInt(x, y);
    }

    public int getint(String text) {
        int x;

        System.out.println(text);
        x = util3.scanner.scannerint(0, 2000);

        return x;
    }


}