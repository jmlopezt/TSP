/*
***************************************************************
 ************** Juan Manuel López Torralba ********************
 ************** Santiago Juárez Rodríguez *********************
 **************************************************************
 * 4ºCurso Grado Ingeniería de Tecnología de Telecomunicación *
 * ******** Especialidad: Sistemas de Telecomunicación ********
 ********* Asignatura: CP (Complementos de Programación) ******
 ***************** Optativa Telemática ************************
 **************************************************************
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
