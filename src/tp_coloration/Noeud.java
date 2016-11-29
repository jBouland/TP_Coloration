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
    private int Dsat;
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
    
    public boolean aVoisinsWithColor(int color){
        for(int i=0; i<voisins.size(); i++){
            if(voisins.get(i).getColor() == color){
                return true;
            }
        }
        return false;
    }

    public int getDsat() {
        return Dsat;
    }

    public void setDsat(int Dsat) {
        this.Dsat = Dsat;
    }
    
    
    
    public Noeud(){
        color = 0;
        Dsat = 0;
        voisins = new ArrayList<Noeud>();
    }
    
    public void addVoisin(Noeud n){
        voisins.add(n);
    }
    
    
    
}
