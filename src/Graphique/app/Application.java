package Graphique.app;

import Graphique.Jpanel.Jframeadd;

import java.awt.*;
import java.sql.Connection;



public class Application extends Jframeadd {



    public Application(){
           // this.setTitle("Application");

            content.setLayout(new GridBagLayout());


        }


    /**
     *
     * @param connection
     */
    public Application(Connection connection){

        this.setTitle(content.getName());
        content.setConfig(Color.lightGray,new GridBagLayout());




    }



}
