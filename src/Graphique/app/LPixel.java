package Graphique.app;

import util3.ComplexeInt;


public class LPixel {

    public int[][] valeur;//0= vide 1=forme 2=air interieur d'une forme
    public ComplexeInt dimension;


    public LPixel()
    {
        dimension = new ComplexeInt(2000, 2000);
        creation();
    }

    public LPixel(int largeur, int hauteur) {
        dimension = new ComplexeInt(largeur, hauteur);
        creation();
    }

    public void creation() {
        valeur = new int[dimension.getRe()][dimension.getIm()];
        for(int i=0;i<dimension.getRe();i++) {
            for (int j = 0; j < dimension.getIm(); j++) {
                valeur[i][j] = 0;
            }
        }

    }

    public void ajoue(LPixel nouveau)
    {
        //si nouveau != de blanc => ajouter au coordonne a valeur
    }



}
