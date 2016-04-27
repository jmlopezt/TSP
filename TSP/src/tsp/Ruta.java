/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.ArrayList;

/**
 *
 * @author Juanma
 */
public class Ruta {
    // este metodo devuelve la ruta calculada ya, pero no el string;n sino su posicion en el vector listaciudades.
    private int nCiudadesVisitadas;
    private static ArrayList<Integer> rutaCiudades = new ArrayList<>();
    
    
    Ruta(int n){

        nCiudadesVisitadas=0;
    }
    
    void addCiudad (int pos){
        
        rutaCiudades.add(pos);
    }
    
    public ArrayList getRuta(){

        return rutaCiudades;
    }
   
    int getNumberCiudadesVisitadas(){    
        
        return rutaCiudades.size();
    }   

}
