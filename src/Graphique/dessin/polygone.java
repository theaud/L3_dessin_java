package Graphique.dessin;

import util3.ComplexeInt;

import java.util.LinkedList;

/**
 * Created by mathieu on 16/05/2017.
 */
public class polygone extends Forme {

    LinkedList<ComplexeInt> sommets=new LinkedList<ComplexeInt>();

    public polygone(LinkedList<ComplexeInt> sommets)
    {

    }

    @Override
    public String toString() {
        return "polygone{" +
                "sommets=" + sommets +
                '}';
    }
}
