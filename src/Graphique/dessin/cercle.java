package Graphique.dessin;

import util3.ComplexeInt;

import java.awt.*;


public class cercle extends Forme {

    public int rayon;


    public cercle()
        {rayon=10;        origine=new ComplexeInt(50,50);        initialisation();}

    public cercle(ComplexeInt Origine,int Rayon)
        {origine=Origine; rayon=Rayon;     initialisation();}
    public cercle(int origineX,int origineY,int Rayon)
        {origine=new ComplexeInt(origineX,origineY);  rayon=Rayon;    initialisation();}

    public void initialisation() { type="cercle"; }

    public void paint(Graphics g) {
        super.paint(g);

        if(origine.getRe()-rayon>0 && origine.getIm()-rayon>0 || true) {
            g.fillOval(origine.getRe() - rayon, origine.getIm() - rayon, rayon * 2, rayon * 2);
            g.setColor(couleur);
        }

    }





    @Override public void translate(ComplexeInt nouvelle_origine) { origine=nouvelle_origine;}
    @Override public Forme copy() {return new cercle(origine,rayon);}

    @Override
    public String toString() {

        return  "Cercle\t:" +
                "\torigine = " + origine +
                "\n\t\t\t\trayon = " + rayon
                ;
    }
}
