package Graphique.dessin;

import Graphique.app.LPixel;
import util3.ComplexeInt;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Forme extends JPanel{


    public static int compteur=0;
    public ComplexeInt origine=new ComplexeInt();
    public Color couleur=new Color(128,255,64);
    public int air;
    public int perimettre;

    public String type;
    public Forme()
    {Random rand = new Random();
       int valeur=rand.nextInt(1236) + 1;
        couleur=new Color((valeur*31)%255,(valeur*101)%255,(valeur*13)%255);

        origine.set(50,50);
        type="Forme";
        compteur++;

    }




    public void paint(Graphics g) {super.paint(g);}
    public Forme copy() {return new Forme();}



    public LPixel get_LPixel()
    {LPixel ecran=new LPixel();
        for(int x=0;x<ecran.dimension.getRe();x++)
        { for(int y=0;y<ecran.dimension.getIm();y++)
        { ecran.valeur[x][y]=appartien( x, y); }
        }
        return ecran;
    }
    public int get_air()
    { LPixel ecran=get_LPixel();
         air=0;
        String ligne;int test;
        for(int x=0;x<ecran.dimension.getRe();x++)
        { ligne="";test=0;
            for(int y=0;y<ecran.dimension.getIm();y++)
            {if(ecran.valeur[x][y]!=0)
            {air++; ligne+=" "+ecran.valeur[x][y];test++;}
            }
            if(test!=0)System.out.println(ligne+"    "+test);
        }
        return air;
    }
    public int get_perimetre() {LPixel ecran=get_LPixel();
         perimettre=0;

        for(int x=0;x<ecran.dimension.getRe();x++)
        {
            for(int y=0;y<ecran.dimension.getIm();y++)
            {if(ecran.valeur[x][y]==1)
            {perimettre++;}
            }
        }
        return perimettre;}

    public int appartien(int x,int y) {return 0;}

    public void translate(ComplexeInt nouvelle_origine)
    { origine=nouvelle_origine;}


    @Override
    public String toString() {
        return "Forme \t:" +
                "\torigine=" + origine +
                "\n\t\t\t\tcouleur=" + couleur +
                "\ttype='" + type + '\''
                ;
    }
}

