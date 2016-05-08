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
import java.util.Scanner;


/**
 * Esta Clase contiene los datos relevantes para la resolucion de la ruta, los cuales se exportaran a la clase Ruta 
 * mediante un objeto problema exportado de esta clase. Contiene datos como el numero de ciudades, un vector 
 * de ciudades tipo ArrayList con las ciudades a visitar, y una matriz de Distancias entre las ciudades.
 * 
 * @author Juan Manuel López Torralba - Santiago Juárez Rodríguez
 */
public class Problema {

    private static ArrayList<Ciudad> listaCiudades = new ArrayList<>();
    private double[][] distancia;
    private static int nCiudades;

    /**
     *  Constructor vacío de Problema
     */
    public Problema(){

        nCiudades=0;

    }
    
     /**
     * Constructor de la clase Problema
     * @param n numero total de ciudades que tiene la ruta
     * @param vCities ArrayList<Ciudad> tipo Ciudad que contiene objetos
     * de la clase ciudad. Las ciudades y su posición en la ruta.
     * @param vDist Vector de distancias entre ciudades de la ruta
     */
    public Problema(int n,ArrayList<Ciudad> vCities, double[][] vDist){
            
        nCiudades=n;
        listaCiudades=vCities;
        distancia=vDist;  
	}

    /**
     * Método que se encarga de leer las ciudades de la entrada estándar
     * @param sc
     */
    public void leerCiudades(Scanner sc){
        
	String etiqueta;
	double x,y;
                
	sc.next();// esto hace que nos lea hasta el espacio en blanco.
	nCiudades = sc.nextInt();    
                
	for(int i= 0;i<nCiudades;i++){
                    
            etiqueta=sc.next();
            x=sc.nextDouble();
            y=sc.nextDouble();
            Punto posicion = new Punto(x,y); 
            Ciudad ciudad =new Ciudad(etiqueta,posicion);
            listaCiudades.add(ciudad);
        }
    }
      
    /**
     * Devuelve la distancia euclidea entre 2 ciudades
     * @param pos1
     * @param pos2
     * @return
     */
    public double getDistancia(int pos1, int pos2){
            
        double dist;
        Ciudad ciudadAux1 = new Ciudad();
        Ciudad ciudadAux2 = new Ciudad();
	 	
        ciudadAux1= listaCiudades.get(pos1);
        ciudadAux2= listaCiudades.get(pos2);
		
        dist= ciudadAux1.getPosicion().CalcDistEuclid(ciudadAux2.getPosicion().ObtieneCoordenada_x(),ciudadAux2.getPosicion().ObtieneCoordenada_y());
		
        return dist;
    }
        
    /**
     * Método que obtiene la ciudad más cercana dada una posicion inicial 
     * desde la que buscar alternativas.
     * @param posCiudad Posicion de la ciudad desde la que busco alternativas
     * @param visitados array de booleanos que contiene las posiciones de 
     * las ciudades visitadas, true si las ha visitado y false si no las 
     * ha visitado.
     * @return cityCloser la posicion de la ciudad mas cercana
     */
    public int getCiudadMasCercana(int posCiudad, boolean[] visitados){

        double[] dist=new double[visitados.length];
        int cityCloser=0;
        int contador=0;
        //Boolean[] auxvisitados = new Boolean[visitados.length];
        //auxvisitados=visitados;
        Ciudad ciudadActual = new Ciudad();
        Ciudad ciudadAux = new Ciudad();
            
        ciudadActual=listaCiudades.get(posCiudad);

        for (int i=0;i</*visitados.length*/listaCiudades.size();i++){
                
            if(visitados[i]==false){
                        
                ciudadAux=listaCiudades.get(i);
                dist[i]= ciudadActual.getPosicion().CalcDistEuclid(ciudadAux.getPosicion().ObtieneCoordenada_x(),ciudadAux.getPosicion().ObtieneCoordenada_y());
                }
            else{
                    dist[i]=-1;
                }
            }
            
        double minDist=999999999;
            
            // Obtengo el mínimo
        for (int j=0;j<dist.length;j++){
                
            if(dist[j]>0 && dist[j]<minDist){
                    
                minDist=dist[j];
                cityCloser=j; 
            }
        }
            
    return cityCloser;
    }
        
    /**
     * Devuelve la ciudad en el indice del array pos
     * @param pos indice del array donde se encuentra la ciudad 
     * que queremos
     * @return
     */
    public static Ciudad getCiudad(int pos){
        
        return listaCiudades.get(pos);
    }
        
    /**
     * Devuelve la dimensión del problema
     * @return
     */
    public int getNumeroCiudades(){
            
        return nCiudades;
    }
        
    /**
     * Devuelve el coste de la ruta
     * @param ruta ruta a la que se le calcula el coste
     * @return coste
     */
    public double coste(Ruta ruta){
        Double coste=0.0;
        Ciudad ciudadAux = new Ciudad();
        Ciudad ciudadAnterior = new Ciudad();
            
        ciudadAnterior=listaCiudades.get(0);
            
        for (int i=1;i<ruta.getNumberCiudadesVisitadas();i++){
            int pos=(int)(ruta.getRuta().get(i));
            ciudadAux=listaCiudades.get(pos);
            coste+=ciudadAux.getPosicion().CalcDistEuclid(ciudadAnterior.getPosicion().ObtieneCoordenada_x(), ciudadAnterior.getPosicion().ObtieneCoordenada_y());
            ciudadAnterior=ciudadAux;
        }
           
        return coste;
    }
    
    /**
     * Este método devuelve la lista de las ciudades que
     * forma la ruta a resolver
     * @return listaCiudades
     */
    public ArrayList<Ciudad> getListaCiudades(){
    
        return listaCiudades;
    }
    
    
    /**
    * Muestra por pantalla las coordenadas de las ciudades de un objeto ruta.
     * @param ruta
    */
    public void muestraCoordenadasRuta(Ruta ruta){
        
        nCiudades=ruta.getNumberCiudadesVisitadas();
        Ciudad ciudadAux = new Ciudad();
        
        for (int i=0;i<nCiudades;i++){
            
            int pos=(Integer)(ruta.getRuta().get(i));
            ciudadAux=listaCiudades.get(pos);
            System.out.print(ciudadAux.getPosicion().ObtieneCoordenada_x());
            System.out.print(" ");
            System.out.print(ciudadAux.getPosicion().ObtieneCoordenada_y());
            System.out.print("\n");
        }
    }
    
}
