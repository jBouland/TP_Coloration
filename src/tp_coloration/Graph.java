/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_coloration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Epulapp
 */
public class Graph {
    public ArrayList<Noeud> noeuds;

    public Graph() {
        noeuds = null;
    }
    
    public class CustomComparator implements Comparator<Noeud> {
        @Override
        public int compare(Noeud o1, Noeud o2) {
            //Return sens inverse
            return Integer.compare(o2.listeVoisins.size(), o1.listeVoisins.size());
        }
    }
    
    /*
    * @return le nombre de couleur sur le graphe via la méthode Welsh Powell
    */
    public int welshPowell(){
        int numberOfColor = 0;
        int color = 0;
        Noeud noeud;
        //Sort : 
        Collections.sort(noeuds, new CustomComparator());
        ArrayList<Noeud> noeudsCopy = new ArrayList();
        for(int i=0; i<noeuds.size(); i++){
            noeudsCopy.add(noeuds.get(i));
        }
        
        while(noeudsCopy.size()>0){
           noeud =  noeudsCopy.remove(0);
           noeud.color = color;
           
        }
        return numberOfColor;
    }
}