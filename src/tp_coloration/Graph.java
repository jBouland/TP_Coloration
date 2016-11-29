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
            return Integer.compare(o2.getVoisins().size(), o1.getVoisins().size());
        }
    }

    /*
     * @return le nombre de couleur sur le graphe via la méthode Welsh Powell
     */
    public int welshPowell() {
        int color = 0;
        Noeud noeud;
        //Sort : 
        Collections.sort(noeuds, new CustomComparator());
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
        return color + 1;
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

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }

    public void setNoeuds(ArrayList<Noeud> noeuds) {
        this.noeuds = noeuds;
    }

}
