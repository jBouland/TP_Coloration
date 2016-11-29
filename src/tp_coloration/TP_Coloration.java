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
public class TP_Coloration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int col = 0;
        
        //GRAPH 5
        Graph g = new Graph();
        //A modifier en fonction du chemin du fichier
        System.out.println("*** GRAPH 5 x 5 ***");
        g.setNoeuds(ImportEngine.importFile("C:\\Users\\Epulapp\\Downloads\\queen5_5.txt"));
        g.raz();
        col = g.welshPowell("DESC");
        System.out.println("Welsh Powell DESC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("ASC");
        System.out.println("Welsh Powell ASC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("RANDOM");
        System.out.println("Welsh Powell RANDOM : " + col + " couleurs");
        g.raz();
        col = g.greedy();
        System.out.println("Greedy : " + col + " couleurs");
         System.out.println("");
         
        //GRAPH 7
        System.out.println("*** GRAPH 7 x 7 ***");
        g = new Graph();
        //A modifier en fonction du chemin du fichier
        g.setNoeuds(ImportEngine.importFile("C:\\Users\\Epulapp\\Downloads\\queen7_7.txt"));
        g.raz();
        col = g.welshPowell("DESC");
        System.out.println("Welsh Powell DESC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("ASC");
        System.out.println("Welsh Powell ASC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("RANDOM");
        System.out.println("Welsh Powell RANDOM : " + col + " couleurs");
        g.raz();
        col = g.greedy();
        System.out.println("Greedy : " + col + " couleurs");
         System.out.println("");
         
        //GRAPH 9
        g = new Graph();
        System.out.println("*** GRAPH 9 x 9 ***");
        //A modifier en fonction du chemin du fichier
        g.setNoeuds(ImportEngine.importFile("C:\\Users\\Epulapp\\Downloads\\queen9_9.txt"));
        g.raz();
        col = g.welshPowell("DESC");
        System.out.println("Welsh Powell DESC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("ASC");
        System.out.println("Welsh Powell ASC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("RANDOM");
        System.out.println("Welsh Powell RANDOM : " + col + " couleurs");
        g.raz();
        col = g.greedy();
        System.out.println("Greedy : " + col + " couleurs");
         System.out.println("");
         
        //GRAPH 11
        g = new Graph();
        //A modifier en fonction du chemin du fichier
        System.out.println("*** GRAPH 11 x 11 ***");
        g.setNoeuds(ImportEngine.importFile("C:\\Users\\Epulapp\\Downloads\\queen11_11.txt"));
        g.raz();
        col = g.welshPowell("DESC");
        System.out.println("Welsh Powell DESC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("ASC");
        System.out.println("Welsh Powell ASC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("RANDOM");
        System.out.println("Welsh Powell RANDOM : " + col + " couleurs");
        g.raz();
        col = g.greedy();
        System.out.println("Greedy : " + col + " couleurs");
         System.out.println("");
         
        //GRAPH 13
        g = new Graph();
        //A modifier en fonction du chemin du fichier
        System.out.println("*** GRAPH 13 x 13 ***");
        g.setNoeuds(ImportEngine.importFile("C:\\Users\\Epulapp\\Downloads\\queen13_13.txt"));
        g.raz();
        col = g.welshPowell("DESC");
        System.out.println("Welsh Powell DESC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("ASC");
        System.out.println("Welsh Powell ASC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("RANDOM");
        System.out.println("Welsh Powell RANDOM : " + col + " couleurs");
        g.raz();
        col = g.greedy();
        System.out.println("Greedy : " + col + " couleurs");
        
        System.out.println("");
        //GRAPH 15
        g = new Graph();
        //A modifier en fonction du chemin du fichier
        System.out.println("*** GRAPH 15 x 15 ***");
        g.setNoeuds(ImportEngine.importFile("C:\\Users\\Epulapp\\Downloads\\queen15_15.txt"));
        g.raz();
        col = g.welshPowell("DESC");
        System.out.println("Welsh Powell DESC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("ASC");
        System.out.println("Welsh Powell ASC : " + col + " couleurs");
        g.raz();
        col = g.welshPowell("RANDOM");
        System.out.println("Welsh Powell RANDOM : " + col + " couleurs");
        g.raz();
        col = g.greedy();
        System.out.println("Greedy : " + col + " couleurs");
        
    }
    
}
