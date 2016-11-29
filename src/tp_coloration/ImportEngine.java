/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_coloration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Epulapp
 */
public abstract class ImportEngine {

    //Importe les datas d'un fichier ENGINE.
    public static ArrayList<Noeud> importFile(String Path) {

        boolean aretesreading = false;
        ArrayList<Noeud> list = new ArrayList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Path));
            String line = br.readLine();
            for (int i = 0; i < 7; i++) {
                line = br.readLine();
            }
            /**
             * On saute l'entête (7 lignes) *
             */
            while (line != null && !aretesreading) {
                list.add(new Noeud());
                line = br.readLine();

                if (line.equals("--- Liste des aretes")) {
                    aretesreading = true;
                    line = br.readLine();
                }
            }
            while (line != null && aretesreading) {
                String[] lineParsed = line.split(" ");
                list.get(Integer.parseInt(lineParsed[0])).addVoisin(list.get(Integer.parseInt(lineParsed[1])));
                line = br.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }

}
