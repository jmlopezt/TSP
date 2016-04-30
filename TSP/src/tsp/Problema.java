/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.*;

/**
 *
 * @author Juanma
 */

public class Problema {
    // 	private static Ciudad[] listaCiudades;

        private static ArrayList<Ciudad> listaCiudades = new ArrayList<>();
	private double[][] distancia;
        private static int nCiudades;
        
        
	public Problema(int n,ArrayList<Ciudad> vCities, double[][] vDist){
            nCiudades=n;
            listaCiudades=vCities;
       //     listaCiudades=vCities;
            distancia=vDist;  
	}

	public static Problema leerCiudades(Scanner sc){
		String etiqueta;
                ArrayList<Ciudad> vCities = new ArrayList<>();
		double x,y;
                
		sc.next();// esto hace que nos lea hasta el espacio en blanco.
		nCiudades = sc.nextInt();
      //          vCities=new Ciudad[nCiudades];     
                
		for(int i= 0;i<nCiudades;i++){
                    
                    etiqueta=sc.next();
                    x=sc.nextDouble();
                    y=sc.nextDouble();
                    Punto posicion = new Punto(x,y); 
                    Ciudad ciudad =new Ciudad(etiqueta,posicion);
                    //listaCiudades[i]=ciudad;
                    vCities.add(ciudad);
		}
                
                Problema problema=new Problema(nCiudades,vCities,null);
                
                return problema;
	}
      
	public double getDistancia(int pos1, int pos2){
            
            double dist;
            Ciudad ciudadAux1 = new Ciudad();
            Ciudad ciudadAux2 = new Ciudad();
	 	
            ciudadAux1= listaCiudades.get(pos1);
            ciudadAux2= listaCiudades.get(pos2);
		
            dist= ciudadAux1.getPosicion().CalcDistEuclid(ciudadAux2.getPosicion().ObtieneCoordenada_x(),ciudadAux2.getPosicion().ObtieneCoordenada_y());
		
            return dist;
	}
        
        public int getCiudadMasCercana(int posCiudad, Boolean[] visitados){
        // visitado es aun array que contiene las posciones de las ciudades visitadas
        //     un uno si la has visitado y un 0 si no la has visitado
        // posCiudad es la posicion de la ciudad desde la que busco alternaivas
        // devolvemos la posicion de la ciudad más cercana
            double []dist = null;
            int cityCloser=0;
            int contador=0;
            
            Ciudad ciudadActual = new Ciudad();
            Ciudad ciudadAux = new Ciudad();
            
            ciudadActual=listaCiudades.get(posCiudad);

            for (int i=0;i<listaCiudades.size();i++){
                
                    if(visitados[i]==false){
                        
                        ciudadAux=listaCiudades.get(i);
                        dist[i]= ciudadActual.getPosicion().CalcDistEuclid(ciudadAux.getPosicion().ObtieneCoordenada_x(),ciudadAux.getPosicion().ObtieneCoordenada_y());
                    }
                    else{
                        dist[i]=-1;
                    }
            }
            
            double minDist=dist[0];
            
            
            // Obtengo el mínimo
            for (int j=1;j<dist.length;j++){
                
                if(dist[j]>0 && dist[j]<minDist){
                    
                    minDist=dist[j];
                    cityCloser=j; 
                }
            }
            
        return cityCloser;
    }
        

        public static Ciudad getCiudad(int pos){
        
            return listaCiudades.get(pos);
        }
        
        public static int getNumeroCiudades(){
            
            int nCities=listaCiudades.size();
            return nCities;
        }
        

        public double coste(Ruta ruta){
            Double coste=0.0;
            Ciudad ciudadAux = new Ciudad();
            Ciudad ciudadAnterior = new Ciudad();
            
            ciudadAnterior=listaCiudades.get(0);
            
            for (int i=1;i<ruta.getNumberCiudadesVisitadas();i++){
                int pos=(Integer)(ruta.getRuta().get(i));
                ciudadAux=listaCiudades.get(pos);
                coste+=ciudadAux.getPosicion().CalcDistEuclid(ciudadAnterior.getPosicion().ObtieneCoordenada_x(), ciudadAnterior.getPosicion().ObtieneCoordenada_y());
                ciudadAnterior=ciudadAux;
            }
           
            return coste;
        }
}
