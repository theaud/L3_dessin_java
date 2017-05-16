package Graphique.app;

import Graphique.GridBagLayoutDemo;
import Graphique.Jpanel.Jframeadd;
import Graphique.aide.Bouton;
import Graphique.dessin.Ligne;
import Graphique.dessin.cercle;
import Graphique.dessin.forme;
import sun.security.pkcs11.P11Util;
import util3.ComplexeInt;

import java.awt.*;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.Random;


public class Application extends Jframeadd {

    public LinkedList<forme> Liste=new LinkedList() ;

    public Application(){
           // this.setTitle("Application");

            content.setLayout(new GridBagLayout());


    for (int i=0;i<5;i++)
        { Random rand = new Random();

            ComplexeInt origine=new ComplexeInt(rand.nextInt(350) + 1,rand.nextInt(350) + 10);
            ComplexeInt rayon=new ComplexeInt(30,i*2+20);
            origine.afficher("origine cercle");


            cercle a=new cercle(origine,rayon);
            a.couleur=new Color((i*31)%255,(i*101)%255,(i*13)%255);
            Liste.add(a);

        }

        for (int i=0;i<5;i++)
        { Random rand = new Random();

            ComplexeInt origine=new ComplexeInt(rand.nextInt(350) + 1,rand.nextInt(350) + 10);
            ComplexeInt rayon=new ComplexeInt(30,i*2+20);
            origine.afficher("origine ligne ");


            Ligne a=new Ligne(origine,rayon);
            a.couleur=new Color((i*31)%255,(i*101)%255,(i*13)%255);
            Liste.add(a);

        }
        Ligne a=new Ligne(new ComplexeInt(10,50),new ComplexeInt(10,50));

        Liste.add(a);

        }


    /**
     *
     * @param connection
     */
    public Application(Connection connection){

        this.setTitle(content.getName());
        content.setConfig(Color.lightGray,new GridBagLayout());



    }

    public void paint(Graphics g) {
        super.paint(g);

        for (forme a:Liste)
        {a.paint(g);
        }

    }

    public void afficher()
    {
        int i=0;
        for (forme a:Liste)
        {i++;
            System.out.println("dessin :"+a.type+" "+i);
        }
    }

}
