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
 * Esta clase implementa distintos algoritmos para resolver la ruta
 * a escoger
 * @author  Juan Manuel López Torralba - Santiago Juárez Rodríguez
 */
public class Heuristica {
    private Problema problema;
    private Ruta mejorRuta,ordenViaje;
   // private Boolean[] visitados;
	
    /**
     * Constructor de la clase heurística
     * @param p
     */
    public Heuristica(Problema p){
        
        problema=p;
    }

    /**
     * Este método resuelve la ruta mediante la Heurística del vecino
     * más cercano
     * @param problema
     * @return mejorRuta
     */
    public Ruta obtenerRutaAlgoritmo1(Problema problema){
        
        ArrayList<Ciudad> listaCiudadesAux = new ArrayList<>();
        listaCiudadesAux=problema.getListaCiudades();
        Boolean[] visitados;
        Ciudad ciudadInicial=new Ciudad();
        int anteriorCiudad;
        
        //Bucle para probar con todas las ciudades i como ciudad inicial
        for (int i=0;i<listaCiudadesAux.size();i++){
            
            visitados=new Boolean[listaCiudadesAux.size()];
            ciudadInicial=listaCiudadesAux.get(i);
            Ruta rutaActual=new Ruta(listaCiudadesAux.size());
            
            rutaActual.addCiudad(i);
            anteriorCiudad=i;
            visitados[anteriorCiudad]=true;
            
            for(int j=0;j<listaCiudadesAux.size()-1;j++){
                
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
    
    public Ruta obtenerRutaInicial(Problema problema){
        
        ArrayList<Ciudad> listaCiudadesAux = new ArrayList<>();
        listaCiudadesAux=problema.getListaCiudades();
	Ruta ordenViaje = new Ruta(listaCiudadesAux.size());
	double yMax =listaCiudadesAux.get(0).getPosicion().ObtieneCoordenada_y();
        double xMax =listaCiudadesAux.get(0).getPosicion().ObtieneCoordenada_x();
        double xMin =listaCiudadesAux.get(0).getPosicion().ObtieneCoordenada_x();
	int pos1=0,pos2=0,pos3=0;
        
		//Buscamos la coordenada Y mayor.
	for (int i=1;i<listaCiudadesAux.size();i++){
            if(listaCiudadesAux.get(i).getPosicion().ObtieneCoordenada_y()> yMax ){
		yMax=listaCiudadesAux.get(i).getPosicion().ObtieneCoordenada_y();
                pos1=i;
           //     visitados[i]=true;
            }
	}
		//Buscamos la coordenada X mayor.
	for (int j=1;j<listaCiudadesAux.size();j++){
            if(listaCiudadesAux.get(j).getPosicion().ObtieneCoordenada_x()> xMax ){
		xMax=listaCiudadesAux.get(j).getPosicion().ObtieneCoordenada_x();
                pos2=j;
            //    visitados[j]=true;
            }
	}
                //Buscamos la coordenada X menor.
	for (int k=1;k<listaCiudadesAux.size();k++){
            if(listaCiudadesAux.get(k).getPosicion().ObtieneCoordenada_x()< xMin ){
		xMin=listaCiudadesAux.get(k).getPosicion().ObtieneCoordenada_x();
                pos3=k;
          //      visitados[k]=true;
            }
	}
        
	ordenViaje.addCiudad(pos1);
	ordenViaje.addCiudad(pos2);
	ordenViaje.addCiudad(pos3);
		
	return ordenViaje;
    }
    
    public Ruta obtenerRutaEconomica(Problema problema){
        
        ArrayList<Ciudad> listaCiudadesAux = new ArrayList<>();
        listaCiudadesAux=problema.getListaCiudades();
        
        Boolean[] visitados = new Boolean[listaCiudadesAux.size()];
        
        Ruta rutaInicial = new Ruta(0);
        Ruta rutaAux = new Ruta(0);
	Ruta rutaFinal = new Ruta(listaCiudadesAux.size());
        
		//rutaInicial=ordenViaje (el triangulo calculado anteriormente)
	rutaInicial=obtenerRutaInicial(problema);
        for (int i=0;i<2;i++){
            visitados[(Integer)rutaInicial.getRuta().get(i)]=true;  
        }
                //Una vez que se han puesto las ciudades visitadas creo que se
                //hace la heuristicavecinomascercano
          return rutaFinal; 
	}

}

