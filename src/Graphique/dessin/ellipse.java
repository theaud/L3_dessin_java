package Graphique.dessin;

import util3.ComplexeInt;

import java.awt.*;


public class ellipse extends Forme {

    public ComplexeInt rayon;

    public ellipse()
    {rayon=new ComplexeInt(10,10);
        initialisation();
    }


    public ellipse(int origineX,int origineY,int Rayon1,int Rayon2)
    {origine=new ComplexeInt(origineX,origineY);
        rayon = new ComplexeInt(Rayon1, Rayon2);
        initialisation();
    }


    public ellipse(ComplexeInt Origine,ComplexeInt  Rayon) {
        origine = Origine.clone();
        rayon = Rayon.clone();
        initialisation();
    }
    public ellipse(ComplexeInt Origine,int Rayon1,int Rayon2)
    {origine=Origine;
        rayon = new ComplexeInt(Rayon1, Rayon2);
        initialisation();
    }

    public void initialisation() {
        type = "ellipse";
        air_perimettre();
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.fillOval(origine.getRe()-rayon.getRe(),origine.getIm()-rayon.getIm(),rayon.getRe()*2,rayon.getIm()*2);
        g.setColor(couleur);

    }

    public void air_perimettre() {
        // a faire
    }


    @Override
    public void translate(ComplexeInt nouvelle_origine) {
        origine = nouvelle_origine;
    }

    @Override
    public void deplacement(ComplexeInt vecteur) {
        origine.set(origine.getRe() + vecteur.getRe(), origine.getIm() + vecteur.getIm());
    }


    @Override
    public Forme clone() {
        return new ellipse(origine, rayon);
    }
    @Override
    public String toString() {

        return "ellipse\t:" +
                "\tID=" + ID +
                "\torigine = " + origine +
                "\n\t\t\t\trayon = " + rayon
                ;
    }
}
