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
 * Esta clase da lugar a objetos ArrayList<Integer> rutaCiudades, los cuales
 * contienen la Ruta ya ordenada.
 * Contienen la posición de las ciudades, ordenada con respecto al vector 
 * donde se almacena la lista de ciudades.
 * 
 * @author Juan Manuel López Torralba - Santiago Juárez Rodríguez
 */
public class Ruta {
  
    private int nCiudadesVisitadas;
    private ArrayList<Integer> rutaCiudades = new ArrayList<>();
    
    
    /**
    * Constructor de la clase Ruta
    * @param ntotalCiudades numero de Ciudades que contendrá la ruta.
    */
    Ruta(int ntotalCiudades){
        
        ArrayList<Integer> rutaCiudades = new ArrayList<>();
        nCiudadesVisitadas=ntotalCiudades;
    }
 
    
    /**
     * Este método añade una ciudad a la ruta.
     * @param pos Indica la posición de dicha ciudad con respecto
     * al vector donde se almacenan las ciudades.
     */
    public void addCiudad (int pos){
        
        rutaCiudades.add(pos);
    }
    
     /**
     * Este método añade una ciudad a la ruta.en la posición n de la ruta
     * @param pos Indica la posición de dicha ciudad con respecto
     * al vector donde se almacenan las ciudades.
     */
    public void addCiudadInLocation (int n, int pos){
        
        rutaCiudades.add(n,pos);
    }
    
    
    /**
     * Método que devuelve una ruta de tipo ArrayList 
     * @return rutaCiudades
     */
    public ArrayList getRuta(){

        return rutaCiudades;
    }
   
    /**
     * Método que devuelve el número de ciudades visitadas
     * en el instante de consulta.
     * @return rutaCiudades.size() 
     */
    public int getNumberCiudadesVisitadas(){    
        
        return rutaCiudades.size();
    }
    
    /**
     * Este método indica para una posición dada de la ciudad en
     * la lista de ciudades leída, su posición en la ruta.
     * @param pos posición de la ciudad en la lista inicial
     * @return su posición en la ruta
     */
    public int getPosCiudad(int pos){
    
        return rutaCiudades.get(pos);
    }

}
