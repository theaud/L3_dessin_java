package Graphique.app;

import util3.Complexe;
import util3.ComplexeInt;

import java.awt.*;


public class LPixel {

    public Color[][] valeur=new Color[800][800];
    public ComplexeInt dimension=new ComplexeInt(800,800);


    public LPixel()
    {
        for(int i=0;i<dimension.getRe();i++)
        {for(int j=0;j<dimension.getIm();j++)
        {valeur[i][j]=new Color(0,0,0);}
        }
    }

    public void ajoue(LPixel nouveau)
    {
        //si nouveau != de blanc => ajouter au coordonne a valeur
    }



}
