package Graphique.dessin;

import util3.ComplexeInt;

import java.awt.*;

public class Ligne extends Forme {

    public ComplexeInt second=new ComplexeInt();

    public Ligne()
    {second.set(10,10);
        type="Ligne";
    }

    public Ligne(ComplexeInt Origine, ComplexeInt Second)
    {origine=Origine;
        second=Second;
        type="Ligne";
    }

    public Ligne(int origineX,int origineY,int secondX,int secondY)
    {origine=new ComplexeInt(origineX,origineY);
     second=new ComplexeInt(secondX,secondY);;
    }

    public void paint(Graphics g) {
        super.paint(g);

        if(origine.getRe()==second.getRe())
            {for(int i=-3;i<3;i++){g.drawLine(origine.getRe()+i,origine.getIm(),second.getRe()+i,second.getIm());}}
        else if(origine.getIm()==second.getIm())
            {for(int i=-3;i<3;i++){ g.drawLine(origine.getRe(),origine.getIm()+i,second.getRe(),second.getIm()+i);}}
        else
            {for(int i=-3;i<3;i++){g.drawLine(origine.getRe()+i,origine.getIm(),second.getRe()+i,second.getIm());}}




    }

    @Override
    public String toString() {
        return "Ligne\t{" +
                "origine=" + origine +
                "\tsecond=" + second +
                '}';
    }
}
