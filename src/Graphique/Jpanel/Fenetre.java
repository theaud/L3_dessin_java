package Graphique.Jpanel;



import javax.swing.*;
import java.awt.*;


public class Fenetre extends JPanel {


    protected static int compteur=0;
    protected Dimension dim = new Dimension(800, 800);
    protected String name="Ma fenetre";


    protected int isopen=0;

    public Fenetre(){


        setBackground(new Color(0,0,64));setSize(dim);
    }

    public Fenetre(Color color){
       // name="Fenetre autogeneration"+(compteur++);

        setBackground(color);setSize(dim);

    }

    public static JLabel[] Tableau_JLabel(int size) {
        JLabel[] label = new JLabel[size];
        for (int i = 0; i < size; i++) {
            label[i] = new JLabel();
        }
        return label;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        Fenetre.compteur = compteur;
    }

    public void add(Fenetre[] list,int size)
    {
    for(int i=0;i<size;i++)
        {add(list[i]);}
    }

    public void setConfig(Color color,GridBagLayout layout)
    {
        setBackground(color);
        setLayout(layout);
    }

//----------------------------------------------------------------------------------------------------------------
//------------------------------------- Getter setter   ----------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Dimension getDim() {   return dim;    }

    public void setDim(Dimension dim) {        this.dim = dim;    }

    public int getIsopen() {return isopen;}
    public void setIsopen(int Isopen) {this.isopen = Isopen;}
    /** use to change the current window     */
    public void stopIsopen(){this.isopen=0;}


}
