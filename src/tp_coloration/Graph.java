package tp_coloration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        Collections.sort(noeuds, new CustomComparator());
        int coloredNodes = 0;
        int color = 1;
        int maxColor = 0;
        noeuds.get(0).setColor(color);
        while (coloredNodes != noeuds.size() - 1) {
            Noeud currentNode = chooseHigherDsat();
            colorNodeWithMinColor(currentNode);
            if (noeuds.contains(currentNode)) {
                System.out.println("Noeud " + noeuds.indexOf(currentNode) + " coloré avec la couleur " + currentNode.getColor());
            } else {
                System.out.println("NOEUD NON EXISTANT TU LAS DANS LE CUL");
            }
            if (maxColor < currentNode.getColor()) {
                maxColor = currentNode.getColor();
            }
            coloredNodes++;
        }
        System.out.println("COULEUR MAX UTILISE : " + maxColor);

    }

    public void colorNodeWithMinColor(Noeud n) {
        ArrayList<Noeud> voisins = n.getVoisins();
        ArrayList colors = new ArrayList();
        for (int i = 0; i < voisins.size(); i++) {
            if (voisins.get(i).getColor() != 0 && !colors.contains(voisins.get(i).getColor())) {
                colors.add(voisins.get(i).getColor());
            }
        }
        for (int i = 1; i < colors.size(); i++) {
            if (!colors.contains(i)) {
                n.setColor(i);
                System.out.println("COULEUR :" + i);
                return;
            }
        }
        n.setColor(colors.size() + 1);

    }

    private Noeud chooseHigherDsat() {
        int maxDsat = -1;
        ArrayList<Noeud> bestNodes = new ArrayList<Noeud>();
        for (int i = 0; i < noeuds.size(); i++) {
            if (noeuds.get(i).getColor() == 0) {
                if (maxDsat < noeuds.get(i).getDsat()) {
                    bestNodes.clear();
                    maxDsat = noeuds.get(i).getDsat();
                    bestNodes.add(noeuds.get(i));
                } else if (maxDsat == noeuds.get(i).getDsat()) {
                    bestNodes.add(noeuds.get(i));
                }
            }
        }

        if (bestNodes.size() != 0) {

            int maxColor = 0;
            Noeud finalNode = bestNodes.get(0);
            for (int i = 0; i < bestNodes.size(); i++) {
                if (maxColor < bestNodes.get(i).getColor()) {
                    maxColor = bestNodes.get(i).getColor();
                    finalNode = bestNodes.get(i);
                }
            }
            return finalNode;
        }
        else{
            return null;
        }
    }

    public void Dsat(Noeud n) {
        int color = n.getColor();

        ArrayList<Noeud> voisins = n.getVoisins();
        for (int i = 0; i < voisins.size(); i++) {
            ArrayList<Noeud> voisins_2 = voisins.get(i).getVoisins();
            Boolean incDsat = true;
            for (int j = 0; j < voisins_2.size(); j++) {
                if (voisins_2.get(j).getColor() == color) {
                    incDsat = false;
                    break;
                }
            }
            if (incDsat) {
                voisins.get(i).setDsat(voisins.get(i).getDsat() + 1);
            }
        }
    }

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }

    public void setNoeuds(ArrayList<Noeud> noeuds) {
        this.noeuds = noeuds;
    }

}
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
