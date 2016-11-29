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
public class Noeud {
    
    private int color;
    private ArrayList<Noeud> voisins;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public ArrayList<Noeud> getVoisins() {
        return voisins;
    }

    public void setVoisins(ArrayList<Noeud> voisins) {
        this.voisins = voisins;
    }
    
    
    public Noeud(){
        voisins = new ArrayList<Noeud>();
    }
    
    public void addVoisin(Noeud n){
        voisins.add(n);
    }
    
    
    
}
