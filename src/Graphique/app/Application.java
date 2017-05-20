package Graphique.app;

import Graphique.Jpanel.Jframeadd;
import Graphique.dessin.Forme;
import java.awt.*;
import java.util.LinkedList;

public class Application extends Jframeadd {

    public LinkedList<Dessin> Dessin=new LinkedList() ;
    public Dessin Dessin_courant ;
    public  String title;

    public Application(){

        Dessin.add(Graphique.app.Dessin.toto());
        Dessin.add(Graphique.app.Dessin.test());
        Dessin.add(new Dessin());

        Dessin_courant=Dessin.get(0);
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



        int air = 0;


    Color red=new Color(255,0,0);

    for(int y = 0; y < HEIGHT; y++)
    {for(int x = 0; x < WIDTH; x++)
        {
            if(getGraphics().getColor().getRed()==red.getRed() && getGraphics().getColor().getGreen()==red.getGreen() && getGraphics().getColor().getBlue()==red.getBlue() &&x%10==0)
            {

                System.out.println(getGraphics().getColor().getRed()+" "+getGraphics().getColor().getGreen()+" "+getGraphics().getColor().getBlue()+" ");
                System.out.println(getGraphics().getColor());
                air++;
            }



        }
    }
    System.out.println(air);
        return air;
    }

public  void fonction() {
        boolean test = true;
        int menu;


         paint(getGraphics());

        do {
            menu = Menu();


            if (menu != 9) {
                switch (menu) {
                    case 1:
                        Dessin_courant.ajout_forme();
                        break;
                    case 2:Menu_consultation_forme( );
                        break;
                    case 3:

                        break;
                    case 4:Menu_gestion_dessin();
                        break;
                    case 5: System.out.println("Quel est le nom de votre nouveau dessin");
                            Dessin_courant=new Dessin(util3.scanner.scannerString());

                            Dessin.add(Dessin_courant);

                        break;
                }

                // appli.paint(appli.getGraphics());
                // appli.afficher();
            }

            this.setTitle(Dessin_courant.Nom);
            paint(getGraphics());
            System.out.println("Aire "+air(getGraphics()));
        } while (menu != 9);
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

        sortie = util3.scanner.scannerint(1, 5);

        return sortie;
    }

public void Menu_consultation_forme() {

        int i=0;
        int choix;
        for (Forme a:Dessin_courant.Liste)
        {i++;
        System.out.println(i+") "+a.toString()+"");
        }

        System.out.println(" Selectionner une forme : son numero");
        System.out.println(" retour : "+(i+1));

        choix = util3.scanner.scannerint(1, i+1);
        if(choix<i+1)
        {System.out.println(i+") "+Dessin_courant.Liste.get(choix).toString()+"");

            System.out.println(" Que souhaitez-vous faire");
            System.out.println("1) Deplacer la forme :  ");//
            System.out.println("2) supprimer la forme :  ");
            System.out.println("&3) copier la forme :  ");
            System.out.println("4) retour :  ");

            switch (util3.scanner.scannerint(1, 3))
            {case 1:break;//homothétie, translation, rotation,  symétrie centrale, symétrie axiale.
                case 2:Dessin_courant.Liste.remove(choix);
                    break;
            }


        }

        //voir detaille , deplacer / supprimer

    }

    public void Menu_gestion_dessin()
    {  System.out.println("1) charger un autre dessin :");
        System.out.println("2) cree un nouveau dessin (et basculer dessus) :");
        System.out.println("3) deplacer tous le dessin courant:");
        System.out.println("4) Copier le dessin courant dans un nouveau ensemble de forme");
        System.out.println("5) Retour");
        switch (util3.scanner.scannerint(1, 5))
        {case 1: if(Dessin.size()==1){System.out.println("Il n'y a pas d'autre dessin");}
            else{int i=0;
                System.out.println("Choix du nouveau dessin :");
                for(Dessin a:Dessin){i++; System.out.println(i+") Dessin "+a.Nom+" ");}

                System.out.println("retour  "+(i+1));
                int  choix = util3.scanner.scannerint(1,i+1);
                if(choix!=i+1){Dessin_courant= Dessin.get(choix-1);}
                }
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
}