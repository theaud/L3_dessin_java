package Graphique.dessin;

import util3.ComplexeInt;

import java.awt.*;

public class Ligne extends Forme {

    public ComplexeInt second=new ComplexeInt();
    public int largeur;


    public Ligne()
    {second.set(10,10);

        largeur=3;


    }

    public Ligne(ComplexeInt Origine, ComplexeInt Second)
    {origine=Origine;
        second=Second;
        largeur=3;
        initialisation();
    }

    public Ligne(ComplexeInt Origine, ComplexeInt Second,int Largeur)
    {origine=Origine;
        second=Second;
        largeur=Largeur;
        initialisation();
    }

    public Ligne(int origineX,int origineY,int secondX,int secondY)
    {origine=new ComplexeInt(origineX,origineY);
     second=new ComplexeInt(secondX,secondY);
        largeur=3;
        initialisation();
    }

    public void initialisation()
    {
        type="Ligne";
    }

    public void paint(Graphics g) {
        super.paint(g);
        int demie_largeur=largeur/2+1;
        if(origine.getRe()==second.getRe())
            {for(int i=-demie_largeur;i<largeur/2;i++){g.drawLine(origine.getRe()+i,origine.getIm(),second.getRe()+i,second.getIm());}}
        else if(origine.getIm()==second.getIm())
            {for(int i=-demie_largeur;i<largeur/2;i++){ g.drawLine(origine.getRe(),origine.getIm()+i,second.getRe(),second.getIm()+i);}}
        else
            {for(int i=-demie_largeur;i<largeur/2;i++){g.drawLine(origine.getRe()+i,origine.getIm(),second.getRe()+i,second.getIm());}}




    }



    @Override
    public int appartien(int x,int y)
    {
        return 0;
    }
    public int get_air(){return 0;}

    public int get_perimetre()
    {return origine.difference(second);}



    @Override public void translate(ComplexeInt nouvelle_origine)
    { origine=nouvelle_origine;
        ComplexeInt translation=new ComplexeInt(origine.getRe()-nouvelle_origine.getRe(),origine.getIm()-nouvelle_origine.getIm());
        second.set(second.getRe()+translation.getRe(),second.getIm()+translation.getIm());
    }


    @Override public Forme copy() {return new Ligne(origine,second,largeur);}

    @Override
    public String toString() {
        return "Ligne\t:" +
                "\torigine = " + origine +
                "\n\t\t\t\tsecond = " + second
                ;
    }
}
