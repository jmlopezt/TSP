/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

/**
 *
 * @author santiago
 */
import java.util.ArrayList;
import java.util.Collections;

public class Algoritmo4 {
    private Problema problema;
    private Ruta mejorRuta;
	
    
    public Algoritmo4(Problema p){
        
        problema=p;
    }


    public Ruta obtenerRutaAleatoria(ArrayList<Ciudad> ciudades){

        int k=10000;
        Ruta rutaActual = new Ruta(ciudades.size());
       
        //Ruta inicial
        for (int i=0; i<ciudades.size(); i++){
            rutaActual.addCiudad(i);
        }
        
        //Hay que crear k rutas aleatorias
        for (int i=0; i<k; i++){
            Collections.shuffle(rutaActual.getRuta()); //Obtenemos una ruta aleatoria con shuffle

            if (problema.coste(mejorRuta)<problema.coste(rutaActual)){
                
                mejorRuta=rutaActual;
            }

        }
        return mejorRuta;
    }
}