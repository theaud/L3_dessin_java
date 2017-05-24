package Graphique.dessin;


import Graphique.app.Dessin;
import util3.ComplexeInt;

import java.awt.*;
import java.util.LinkedList;

public class Calque extends Forme {

    public LinkedList<Forme> Liste = new LinkedList<Forme>();
    public String Nom;


    public Calque(String nom, LinkedList<Forme> Liste_forme, ComplexeInt Origine) {
        origine = Origine.clone();
        Nom = nom;
        for (Forme a : Liste_forme) {
            Liste.add(a.clone());
        }

        for (Forme z : Liste) {
            z.deplacement(origine);
        }

    }

    public Calque(Dessin copie, ComplexeInt Origine) {
        Nom = copie.Nom;
        origine = Origine.clone();
        for (Forme a : copie.Liste) {
            Liste.add(a.clone());
        }

        for (Forme z : Liste) {
            z.deplacement(origine);
        }


    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Forme a : Liste) {
            a.paint(g);
        }

    }


    @Override
    public void translate(ComplexeInt nouvelle_origine) {
        ComplexeInt translation = new ComplexeInt(origine.getRe() - nouvelle_origine.getRe(), origine.getIm() - nouvelle_origine.getIm());
        deplacement(translation);
    }

    @Override
    public void deplacement(ComplexeInt vecteur) {

        for (Forme a : Liste) {
            a.deplacement(vecteur);
        }

        origine.set(origine.getRe() + vecteur.getRe(), origine.getIm() + vecteur.getIm());
    }

    @Override
    public Forme clone() {


        LinkedList<Forme> newList = new LinkedList<Forme>();
        for (Forme a : Liste) {
            newList.add(a);
        }


        return new Calque(Nom, newList, origine.clone());
    }

    @Override
    public String toString() {
        String returned = "Calque :" + Nom + " \t" +
                "\tID=" + ID +
                "\torigine=" + origine +
                "\n\t\t\t\tcouleur=" + couleur;
        for (Forme a : Liste) {
            returned += "\n\t\t" + a.toString();

        }
        return returned;
    }


}
