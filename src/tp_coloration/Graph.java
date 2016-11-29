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
    
    public void raz(){
        //remove color
        for(int i=0; i< noeuds.size(); i++){
            noeuds.get(i).setColor(0);
        }
    }

    public class CustomComparatorAsc implements Comparator<Noeud> {

        @Override
        public int compare(Noeud o1, Noeud o2) {
           //Return sens inverse
           return Integer.compare(o1.getVoisins().size(), o2.getVoisins().size());
        }
    }
    
    public class CustomComparatorDesc implements Comparator<Noeud> {

        @Override
        public int compare(Noeud o1, Noeud o2) {
            //Return sens inverse
            return Integer.compare(o2.getVoisins().size(), o1.getVoisins().size());
        }
    }

    /*
     * @return le nombre de couleur sur le graphe via la méthode Welsh Powell
     */
    public int welshPowell(String comparator) {
        int color = 1;
        Noeud noeud;
        //Sort : 
        switch(comparator){
            case "ASC":
                Collections.sort(noeuds, new CustomComparatorAsc());
                break;
            case "DESC":
                Collections.sort(noeuds, new CustomComparatorDesc());
                break;
            default:
                break;
        }
        ArrayList<Noeud> noeudsCopy = new ArrayList();
        for (int i = 0; i < noeuds.size(); i++) {
            noeudsCopy.add(noeuds.get(i));
        }

        while (noeudsCopy.size() > 0) {
            noeud = noeudsCopy.remove(0);
            noeud.setColor(color);
            for (int i = 0; i < noeudsCopy.size(); i++) {
                Noeud n2 = noeudsCopy.get(i);
                if (!n2.aVoisinsWithColor(color)) {
                    n2.setColor(color);
                    noeudsCopy.remove(n2);
                    i--;
                }
            }
            color++;
        }
        return color;
    }

    public void Dsatur() {
        //sortByDegree()
        int color = 0;
        noeuds.get(0).setColor(color);

    }

    public void Dsat() {
        for (int i = 0; i < noeuds.size(); i++) {

        }
    }
    
    public int greedy(){
        int maxCol = 0;
        for(int i =0; i<noeuds.size(); i++){
            Noeud n =noeuds.get(i);
            n.setColor(n.premiereCouleurDispo());
            if(maxCol < n.getColor()){
                maxCol = n.getColor();
            }
        }
        return maxCol;
    }

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }

    public void setNoeuds(ArrayList<Noeud> noeuds) {
        this.noeuds = noeuds;
    }

}
