package Graphique.app;


import Graphique.Jpanel.Jframeadd;
import Graphique.dessin.Forme;

import java.awt.*;
import java.util.LinkedList;



public class Application extends Jframeadd {

    public LinkedList<Dessin> Dessin=new LinkedList() ;

    public Dessin Dessin_courant ;

    public Application(){

        Dessin.add(Graphique.app.Dessin.toto());
        Dessin.add(new Dessin("test"));
        Dessin.add(new Dessin());

        Dessin_courant=Dessin.get(0);
        String title="Application "+Dessin_courant.Liste.size();
        this.setTitle(title);

        }

    public void paint(Graphics g) {
        super.paint(g);

        try {
            if (Dessin_courant.Liste.size() > 0) {
                for (Forme a : Dessin_courant.Liste) {

                    a.paint(g);
                }
            }
            this.setTitle("Application " + Dessin_courant.Liste.size());
        }
        catch (java.lang.NullPointerException e)
        {

        }
    }


    public  void fonction() {
        boolean test = true;
        int menu;
        int menu2;
        do {
            menu = Menu();


            if (menu != 9) {
                switch (menu) {
                    case 1:
                        Dessin_courant.ajout_forme();
                        break;
                    case 2:
                        menu2 = Menu_consultation_forme( );
                        break;
                    case 3:

                        break;
                    case 4: if(Dessin.size()==1)
                        {
                            System.out.println("Il n'y a pas d'autre dessin");
                        }
                        else
                        {int i=0;
                            System.out.println("Choix du nouveau dessin :");
                            for(Dessin a:Dessin)
                            {i++;
                                System.out.println(i+") Dessin "+a.Nom+" ");
                            }
                            System.out.println("retour  "+(i+1));
                            int  choix = util3.scanner.scannerint(1,i+1);
                            if(choix!=i+1)
                            {
                                Dessin_courant= Dessin.get(choix-1);
                            }
                        }

                        break;
                    case 5: Dessin_courant=new Dessin();
                            Dessin.add(Dessin_courant);

                        break;
                }

                // appli.paint(appli.getGraphics());
                // appli.afficher();
            }

            this.setTitle(Dessin_courant.Nom);
            paint(getGraphics());
        } while (menu != 9);
    }

    public  int Menu() {

        int sortie;

        System.out.println("\n\n----------------------------------------");
        System.out.println("Menu : que souhaitez-vous faire?");
        System.out.println("Ajoutez une Forme :1");
        System.out.println("Consulter les formes deja présente :2");//voir detaille , deplacer / supprimer
        System.out.println("Trier les formes :3");
        System.out.println("Charger un autre dessin :4");
        System.out.println("cree un nouveau dessin :5");
        System.out.println("Quitter :6");


        sortie = util3.scanner.scannerint(1, 6);


        return sortie;
    }

    public int Menu_consultation_forme() {

        int i=0;
        int choix;
        for (Forme a:Dessin_courant.Liste)
        {i++;
            System.out.println(i+") "+a.toString()+"\n");

        }

        System.out.println(" Selectionner une forme : son numero");
        System.out.println(" retour : "+(i+1));

        choix = util3.scanner.scannerint(1, i+1);
        if(choix<i+1)
        {System.out.println(i+") "+Dessin_courant.Liste.get(choix).toString()+"\n");

            System.out.println(" Que souhaitez-vous faire");
            System.out.println(" Deplacer la forme : 1 ");//
            System.out.println(" supprimer la forme : 2 ");
            System.out.println(" retour : 3 ");

            switch (util3.scanner.scannerint(1, 3))
            {case 1:break;//homothétie, translation, rotation,  symétrie centrale, symétrie axiale.
                case 2:Dessin_courant.Liste.remove(choix);
                    break;
            }


        }

        //voir detaille , deplacer / supprimer
        return 1;
    }

}