/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_coloration;

import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class Graph {
    
    private ArrayList<Noeud> noeuds;

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }

    public void setNoeuds(ArrayList<Noeud> noeuds) {
        this.noeuds = noeuds;
    }
    
    
    public void Dsatur(){
        //sortByDegree()
        int color = 0;
        noeuds.get(0).setColor(color);
        
    }
    
    public void Dsat(){
        for(int i = 0; i < noeuds.size(); i++){
            
        }
    }
   
}
