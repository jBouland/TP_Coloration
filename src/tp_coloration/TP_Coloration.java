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
        
        Graph g = new Graph();
        g.setNoeuds(ImportEngine.importFile("C:\\Users\\Epulapp\\Downloads\\queen13_13.txt"));
        g.Dsatur();
        
    }
    
}
