package Graphique.Jpanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mathieu on 20/01/2017.
 */
public class Jframeadd  extends JFrame {
    protected  Fenetre content = new Fenetre();

    public Jframeadd(){

        content.setConfig(Color.lightGray,new GridBagLayout());


        initialisation_obligatoire();
        chargerFenetre();

    }


    /**
     * set the obligatory setting
     */
    public void  initialisation_obligatoire()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(content);
        this.setVisible(true);
    }

    /**
     * load or reload the value of the window in the frame
     */
    public void chargerFenetre()
    {
        this.setTitle(content.getName());
        this.setSize(content.getDim());

    }

}
