package Graphique.dessin;

import util3.ComplexeInt;

import java.awt.*;


public class Rectangle extends Forme {

    public ComplexeInt second;

    public Rectangle() {
        origine = new ComplexeInt(50, 50);
        second = new ComplexeInt(100, 100);
        initialisation();
    }

    public Rectangle(ComplexeInt Origine, ComplexeInt Second) {
        origine = Origine;
        second = Second;
        initialisation();
    }

    public void initialisation() {
        type = "Rectangle";
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.fillRect(origine.getRe(), origine.getIm(), second.getRe(), second.getIm());
        g.setColor(couleur);
    }


    @Override
    public int appartien(int x, int y) {
        if ((origine.getRe() == x || second.getRe() == x) && ((origine.getIm() >= y && y >= second.getIm()) || (origine.getIm() <= y && y <= second.getIm()))) {
            return 1;
        } else if ((origine.getIm() == y || second.getIm() == y) && ((origine.getRe() <= x && x <= second.getRe()) || (origine.getRe() >= x && x >= second.getRe()))) {
            return 1;
        } else if ((origine.getRe() < x && x < second.getRe()) || (origine.getRe() > x && x > second.getRe())) {
            if ((origine.getIm() < y && y < second.getIm()) || (origine.getIm() > y && y > second.getIm())) {
                return 2;
            }
        }

        return 0;
    }


    @Override
    public Forme copy() {
        return new Rectangle(origine, second);
    }


    @Override
    public void translate(ComplexeInt nouvelle_origine) {
        origine = nouvelle_origine;
        ComplexeInt translation = new ComplexeInt(origine.getRe() - nouvelle_origine.getRe(), origine.getIm() - nouvelle_origine.getIm());
        second.set(second.getRe() + translation.getRe(), second.getIm() + translation.getIm());
    }


    @Override
    public String toString() {
        return "Rectangle\t:" +
                "\torigine = " + origine +
                "\n\t\t\t\tsecond = " + second
                ;

    }
}
