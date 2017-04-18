package Graphique.aide;

import Graphique.Jpanel.Fenetre;

import javax.swing.*;
import java.awt.*;

public class Form  {


   protected JLabel     texte;
   protected JTextField form;
   protected Bouton bouton;
   protected boolean withBouton=false;


    public Form()
    {texte=new JLabel("no texte2");

     texte.setLayout(new BorderLayout());
        constructeur();
    }

    public Form(String Texte)
    {texte=new JLabel(Texte);
        constructeur();
    }
    public Form(String Texte,Bouton b1)
    {texte=new JLabel(Texte);
        constructeur();
        bouton=b1;
        withBouton=true;
    }

    private void constructeur()
    {  form=new JTextField();
        form.setPreferredSize(new Dimension(100, 25));
        form.setLayout(new BorderLayout());
    }


    public static  Form[] Tableau_Form(int size)
    { Form[] form     =new Form[size];
        for(int i=0;i<size;i++)
        {form[i]=new Form("no texte");}
        return form;
    }

    public void addBouton(Bouton added){
        if(!withBouton){
            withBouton=true;
            bouton=added;
        }
    }


    public JLabel getTexte() {return texte;}
    public void setTexte(JLabel texte) {this.texte = texte;}

    public String getTexteString() {return texte.getText();}
    public void setTexteString(String texte) {this.texte.setText(texte);}

    public JTextField getForm() {return form;}
    public void setForm(JTextField form) {this.form = form;}

    public String getContain() {return form.getText();}
    public void setContain(String Contain) {this.form.setText(Contain) ;}


    public Fenetre getOnPanel() {
        Fenetre returned=new Fenetre();
        returned.add(texte);
        returned.add(form);
        if(withBouton){returned.add(bouton);}
        return returned;}



    public boolean isWithBouton() {
        return withBouton;
    }

    public void setWithBouton(boolean withBouton) {
        this.withBouton = withBouton;
    }

    public Bouton getBouton() {
        return bouton;
    }

    public void setBouton(Bouton bouton) {
        this.bouton = bouton;
    }
}
