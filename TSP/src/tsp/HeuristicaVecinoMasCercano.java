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
public class HeuristicaVecinoMasCercano {
    private Problema problema;
    private Ruta mejorRuta;
	
    
    public HeuristicaVecinoMasCercano(Problema p){
        
        problema=p;
    }

    public Ruta obtenerMejorRuta(ArrayList<Ciudad> ciudades){
        
        Boolean[] visitados;
        Ciudad ciudadInicial=new Ciudad();
        int anteriorCiudad;
        
        //Bucle para probar con todas las ciudades i como ciudad inicial
        for (int i=0;i<ciudades.size();i++){
            
            visitados=new Boolean[ciudades.size()];
            ciudadInicial=ciudades.get(i);
            Ruta rutaActual=new Ruta(ciudades.size());
            
            rutaActual.addCiudad(i);
            anteriorCiudad=i;
            visitados[anteriorCiudad]=true;
            
            for(int j=0;j<ciudades.size()-1;j++){
                
                int ciudadMasCercana=problema.getCiudadMasCercana(anteriorCiudad, visitados);
                anteriorCiudad=ciudadMasCercana;
                visitados[ciudadMasCercana]=true;
                rutaActual.addCiudad(ciudadMasCercana);
            }
            if (problema.coste(mejorRuta)<problema.coste(rutaActual)){
                
                mejorRuta=rutaActual;
            }
        }	
	return mejorRuta;
    }
}
